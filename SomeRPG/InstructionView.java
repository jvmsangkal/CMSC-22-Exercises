import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class InstructionView extends JPanel{

	private String instructionMessage;

	private boolean isBlinkerOn;
	
	public InstructionView(){
		instructionMessage = RPGUtility.getInstructionMessage(0);
		isBlinkerOn = true;
		this.addKeyListener(new InstructionViewListener(this));
		
		MessageBlinker mb = new MessageBlinker(this);
		Timer t = new Timer("Message Blinker");
		t.schedule(mb, 0, 350);

		
	}

	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		drawScene(g);
		
	}
	
	private void drawScene(Graphics g){

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
	
		g.setColor(Color.WHITE);
		g.setFont(RPGUtility.getFinalFantasyFont().deriveFont(Font.BOLD));
		
		g.drawString(instructionMessage, 250-(instructionMessage.length()/2*10), 230);
		
		if(!isBlinkerOn){
			g.setColor(Color.BLACK);
		}
		else{
			g.setColor(Color.WHITE);
		}
		g.fillOval(400,255, 7, 7);
	
	}
	
	public String getInstructionMessage(){
		return instructionMessage;
	}
	
	public void setInstructionMessage(String instructionMessage){
		this.instructionMessage = instructionMessage;
	}
	
	public boolean isBlinkerOn(){
		return isBlinkerOn;
	}
	
	public void setisBlinkerOn(boolean isBlinkerOn){
		this.isBlinkerOn = isBlinkerOn;
	}

}

class MessageBlinker extends TimerTask{

	private InstructionView iv;

	public MessageBlinker(InstructionView iv){
		this.iv = iv;
	}
	
	public void run(){
		
		if(this.iv.isBlinkerOn()){
			this.iv.setisBlinkerOn(false);
		}
		else{
			this.iv.setisBlinkerOn(true);
		}
		this.iv.repaint();
		
	}

}

class InstructionViewListener implements KeyListener{

	private int instructionIndex;
	private InstructionView iv;
	
	public InstructionViewListener(InstructionView iv){
		this.instructionIndex = 1;
		this.iv = iv;
	}

	public void keyTyped(KeyEvent e){
	}
	
	public void keyPressed(KeyEvent e){
	
		switch(e.getKeyCode()){
			
			case KeyEvent.VK_ENTER:
							RPGUtility.playSound(RPGUtility.CLICK_FILE);
							
							if(instructionIndex>=RPGUtility.getInstructionMessageArraySize()){
								MainGameController mgc = new MainGameController(new MainGameView());
							}
							else{
								iv.setInstructionMessage(RPGUtility.getInstructionMessage(instructionIndex));
								instructionIndex++;
								iv.repaint();
							}
				break;
		}
	
	}
	
	public void keyReleased(KeyEvent e){
	}

}