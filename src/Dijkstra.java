import java.util.*;

public class Dijkstra<V extends Comparable<V>>
{
//	private List<Integer> marked;
//	private List<Integer> previous;
//	private List<Integer> distance;
	protected Map<List<V>, Double> fringe;
	protected List<V> closed;


	public Dijkstra()
	{
		this.fringe = new HashMap<>();
		this.closed = new ArrayList<>();
	}


	public void dijkstraSP(WDigraph<V> graph, V start, V goal)
	{
		if(!verifyNonNegative(graph))
		{
			System.out.println("Graph has one or more negative weighted edge(s), results may be innacurate");
		}

		this.fringe.put(new ArrayList<>(){{add(start);}}, 0.0);
		Map<List<V>, Double> path = new HashMap<>();

		printFringe(this.fringe);

		while (!this.closed.contains(goal))
		{
			path = findMinPathinFringe(this.fringe, this.closed);
			addToFringe(this.fringe, this.closed, path, graph);

			removeFromFringe(this.fringe, path);
			addToClosed(this.closed, path);

			printFringe(this.fringe);
		}

		System.out.println("Shortest path : " + path);
		System.out.println("Visited nodes : " + this.closed);
	}


	protected void removeFromFringe(Map<List<V>, Double> fringe, Map<List<V>, Double> path)
	{
		List<List<V>> keys = new ArrayList<>(path.keySet());
		List<V> key = keys.get(0);

		fringe.remove(key);
	}


	protected void printFringe(Map<List<V>, Double> fringe)
	{
		for (Map.Entry mapentry : fringe.entrySet())
		{
			List<V> key = (List<V>) mapentry.getKey();
			double value = (double) mapentry.getValue();

			String str = "";

			for (V node : key)
			{
			    str = str + node + " -> ";
			}

			str = str.substring(0, str.length()-4);
			str = str + " : ";

			System.out.println(str + value);
		}

		System.out.println("");
	}


	protected void addToClosed(List<V> closed, Map<List<V>, Double> path)
	{
		List<List<V>> keys = new ArrayList<>(path.keySet());
		List<V> key = keys.get(0);
		V node = key.get(key.size() - 1);

		closed.add(node);
	}


	protected void addToFringe(Map<List<V>, Double> fringe, List<V> closed, Map<List<V>, Double> path, WDigraph<V> graph)
	{
		List<List<V>> keys = new ArrayList<>(path.keySet());
		List<V> key = keys.get(0);
		V node = key.get(key.size() - 1);

		List<Double> values = new ArrayList<>(path.values());
		double value = values.get(0);

		if (!closed.contains(node))
		{
			List<DirectedEdge<V>> list = graph.getAdjacencyList().get(node);

			if (list != null)
			{
				for (DirectedEdge<V> directedEdge : list)
				{
					List<V> new_path = new ArrayList<>();
					new_path.addAll(key);
					new_path.add(directedEdge.getDestination());

					fringe.put(new_path, value + directedEdge.getWeight());
				}
			}
		}
	}


	protected Map<List<V>, Double> findMinPathinFringe(Map<List<V>, Double> fringe, List<V> closed)
	{
		List<Double> values = new ArrayList<>(fringe.values());
		double min = Collections.max(values);
		List<V> path = new ArrayList<>();


		for (Map.Entry mapentry : fringe.entrySet())
		{
			List<V> key = (List<V>) mapentry.getKey();
			double value = (double) mapentry.getValue();

			if (value <= min && !closed.contains(key.get(key.size() - 1)))
			{
				path = key;
				min = value;
			}
		}

		Map<List<V>, Double> map = new HashMap<>();
		map.put(path, min);

		return map;
	}


	protected boolean verifyNonNegative(WDigraph<V> G)
	{
		for (Map.Entry<V, ArrayList<DirectedEdge<V>>> edgeList : G.getAdjacencyList().entrySet())
		{
			for (DirectedEdge<V> edge : edgeList.getValue())
			{
				if(edge.getWeight() < 0)
				{
					return false; //return false if an edge has a negative weight
				}
			}
		}

		return true;
	}
	
	void hasPathTo(int v)
	{
		
	}
	
	void distTo (int v)
	{
		
	}
	
	void printSP (int v)
	{
		
	}
}
