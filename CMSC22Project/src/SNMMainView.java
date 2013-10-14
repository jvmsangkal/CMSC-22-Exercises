import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SNMMainView extends JPanel{
	JButton start= new JButton("Start Simulation");
	JButton description= new JButton("Description");
	JButton quit= new JButton("Quit");
	
	public SNMMainView(){
		start.addActionListener(new MainMenuListener(start));
		description.addActionListener(new MainMenuListener(description));
		quit.addActionListener(new MainMenuListener(quit));
		this.add(start);
		this.add(description);
		this.add(quit);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		drawScene(g);
		
	}
	
	private void drawScene(Graphics g){
		g.drawImage(SNMStat.loadImage("MenuBackground.jpg"), 0, 0,null);
	}

}

class MainMenuListener implements ActionListener{

	private JButton b;
	public MainMenuListener(JButton b){
				this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(b.getText()){
		case "Quit":
			SNMStat.mainFrame.dispose();	
			break;
		case "Start Simulation":
			MainController mc = new MainController(new MainView());
			break;
		case "Description":
			break;
		
		}
		
	}
	
	
}