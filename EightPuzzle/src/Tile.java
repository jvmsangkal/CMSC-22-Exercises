import javax.swing.JButton;


public class Tile extends JButton{
	private int prevX;
	private int prevY;
	private int positionX;
	private int positionY;
	
	public Tile(String label,int X, int Y){
		super();
		super.setText(label);
		this.positionX=X;
		this.positionY=Y;
	}

	public int getPrevX() {
		return prevX;
	}

	public void setPrevX(int prevX) {
		this.prevX = prevX;
	}

	public int getPrevY() {
		return prevY;
	}

	public void setPrevY(int prevY) {
		this.prevY = prevY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
