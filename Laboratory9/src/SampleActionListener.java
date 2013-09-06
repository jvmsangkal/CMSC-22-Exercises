import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SampleActionListener implements ActionListener{
	private JButton b;
	public SampleActionListener(JButton b){
				this.b=b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(b.getText());
	}

}
