package src;

import static org.junit.Assert.*;

import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.Test;

public class WeightedGraphTest {
	
	@Test
	public void testGenerateEdgeWeightedGraphZeroVerticesContainsZeroVertexAndZeroEdges() {
		SimpleWeightedGraph<String, Edge> graph = WeightedGraph.generateEdgeWeightedGraph(0);
		assertTrue(graph.vertexSet().isEmpty());
		assertTrue(graph.vertexSet().size() == 0);
		assertTrue(graph.edgeSet().size() == 0);
	}
	
	@Test
	public void testGenerateEdgeWeightedGraphOneVerticesContainsOneVertexAndZeroEdges() {
		SimpleWeightedGraph<String, Edge> graph = WeightedGraph.generateEdgeWeightedGraph(1);
		assertTrue(graph.vertexSet().contains("0"));
		assertTrue(graph.vertexSet().size() == 1);
		assertTrue(graph.edgeSet().size() == 0);
	}
	
	@Test
	public void testGenerateEdgeWeightedGraphToVerticesContainsTwoVertexAndOneEdge() {
		SimpleWeightedGraph<String, Edge> graph = WeightedGraph.generateEdgeWeightedGraph(2);
		assertTrue(graph.vertexSet().contains("0"));
		assertTrue(graph.vertexSet().contains("1"));
		assertTrue(graph.vertexSet().size() == 2);
		assertTrue(graph.edgeSet().size() == 1);
	}
	
	
	@Test
	public void testGenerateEdgeWeightedGraphTwoVerticesIsConnected() {
		SimpleWeightedGraph<String, Edge> graph = WeightedGraph.generateEdgeWeightedGraph(2);

		boolean exists = false;
		for (int i = 0; i < 2; i++) {
			exists = false;
			for (Edge edge : graph.edgeSet()) {
				if (edge.getSourceVertex() == i || edge.getTargetVertex() == i) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				break;
			}
		}
		assertTrue(exists);
	}
	
	@Test
	public void testGenerateEdgeWeightedGraphThreeVerticesIsConnected() {
		SimpleWeightedGraph<String, Edge> graph = WeightedGraph.generateEdgeWeightedGraph(3);

		boolean exists = false;
		for (int i = 0; i < 3; i++) {
			exists = false;
			for (Edge edge : graph.edgeSet()) {
				if (edge.getSourceVertex() == i || edge.getTargetVertex() == i) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				break;
			}
		}
		assertTrue(exists);
	}
	
	

}
