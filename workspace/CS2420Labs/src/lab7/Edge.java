package lab7;

public class Edge 
{
  private Vertex other; // 2nd vertex in Edge 

  private int distance;
  
  public Edge(Vertex _other, int _distance) 
  {
    this.other = _other;
    this.distance = _distance;
  }
  
  public int getDistance(){
	  return distance;
  }

  public Vertex getOtherVertex() 
  {
    return other;
  }

  public String toString() 
  {
    return other.getName();
  }
}
