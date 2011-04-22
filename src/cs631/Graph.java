package cs631;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Graph {
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public ArrayList<Edge> edges = new ArrayList<Edge>();
	public int width;
	public int height;
	
	
	public Graph(int pWidth, int pHeight)
	{
		width = pWidth;
		height = pHeight;	
	}

	public void prepare()
	{
		/*
		Random randx = new Random(); 
		Random randy = new Random(); 
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext())
		{
			Node node = i.next();
			int x = randx.nextInt(width);
			while(!isXValid(x))
			{
				x = randx.nextInt(width);
				System.out.println(x);
			}
			node.x = x;
			
			int y = randy.nextInt(height);
			while(!isYValid(y))
			{
				y = randy.nextInt(height);
				System.out.println(y);
			}
			node.y =y;
		}
		*/
		
		int curx = 50;
		int cury = 50;
		boolean xChanged = true;
		boolean yChanged = true;
		boolean newRow = false;

		Iterator<Node> i = nodes.iterator();
		while(i.hasNext())
		{
			Node node = i.next();
			
			if(curx > 700)
			{
				curx = 50;
				if(xChanged)
					curx += 20;
				cury += 180;
				newRow = true;
			}
			
			node.x = curx;
			if(!xChanged)
				node.x += 50;
			
			node.y = cury;
			if(!yChanged)
				node.y += 50;
			
			xChanged = !xChanged;
			yChanged = !yChanged;

			curx += 150;
			newRow = false;
			
		}
		
		Collections.sort(edges);
	}
	
	public boolean isXValid(int x)
	{
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext())
		{
			Node node = i.next();
			if((x <= 30) || (x > width-10))
				return false;
		}
		return true;
	}

	public boolean isYValid(int y)
	{
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext())
		{
			Node node = i.next();
			if( (y <= 30 ) || (y > height -10) )
				return false;
		}
		return true;
	}
	
	public void addNode(Node node)
	{
		nodes.add(node);
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
