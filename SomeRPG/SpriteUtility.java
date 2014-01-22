import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
import java.io.InputStream;

public class SpriteUtility{

	public static int claudiusWidth = 32;
	public static int claudiusHeight = 64;
	public static int cladiusFrameCount = 6;

	private static BufferedImage cladiusBigImg;
	private static BufferedImage[] cladiusEast;
	private static BufferedImage[] cladiusWest;
	private static BufferedImage[] cladiusNorth;
	private static BufferedImage[] cladiusSouth;
	
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	public static final int CLADIUS_MS = 6;
	
	public static int getCladiusFrameCount(){
		return cladiusFrameCount;
	}
	
	public static int getNORTH(){
		return NORTH;
	}
	
	public static int getSOUTH(){
		return SOUTH;
	}
	
	public static int getEAST(){
		return EAST;
	}
	
	public static int getWEST(){
		return WEST;
	}
	
	public static void loadImages(){
		loadClaudius();
	}
	
	public static Image getCladiusImage(int direction, int frameIndex){
	
		switch(direction){
		
			case NORTH:
						return Toolkit.getDefaultToolkit().createImage(cladiusNorth[frameIndex].getSource());
			case SOUTH:
						return Toolkit.getDefaultToolkit().createImage(cladiusSouth[frameIndex].getSource());
			case EAST:
						return Toolkit.getDefaultToolkit().createImage(cladiusEast[frameIndex].getSource());
			case WEST:
						return Toolkit.getDefaultToolkit().createImage(cladiusWest[frameIndex].getSource());
			default:
						return null;
		
		}
	
	}
	
	public static void loadClaudius(){
		
		try{
			
			InputStream is = RPGUtility.class.getResourceAsStream("sprites_map_claudius.png");
			cladiusBigImg = ImageIO.read(is);
			
			cladiusEast = new BufferedImage[cladiusFrameCount];
			cladiusWest = new BufferedImage[cladiusFrameCount];
			cladiusNorth = new BufferedImage[cladiusFrameCount];
			cladiusSouth = new BufferedImage[cladiusFrameCount];
			
			for(int i=0; i<cladiusFrameCount; i++){
				cladiusSouth[i] = cladiusBigImg.getSubimage(i*claudiusWidth, claudiusHeight*0, claudiusWidth, claudiusHeight);
			}
			for(int i=0; i<cladiusFrameCount; i++){
				cladiusWest[i] = cladiusBigImg.getSubimage(i*claudiusWidth, claudiusHeight*1, claudiusWidth, claudiusHeight);
			}
			for(int i=0; i<cladiusFrameCount; i++){
				cladiusNorth[i] = cladiusBigImg.getSubimage(i*claudiusWidth, claudiusHeight*2, claudiusWidth, claudiusHeight);
			}
			for(int i=0; i<cladiusFrameCount; i++){
				cladiusEast[i] = cladiusBigImg.getSubimage(i*claudiusWidth, claudiusHeight*3, claudiusWidth, claudiusHeight);
			}
		}
		catch(Exception e){
			System.out.println("Claudius was not loaded.");
		}
		
	}

}