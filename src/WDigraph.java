import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class WDigraph<V extends Comparable<V>> extends Graph<V,DirectedEdge<V>>
{
	
	private Map<V,ArrayList<DirectedEdge<V>>> adjacencyList;

	public WDigraph()
	{
		this.adjacencyList = new TreeMap<V,ArrayList<DirectedEdge<V>>>();
	}

	public void addEdge(DirectedEdge<V> edge)
	{
		if (this.adjacencyList.get(edge.getSource()) == null)
		{
		    this.adjacencyList.put(edge.getSource(), new ArrayList<DirectedEdge<V>>());
		}

		this.adjacencyList.get(edge.getSource()).add(edge);
	}

	public Map<V, ArrayList<DirectedEdge<V>>> getAdjacencyList() {return this.adjacencyList;}

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
