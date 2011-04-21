package cs631;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {
    public MainWindow()
    {
    	
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }
    
}
