import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PaintJPanel extends JPanel{
	public static String Shape="circle";
	public static Color c;
	public static int x;
	public static int y;
	
	
	public PaintJPanel() {
		
	}

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(c);
		if(Shape.equals("circle")){
			g.fillArc(x, y, 17, 17, 0, 360);
			
		}else if(Shape.equals("triangle")){
		
			
		}else if(Shape.equals("cross")){
			
			
		}else if(Shape.equals("hexagon")){
			
			
		}
		repaint();
		
	}
}
