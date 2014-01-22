import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*Author: John Viscel M. Sangkal
 * CMSC 170 U-4L
 * 2011-62193
 * made using eclipse.
 * uses imageIcons.
 * bugs: Out of Memory Exception due to brute force
 * 
 */
//mfbtandoc@gmail.com/mfbtandoc@uplb.edu.ph
//CMSC 170 U-4L Exer1b Sangkal
public class LightsOutRunner {

	static Light[][] lightGrid = new Light[5][5];
	static int[][] initialState = new int[5][5];			
	static ImageIcon lighton;
	static ImageIcon lightoff;
	static JOptionPane op= new JOptionPane();
	static JPanel pane = new JPanel();
	public static void main(String[] Args){
		
		JFrame mainFrame = new JFrame("Lights-Out!");
		mainFrame.setMinimumSize(new Dimension(800, 600));
		
		pane.setPreferredSize(new Dimension(600,600));
		JPanel mainPane = new JPanel();
		LightsOutSolver los= new LightsOutSolver();
		mainPane.setLayout(new BorderLayout());
		
		mainFrame.setContentPane(mainPane);
		mainPane.add(pane,BorderLayout.CENTER);
		mainPane.add(los, BorderLayout.EAST);
		pane.setLayout(new GridLayout(5,5,3,3));
		
		lighton= new ImageIcon(loadImage("lighton.jpg"));
		lightoff= new ImageIcon(loadImage("lightoff.jpg"));
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				lightGrid[i][j]=new Light(i,j);
				lightGrid[i][j].setIcon(lighton);
				pane.add(lightGrid[i][j]);
				lightGrid[i][j].addActionListener(new LightsOutListener(lightGrid[i][j]));
			}
		}
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("initialState.txt"));
			String line = br.readLine();
			int i=0;
			while(line !=null){
				for(int j=0;j<5;j++){
					initialState[i][j]=Integer.parseInt(""+line.charAt(j));
				}
				line =br.readLine();
				i++;
			}
			br.close();
		}catch(Exception e){
			
		}
		Light b=null;
		Light l=null;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
			if(initialState[i][j]==1){
			 b=lightGrid[i][j];	
			 
			 b.setSwitchState(!b.isSwitchState());
				b.setLightState(!b.isLightState());
				if(b.isLightState()){
					b.setIcon(LightsOutRunner.lighton);
				}else{
					b.setIcon(LightsOutRunner.lightoff);
				}
				
				int X = b.getPositionX();
				int Y=b.getPositionY();
				
				
				try{
				l=LightsOutRunner.lightGrid[X][Y+1];
				
				l.setLightState(!l.isLightState());
				if(l.isLightState()){
					l.setIcon(LightsOutRunner.lighton);
				}else{
					l.setIcon(LightsOutRunner.lightoff);
				}
				
				}catch(Exception c){
					
				}
				try{
					l=LightsOutRunner.lightGrid[X][Y-1];
					
					l.setLightState(!l.isLightState());
					if(l.isLightState()){
						l.setIcon(LightsOutRunner.lighton);
					}else{
						l.setIcon(LightsOutRunner.lightoff);
					}
					
					}catch(Exception c){
						
					}
				try{
					l=LightsOutRunner.lightGrid[X+1][Y];
					
					l.setLightState(!l.isLightState());
					if(l.isLightState()){
						l.setIcon(LightsOutRunner.lighton);
					}else{
						l.setIcon(LightsOutRunner.lightoff);
					}
					
					}catch(Exception c){
						
					}
				try{
					l=LightsOutRunner.lightGrid[X-1][Y];
					
					l.setLightState(!l.isLightState());
					if(l.isLightState()){
						l.setIcon(LightsOutRunner.lighton);
					}else{
						l.setIcon(LightsOutRunner.lightoff);
					}
					
					}catch(Exception c){
						
					}
			}	
				
			}
		}
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		
	}
	
	public static Image loadImage(String filename){
		
		try{
			return ImageIO.read(new File(filename));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	}
}


class LightsOutListener implements ActionListener{


	private Light b;
	
	public LightsOutListener(Light b){
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b.setSwitchState(!b.isSwitchState());
		b.setLightState(!b.isLightState());
		if(b.isLightState()){
			b.setIcon(LightsOutRunner.lighton);
		}else{
			b.setIcon(LightsOutRunner.lightoff);
		}
		
		int X = b.getPositionX();
		int Y=b.getPositionY();
		
		Light l= null;
		
		try{
		l=LightsOutRunner.lightGrid[X][Y+1];
		
		l.setLightState(!l.isLightState());
		if(l.isLightState()){
			l.setIcon(LightsOutRunner.lighton);
		}else{
			l.setIcon(LightsOutRunner.lightoff);
		}
		
		}catch(Exception c){
			
		}
		try{
			l=LightsOutRunner.lightGrid[X][Y-1];
			
			l.setLightState(!l.isLightState());
			if(l.isLightState()){
				l.setIcon(LightsOutRunner.lighton);
			}else{
				l.setIcon(LightsOutRunner.lightoff);
			}
			
			}catch(Exception c){
				
			}
		try{
			l=LightsOutRunner.lightGrid[X+1][Y];
			
			l.setLightState(!l.isLightState());
			if(l.isLightState()){
				l.setIcon(LightsOutRunner.lighton);
			}else{
				l.setIcon(LightsOutRunner.lightoff);
			}
			
			}catch(Exception c){
				
			}
		try{
			l=LightsOutRunner.lightGrid[X-1][Y];
			
			l.setLightState(!l.isLightState());
			if(l.isLightState()){
				l.setIcon(LightsOutRunner.lighton);
			}else{
				l.setIcon(LightsOutRunner.lightoff);
			}
			
			}catch(Exception c){
				
			}
		 boolean flag=true;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(LightsOutRunner.lightGrid[i][j].isLightState()){
					flag=false;
				}
			}
		}
		if(flag){
		LightsOutRunner.op.showMessageDialog(LightsOutRunner.pane,"Congratulations!");
		}
	}
	
}