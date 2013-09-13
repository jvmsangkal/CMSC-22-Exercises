import javax.swing.*;
import java.awt.*;

public class PaintJPanel extends JPanel{

	public PaintJPanel(){
		super();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawLine(50, 50, 350, 350);
		g.setColor(Color.RED);
		g.drawOval(225, 225, 50, 50);
		g.setColor(new Color(25,25,255));
		g.drawString("CMSC22", 100, 100);
		g.fillArc(230, 230, 40, 40, 0, 230); 
	}
}
