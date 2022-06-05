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
		long start1 = System.currentTimeMillis();
		dijkstraMetro.dijkstraSP(graphMetro, "80", "105");
		long end1 = System.currentTimeMillis();
		System.out.println("Execution time: " + (end1 - start1) + " ms");



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



		//Test BellmanFord
		System.out.println("");
		BellmanFord<String> bellmanFord = new BellmanFord<String>();
		bellmanFord.BellmanFordSP(graphWDG, "0", "7");

		System.out.println("");

		BellmanFord<String> bellmanFordMetro = new BellmanFord<String>();
		long start3 = System.currentTimeMillis();
		bellmanFordMetro.BellmanFordSP(graphMetro, "80", "105");
		long end3 = System.currentTimeMillis();
		System.out.println("Execution time: " + (end3 - start3) + " ms");
	}
}
