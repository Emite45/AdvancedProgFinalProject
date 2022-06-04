public class Edge<V>
{
	private final V source;
	private final V destination;
	
	public Edge(V sourceVertex, V destinationVertex)
	{
		this.source = sourceVertex;
		this.destination = destinationVertex;
	}
	
	public V getSource() {return source;}
	public V getDestination() {return destination;}

	@Override
	public String toString()
	{
		return this.source + " --> " + this.destination;
	}
}
