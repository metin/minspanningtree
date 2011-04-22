package cs631;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;


public class MainWindow extends JFrame {
    
    public Graph graph = null;
    
    public MainWindow(Graph pGraph)
    {
        graph = pGraph;
//        Container container = this.getContentPane();
//        GridLayout layout = new GridLayout(2, 1);
//        container.setLayout(layout);
//        JPanel top = new JPanel();
//        top.setLayout(new GridLayout(1,3));
//        top.add(new JButton("Btn")); 
//        container.add(top);
//        container.add(new JButton("Btn")); 
        
    }
    
    public void paint(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        for (int i = 0; i < this.graph.nodes.size(); i++)
            paintNode(g, this.graph.nodes.get(i), fm);
        for (int i = 0; i < this.graph.edges.size(); i++)
            paintEdge(g, this.graph.edges.get(i), fm);

    }

    public void paintNode(Graphics g, Node n, FontMetrics fm) {
        String s;
        int x = n.x;
        int y = n.y;
        int w = fm.stringWidth(n.name) + 10;
        int h = fm.getHeight() + 4;
        n.w = w;
        n.h = h;

        g.setColor(Color.black);
        g.drawRect(x-w/2,y-h/2,w,h);

        g.setColor(getBackground());
        g.fillRect(x-w/2+1,y-h/2+1,w-1,h-1);

        g.setColor(Color.black);
        g.drawString(n.name,x-(w-10)/2,(y-(h-4)/2)+fm.getAscent());
    }

    void drawEdge(Graphics g,int x1,int y1,int x2,int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    public void paintEdge(Graphics g, Edge e, FontMetrics fm) {

    	drawEdge(g, e.left.x, e.left.y, e.right.x, e.right.y);
        g.drawString("" + e.weight, e.middleX(), e.middleY());
    }
}
