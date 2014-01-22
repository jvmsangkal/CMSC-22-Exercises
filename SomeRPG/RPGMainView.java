import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RPGMainView extends JPanel{

	private int selectorLocation = RPGUtility.mainNewGameY1;
	
	public RPGMainView(){
		this.addKeyListener(new MainMenuListener(this));
	}
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		drawScene(g);
		
	}
	
	private void drawScene(Graphics g){
	
		g.drawImage(RPGUtility.loadImage("MainBG.png"), 0, 0, null);
		
		if(selectorLocation==RPGUtility.mainNewGameY1){
			g.setFont(RPGUtility.getFinalFantasyFont().deriveFont(Font.BOLD));
		}
		else{
			g.setFont(RPGUtility.getFinalFantasyFont());
		}
		
		g.setColor(Color.WHITE);
		g.drawString("New Game", 195, 220);
		
		if(selectorLocation==RPGUtility.mainNewGameY2){
			g.setFont(RPGUtility.getFinalFantasyFont().deriveFont(Font.BOLD));
		}
		else{
			g.setFont(RPGUtility.getFinalFantasyFont());
		}
		
		g.setColor(Color.GRAY);
		g.drawString("Continue", 195, 250);
		
		g.setColor(Color.WHITE);
		g.setFont(RPGUtility.getFinalFantasyFont().deriveFont(Font.BOLD).deriveFont(new Float(22.0).floatValue()));
		g.drawString("I DO NOT CLAIM OWNERSHIP TO ANY OF SQUARESOFT'S-SQUAREENIX'S", 30, 400);
		g.drawString("TITLES-CHARACTERS-SPRITES USED IN THIS DEMO.", 90, 430);
		
		g.drawImage(RPGUtility.loadImage("MainSelector.png"), 115, selectorLocation, null);
		
	}
	
	public int getSelectorLocation(){
		return selectorLocation;
	}
	
	public void setSelectorLocation(int selectorLocation){
		this.selectorLocation = selectorLocation;
	}

}

class MainMenuListener implements KeyListener{

	private RPGMainView rpgMainView;

	public MainMenuListener(RPGMainView rpgMainView){
		this.rpgMainView = rpgMainView;
	}

	public void keyTyped(KeyEvent e){
	}
	
	public void keyPressed(KeyEvent e){
	
		if((e.getKeyCode()==KeyEvent.VK_W)||(e.getKeyCode()==KeyEvent.VK_S)){
		
			RPGUtility.playSound(RPGUtility.CLICK_FILE);
		
			if(rpgMainView.getSelectorLocation()==RPGUtility.mainNewGameY1){
				rpgMainView.setSelectorLocation(RPGUtility.mainNewGameY2);
			}
			else if(rpgMainView.getSelectorLocation()==RPGUtility.mainNewGameY2){
				rpgMainView.setSelectorLocation(RPGUtility.mainNewGameY1);
			}
			rpgMainView.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER){
		
			if(rpgMainView.getSelectorLocation()==RPGUtility.mainNewGameY2){
				RPGUtility.playSound(RPGUtility.ERROR_FILE);
			}
			else if(rpgMainView.getSelectorLocation()==RPGUtility.mainNewGameY1){
				RPGUtility.playSoundNonThread(RPGUtility.SELECT_FILE);
				InstructionController ic = new InstructionController(new InstructionView());
				
				
			}
		
		}
		
	}
	
	public void keyReleased(KeyEvent e){
	}

}