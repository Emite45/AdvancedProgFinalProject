import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class WDigraph<V extends Comparable<V>> extends Graph<V,DirectedEdge<V>>{
	
	public Map<V,ArrayList<DirectedEdge<V>>> adjacencyList;

	public void addEdge(DirectedEdge<V> edge) {
		if (this.adjacencyList.get(edge.from()) == null) {
		    this.adjacencyList.put(edge.from(), new ArrayList<DirectedEdge<V>>());
		}
		this.adjacencyList.get(edge.from()).add(edge);
	}
	
	public WDigraph() {
		this.adjacencyList = new TreeMap<V,ArrayList<DirectedEdge<V>>>();
	}
}
