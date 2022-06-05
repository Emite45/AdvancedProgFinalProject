import java.util.*;
import java.util.stream.Collectors;

public class DijkstraBidirectional <V extends Comparable<V>> extends Dijkstra<V>
{
    private Map<List<V>, Double> fringeGoal;
    private List<V> closedGoal;

    public DijkstraBidirectional()
    {
        super();
        this.fringeGoal = new HashMap<>();
        this.closedGoal = new ArrayList<>();
    }


    public void dijkstraBidirectionalSP(WDigraph<V> graph, V start, V goal)
    {
        if(!verifyNonNegative(graph))
        {
            System.out.println("Graph has one or more negative weighted edge(s), results may be innacurate");
        }

        this.fringe.put(new ArrayList<>(){{add(start);}}, 0.0);
        this.fringeGoal.put(new ArrayList<>(){{add(goal);}}, 0.0);

        Map<List<V>, Double> pathStart = new HashMap<>();
        Map<List<V>, Double> pathGoal = new HashMap<>();

        printFringe(this.fringe);
        printFringe(this.fringeGoal);

        while (!haveACommonElement(this.closed, this.closedGoal))
        {
            pathStart = findMinPathinFringe(this.fringe, this.closed);
            addToFringe(this.fringe, this.closed, pathStart, graph);

//            removeFromFringe(this.fringe, pathStart);
            addToClosed(this.closed, pathStart);

            printFringe(this.fringe);


            pathGoal = findMinPathinFringe(this.fringeGoal, this.closedGoal);
            addToFringe(this.fringeGoal, this.closedGoal, pathGoal, graph);

//            removeFromFringe(this.fringeGoal, pathGoal);
            addToClosed(this.closedGoal, pathGoal);

            printFringe(this.fringe);
        }

        V commonElement = findCommonElement(this.closed, this.closedGoal);

        System.out.println("Shortest path : " + findSP(this.fringe, this.fringeGoal, commonElement));
        System.out.println("Visited nodes : " + findVisitedNodes(this.closed, this.closedGoal));
    }


    private boolean haveACommonElement(List<V> list1, List<V> list2)
    {
        Set<V> set = new HashSet<>(list1);
        set.retainAll(list2);

        return !set.isEmpty();
    }

    private V findCommonElement(List<V> list1, List<V> list2)
    {
        Set<V> set = new HashSet<>(list1);
        set.retainAll(list2);

        List<V> returnList = new ArrayList<>(set);
        return returnList.get(0);
    }

    private Map<List<V>, Double> findSP(Map<List<V>, Double> fringe, Map<List<V>, Double> fringeGoal, V commonElement)
    {
        List<V> new_pathStart = new ArrayList<>();
        List<V> new_pathGoal = new ArrayList<>();

        double minStart = Collections.max(fringe.values());
        double minGoal =Collections.max(fringeGoal.values());

        for (Map.Entry mapentry : fringe.entrySet())
        {
            List<V> key = (List<V>) mapentry.getKey();
            double value = (double) mapentry.getValue();

            if (key.contains(commonElement) && value <= minStart)
            {
                new_pathStart = key;
                minStart = value;
            }
        }

        for (Map.Entry mapentry : fringeGoal.entrySet())
        {
            List<V> key = (List<V>) mapentry.getKey();
            double value = (double) mapentry.getValue();

            if (key.contains(commonElement) && value <= minGoal)
            {
                new_pathGoal = key;
                minGoal = value;
            }
        }

        Collections.reverse(new_pathGoal);
        new_pathStart.addAll(new_pathGoal);
        new_pathStart = new_pathStart.stream().distinct().collect(Collectors.toList());

        Map<List<V>, Double> shortestPath = new HashMap<>();
        shortestPath.put(new_pathStart, minStart + minGoal);

        return shortestPath;
    }

    public List<V> findVisitedNodes(List<V> closed, List<V> closedGoal)
    {
        closed.addAll(closedGoal);
        closed = closed.stream().distinct().collect(Collectors.toList());

        return closed;
    }
}
