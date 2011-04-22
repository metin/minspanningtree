package cs631;

public class Edge implements Comparable<Edge> {
	public Node left;
	public Node right;
	public int weight;
	
	public Edge(Node pLeft, Node pRight, int pWeight)
	{
		this.left = pLeft;
		this.right = pRight;
		this.weight = pWeight;
	}
	
	public int middleX()
	{
		return (left.x + right.x)/2;
	}

	public int middleY()
	{
		return (left.y + right.y)/2;
	}

	@Override
	public int compareTo(Edge o) {
		return (this.weight - o.weight);
	}

	
}
