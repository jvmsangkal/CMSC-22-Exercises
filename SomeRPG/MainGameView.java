import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MainGameView extends JPanel{

	private MainCharacter mc;
	private MainGameErrorLabel mgel;
	
	public MainGameView(){
	
		this.mc = new MainCharacter(186, 218, SpriteUtility.SOUTH, 0);
		this.mgel = new MainGameErrorLabel(0, 0, "");
	
		this.addKeyListener(new MainGameViewKeyListener(this));
	
	}
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		drawScene(g);
		
	}
	
	private void drawScene(Graphics g){
	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
	
		g.drawImage(SpriteUtility.getCladiusImage(mc.getDirection(), mc.getCurrentImageIndex()), mc.getX(), mc.getY(), null);
	
		g.setColor(Color.WHITE);
		g.setFont(RPGUtility.getFinalFantasyFont().deriveFont(Font.BOLD));
		g.drawString(mgel.getLabel(), mgel.getX(), mgel.getY());
	
	}
	
	public MainCharacter getMC(){
		return mc;
	}
	
	public MainGameErrorLabel getMgel(){
		return mgel;
	}

}

class MainGameViewKeyListener implements KeyListener{

	private MainGameView mv;

	public MainGameViewKeyListener(MainGameView mv){
		this.mv = mv;
	}
	
	public void showError(){
	
		mv.getMgel().setLabel(RPGUtility.randomizeWallBumpMessage());
		mv.getMgel().setX(250 - (mv.getMgel().getLabel().length()/2*5));
	
		if(mv.getMC().getY()>=250){
			
			mv.getMgel().setY(100);
		}
		else if(mv.getMC().getY()<250){
			mv.getMgel().setY(400);
		
		}
	}

	public void removeError(){
		mv.getMgel().setLabel("");
	}
	
	public void keyTyped(KeyEvent e){
	}
	
	public void keyReleased(KeyEvent e){
	}
	
	public void keyPressed(KeyEvent e){
	
		switch(e.getKeyCode()){
		
			case KeyEvent.VK_W:
								mv.getMC().setDirection(SpriteUtility.NORTH);
								mv.getMC().incrementNorth(SpriteUtility.getCladiusFrameCount());
								
								if((mv.getMC().getY()-SpriteUtility.CLADIUS_MS)<0){
									mv.getMC().setY(0);
									RPGUtility.playSound(RPGUtility.ERROR_FILE);
									showError();
								}
								else{
									mv.getMC().setY(mv.getMC().getY()-SpriteUtility.CLADIUS_MS);
									RPGUtility.playCladiusWalk(mv.getMC().incrementFootstep());
									removeError();
								}
								
								mv.getMC().setCurrentImageIndex(mv.getMC().getNorthImageIndex());
								mv.repaint();
								
								break;
			case KeyEvent.VK_D:
								mv.getMC().setDirection(SpriteUtility.EAST);
								mv.getMC().incrementEast(SpriteUtility.getCladiusFrameCount());
								
								if((SpriteUtility.claudiusWidth+mv.getMC().getX()+SpriteUtility.CLADIUS_MS)>500){
									mv.getMC().setX(500-SpriteUtility.claudiusWidth);
									RPGUtility.playSound(RPGUtility.ERROR_FILE);
									showError();
								}
								else{
									mv.getMC().setX(mv.getMC().getX()+SpriteUtility.CLADIUS_MS);
									RPGUtility.playCladiusWalk(mv.getMC().incrementFootstep());
									removeError();
								}
								
								mv.getMC().setCurrentImageIndex(mv.getMC().getEastImageIndex());
								mv.repaint();
								
								break;
			case KeyEvent.VK_S:
								mv.getMC().setDirection(SpriteUtility.SOUTH);
								mv.getMC().incrementSouth(SpriteUtility.getCladiusFrameCount());
								mv.getMC().setCurrentImageIndex(mv.getMC().getSouthImageIndex());
								
								if((SpriteUtility.claudiusHeight+mv.getMC().getY()+SpriteUtility.CLADIUS_MS)>500){
									mv.getMC().setY(500-SpriteUtility.claudiusHeight);
									RPGUtility.playSound(RPGUtility.ERROR_FILE);
									showError();
								}
								else{
									mv.getMC().setY(mv.getMC().getY()+SpriteUtility.CLADIUS_MS);
									RPGUtility.playCladiusWalk(mv.getMC().incrementFootstep());
									removeError();
								}
								
								mv.repaint();
								break;
			case KeyEvent.VK_A:
								mv.getMC().setDirection(SpriteUtility.WEST);
								mv.getMC().incrementWest(SpriteUtility.getCladiusFrameCount());
								mv.getMC().setCurrentImageIndex(mv.getMC().getWestImageIndex());
								
								if((mv.getMC().getX()-SpriteUtility.CLADIUS_MS)<0){
									mv.getMC().setX(0);
									RPGUtility.playSound(RPGUtility.ERROR_FILE);
									showError();
								}
								else{
									mv.getMC().setX(mv.getMC().getX()-SpriteUtility.CLADIUS_MS);
									RPGUtility.playCladiusWalk(mv.getMC().incrementFootstep());
									removeError();
								}
								
								mv.repaint();
								break;
		}
	
	}

}