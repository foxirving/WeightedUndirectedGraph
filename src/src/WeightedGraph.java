package src;

import java.security.InvalidParameterException;
import java.util.Iterator;

import org.jgrapht.graph.SimpleWeightedGraph;

public class WeightedGraph {

	/**
	 * Generates a Simple Weighted Graph using the amount of vertices indicated.
	 * Generates the weight between 1 and the number of vertices. Generates a
	 * moderately dense graph.
	 * 
	 * @param theNumbVertices
	 *            - number of vertices to be generated in graph.
	 * @return a Simple Weighted Graph.
	 */
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theNumbVertices) {
		SimpleWeightedGraph<String, Edge> graph = new SimpleWeightedGraph<String, Edge>(Edge.class);

		if (theNumbVertices < 0) {
			throw new InvalidParameterException();
		}
		if (theNumbVertices == 0) {
			return graph;
		}
		if (theNumbVertices == 1) {
			graph.addVertex(Integer.toString(0));
			return graph;
		}

		// Generate Edges
		for (int i = 0; i < theNumbVertices; i++) {
			graph.addVertex(Integer.toString(i));
		}

		// Make sure every vertex has at least one edge.
		int edges = 0;
		int i = 0;
		while (i < theNumbVertices) {
			int m = Calculations.getRandomVertexIndexExcluding(theNumbVertices, i);
			// if the vertex already has max edges, skip it.
			if (Calculations.graphVertexHasMaxEdges(graph, theNumbVertices, i)) {
				i++;
			} else if (!Calculations.graphContainsUndirectedEdge(graph, m, i)) {
				Edge edge = (Edge) graph.addEdge(Integer.toString(m), Integer.toString(i));
				// Edge and Weight
				graph.setEdgeWeight(edge, Calculations.getRandomWeight(1, theNumbVertices));
				edges++;
				i++;
			}
		}

		// Generate Weight and adds to graph.
		int totalEdges = Calculations.getRandomEdgeFromRange(theNumbVertices, GraphDensity.MEDIUM);
		while (edges < totalEdges) {
			int m = Calculations.getRandomVertexIndex(theNumbVertices);
			int n = Calculations.getRandomVertexIndex(theNumbVertices);
			// if m and n aren't the same number and that edge doesn't exist in
			// the graph.
			if (m != n && !graph.containsEdge(Integer.toString(m), Integer.toString(n))) {
				Edge edge = (Edge) graph.addEdge(Integer.toString(m), Integer.toString(n));
				// Edge and Weight
				graph.setEdgeWeight(edge, Calculations.getRandomWeight(1, theNumbVertices));
				edges++;
			}
		}

		return graph;
	}

	/**
	 * Generates a Simple Weighted Graph using the amount of vertices indicated.
	 * Generates the weight between the minimum and maximum values. Generates a
	 * moderately dense graph.
	 * 
	 * @param theAmountVertices
	 *            - number of vertices to be generated in graph.
	 * @param theMinWeight
	 *            - Minimum weight of an edge in the graph.
	 * @param theMaxWeight
	 *            - Maximum weigh of an edge in a graph.
	 * @return a Simple Weighted Graph.
	 */
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theAmountVertices, int theMinWeight,
			int theMaxWeight) {
		SimpleWeightedGraph<String, Edge> graph = new SimpleWeightedGraph<String, Edge>(Edge.class);
		return graph;
	}

	/**
	 * Generates a Simple Weighted Graph using the amount of vertices indicated.
	 * Generates the weight between the minimum and maximum values. Generates
	 * graph density based off of users specification.
	 * 
	 * @param theAmountVertices
	 *            - number of vertices to be generated in graph.
	 * @param theMinWeight
	 *            - Minimum weight of an edge in the graph.
	 * @param theMaxWeight
	 *            - Maximum weigh of an edge in a graph.
	 * @param theGraphDensity
	 *            - 0 for sparse graph, 1 for dense graph. Unspecifified density
	 *            defaults to moderately dense.
	 * @return
	 */
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theAmountVertices, int theMinWeight,
			int theMaxWeight, int theGraphDensity) {
		SimpleWeightedGraph<String, Edge> graph = new SimpleWeightedGraph<String, Edge>(Edge.class);
		return graph;
	}

	/**
	 * Prints the source vertex, its edge weight, and the target vertex.
	 * 
	 * @param theGraph
	 *            - the impleweightedgraph being printed.
	 */
	public static void print(SimpleWeightedGraph<String, Edge> theGraph) {
		for (Edge edge : theGraph.edgeSet()) {
			System.out.println("Vertex: " + edge.getSourceVertex() + " ---(" + edge.getEdgeWeight() + ")--- "
					+ "Vertex: " + edge.getTargetVertex());
		}
	}

	public static void main(String[] args) {
		SimpleWeightedGraph<String, Edge> graph = generateEdgeWeightedGraph(4);
		print(graph);

		// for (int i = 1; i <= 8; i++) {
		// System.out.println(Calculations.getMinEdges(i));
		// System.out.println(Calculations.getQuartileOneNumbEdges(i));
		// System.out.println(Calculations.getQuartileTwoNumbEdges(i));
		// System.out.println(Calculations.getQuartileThreeNumbEdges(i));
		// System.out.println(Calculations.getMaxEdges(i));
		// System.out.println();
		// }
	}

}
