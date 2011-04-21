package cs631;

public class Edge {
	public Node left;
	public Node right;
	public int weight;
	
	public Edge(Node pLeft, Node pRight, int pWeight)
	{
		this.left = pLeft;
		this.right = pRight;
		this.weight = pWeight;
	}
}
