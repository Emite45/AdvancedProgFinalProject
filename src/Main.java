import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		WDigraph<String> myWDiGraph = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
		System.out.println(myWDiGraph);
//		WDigraph<String> myWDiGraph = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
//		System.out.println(myWDiGraph);
//
//		Dijkstra<String> myDijkstra = new Dijkstra<>();
//		myDijkstra.dijkstraSP(myWDiGraph, "A", "G");

		Dijkstra<String> myDijkstraSP = new Dijkstra<String>();
		myDijkstraSP.dijkstraSP(myWDiGraph, "4", "3");
		BellmanFord<String> myBellmanFord = new BellmanFord<String>();
		myBellmanFord.BellmanFordSP(myWDiGraph, "4", "3");
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





		Map<Integer, String> stationListMap = new HashMap<>();
		WDigraph<String> myGraph = GraphFactory.createWDiGraphFromMetroFile("metro.txt", stationListMap);

		DijkstraBidirectional<String> myBiDijkstraSP = new DijkstraBidirectional<>();
		myBiDijkstraSP.dijkstraBidirectionalSP(myGraph, "80", "105");

	}
}
