import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		WDigraph<String> myWDiGraph = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
		System.out.println(myWDiGraph.adjacencyList);
		Dijkstra<String> myDijkstraSP = new Dijkstra<>(myWDiGraph, 0);
		System.out.println("The graph contains no negative weight edge ? " + myDijkstraSP.verifyNonNegative(myWDiGraph));
	}
}
