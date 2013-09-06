import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ExerActionListener implements ActionListener{
	private JButton b;
	private JTextField tf;
	public ExerActionListener(JButton b,JTextField tf){
				this.b=b;
				this.tf=tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(b.getText().equals("Backspace")){
			String text;
			text=tf.getText().substring(0,tf.getText().length()-1);
			tf.setText(text);
		}else if(b.getText().equals("SPACE")){
			String text;
			text=tf.getText()+" ";
			tf.setText(text);
		} else{
		String text;
		text=tf.getText()+b.getText();
			tf.setText(text);
		}
	}
}
