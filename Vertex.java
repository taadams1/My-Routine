/**
 * Initial copy of found Vertex class,
 * working on tweaks for personal use and
 * reworking to avoid plagiarism >_>
 */

import java.util.ArrayList;

package MyRoutine;

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
		this.neighborhood.remove(index);
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
	
	//to self: is this where to correctly increment visits?
	public boolean equals(Object other)
	{
		if(!(other instanceof Vertex))
		{
			return false;
		}
		Vertex v = (Vertex)other;
		//increment visits to place if already in graph
		v.visit();
		
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
