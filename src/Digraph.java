import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Digraph<V extends Comparable<V>> extends Graph<V,Edge<V>>
{
	public Map<V,ArrayList<Edge<V>>> adjacencyList;

	public Digraph()
	{
		this.adjacencyList = new TreeMap<V,ArrayList<Edge<V>>>();
	}

	public void addEdge(Edge<V> edge)
	{
		if (this.adjacencyList.get(edge.getSource()) == null)
		{
		    this.adjacencyList.put(edge.getSource(), new ArrayList<Edge<V>>());
		}

		this.adjacencyList.get(edge.getSource()).add(edge);
	}

	@Override
	public String toString()
	{
		String str = "Order: " + this.order + "\nSize: " + this.size + "\n";

		for (Map.Entry mapentry : this.adjacencyList.entrySet())
		{
			str = str + mapentry.getKey() + " : " + mapentry.getValue().toString() + "\n";
		}

		return str;
	}
}
