import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class ExerKeyListener implements KeyListener{
	private JTextField tf;
	public ExerKeyListener(JTextField tf){
		this.tf=tf;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		KeyEvent.getKeyText(e.getKeyCode());
		String text;
		text=tf.getText()+KeyEvent.getKeyText(e.getKeyCode());
			tf.setText(text);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
