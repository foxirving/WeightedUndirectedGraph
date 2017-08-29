package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.Random;

import org.jgrapht.graph.SimpleWeightedGraph;

final public class Calculations {

	private Calculations() {
		// private constructor.
	}
	
	public static boolean graphVertexHasMaxEdges(SimpleWeightedGraph<String, Edge>  theGraph, int theNumbvertices, int theVertex){
		int edgeNumb = 0;
		for (Edge edge : theGraph.edgeSet()) {
			if (edge.getSourceVertex() == theVertex || edge.getTargetVertex() == theVertex){
				edgeNumb++;
			}
		}
		return edgeNumb >= (theVertex - 1);
	}

	public static boolean graphContainsUndirectedEdge(SimpleWeightedGraph<String, Edge> theGraph, int theVertex1,
			int theVertex2) {
		return (theGraph.containsEdge(Integer.toString(theVertex1), Integer.toString(theVertex2))
				|| theGraph.containsEdge(Integer.toString(theVertex2), Integer.toString(theVertex1)));
	}

	/**
	 * Returns a random index between 1 and the number of vertices specified.
	 * 
	 * @param theAmountVertices
	 *            - the number of vertices int he graph.
	 * @return a random index.
	 */
	public static int getRandomVertexIndex(int theAmountVertices) {
		if (theAmountVertices < 1) {
			throw new InvalidParameterException();
		}
		Random rand = new Random();
		return rand.nextInt(theAmountVertices);
	}
	
	/**
	 * Returns a random index between 1 and the number of vertices specified.
	 * 
	 * @param theAmountVertices
	 *            - the number of vertices int he graph.
	 * @return a random index.
	 */
	public static int getRandomVertexIndexExcluding(int theAmountVertices, int theExcludedVertex) {
		Random rand = new Random();
		int vertex = rand.nextInt(theAmountVertices);
		while (vertex == theExcludedVertex){
			vertex = rand.nextInt(theAmountVertices);
		}
		return vertex;
	}

	/**
	 * Returns a random integer between a max and min (inclusive). Throws
	 * invalidParameterException when min > max, min <0, or max <0.
	 * 
	 * @param theMin
	 * @param theMax
	 * @return
	 */
	public static int getRandomWeight(int theMin, int theMax) {
		if (theMin > theMax || theMin < 0 || theMax < 0) {
			throw new InvalidParameterException();
		}
		Random rand = new Random();
		return rand.nextInt(theMax - theMin + 1) + theMin;
	}

	/**
	 * Returns the minimum number of edges in a connected graph given a number
	 * of vertices.
	 * 
	 * @param theNumbVertex
	 * @return
	 */
	public static int getMinEdges(int theNumbVertex) {
		if (theNumbVertex < 2) {
			return 0;
		}
		return theNumbVertex - 1;
	}

	/**
	 * Returns the maximum number of edges in a connected graph given the number
	 * of vertices.
	 * 
	 * @param theNumbVertex
	 * @return
	 */
	public static int getMaxEdges(int theNumbVertex) {
		if (theNumbVertex < 2) {
			return 0;
		}
		return (theNumbVertex * (theNumbVertex - 1)) / 2;
	}

	/**
	 * Returns the Quartile 1 number of edges in a connected graph given its min
	 * and median number of edges. Quartile 1 is rounded down iff result <= .5,
	 * else it is rounded up.
	 * 
	 * @param theNumbVertex
	 * @return
	 */
	public static int getQuartileOneNumbEdges(int theNumbVertex) {
		if (theNumbVertex < 2) {
			return 0;
		}
		double result = (theNumbVertex - 1.0) * (theNumbVertex + 6.0) / 8.0;
		result = roundHalfDown(result);
		return (int) result;
	}

	/**
	 * Returns the Median number of edges in a connected graph given its min and
	 * max number of edges. Median (quartile 2) is typically rounded up.
	 * 
	 * @param theNumbVertex
	 * @return
	 */
	public static int getQuartileTwoNumbEdges(int theNumbVertex) {
		if (theNumbVertex < 2) {
			return 0;
		}
		double result = ((theNumbVertex - 1.0) * (theNumbVertex + 2.0)) / 4.0;
		result = Math.ceil(result);
		return (int) result;
	}

	/**
	 * Returns the Quartile 3 number of edges in a connected graph given its
	 * median and max number of edges. Quartile 3 is rounded down iff result <=
	 * .5, else it is rounded up.
	 * 
	 * @param theNumbVertex
	 * @return
	 */
	public static int getQuartileThreeNumbEdges(int theNumbVertex) {
		if (theNumbVertex < 2) {
			return 0;
		}
		double result = ((theNumbVertex - 1.0) * (3.0 * theNumbVertex + 2.0)) / 8.0;
		result = roundHalfDown(result);
		return (int) result;
	}

	/**
	 * Returns a random number of edges between a given range depending on
	 * desired graph density. Sparce: between min and (Q1 -1) edges (inclusive).
	 * Medium: between Q1 and Q3 edges (inclusive). Dense: between (Q3 +1) and
	 * max edges inclusive.
	 * 
	 * @param theNumbVertex
	 * @param theDensity
	 * @return
	 */
	public static int getRandomEdgeFromRange(int theNumbVertex, GraphDensity theDensity) {
		if (theNumbVertex < 2) {
			return 0;
		}
		Random rand = new Random();

		int min = getMinEdges(theNumbVertex);
		int Q1 = getQuartileOneNumbEdges(theNumbVertex);
		int Q2 = getQuartileTwoNumbEdges(theNumbVertex);
		int Q3 = getQuartileThreeNumbEdges(theNumbVertex);
		int max = getMaxEdges(theNumbVertex);

		if (theDensity == GraphDensity.SPARCE) {
			if (min == Q1) {
				return min;
			}
			return rand.nextInt((Q1 - 1) - min + 1) + min;
		} else if (theDensity == GraphDensity.DENSE) {
			if (Q3 == max) {
				return max;
			}
			return rand.nextInt(max - (Q3 + 1) + 1) + (Q3 + 1);
		}
		return rand.nextInt(Q3 - Q1 + 1) + Q1;
	}

	/**
	 * Returns a number rounded down if number is <- .5, rounds up otherwise.
	 * 
	 * @param theNumber
	 * @return
	 */
	public static final int roundHalfDown(double theNumber) {
		return (int) new BigDecimal(theNumber).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
	}

}
