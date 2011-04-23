package cs631;

public class Node {
	public String name;
	public int x;
	public int y;
	public Node head, tail, next;
	
	public Node(String pName, int px, int py) 
	{
		this.name = pName;
		this.x = px;
		this.y = py;
        next = null;      
        head = tail = this;
	}

	public Node(String pName) 
	{
		this.name = pName;
		x = 0;
		y = 0;
        next = null;      
        head = tail = this;
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
