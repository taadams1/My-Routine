/**Edge class built from tutorial, some tweaks made
 * more to come
 */

package MyRoutine;

public class Edge implements Comparable<Edge>
{
	
	private Vertex one, two;
	private int weight;
	
	public Edge(Vertex one, Vertex two)
	{
		this(one, two, 1);
	}
	
	public Edge (Vertex one, Vertex two, int weight)
	{
		this.one = (one.getLabel().compareTo(two.getLabel())
					<= 0) ? one : two;
		this.two = (this.one == one) ? two : one;
		this.weight = weight;
	}
	
	public Vertex getNeighbor(Vertex current)
	{
		if (!( current.equals(one) || current.equals(two)))
		{ return null; }
		return (current.equals(one)) ? two : one;
	}
	
	//general getter methods for vertices and weight
	public Vertex getOne()
	{
		return this.one;
	}
	
	public Vertex getTwo()
	{
		return this.two;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	//compares edge weights
	public int compareTo(Edge other)
	{
		return this.weight - other.weight;
	}
	
	//toString method for edge
	public String toString()
	{
		return "[{ " + one + ", " + two + " }, "
				+ weight + " ]";
	}
	
	public int hashCode()
	{
		return (one.getLabel() + two.getLabel()).hashCode();
	}
	
	//compare edges, return true if same
	public boolean equals(Object other)
	{
		if (!( other instanceof Edge))
		{ return false; }
		Edge e = (Edge)other;
		
		return e.one.equals(this.one) &&
				e.two.equals(this.two);
	}

}
