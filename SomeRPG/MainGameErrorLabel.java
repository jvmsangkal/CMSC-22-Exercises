public class MainGameErrorLabel{

	private String label;
	private int x;
	private int y;

	public MainGameErrorLabel(int x, int y, String label){
	
		this.x = x;
		this.y = y;
		this.label = label;
	
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public void setLabel(String label){
		this.label = label;
	}
	
}