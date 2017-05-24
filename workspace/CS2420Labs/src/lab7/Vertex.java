package lab7;

import java.util.LinkedList;
import java.util.Iterator;

public class Vertex 
{
  private String name; // used to id the Vertex

  private int Vertsize;
  
  private LinkedList<Edge> adj; // adjacency list

  public Vertex(String _name) 
  {
    this.name = _name;
    this.adj = new LinkedList<Edge>();
  }

  public String getName() 
  {
    return name;
  }

  public void addEdge(Vertex otherVertex, int length) 
  {
    adj.add(new Edge(otherVertex, length));
  }

  public Iterator<Edge> edges() 
  {
    return adj.iterator();
  }

  public String toString() 
  {
    String s = "Vertex " + name + " adjacent to ";
    Iterator<Edge> itr = adj.iterator();
    while (itr.hasNext())
      s += itr.next() + "  ";
    return s;
  }
  
  public int DijkstrasAlgorithm (Graph gr, Vertex ver){
	  for (Vertex: adj){
		  
	  }
  }
}
