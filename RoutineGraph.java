/**Graph class built from tutorial, some tweaks made
 * more to come
 */

package MyRoutine;

import java.util.HashMap;
import java.util.Set;

public class RoutineGraph
{
	private HashMap<String, Vertex> vertices;
	private HashMap<Integer, Edge> edges;

	
	public RoutineGraph()
	{
		this.vertices = new HashMap<String, Vertex>();
		this.edges = new HashMap<Integer, Edge>();
	}
	
	//add edge with default weight if it does not exist
	public boolean addEdge(Vertex one, Vertex two)
	{
		return addEdge(one, two, 1);//returns true if added
	}
	
	//add edge with provided weight
	public boolean addEdge(Vertex one,Vertex two,int weight)
	{
		if (one.equals(two)) { return false; }
		
		//check that edge is not in graph
		Edge e = new Edge(one,two,weight);
		//future location to increment trips along
		//the same path
		if (edges.containsKey(e.hashCode()))
		{
			return false;
		}
		//check that edge is not incident to either vertex
		else if (one.containsNeighbor(e) || two.containsNeighbor(e))
		{
			return false;
		}
		
		edges.put(e.hashCode(), e);
		one.addNeighbor(e);
		two.addNeighbor(e);
		return true;
	}
	
	public boolean containsEdge(Edge e)
	{
		if (e.getOne() == null || e.getTwo() == null)
		{
			return false;
		}
		return this.edges.containsKey(e.hashCode());
	}
	
	//don't need to remove edges
	
	//check graph for specified vertex
	public boolean containsVertex(Vertex vertex)
	{
		return this.vertices.get(vertex.getLabel()) != null;
	}
	
	//return vertex with specified name
	public Vertex getVertex(String place)
	{
		return vertices.get(place);
	}
	
	//method to add a vertex
	public boolean addVertex(Vertex vertex)
	{
		Vertex current = this.vertices.get(vertex.getLabel());
		if (current != null)
		{
			return false;
		}
		vertices.put(vertex.getLabel(), vertex);
		return true;
		
	}
		
	/**@return set of places from graph
	 */
	public Set<String> vertexKeys()
	{
		return this.vertices.keySet();
	}
	
	/**
	 * @return Edges in graph
	 */
	public Set<Edge> getEdges()
	{
		return new HashSet<Edge>(this.edges.values());
	}
	
	public void printRoutine()
	{
		
	}

}
