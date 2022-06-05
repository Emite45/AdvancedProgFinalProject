import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
		System.out.println("\nBellman-Ford : ");
		printDistance(distances, start, destination);
		printPath(predecessor, start, destination);
	}

	private void printDistance(Map<V, Double> distances, V start, V destination) {
		System.out.println("shortest distance from " + start + " to " + destination + " = " + distances.get(destination));
		
	}

	private void printPath(Map<V, V> predecessor, V start, V destination) {
		V current = destination;
		List<V> path = new ArrayList<V>();
		while(current != null) {
			path.add(current);
			current = predecessor.get(current);
		}
		Collections.reverse(path);
		System.out.println("shortest path from " + start + " to " + destination + " = " + path);
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
