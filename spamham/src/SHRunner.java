import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class SHRunner {
		static JPanel pane = new JPanel();
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("Ham Spam Filter");
		mainFrame.setMinimumSize(new Dimension(600, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setContentPane(pane);
		pane.setLayout(new BorderLayout(5,5));
		
		pane.add(new Buttons(), BorderLayout.NORTH);
		pane.add(new TableOfWords(), BorderLayout.CENTER);
		pane.add(new BottomPane(),BorderLayout.SOUTH);
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
}
