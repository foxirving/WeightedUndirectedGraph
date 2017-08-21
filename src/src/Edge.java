package src;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Edge extends DefaultWeightedEdge implements Comparable<Edge>{

	private static final long serialVersionUID = 1L;

	public double getEdgeWeight(){
		return getWeight();
	}

	@Override
	public int compareTo(Edge theOtherEdge) {
		return Double.compare(this.getWeight(),  theOtherEdge.getEdgeWeight());
	}
	
	public int getSourceVertex(){
		return Integer.parseUnsignedInt((String) getSource());
	}
	
	public int getTargetVertex(){
		return Integer.parseUnsignedInt((String) getTarget());
	}
	
}
