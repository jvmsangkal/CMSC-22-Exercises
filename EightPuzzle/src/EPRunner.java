import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
//Subject CMSC 170 U-4L Exer2
/* Author: John Viscel M.Sangkal
 * Program Description: 8Puzzle Solver using a* algorithm
 * Developed using Eclipse IDE. Move the initialState.txt to /src
 * Bugs: None. Mabagal lang talaga.
 * 
*/
public class EPRunner {
	static JPanel pane = new JPanel();
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("Eight Puzzle");
		mainFrame.setMinimumSize(new Dimension(400, 300));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setContentPane(pane);
		pane.setLayout(new BorderLayout());
		
		pane.add(new Board(), BorderLayout.CENTER);
		pane.add(new EPSolver(), BorderLayout.EAST);
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}

}
