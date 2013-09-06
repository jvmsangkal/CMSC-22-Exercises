import java.awt.*;

import javax.swing.*;

public class Lab9Sample {
	
	public static void main (String[] args){
		JFrame mf = new JFrame("CMSC22 Lab9");
		JPanel pane = new JPanel();
		mf.setContentPane(pane);
		mf.setSize(500,500);
		//pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		//pane.setLayout(new GridLayout(2,2));
		pane.setLayout(new BorderLayout());
		JButton b1= new JButton("Button 1");
		//b1.addActionListener(new SampleActionListener(b1));
		//b1.addKeyListener(new SampleKeyListener());
		pane.addKeyListener(new SampleKeyListener());
		pane.setFocusable(true);
		pane.add(b1);
		
		//pane.add(new JButton("Button1"),BorderLayout.CENTER);
		//pane.add(new JButton("Button2"),BorderLayout.CENTER);
		//pane.add(new JButton("Button3"),BorderLayout.NORTH);
		//JPanel west = new JPanel();
		//west.setLayout(new GridLayout(2,1));
		//west.add(new JLabel("W1"));
		//west.add(new JLabel("W2"));
		//pane.add(west,BorderLayout.WEST);
		
		//for(int i=1000;i<1500;i++){
			//pane.add(new JLabel(""+i));
			
		//}
		mf.setVisible(true);
	}
}
