import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Paint {
	
	
	public static void main(String[] args) {
		JFrame mf = new JFrame("Paint");
		mf.setSize(700,700);
		
		
		PaintJPanel pane1 = new PaintJPanel();
		pane1.setBackground(Color.WHITE);
		
		JPanel pane = new JPanel();
		JPanel colors = new JPanel();
		JPanel brushes = new JPanel();
		mf.setContentPane(pane);
		pane.setLayout(new BorderLayout());
		pane.add(pane1,BorderLayout.CENTER);
		pane.add(colors,BorderLayout.WEST);
		pane.add(brushes,BorderLayout.EAST);
		
		brushes.setLayout(new GridLayout(4,1));
		JButton[] brush = new JButton[4];
		for(int i=0;i<4;i++){
			brush[i]=new JButton();
			brushes.add(brush[i]);
			brush[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					
				}
			});
		}
		brush[0].setText("circle");
		brush[1].setText("triangle");
		brush[2].setText("cross");
		brush[3].setText("hexagon");
		
		JButton[] color = new JButton[5];
		colors.setLayout(new GridLayout(5,1));
		for(int i=0;i<5;i++){
			color[i]=new JButton();
			colors.add(color[i]);
			color[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					
				}
			});
		}
		color[0].setBackground(Color.RED);
		color[1].setBackground(Color.BLUE);
		color[2].setBackground(Color.GREEN);
		color[3].setBackground(Color.YELLOW);
		color[4].setBackground(Color.BLACK);
		
		pane1.addMouseListener(new MouseAdapter() {
		
			public void mouseDragged(MouseEvent e){
				PaintJPanel.x=e.getX();
				PaintJPanel.y=e.getY();
			}
		});
		pane1.repaint();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

}
