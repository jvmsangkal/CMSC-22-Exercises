import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class LabSample10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mf = new JFrame("CMSC22 Lab10");
		PaintJPanel pane = new PaintJPanel();
		
		/*pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(new JButton("Hello"));
		pane.add(new JButton("World"));
		*/
		mf.setContentPane(pane);
		mf.setSize(500, 500);
		JButton test=new JButton("Press Me!");
		
		test.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				System.out.println("Pressed Test");
			}
		});
		pane.add(test);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
	}

}
