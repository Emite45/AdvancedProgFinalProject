import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Digraph<V extends Comparable<V>> extends Graph<V,Edge<V>> {
	
	public Map<V,ArrayList<Edge<V>>> adjacencyList;

	public void addEdge(Edge<V> edge) {
		if (this.adjacencyList.get(edge.from()) == null) {
		    this.adjacencyList.put(edge.from(), new ArrayList<Edge<V>>());
		}
		this.adjacencyList.get(edge.from()).add(edge);
	}

	public Digraph() {
		this.adjacencyList = new TreeMap<V,ArrayList<Edge<V>>>();
	}
}
