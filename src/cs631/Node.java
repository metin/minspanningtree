package cs631;

public class Node {
	public String name;
	public int x;
	public int y;
	public int w;
	public int h;
	
	public Node(String pName, int px, int py) 
	{
		this.name = pName;
		this.x = px;
		this.y = py;
		h = 5;
		w = 5;
	}

	public Node(String pName) 
	{
		this.name = pName;
		x = 0;
		y = 0;
	}
	
	@Override
	public boolean equals(Object o)
	{
	    if (o instanceof Node) {
	    	Node n = (Node) o;
	        if (this.name.equals(n.name)) return true;
	    }
	    return false;
	}

	
}
