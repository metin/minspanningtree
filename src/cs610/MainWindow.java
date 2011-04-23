package cs610;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

  private static final long serialVersionUID = 1L;
  public Graph graph = null;

  public MainWindow(Graph pGraph) {
    graph = pGraph;
  }

  public void paint(Graphics g) {
    printCost(g);
    for (int i = 0; i < this.graph.nodes.size(); i++)
      paintNode(g, this.graph.nodes.get(i));
    for (int i = 0; i < this.graph.edges.size(); i++)
      paintEdge(g, this.graph.edges.get(i));
  }
  
  public void printCost(Graphics g)
  {
    g.setColor(Color.blue);
    Font f = g.getFont();
    Font nf = new Font(f.getName(), Font.BOLD, 16);
    g.setFont(nf);
    g.drawString("COST:" + graph.mstCost, 50, 50);
    g.setFont(f);
  }

  public void paintNode(Graphics g, Node n) {
    FontMetrics fm = g.getFontMetrics();
    int x = n.x;
    int y = n.y;
    int w = fm.stringWidth(n.name) + 10;
    int h = fm.getHeight() + 4;

    g.setColor(Color.black);
    g.drawRect(x - w / 2, y - h / 2, w, h);
    g.setColor(Color.white);
    g.fillRect(x - w / 2 + 1, y - h / 2 + 1, w - 1, h - 1);
    g.setColor(Color.blue);
    Font f = g.getFont();
    Font nf = new Font(f.getName(), Font.BOLD, 16);
    g.setFont(nf);
    g.drawString(n.name, x - (w - 10) / 2, (y - (h - 4) / 2) + fm.getAscent());
    g.setFont(f);
  }

  public void paintEdge(Graphics g, Edge e) {
    g.setColor(e.getColor());
    g.drawLine(e.left.x, e.left.y, e.right.x, e.right.y);
    g.setColor(Color.black);
    
    Font f = g.getFont();
    Font nf = new Font(f.getName(), Font.BOLD, 14);
    g.setFont(nf);
    g.drawString("" + e.weight, e.middleX(), e.middleY());
    g.setFont(f);
  }
}
