import java.awt.TrayIcon.MessageType;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tamagochi {
	     static Pet arian  = new Pet("Ariangochi","Happy");
	     static JPanel pane =new JPanel();
	    // static boolean fed=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mf = new JFrame("Textual Tamagochi");
		
		final JOptionPane op= new JOptionPane();
		JLabel name = new JLabel("Name: "+arian.getName());
		final JLabel status= new JLabel("Status: "+arian.getStatus());
		final JButton feed = new JButton("Feed");
		final JLabel feedWindow = new JLabel("Feed Window: ");
		JLabel pooCount = new JLabel("Poo Count: ");
		final JLabel feedWindowDisplay = new JLabel("15");
		final JLabel pooCountDisplay = new JLabel("0");
		feed.addActionListener(new TamagochiActionListener(feed, arian, status,feedWindowDisplay,feedWindow));
		feed.setVisible(false);
		feedWindow.setVisible(false);
		feedWindowDisplay.setVisible(false);
		
		pane.add(name);
		pane.add(status);
		pane.add(feed);
		pane.add(feedWindow);
		pane.add(feedWindowDisplay);
		pane.add(pooCount);
		pane.add(pooCountDisplay);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				if(arian.getStatus().equals("Happy")){
				arian.setStatus("Hungry");
				status.setText("Status: "+arian.getStatus());
				feed.setVisible(true);
				feedWindow.setVisible(true);
				feedWindowDisplay.setVisible(true);
				feedWindowDisplay.setText("15");
				}
			}
		}, 20000, 20000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				if(feedWindowDisplay.isVisible()==true){
				int i = Integer.parseInt(feedWindowDisplay.getText());
				i--;
				feedWindowDisplay.setText(""+i);
				if (i==0){
					arian.setStatus("Dead");
					status.setText("Status: "+arian.getStatus());
					op.showMessageDialog(pane,"Ariangochi is Dead!") ;
					feedWindowDisplay.setText("15");
					feed.setVisible(false);
					feedWindow.setVisible(false);
					feedWindowDisplay.setVisible(false);
				}
				}
			}
		}, 0, 1000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				int i=Integer.parseInt(pooCountDisplay.getText());
				if(TamagochiActionListener.fed==true){
					i++;
					pooCountDisplay.setText(""+i);
					TamagochiActionListener.fed=false;
				}
				
			}
		}, 0, 5000);
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setContentPane(pane);
		mf.setSize(175, 200);
		mf.setVisible(true);
		
	}

}
