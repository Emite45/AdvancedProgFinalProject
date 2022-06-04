import java.util.ArrayList;
import java.util.Map;

public abstract class Graph<V extends Comparable<V>, E>
{
	protected int order;
	protected int size;
	public Map<V,ArrayList<E>> adjacencyList;

	public int getOrder() {return order;}
	public int getSize() {return size;}

	public abstract void addEdge(E edge);
}
