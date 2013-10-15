import javax.swing.JPanel;


public class Equipment extends JPanel{
	private int totalSlots;
	private int occupiedSlots=0;
	
	public Equipment(int totalSlots, int occupiedSlots) {
		super();
		this.totalSlots = totalSlots;
		this.occupiedSlots = occupiedSlots;
	}


	public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	public int getOccupiedSlots() {
		return occupiedSlots;
	}

	public void setOccupiedSlots(int occupiedSlots) {
		this.occupiedSlots = occupiedSlots;
	}
	
	
}
