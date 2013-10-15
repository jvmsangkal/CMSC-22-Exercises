import java.awt.Dimension;

import javax.swing.JFrame;


public class SNMRunner {
	
	public static void main(String[] args){
			
		JFrame mainFrame = new JFrame("MassageBang!");
		mainFrame.setMinimumSize(new Dimension(1000, 700));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		SNMStat.mainFrame = mainFrame;
	
		SNMMainController snmMainController  = new SNMMainController(new SNMMainView());
	
	}
}
