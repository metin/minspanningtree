
import java.io.*;
import javax.swing.*;

import cs631.*;


public class Program {


	public static void main(String[] args) {

        System.out.println(args[0]);
        Graph g = new Graph(750, 400);
        
        try{
        	BufferedReader input =  new BufferedReader(new FileReader(args[0]));
	        try {
	        	String line = null; 
          		int index = 0;
          		System.out.println("Graph...");
	        	while (( line = input.readLine()) != null){
	        	  if(line.trim().equals("#EDGES")) break;
	        	  String[] arr = line.split(" ");
	        	  System.out.println("Graph:" + index + ":" + line);
	        	  Node n = null;
	        	  Node node = null;
	        	  for( int j = 0;  j < arr.length; j++)
	        	  { 
		        	  n = new Node(arr[j]);
		        	  node = g.findNode(n);
		        	  if(node == null) g.addNode(n, index);
	        	  }
	        	  index++;
	        	}
	        	System.out.println("Edges...");
	        	while (( line = input.readLine()) != null){
	        	  String[] arr = line.split(" ");
	        	  System.out.println(arr[0] + " - " + arr[1] + " - " + arr[2]);
	        	  Node n = new Node(arr[0]);
	        	  Node left = g.findNode(n);
	        	  n = new Node(arr[1]);
	        	  Node right = g.findNode(n);
	        	  g.addEdge(left, right, Integer.parseInt(arr[2]));
	        	}
	        }
	        finally {
	        	input.close();
	        }
        }
        catch(Exception e) { }
        
        g.prepareNodes();
        g.sortEdges();
        g.kruskal();
        
        MainWindow f = new MainWindow(g);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
