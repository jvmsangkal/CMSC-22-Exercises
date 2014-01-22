import javax.swing.JFrame;
import java.awt.Dimension;

public class RPGRunner{
	
	public static void main(String[] args){
		
		SpriteUtility.loadImages();
		
		JFrame mainFrame = new JFrame("FINAL COQUETRY");
		mainFrame.setMinimumSize(new Dimension(500, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		RPGUtility.mainFrame = mainFrame;
	
		RPGMainController rpgMainController  = new RPGMainController(new RPGMainView());
	
	}

}