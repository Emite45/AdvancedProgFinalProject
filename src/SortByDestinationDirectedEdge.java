import java.util.Comparator;

public class SortByDestinationDirectedEdge<V extends Comparable<V>> implements Comparator<DirectedEdge<V>>
{
	public int compare(DirectedEdge<V> a, DirectedEdge<V> b)
	{
		V aTo = a.getDestination();
		V bTo = b.getDestination();

		return aTo.compareTo(bTo);
	}
}
