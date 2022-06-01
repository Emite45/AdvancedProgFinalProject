import java.util.ArrayList;
import java.util.Map;

public abstract class Graph<V extends Comparable<V>, E> {
	protected int n;
	protected int m;
	public Map<V,ArrayList<E>> adjacencyList;
	public Graph(int nbVertices, int nbEdges) {

	}

// initialize an empty graph
	public Graph() {

	}

	public int order() {
		return n;
	}

	public int size() {
		return m;
	}
	
	public abstract void addEdge(E edge);
}
