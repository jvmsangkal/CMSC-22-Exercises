import java.awt.Image;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class SNMStat implements SNMStatInterface{
	private double currentCash;
	private int currentSpaSessionsCount=0;
	private int currentMassageSessionsCount=0;
	private double totalMaintainanceCost=0;
	private double totalSpaSales=0;
	private double totalMassageSales=0;
	private double maintainanceCost;
	private double memberDiscount;
	private int rateOfQueuedGuest;
	public static JFrame mainFrame;
	public static SuperController controller;
	
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
		this.currentCash = currentCash;
	}
	public int getCurrentSpaSessionsCount() {
		return currentSpaSessionsCount;
	}
	public void setCurrentSpaSessionsCount(int currentSpaSessionsCount) {
		this.currentSpaSessionsCount = currentSpaSessionsCount;
	}
	public int getCurrentMassageSessionsCount() {
		return currentMassageSessionsCount;
	}
	public void setCurrentMassageSessionsCount(int currentMassageSessionsCount) {
		this.currentMassageSessionsCount = currentMassageSessionsCount;
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
		this.totalSpaSales = totalSpaSales;
	}
	public double getTotalMassageSales() {
		return totalMassageSales;
	}
	public void setTotalMassageSales(double totalMassageSales) {
		this.totalMassageSales = totalMassageSales;
	}

	public double computeAverageEarningsPerMinute() {
		return (MainView.snmStat.getTotalMassageSales()+MainView.snmStat.getTotalSpaSales())/MainView.minutes;
	}

	public double getMaintainanceCost() {
		return maintainanceCost;
	}
	public void setMaintainanceCost(double maintainanceCost) {
		this.maintainanceCost = maintainanceCost;
	}
	public double computeSalesPerSecond() {
		// TODO Auto-generated method stub
		return (MainView.snmStat.getTotalMassageSales()+MainView.snmStat.getTotalSpaSales())/MainView.seconds;
	}
	
	public static Image loadImage(String filename){
		
		try{
			return ImageIO.read(new File(filename));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	
	}


}
