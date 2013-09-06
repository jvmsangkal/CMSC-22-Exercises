import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class SampleKeyListener implements KeyListener{

	public SampleKeyListener(){
				
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_ENTER: System.out.println("Enter Pressed.");
								break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
