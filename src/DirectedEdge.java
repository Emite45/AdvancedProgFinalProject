public class DirectedEdge<V> extends Edge<V>
{
	private final double weight;
	
	public DirectedEdge(V source, V destination, double weightDouble)
	{
		super(source, destination);
		this.weight = weightDouble;
	}
	
	public double getWeight() {return weight;}

	@Override
	public String toString()
	{
		return this.getSource() + " --> " + this.getDestination() + " : " + this.weight;
	}
}
