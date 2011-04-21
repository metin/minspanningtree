import java.awt.Color;
import java.awt.Graphics;
import java.io.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import cs631.*;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("test");
        System.out.println(args[0]);

        
        try{
	        BufferedReader input =  new BufferedReader(new FileReader(args[0]));
	        try {
	          String line = null; //not declared within while loop
	
	          while (( line = input.readLine()) != null){
	        	  System.out.println(line);
	          }
	        }
	        finally {
	          input.close();
	        }
        }
        catch(Exception e)
        {
        	
        }
        
        
        
        MainWindow f = new MainWindow();
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
