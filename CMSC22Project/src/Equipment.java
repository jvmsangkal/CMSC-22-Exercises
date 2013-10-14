
public class Equipment {
	static int counters;
	static double rate;
	static double upgradeCost;
	private int totalSlots;
	private int occupiedSlots;
	
	public Equipment(int totalSlots, int occupiedSlots) {
		super();
		this.totalSlots = totalSlots;
		this.occupiedSlots = occupiedSlots;
	}

	public static int getCounters() {
		return counters;
	}

	public static void setCounters(int counters) {
		Equipment.counters = counters;
	}

	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		Equipment.rate = rate;
	}

	public static double getUpgradeCost() {
		return upgradeCost;
	}

	public static void setUpgradeCost(double upgradeCost) {
		Equipment.upgradeCost = upgradeCost;
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
