import java.awt.Font;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import java.util.Random;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;

public class RPGUtility{

	public static final int mainNewGameY1 = 200;
	public static final int mainNewGameY2 = 230;

	public static final String ERROR_FILE = "error.wav";
	public static final String CLICK_FILE = "click.wav";
	public static final String SELECT_FILE = "selected.wav";
	
	private static String FF_FONT = "ff7.ttf";

	public static SuperController gameController;
	public static JFrame mainFrame;
	
	private static String[] instructionMessage = {
		"Bring light to the darkness!",
		"Press ENTER to scroll through messages.",
		"Press W, A, S, D buttons to move.",
		"Hold the CTRL button to bring forth light."
	};
	
	private static String[] wallBumpMessage = {
		"Don't force it.",
		"Stop it.",
		"...",
		"...",
		"...",
		"...",
		"...",
		"Seriously.",
		"Stahp.",
		"Please, don't."
	};
	
	public static Font getFinalFantasyFont() {
		
		Font font = null;
    
		try{
			//InputStream is = new FileInputStream(new File(FF_FONT));
			InputStream is = RPGUtility.class.getResourceAsStream(FF_FONT);
			font = Font.createFont(Font.PLAIN, is).deriveFont(32f);
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.err.println("Font not loaded.  Switching to SERIF font.");
			font = new Font("serif", Font.PLAIN, 24);
		}
		
		return font;
	}

	public static Image loadImage(String filename){
	
		try{
			InputStream is = RPGUtility.class.getResourceAsStream(filename);
			return ImageIO.read(is);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	}
	
	public static synchronized void playSound(final String url) {
		
		new Thread(new Runnable() {
			public void run() {
				MakeSound ms = new MakeSound();
				ms.playSound(url);
			}
		}).start();

	
	}

	public static void playSoundNonThread(final String url) {
	
		MakeSound ms = new MakeSound();
		ms.playSound(url);
		
	}
	
	public static void playCladiusWalk(final int footstepIndex) {
	
		new Thread(new Runnable() {
			public void run() {
				MakeSound ms = new MakeSound();
				
				switch(footstepIndex){
					case 2:
							ms.playSound("footstep0.wav");
							break;
					case 5:
							ms.playSound("footstep1.wav");
							break;
				}
			}
		}).start();
	
	}
	
	public static int getInstructionMessageArraySize(){
		return RPGUtility.instructionMessage.length;
	}

	public static String getInstructionMessage(int index){
		return RPGUtility.instructionMessage[index];
	}
	
	public static String randomizeWallBumpMessage(){
		
		Random r = new Random();
		return wallBumpMessage[r.nextInt(wallBumpMessage.length)];
		
	}
	
}