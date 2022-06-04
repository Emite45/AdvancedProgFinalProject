import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		WDigraph<String> myWDiGraph = GraphFactory.createWDiGraphFromTextFile("graph-WDG.txt");
		System.out.println(myWDiGraph);

		DijkstraSP<String> myDijkstraSP = new DijkstraSP<>(myWDiGraph, "0", "7");
//		System.out.println("The graph contains no negative weight edge ? " + myDijkstraSP.verifyNonNegative(myWDiGraph));



//		Map<String, Integer> map = new HashMap<>()
//		{{
//			put("0", 0);
//			put("1", 1);
//			put("2", 2);
//			put("3", 3);
//			put("4", 4);
//		}};
//
//		List<Integer> values = new ArrayList<>(map.values());
//		System.out.println(Collections.min(values));
//		System.out.println(Collections.max(values));


//		List<Integer> list = new ArrayList<>()
//		{{
//			add(1);
//			add(2);
//			add(3);
//		}};
//
//		List<Integer> list2 = new ArrayList<>();
//		list2.addAll(list);
//		list2.add(4);
//
//		System.out.println(list);
//		System.out.println(list2);
	}
}
