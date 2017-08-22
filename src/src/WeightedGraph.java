package src;

import java.util.Iterator;

import org.jgrapht.graph.SimpleWeightedGraph;

public class WeightedGraph {

	private static final int SPARCE_GRAPH = 0;
	private static final int DENSE_GRAPH = 1;

	/**
	 * Generates a Simple Weighted Graph using the amount of vertices indicated.
	 * Generates the weight between 1 and the number of vertices. Generates a
	 * moderately dense graph.
	 * 
	 * @param theAmountVertices
	 *            - number of vertices to be generated in graph.
	 * @return a Simple Weighted Graph.
	 */
	public static SimpleWeightedGraph<String, Edge> generateEdgeWeightedGraph(int theAmountVertices) {
		SimpleWeightedGraph<String, Edge> graph = new SimpleWeightedGraph<String, Edge>(Edge.class);

		// Generate Edges
		for (int i = 0; i < theAmountVertices; i++) {
			graph.addVertex(Integer.toString(i));
		}

		// Make sure every vertex has at least one edge.
		for (int i = 0; i < theAmountVertices; i++) {
			int m = getRandomVertexIndex(theAmountVertices);
			if (m != i && !graph.containsEdge(Integer.toString(m), Integer.toString(i))) {
				Edge edge = (Edge) graph.addEdge(Integer.toString(m), Integer.toString(i));
				// Edge and Weight
				graph.setEdgeWeight(edge, getRandomVertexIndex(theAmountVertices));
			}
		}
		
		// Generate Weight and adds to graph.
		while (true) {
			int m = getRandomVertexIndex(theAmountVertices);
			int n = getRandomVertexIndex(theAmountVertices);
			// if m and n aren't the same number and that edge doesn't exist in
			// the graph.
			if (m != n && !graph.containsEdge(Integer.toString(m), Integer.toString(n))) {
				Edge edge = (Edge) graph.addEdge(Integer.toString(m), Integer.toString(n));
				// Edge and Weight
				graph.setEdgeWeight(edge, getRandomVertexIndex(theAmountVertices));
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
	 * Returns a random index between 1 and the number of vertices specified.
	 * @param theAmountVertices - the number of vertices int he graph.
	 * @return a random index.
	 */
	private static int getRandomVertexIndex(int theAmountVertices) {
		return (int) (Math.random() * (theAmountVertices - 1)) + 1;
	}

	/**
	 * Prints the source vertex, its edge weight, and the target vertex.
	 * 
	 * @param theGraph - the impleweightedgraph being printed.
	 */
	public static void print(SimpleWeightedGraph<String, Edge> theGraph) {
		for (Edge edge : theGraph.edgeSet()) {
			System.out.println(edge.getSourceVertex() + "---(" + edge.getEdgeWeight() + ")---" + edge.getTargetVertex());
		}
	}

	public static void main(String[] args) {
		SimpleWeightedGraph<String, Edge> graph = generateEdgeWeightedGraph(10);
		System.out.println(graph.edgeSet().size());
		print(graph);
	}

}
