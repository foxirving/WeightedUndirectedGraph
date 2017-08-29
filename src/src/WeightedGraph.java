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

		// Generate Vertices
		generateVertices(graph, theNumbVertices);

		generateGraph(graph, theNumbVertices, 1, theNumbVertices, GraphDensity.MEDIUM);

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
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theNumbVertices, int theMinWeight,
			int theMaxWeight) {
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

		// Generate Vertices
		generateVertices(graph, theNumbVertices);

		generateGraph(graph, theNumbVertices, theMinWeight, theMaxWeight, GraphDensity.MEDIUM);

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
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theNumbVertices, int theMinWeight,
			int theMaxWeight, GraphDensity theGraphDensity) {
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

		// Generate Vertices
		generateVertices(graph, theNumbVertices);

		generateGraph(graph, theNumbVertices, theMinWeight, theMaxWeight, theGraphDensity);

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
	}

	private static void generateVertices(SimpleWeightedGraph<String, Edge> theGraph, int theNumbVertices) {
		for (int i = 0; i < theNumbVertices; i++) {
			theGraph.addVertex(Integer.toString(i));
		}
	}

	private static void generateGraph(SimpleWeightedGraph<String, Edge> theGraph, int theNumbVertices, int theMinWeight,
			int theMaxWeight, GraphDensity theGraphDensity) {
		// Make sure every vertex has at least one edge.
		int edges = 0;
		int i = 0;
		while (i < theNumbVertices) {
			int m = Calculations.getRandomVertexIndexExcluding(theNumbVertices, i);
			// if the vertex already has max edges, skip it.
			if (Calculations.graphVertexHasMaxEdges(theGraph, theNumbVertices, i)) {
				i++;
			} else if (!Calculations.graphContainsUndirectedEdge(theGraph, m, i)) {
				Edge edge = (Edge) theGraph.addEdge(Integer.toString(m), Integer.toString(i));
				// Edge and Weight
				theGraph.setEdgeWeight(edge, Calculations.getRandomWeight(theMinWeight, theMaxWeight));
				edges++;
				i++;
			}
		}

		// Generate Weight and adds to graph.
		int totalEdges = Calculations.getRandomEdgeFromRange(theNumbVertices, theGraphDensity);
		while (edges < totalEdges) {
			int m = Calculations.getRandomVertexIndex(theNumbVertices);
			int n = Calculations.getRandomVertexIndex(theNumbVertices);
			// if m and n aren't the same number and that edge doesn't exist in
			// the graph.
			if (m != n && !theGraph.containsEdge(Integer.toString(m), Integer.toString(n))) {
				Edge edge = (Edge) theGraph.addEdge(Integer.toString(m), Integer.toString(n));
				// Edge and Weight
				theGraph.setEdgeWeight(edge, Calculations.getRandomWeight(theMinWeight, theMaxWeight));
				edges++;
			}
		}
	}

}
