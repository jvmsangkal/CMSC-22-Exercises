
import javax.swing.JButton;


public class Light extends JButton{

	private boolean lightState;
	private boolean switchState;
	private int positionX;
	private int positionY;
	
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

	public Light(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.lightState = true;
		this.switchState = false;
	}

	public Light() {
		super();
		this.lightState = true;
		this.switchState = false;
	}
	
	public Light(boolean lightState, boolean switchState) {
		super();
		this.lightState = lightState;
		this.switchState = switchState;
	}

	public boolean isLightState() {
		return lightState;
	}
	public void setLightState(boolean lightState) {
		this.lightState = lightState;
	}
	public boolean isSwitchState() {
		return switchState;
	}
	public void setSwitchState(boolean switchState) {
		this.switchState = switchState;
	}
	
}

