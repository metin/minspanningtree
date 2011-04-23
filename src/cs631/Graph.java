package cs631;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;


public class Graph {
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Edge> edges = new ArrayList<Edge>();
	public ArrayList<ArrayList<Node>> lines = new ArrayList<ArrayList<Node>>();

	public int width;
	public int height;
	public int xStep = 140;
	public int yStep = 100;

	
	public Graph(int pWidth, int pHeight)
	{
		width = pWidth;
		height = pHeight;	
	}

	public void prepareNodes()
	{
		int xCurrent = 50;
		int yCurrent = 50;
		Iterator<ArrayList<Node>> i = lines.iterator();
		while(i.hasNext())
		{
			ArrayList<Node> line = i.next();
			Iterator<Node> li = line.iterator();
			
			while(li.hasNext())
			{
				Node node = li.next();
				node.x = xCurrent;
				node.y = yCurrent;
				xCurrent += xStep;
			}
			yCurrent += 2 * yStep;
			xCurrent = 50;
		}
	}
	
	public void sortEdges()
	{
		Collections.sort(edges);
	}

	public void kruskal()
	{
		sortEdges();
		ArrayList<Edge> mst = new ArrayList<Edge>();  
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); )
	    {
			Edge e = it.next();
			if(e.left.head != e.right.head)
			{
				mst.add(e);
				union(e.left, e.right);
			}
	    }
		
		for (Iterator<Edge> it = mst.iterator(); it.hasNext(); )
	    {
			it.next().select();
	    }
		
	}
	
	public void union(Node left, Node right)
	{
		left.head.tail.next = right.head;   
	    left.head.tail = right.head.tail;   
	    for (Node v = right.head; v!=null; v = v.next)
	      v.head = left.head;            
	}

	public void addNode(Node node, int index)
	{
		nodes.add(node);
		ArrayList<Node> curLine = new ArrayList<Node>();
		if(lines.size() > index)
			curLine = lines.get(index);
		else
			lines.add(curLine);
		curLine.add(node);
	}
	
	public void addEdge(Node left, Node right, int weight)
	{
		Edge e = new Edge(left, right, weight);
		edges.add(e);
	}
	
	public Node findNode(Node node)
	{
		if(nodes.contains(node))
		{
			return nodes.get(nodes.indexOf(node));
		}
		return null;
	}
	

}
