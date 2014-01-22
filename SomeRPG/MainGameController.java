import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGameController extends SuperController{

	private MainGameView mainGameView;

	public MainGameController(MainGameView mainGameView){

		this.mainGameView = mainGameView;
		
		RPGUtility.mainFrame.setContentPane(mainGameView);
		
		RPGUtility.gameController = this;
		
		mainGameView.setFocusable(true);
		mainGameView.requestFocus();
		
		RPGUtility.mainFrame.pack();
		RPGUtility.mainFrame.repaint();
	
	}
	
}