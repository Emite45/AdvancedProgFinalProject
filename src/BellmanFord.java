import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BellmanFord<V extends Comparable<V>> {

	void BellmanFordSP(WDigraph<V> graph, V start, V destination) {

		Map<V, Double> distances = new TreeMap<V, Double>();
		Map<V, V> predecessor = new HashMap<V, V>();

		for (Map.Entry<V, ArrayList<DirectedEdge<V>>> node : graph.getAdjacencyList().entrySet()) {
			distances.put(node.getKey(), Double.MAX_VALUE);
		}
		distances.replace(start, 0.0);

		ArrayList<DirectedEdge<V>> listOfEdges = new ArrayList<>();
		listOfEdges = createEdgeList(graph);

		for (int i = 1; i < graph.order; i++) {
			for (int j = 0; j < graph.size; ++j) {
				V u = listOfEdges.get(j).getSource();
				V v = listOfEdges.get(j).getDestination();
				Double weight = listOfEdges.get(j).getWeight();
				if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
					distances.replace(v, distances.get(u) + weight);
					if (predecessor.get(v) != null) {
						predecessor.replace(v, u);
					} else {
						predecessor.put(v, u);
					}
				}
			}
		}

		for (int j = 0; j < graph.size; ++j) {
			V u = listOfEdges.get(j).getSource();
			V v = listOfEdges.get(j).getDestination();
			Double weight = listOfEdges.get(j).getWeight();
			if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printDistances(distances);
		printPaths(predecessor,destination);
	}

	private void printPaths(Map<V, V> predecessor) {
		System.out.println("Path from Source");
		for (Map.Entry<V, V> node : predecessor.entrySet()) {
			System.out.println("node " + node.getKey() + " : " + node.getValue());
		}
	}

	void printDistances(Map<V, Double> distances) {
		System.out.println("Vertex Distance from Source");
		for (Map.Entry<V, Double> node : distances.entrySet()) {
			System.out.println("node " + node.getKey() + " : " + node.getValue());
		}
	}

	ArrayList<DirectedEdge<V>> createEdgeList(WDigraph<V> graph) {
		ArrayList<DirectedEdge<V>> listOfEdges = new ArrayList<DirectedEdge<V>>();
		for (Map.Entry<V, ArrayList<DirectedEdge<V>>> node : graph.getAdjacencyList().entrySet()) {
			for (DirectedEdge<V> directedEdge : node.getValue()) {
				listOfEdges.add(directedEdge);
			}
		}
		return listOfEdges;
	}
}
