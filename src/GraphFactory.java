import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphFactory
{
	
	public static Digraph<String> createDiGraphFromTextFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner sc = new Scanner(file);
		Digraph<String> graph = new Digraph<String>();

		while (sc.hasNextLine())
		{
			graph.size++;
			String[] currentLineNodes = sc.nextLine().split(" ");
			Edge<String> newEdge = new Edge<String>(currentLineNodes[0], (currentLineNodes[1]));
			graph.addEdge(newEdge);
		}

		sc.close();
		return graph;
	}

	
	public static WDigraph<String> createWDiGraphFromTextFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner sc = new Scanner(file);
		WDigraph<String> graph = new WDigraph<String>();

		while (sc.hasNextLine())
		{
			graph.size++;
			String[] currentLineNodes = sc.nextLine().split(" ");
			DirectedEdge<String> newDirectedEdge = new DirectedEdge<String>(currentLineNodes[0], (currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
			graph.addEdge(newDirectedEdge);
		}

		sc.close();
		return graph;
	}
	
	public static WDigraph<String> createWDiGraphFromMetroFile(String path, Map<Integer, String> stationList) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner sc = new Scanner(file);
		WDigraph<String> graph = new WDigraph<String>();
		sc.nextLine();
		//Map<Integer, String> stationList = new HashMap<>();
		while (sc.hasNextLine() && !sc.nextLine().contains("$"))
		{
			//String[] currentLine = sc.nextLine().split(" ");
			//stationList.put(Integer.valueOf(currentLine[0]), currentLine[1]);
			//System.out.println(currentLine[1]);
			System.out.println(sc.nextLine());
			
		}		
		while (sc.hasNextLine())
		{
			graph.size++;
			String[] currentLineNodes = sc.nextLine().split(" ");
			DirectedEdge<String> newDirectedEdge = new DirectedEdge<String>(currentLineNodes[0], (currentLineNodes[1]), Double.parseDouble(currentLineNodes[2]));
			graph.addEdge(newDirectedEdge);
			System.out.println(currentLineNodes[0]);
		}

		sc.close();
		return graph;
	}
}
