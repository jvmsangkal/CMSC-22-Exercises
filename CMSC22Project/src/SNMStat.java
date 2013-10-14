
public class SNMStat implements SNMStatInterface{
	private double currentCash;
	private int currentSpaSessionsCount;
	private int currentMassageSessionsCount;
	private double totalMaintainanceCost;
	private double totalSpaSales;
	private double totalMassageSales;
	private double maintainanceCost;
	private double memberDiscount;
	private int rateOfQueuedGuest;
	
	public double getMemberDiscount() {
		return memberDiscount;
	}
	public void setMemberDiscount(double memberDiscount) {
		this.memberDiscount = memberDiscount;
	}
	public int getRateOfQueuedGuest() {
		return rateOfQueuedGuest;
	}
	public void setRateOfQueuedGuest(int rateOfQueuedGuest) {
		this.rateOfQueuedGuest = rateOfQueuedGuest;
	}
	public double getCurrentCash() {
		return currentCash;
	}
	public void setCurrentCash(double currentCash) {
		currentCash = currentCash;
	}
	public int getCurrentSpaSessionsCount() {
		return currentSpaSessionsCount;
	}
	public void setCurrentSpaSessionsCount(int currentSpaSessionsCount) {
		currentSpaSessionsCount = currentSpaSessionsCount;
	}
	public int getCurrentMassageSessionsCount() {
		return currentMassageSessionsCount;
	}
	static public void setCurrentMassageSessionsCount(int currentMassageSessionsCount) {
		currentMassageSessionsCount = currentMassageSessionsCount;
	}
	public double getTotalMaintainanceCost() {
		return totalMaintainanceCost;
	}
	public void setTotalMaintainanceCost(double totalMaintenanceCost) {
		totalMaintainanceCost = totalMaintenanceCost;
	}
	public double getTotalSpaSales() {
		return totalSpaSales;
	}
	public void setTotalSpaSales(double totalSpaSales) {
		totalSpaSales = totalSpaSales;
	}
	public double getTotalMassageSales() {
		return totalMassageSales;
	}
	public void setTotalMassageSales(double totalMassageSales) {
		totalMassageSales = totalMassageSales;
	}

	public double computeAverageEarningsPerMinute() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMaintainanceCost() {
		return maintainanceCost;
	}
	public void setMaintainanceCost(double maintainanceCost) {
		this.maintainanceCost = maintainanceCost;
	}
	public double computeSalesPerSecond() {
		// TODO Auto-generated method stub
		return 0;
	}
	



}
