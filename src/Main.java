import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
//		WDigraph<String> myWDiGraph = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
//		System.out.println(myWDiGraph);
//
//		Dijkstra<String> myDijkstra = new Dijkstra<>();
//		myDijkstra.dijkstraSP(myWDiGraph, "A", "G");


//		DijkstraBidirectional<String> myDijkstraBidirectional = new DijkstraBidirectional<>();
//		myDijkstraBidirectional.dijkstraBidirectionalSP(myWDiGraph, "0", "7");





		Map<Integer, String> stationListMap = new HashMap<>();
		WDigraph<String> myGraph = GraphFactory.createWDiGraphFromMetroFile("metro.txt", stationListMap);

		DijkstraBidirectional<String> myDijkstraSP = new DijkstraBidirectional<>();
		myDijkstraSP.dijkstraBidirectionalSP(myGraph, "80", "105");

	}
}
