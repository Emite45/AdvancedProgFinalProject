import java.util.ArrayList;
import java.util.Map;

public class Dijkstra<V extends Comparable<V>> {
	boolean[] marked;
	int[] previous;
	int[] distance;
	
	boolean verifyNonNegative(WDigraph<V> G) {
		for (Map.Entry<V, ArrayList<DirectedEdge<V>>> edgeList : G.adjacencyList.entrySet()) {
			for (DirectedEdge<V> edge : edgeList.getValue()) {
				if(edge.getWeight() < 0) {
					return false; //return false if an edge has a negative weight
				}
			}
		}
		return true;
	}
	
	void DijkstraSP(WDigraph<V> G, int s) {
		if(verifyNonNegative(G)) {
			
		} else {
			System.out.println("Graph has one or more negative weighted edge(s), results may be innacurate");
		}
	}
	
	void hasPathTo(int v) {
		
	}
	
	void distTo (int v) {
		
	}
	
	void printSP (int v) {
		
	}
	
	
}
