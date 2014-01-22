import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class InstructionController extends SuperController{

	private InstructionView iv;
	
	public InstructionController(InstructionView iv){
		
		this.iv = iv;
		
		RPGUtility.mainFrame.setContentPane(iv);
		
		RPGUtility.gameController = this;
		
		iv.setFocusable(true);
		iv.requestFocus();
		
		RPGUtility.mainFrame.pack();
		RPGUtility.mainFrame.repaint();
		
	}

}