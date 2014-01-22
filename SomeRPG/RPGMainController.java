import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class RPGMainController extends SuperController{

	private RPGMainView rpgMainView;

	public RPGMainController(RPGMainView rpgMainView){

		this.rpgMainView = rpgMainView;
	
		RPGUtility.mainFrame.setContentPane(rpgMainView);
		rpgMainView.setFocusable(true);
		rpgMainView.requestFocus();
		
		RPGUtility.gameController = this;

		RPGUtility.mainFrame.pack();
		RPGUtility.mainFrame.repaint();
	
	}
	
}