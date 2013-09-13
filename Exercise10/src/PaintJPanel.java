import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PaintJPanel extends JPanel{
	private String Shape="circle";
	private Color c=Color.BLACK;
	private int x;
	private int y;
	private boolean clicked;
	
	public PaintJPanel() {
		super();
		this.setBackground(Color.WHITE);
	}

	public PaintJPanel(String shape, Color c, int x, int y, boolean clicked) {
		super();
		Shape = shape;
		this.c = c;
		this.x = x;
		this.y = y;
		this.clicked = clicked;
	}

	public String getShape() {
		return Shape;
	}

	public void setShape(String shape) {
		Shape = shape;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(c);
		if (clicked==true){
		if(Shape.equals("circle")){
			g.fillArc(x-9, y-9, 18, 18, 0, 360);	
		}else if(Shape.equals("triangle")){
			int[] xPoints={x-20,x,x+20};
			int[] yPoints={y+10,y-10,y+10};
			g.fillPolygon(xPoints, yPoints, 3);
			int[] xPoints2={x,x-10,x+10};
			int[] yPoints2={y+10,y,y};
			g.setColor(Color.WHITE);
			g.fillPolygon(xPoints2, yPoints2, 3);
			g.setColor(c);
		}else if(Shape.equals("cross")){
			g.fillRect(x-10, y-20, 15, 40);
			g.fillRect(x-20, y-10, 35, 15);
		}else if(Shape.equals("hexagon")){
			int[] xpoints={x-15,x,x+15,x+15,x,x-15};
			int[] ypoints={y+10,y+20,y+10,y-10,y-20,y-10};
			g.fillPolygon(xpoints,ypoints,6);
		}
		}
		
	}
}
