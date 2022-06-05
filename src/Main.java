import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Creation of graphs
		WDigraph<String> graphWDG = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
		System.out.println(graphWDG);

		Map<Integer, String> stationListMap = new HashMap<>();
		WDigraph<String> graphMetro = GraphFactory.createWDiGraphFromMetroFile("metro.txt", stationListMap);



		//Test Dijkstra
		System.out.println("\nTest Dijkstra with graph-WDG.txt");
		Dijkstra<String> dijkstraGraphWDG = new Dijkstra<>();
		dijkstraGraphWDG.dijkstraSP(graphWDG, "0", "7");

		System.out.println("\nTest Dijkstra with graph-WDG.txt");
		Dijkstra<String> dijkstraMetro = new Dijkstra<>();
		long start = System.currentTimeMillis();
		dijkstraMetro.dijkstraSP(graphMetro, "80", "105");
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start) + " ms");



		//Test Dijkstra bidirectional
		System.out.println("\n\nTest Dijkstra with graph-WDG.txt");
		DijkstraBidirectional<String> dijkstraBidirectionalGraphWDG = new DijkstraBidirectional<>();
		dijkstraBidirectionalGraphWDG.dijkstraBidirectionalSP(graphWDG, "0", "7");

		System.out.println("\nTest Dijkstra with graph-WDG.txt");
		DijkstraBidirectional<String> dijkstraBidirectionalMetro = new DijkstraBidirectional<>();
		long start2 = System.currentTimeMillis();
		dijkstraBidirectionalMetro.dijkstraBidirectionalSP(graphMetro, "80", "105");
		long end2 = System.currentTimeMillis();
		System.out.println("Execution time: " + (end2 - start2) + " ms");

//		Dijkstra<String> myDijkstraSP = new Dijkstra<String>();
//		myDijkstraSP.dijkstraSP(myWDiGraph, "4", "3");
//		BellmanFord<String> myBellmanFord = new BellmanFord<String>();
//		myBellmanFord.BellmanFordSP(myWDiGraph, "4", "3");
//		System.out.println("The graph contains no negative weight edge ? " + myDijkstraSP.verifyNonNegative(myWDiGraph));
//		Map<Integer, String> stationListMap = new HashMap<>();
//		WDigraph<String> myGraph = GraphFactory.createWDiGraphFromMetroFile("metro.txt", stationListMap);
//		System.out.println("number of nodes : " + myGraph.adjacencyList.size());
//		int numberOfEdges = 0;
//		for (Map.Entry<String, ArrayList<DirectedEdge<String>>> mapElement : myGraph.adjacencyList.entrySet()) {
//			numberOfEdges += mapElement.getValue().size();
//			
//		}
//		System.out.println("number of edges : " + numberOfEdges);
//		System.out.println("Test push repo git");

//		DijkstraBidirectional<String> myDijkstraBidirectional = new DijkstraBidirectional<>();
//		myDijkstraBidirectional.dijkstraBidirectionalSP(myWDiGraph, "0", "7");






//
//		DijkstraBidirectional<String> myBiDijkstraSP = new DijkstraBidirectional<>();
//		myBiDijkstraSP.dijkstraBidirectionalSP(myGraph, "80", "105");

	}
}
