import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class RPGMainMenuItem extends JPanel{

	private String menuString;
	private int x, y;
	
	public RPGMainMenuItem(String menuString, int x, int y){
		this.menuString = menuString;
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		g.setFont(RPGUtility.getFinalFantasyFont());
		g.drawString(menuString, x, y);
		
	}

}