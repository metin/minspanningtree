package cs610;

import java.awt.Color;

public class Edge implements Comparable<Edge> {
  public Vertex left;
  public Vertex right;
  public int weight;
  public boolean selected = false;

  public Edge(Vertex pLeft, Vertex pRight, int pWeight) {
    this.left = pLeft;
    this.right = pRight;
    this.weight = pWeight;
  }

  public int middleX() {
    return (left.x + right.x) / 2;
  }

  public int middleY() {
    return (left.y + right.y) / 2;
  }

  public void select() {
    this.selected = true;
  }

  public boolean isSelected() {
    return this.selected;
  }

  public Color getColor() {
    return isSelected() ? Color.red : Color.lightGray;
  }

  @Override
  public int compareTo(Edge o) {
    return (this.weight - o.weight);
  }

}
