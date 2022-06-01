import java.util.ArrayList;
import java.util.Map;

public class DijkstraSP<V extends Comparable<V>> {
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
	
	DijkstraSP(WDigraph<V> G, int s) {
		
	}
	
	void hasPathTo(int v) {
		
	}
	
	void distTo (int v) {
		
	}
	
	void printSP (int v) {
		
	}
	
	
}
