public class MainCharacter{

	private int x;
	private int y;
	private int direction;
	private int southImageIndex;
	private int northImageIndex;
	private int westImageIndex;
	private int eastImageIndex;
	private int currentImageIndex;
	private int currentFootstep;
	
	public MainCharacter(int x, int y, int direction, int imageIndex){
	
		this.x = x;
		this.y = y;
		this.direction = direction;
		
		this.southImageIndex = imageIndex;
		this.northImageIndex = imageIndex;
		this.westImageIndex = imageIndex;
		this.eastImageIndex = imageIndex;
		this.currentFootstep = 0;
	
	}
	
	public void setPlacement(int x, int y, int direction, int imageIndex){
	
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.southImageIndex = imageIndex;
		this.northImageIndex = imageIndex;
		this.westImageIndex = imageIndex;
		this.eastImageIndex = imageIndex;
		this.currentFootstep = 0;
	
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getDirection(){
		return this.direction;
	}

	public int getNorthImageIndex(){
		return this.northImageIndex;
	}
	
	public int getSouthImageIndex(){
		return this.southImageIndex;
	}
	
	public int getEastImageIndex(){
		return this.eastImageIndex;
	}
	
	public int getWestImageIndex(){
		return this.westImageIndex;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public void setNorthImageIndex(int northImageIndex){
		this.northImageIndex = northImageIndex;
	}
	
	public void setSouthImageIndex(int southImageIndex){
		this.southImageIndex = southImageIndex;
	}
	
	public void setEastImageIndex(int eastImageIndex){
		this.eastImageIndex = eastImageIndex;
	}
	
	public void setWestImageIndex(int westImageIndex){
		this.westImageIndex = westImageIndex;
	}
	
	public void incrementNorth(int frameCount){
		northImageIndex++;
		northImageIndex%=frameCount;
	}
	
	public void incrementSouth(int frameCount){
		southImageIndex++;
		southImageIndex%=frameCount;
	}
	
	public void incrementWest(int frameCount){
		westImageIndex++;
		westImageIndex%=frameCount;
	}
	
	public void incrementEast(int frameCount){
		eastImageIndex++;
		eastImageIndex%=frameCount;
	}
	
	public int getCurrentImageIndex(){
		return this.currentImageIndex;
	}
	
	public void setCurrentImageIndex(int currentImageIndex){
		this.currentImageIndex = currentImageIndex;
	}
	
	public int incrementFootstep(){
		this.currentFootstep++;
		this.currentFootstep%=6;
		return this.currentFootstep;
	}
	
}