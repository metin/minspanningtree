package cs610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Graph {
  public ArrayList<Vertex> nodes = null;
  public ArrayList<Edge> edges = null;
  public ArrayList<ArrayList<Vertex>> lines = null;

  public int xStep = 140;
  public int yStep = 80;
  public int mstCost = 0;
  
  public Graph() {
    nodes = new ArrayList<Vertex>();
    edges = new ArrayList<Edge>();
    lines = new ArrayList<ArrayList<Vertex>>();
  }

  public void prepareNodes() {
    int xCurrent = 50;
    int yCurrent = 80;
    Iterator<ArrayList<Vertex>> i = lines.iterator();
    while (i.hasNext()) {
      ArrayList<Vertex> line = i.next();
      Iterator<Vertex> li = line.iterator();

      while (li.hasNext()) {
        Vertex node = li.next();
        node.x = xCurrent;
        node.y = yCurrent;
        xCurrent += xStep;
      }
      yCurrent += 2 * yStep;
      xCurrent = 50;
    }
  }

  public void sortEdges() {
    Collections.sort(edges);
  }

  public void kruskal() {
    sortEdges();
    ArrayList<Edge> mst = new ArrayList<Edge>();
    for (Iterator<Edge> it = edges.iterator(); it.hasNext();) {
      Edge e = it.next();
      if (e.left.head != e.right.head) {
        mst.add(e);
        union(e.left, e.right);
      }
    }

    for (Iterator<Edge> it = mst.iterator(); it.hasNext();) {
      Edge sel = it.next();
      sel.select();
      mstCost += sel.weight;
    }

  }

  public void union(Vertex left, Vertex right) {
    left.head.tail.next = right.head;
    left.head.tail = right.head.tail;
    for (Vertex v = right.head; v != null; v = v.next)
      v.head = left.head;
  }

  public void addNode(Vertex node, int index) {
    nodes.add(node);
    ArrayList<Vertex> curLine = new ArrayList<Vertex>();
    if (lines.size() > index)
      curLine = lines.get(index);
    else
      lines.add(curLine);
    curLine.add(node);
  }

  public void addEdge(Vertex left, Vertex right, int weight) {
    Edge e = new Edge(left, right, weight);
    edges.add(e);
  }

  public Vertex findNode(Vertex node) {
    if (nodes.contains(node)) {
      return nodes.get(nodes.indexOf(node));
    }
    return null;
  }

}
