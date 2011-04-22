import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import cs631.*;
import cs631.Edge;
import cs631.Node;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println(args[0]);
        Graph g = new Graph(750, 400);
        
        try{
	        BufferedReader input =  new BufferedReader(new FileReader(args[0]));
	        try {
	          String line = null; 
	
	          while (( line = input.readLine()) != null){
	        	  
	        	  String[] arr = line.split(" ");
	        	  
	        	  System.out.println(arr[0] + " - " + arr[1] + " - " + arr[2]);
	        	  
	        	  cs631.Node n = new cs631.Node(arr[0]);
	        	  cs631.Node left = g.findNode(n);
	        	  if(left == null)
	        	  {
	        		  left = new cs631.Node(arr[0]);
	        		  g.addNode(left);
	        	  }

	        	  n = new cs631.Node(arr[1]);
	        	  cs631.Node right = g.findNode(n);
	        	  if(right == null)
	        	  {
	        		  right = new cs631.Node(arr[1]);
	        		  g.addNode(right);
	        	  }
	        	  
	        	  g.addEdge(left, right, Integer.parseInt(arr[2]));
	          }
	        }
	        finally {
	          input.close();
	        }
        }
        catch(Exception e)
        {
        	
        }
        
        g.prepare();
        
        Iterator<Edge> i  = g.edges.iterator();
        
        System.out.println( "Sorting... ");
		while(i.hasNext())
		{
			Edge e = i.next();
			System.out.println( " Edge - " + e.weight);
		}
		
        MainWindow f = new MainWindow(g);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
