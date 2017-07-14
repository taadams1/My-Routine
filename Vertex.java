/**
 * Vertex class created frmo tutorial, some tweaks
 * made, more to come
 */

package MyRoutine;

import java.util.ArrayList;

public class Vertex
{
	private ArrayList<Edge> neighborhood;
	private String place;
	private int visits;
	
	public Vertex(String place)
	{
		this.place = place;
		this.neighborhood = new ArrayList<Edge>();
		visits = 1;
	}
	
	public void addNeighbor(Edge edge)
	{
		if(this.neighborhood.contains(edge))
		{
			return;//future spot to increment paths
		}
		this.neighborhood.add(edge);
	}
	
	public boolean containsNeighbor(Edge other)
	{
		return this.neighborhood.contains(other);
	}
	
	public Edge getNeighbor(int index)
	{
		return this.neighborhood.get(index);
	}
	
	//not needed for this app
	Edge removeNeighbor(int index)
	{
		return this.neighborhood.remove(index);
	}
	
	//not needed for this app
	public void removeNeighbor(Edge e)
	{
		this.neighborhood.remove(e);
	}
	
	//probably not needed for app
	public int getNeighborCount()
	{
		return this.neighborhood.size();
	}
	
	public String getLabel()
	{
		return this.place;
	}
	
	public String toString()
	{
		return "Place: " + place + " Visits: " + visits;
	}
	
	public int hashCode()
	{
		return this.place.hashCode();
	}
	
	public boolean equals(Object other)
	{
		if(!(other instanceof Vertex))
		{
			return false;
		}
		Vertex v = (Vertex)other;
				
		return this.place.equals(v.place);
	}
	
	public ArrayList<Edge> getNeighbors()
	{
		return new ArrayList<Edge>(this.neighborhood);
	}
	
	public void visit()
	{
		visits++;
	}

}
