import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Paint {
	static PaintJPanel pane1 = new PaintJPanel();
	static JButton shape1= new JButton();
	static JButton shape2= new JButton();
	static JButton shape3= new JButton();
	static JButton shape4= new JButton();
	static JButton color1= new JButton();
	static JButton color2= new JButton();
	static JButton color3= new JButton();
	static JButton color4= new JButton();
	static JButton color5= new JButton();
	public static void main(String[] args) {
		JFrame mf = new JFrame("Paint");
		mf.setSize(700,700);
		Icon circle=new ImageIcon("circle.gif");
		Icon triangle=new ImageIcon("triangle.gif");
		Icon cross=new ImageIcon("cross.jpeg");
		Icon hexagon=new ImageIcon("hexagon.png");
		//shape1.setIcon(circle);
		//shape2.setIcon(triangle);
		//shape3.setIcon(cross);
		//shape4.setIcon(hexagon);
		
		shape1.setName("circle");
		shape2.setName("triangle");
		shape3.setName("cross");
		shape4.setName("hexagon");
		
		pane1.setBackground(Color.WHITE);
		color1.setBackground(Color.RED);
		color2.setBackground(Color.GREEN);
		color3.setBackground(Color.BLUE);
		color4.setBackground(Color.YELLOW);
		color5.setBackground(Color.BLACK);
		
		JPanel pane = new JPanel();
		JPanel colors = new JPanel();
		JPanel brushes = new JPanel();
		
		mf.setContentPane(pane);
		pane.setLayout(new BorderLayout());
		pane.add(colors,BorderLayout.WEST);
		pane.add(pane1,BorderLayout.CENTER);
		pane.add(brushes,BorderLayout.EAST);
		
		brushes.setLayout(new GridLayout(4,1));
		brushes.add(shape1);
		brushes.add(shape2);
		brushes.add(shape3);
		brushes.add(shape4);
		
		shape1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setShape(shape1.getName());
			}
		});
		shape2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setShape(shape2.getName());
			}
		});
		shape3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setShape(shape3.getName());
			}
		});
		shape4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setShape(shape4.getName());
			}
		});
		
		colors.setLayout(new GridLayout(5,1));
		colors.add(color1);
		colors.add(color2);
		colors.add(color3);
		colors.add(color4);
		colors.add(color5);
		
		color1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setC(color1.getBackground());
			}
		});
		color2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setC(color2.getBackground());
			}
		});
		color3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setC(color3.getBackground());
			}
		});
		color4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setC(color4.getBackground());
			}
		});
		color5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				pane1.setC(color5.getBackground());
			}
		});
		pane1.addMouseMotionListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				pane1.setX(e.getX());
				pane1.setY(e.getY());
				pane1.setClicked(true);	
				//pane1.paintComponent(pane1.getGraphics());
				
			}
			public void mouseDragged(MouseEvent e){
				pane1.setX(e.getX());
				pane1.setY(e.getY());
				pane1.setClicked(true);
				pane1.repaint();
				//pane1.paintComponent(pane1.getGraphics());
			}
			public void mouseReleased(MouseEvent e){
				pane1.setClicked(false);	
			}
		});
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

}
