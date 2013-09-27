public interface SNMStatInterface {
	public double getCurrentCash();
	public int getCurrentSpaSessionsCount();
	public int getCurrentMassageSessionsCount();
	public double getTotalMaintainanceCost();
	public double computeAverageEarningsPerMinute();
	public double computeSalesPerSecond();
	public double getTotalSpaSales();
	public double getTotalMassageSales();	
}