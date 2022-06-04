import java.util.*;

public class DijkstraSP<V extends Comparable<V>>
{
//	private List<Integer> marked;
//	private List<Integer> previous;
//	private List<Integer> distance;
	private Map<List<V>, Double> fringe;
	private List<V> closed;



	public DijkstraSP(WDigraph<V> graph, V start, V goal)
	{
		if(verifyNonNegative(graph))
		{
			fringe = new HashMap<>();
			closed = new ArrayList<>();

			fringe.put(new ArrayList<>(){{add(start);}}, 0.0);
			Map<List<V>, Double> path = null;

			while (!closed.contains(goal))
			{
				path = findMinPathinFringe();
				addToFringe(path, graph);

				this.fringe.remove(path);
				addToClosed(path);

				printFringe();
			}

			System.out.println("Shortest path : " + path);
			System.out.println("Visited nodes : " + this.closed);
		}

		else
		{
			System.out.println("Graph has one or more negative weighted edge(s), results may be innacurate");
		}
	}


	private void printFringe()
	{
		for (Map.Entry mapentry : this.fringe.entrySet())
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


	private void addToClosed(Map<List<V>, Double> path)
	{
		List<List<V>> keys = new ArrayList<>(path.keySet());
		List<V> key = keys.get(0);
		V node = key.get(key.size() - 1);

		this.closed.add(node);
	}


	private void addToFringe(Map<List<V>, Double> path, WDigraph<V> graph)
	{
		List<List<V>> keys = new ArrayList<>(path.keySet());
		List<V> key = keys.get(0);
		V node = key.get(key.size() - 1);

		List<Double> values = new ArrayList<>(path.values());
		double value = values.get(0);

		if (!closed.contains(node))
		{
			List<DirectedEdge<V>> list = graph.getAdjacencyList().get(node);

			for (DirectedEdge<V> directedEdge : list)
			{
				List<V> new_path = new ArrayList<>();
				new_path.addAll(key);
				new_path.add(directedEdge.getDestination());

				this.fringe.put(new_path, value + directedEdge.getWeight());
			}
		}
	}


	private Map<List<V>, Double> findMinPathinFringe()
	{
		List<Double> values = new ArrayList<>(this.fringe.values());
		double min = Collections.max(values);
		List<V> path = new ArrayList<>();


		for (Map.Entry mapentry : this.fringe.entrySet())
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


	boolean verifyNonNegative(WDigraph<V> G)
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
