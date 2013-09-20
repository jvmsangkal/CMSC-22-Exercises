import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class TimerSample {

	public static void main(String[] args) {

		JFrame mf = new JFrame("Timer");
		JPanel pane =new JPanel();
		JLabel timerLabel=new JLabel("Minutes");
		JLabel timerLabel2=new JLabel(":");
		final JLabel timerDisplay = new JLabel("0");
		final JLabel timerDisplay2 = new JLabel("0");
		pane.add(timerLabel);
		pane.add(timerDisplay);
		pane.add(timerLabel2);
		pane.add(timerDisplay2);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			
			public void run() {
				// TODO Auto-generated method stub
				int i = Integer.parseInt(timerDisplay.getText());
				i++;
				timerDisplay.setText(""+i);
			}
		},60000,60000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i=Integer.parseInt(timerDisplay2.getText());
				i++;
				
				if (i==60){
					i=0;
					
				}
				timerDisplay2.setText(""+i);
			}
		},1000 ,1000
		);
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setContentPane(pane);
		mf.setSize(200, 75);
		mf.setVisible(true);
	}

}
