import java.io.*;
import javax.swing.*;

import cs610.*;

public class Mst {

  public static void main(String[] args) {

    if(args.length != 1)
    {
      System.out.println("Usage: java Msp <filename>");
      System.exit(2);
    }
    Graph g = new Graph();
    loadFile(g, args[0]);

    // Calculate locations of nodes
    g.prepareNodes();
    // Perform kruskal algorithm
    g.kruskal();

    // Show results in JFrame
    MainWindow f = new MainWindow(g);
    f.setSize(800, 600);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public static void loadFile(Graph g, String fileName) {
    System.out.println("Reading date from " + fileName);
    try {
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      try {
        String line = null;
        int index = 0;
        System.out.println("Graph...");
        while ((line = input.readLine()) != null) {
          if (line.trim().equals("#EDGES"))
            break;
          String[] arr = line.split(" ");
          System.out.println("Graph Line " + index + ":  " + line);
          Vertex n = null;
          Vertex node = null;
          for (int j = 0; j < arr.length; j++) {
            n = new Vertex(arr[j]);
            node = g.findNode(n);
            if (node == null)
              g.addNode(n, index);
          }
          index++;
        }
        System.out.println("Edges...");
        while ((line = input.readLine()) != null) {
          String[] arr = line.split(" ");
          System.out.println("[" + arr[0] + " - " + arr[1] + "] - Cost: "
              + arr[2]);
          Vertex n = new Vertex(arr[0]);
          Vertex left = g.findNode(n);
          n = new Vertex(arr[1]);
          Vertex right = g.findNode(n);
          g.addEdge(left, right, Integer.parseInt(arr[2]));
        }
      } finally {
        input.close();
      }
    } catch (Exception e) {
    }

  }

}
