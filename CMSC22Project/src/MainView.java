import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainView extends JPanel{
	public JPanel stations;
	public JPanel status;
	public static SNMStat snmStat;
	public static LinkedList<Guest> guestQueue=new LinkedList<Guest>();
	public static Random randomGenerator= new Random();
	public static Guest g= null;
	public static int queueTimer;
	public static JLabel currentCash; 
	public static Spa s=null;
	public static Massage m=null;
	public static ArrayList<Spa> spaStations = new ArrayList<Spa>();
	public static ArrayList<Massage> massageStations= new ArrayList<Massage>();
	static JLabel queueCount; 
	static JLabel currentMassageSessions;
	static JLabel salesMassage;
	static JLabel salesSpa;
	static JLabel currentSpaSessions;
	static JTextArea activityLog;
	static int minutes=0;
	static int seconds=0;
	public MainView(){
		this.setPreferredSize(new Dimension(1500,700));
		snmStat= new SNMStat();
		this.setLayout(new BorderLayout());
		stations= new JPanel();
		//stations.setLayout(new GridLayout(4,5));
		//stations.setBackground(Color.GREEN);
		status = new JPanel();
		status.setLayout(new BorderLayout());
		
		activityLog= new JTextArea(10,10);
		activityLog.setFocusable(false);
		JScrollPane scroll = new JScrollPane (activityLog,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.add(stations,BorderLayout.CENTER);
		this.add(status,BorderLayout.EAST);
		status.add(scroll,BorderLayout.SOUTH);
		JPanel statusCenterPanel = new JPanel();
		//statusCenterPanel.setLayout(new )
		statusCenterPanel.setLayout(new GridLayout(23, 1));
		status.add(statusCenterPanel,BorderLayout.CENTER);
		ArrayList<Parameter> al= new ArrayList<Parameter>();
		Parameter p = null;
		
		try{
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("wx6lparameter.ser"));
			for(int i=0;i<11;i++){
				p=(Parameter)ois.readObject();
				al.add(p);
			}	
			ois.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		snmStat.setCurrentCash(al.get(0).getDoubleValue());
		Spa.counters= al.get(1).getIntValue();
		Massage.counters =al.get(2).getIntValue();
		Spa.rate=al.get(3).getDoubleValue();
		Massage.rate= al.get(4).getDoubleValue();
		snmStat.setMaintainanceCost(al.get(5).getDoubleValue());
		Spa.upgradeCost=al.get(6).getDoubleValue();
		Massage.upgradeCost=al.get(7).getDoubleValue();
		snmStat.setMemberDiscount(al.get(8).getDoubleValue());
		Guest.guestCount=al.get(9).getIntValue();
		snmStat.setRateOfQueuedGuest(al.get(10).getIntValue());
		
		queueTimer=60/snmStat.getRateOfQueuedGuest();
		JLabel queueLabel= new JLabel("Guest Queue: ");
		queueCount= new JLabel(""+guestQueue.size());
		JLabel nextQueueLabel = new JLabel("Next Queued Guest: ");
		final JLabel nextQueue = new JLabel(""+queueTimer);
		JLabel currentCashLabel= new JLabel("Current Cash: ");
		currentCash = new JLabel(""+snmStat.getCurrentCash());
		JLabel currentSpaSessionsLabel = new JLabel("SpaSessionsCount: ");
		currentSpaSessions = new JLabel(""+snmStat.getCurrentSpaSessionsCount());
		JLabel currentMassageSessionsLabel = new JLabel("MassageSessionsCount: ");
		currentMassageSessions = new JLabel(""+snmStat.getCurrentMassageSessionsCount());
		JLabel maintenanceCostLabel=new JLabel("TotalMaintenancCost: ");
		final JLabel maintenanceCost=new JLabel(""+snmStat.getTotalMaintainanceCost());
		JLabel averageEarningsLabel = new JLabel("AverageEarning/Minute ");
		final JLabel averageEarning=new JLabel(""+snmStat.computeAverageEarningsPerMinute());
		JLabel salesPerSecondLabel = new JLabel("TotalSales/Second: ");
		final JLabel salesPerSecond=new JLabel(""+snmStat.computeSalesPerSecond());
		JLabel salesSpaLabel= new JLabel("Sales - SpaSessions: ");
		salesSpa=new JLabel(""+snmStat.getTotalSpaSales());
		JLabel salesMassageLabel= new JLabel("Sales - MassageSessions:");
		salesMassage=new JLabel(""+snmStat.getTotalMassageSales());
		
		JButton buySpa =new JButton("Buy Spa Counter");
		JButton buyMassage =new JButton("Buy Massage Counter");
		JButton quit =new JButton("Quit");
		buySpa.addActionListener(new MainViewListener(this,buySpa));
		buyMassage.addActionListener(new MainViewListener(this,buyMassage));
		quit.addActionListener(new MainViewListener(this,quit));
		statusCenterPanel.add(queueLabel);
		statusCenterPanel.add(queueCount);
		statusCenterPanel.add(nextQueueLabel);
		statusCenterPanel.add(nextQueue);
		statusCenterPanel.add(currentCashLabel);
		statusCenterPanel.add(currentCash);
		statusCenterPanel.add(currentSpaSessionsLabel);
		statusCenterPanel.add(currentSpaSessions);
		statusCenterPanel.add(currentMassageSessionsLabel);
		statusCenterPanel.add(currentMassageSessions);
		statusCenterPanel.add(maintenanceCostLabel);
		statusCenterPanel.add(maintenanceCost);
		statusCenterPanel.add(averageEarningsLabel);
		statusCenterPanel.add(averageEarning);
		statusCenterPanel.add(salesPerSecondLabel);
		statusCenterPanel.add(salesPerSecond);
		statusCenterPanel.add(salesSpaLabel);
		statusCenterPanel.add(salesSpa);
		statusCenterPanel.add(salesMassageLabel);
		statusCenterPanel.add(salesMassage);
		statusCenterPanel.add(buySpa);
		statusCenterPanel.add(buyMassage);
		statusCenterPanel.add(quit);
		
		
		for(int i=0; i<Guest.guestCount;i++){
			g=new Guest(randomGenerator.nextBoolean(),randomGenerator.nextBoolean());
			guestQueue.add(g);
			System.out.println(g.isWillMassage());
			queueCount.setText(""+guestQueue.size());
			if (g.isMember()){
				activityLog.append("A member is in Queue.\n");
			}else{
				activityLog.append("A non-member is in Queue.\n");
			}
		}
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				g=new Guest(randomGenerator.nextBoolean(),randomGenerator.nextBoolean());
				guestQueue.add(g);
				System.out.println(g.isWillMassage());
				queueCount.setText(""+guestQueue.size());
				if (g.isMember()){
					activityLog.append("A member is in Queue.\n");
				}else{
					activityLog.append("A non-member is in Queue.\n");
				}
			}
		},queueTimer*1000,queueTimer*1000);
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				snmStat.setCurrentCash(snmStat.getCurrentCash()-snmStat.getMaintainanceCost());
				currentCash.setText(""+snmStat.getCurrentCash());
				snmStat.setTotalMaintainanceCost(snmStat.getTotalMaintainanceCost()+snmStat.getMaintainanceCost());
				maintenanceCost.setText(""+snmStat.getTotalMaintainanceCost());
				int temp=Integer.parseInt(nextQueue.getText());
				temp--;
				if(temp==0){
					nextQueue.setText(""+MainView.queueTimer);
				}else {
					nextQueue.setText(""+temp);
				}
				
				if (snmStat.getCurrentCash()<=0){
					SNMStat.mainFrame.dispose();
				}
				
				seconds++;
				salesPerSecond.setText(""+snmStat.computeSalesPerSecond());
			}
		},1000,1000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				minutes++;
				averageEarning.setText(""+snmStat.computeAverageEarningsPerMinute());
			}
		}, 60000, 60000);
		
		for(int i=0;i<Spa.counters;i++){
			s=new Spa(1, 0);
			stations.add(s);
			stations.revalidate();
			spaStations.add(s);
		}
		
		for(int i=0;i<Massage.counters;i++){
			m=new Massage(1, 0);
			stations.add(m);
			stations.revalidate();
			massageStations.add(m);
			
		}
	}

}

class MainViewListener implements ActionListener{

	private MainView mv;
	private JButton b;
	
	public MainViewListener(MainView mv,JButton b){
		this.mv = mv;
		this.b=b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(b.getText()){
		case "Buy Spa Counter":
			if (Spa.counters==10){
			
			}else{
			MainView.s=new Spa(1,0);
			mv.stations.add(MainView.s);
			mv.stations.revalidate();
			Spa.counters++;
			mv.snmStat.setCurrentCash(mv.snmStat.getCurrentCash()-Spa.upgradeCost);
			mv.currentCash.setText(""+mv.snmStat.getCurrentCash());
			MainView.spaStations.add(MainView.s);
			MainView.activityLog.append("You Bought a Spa Counter\n");
			}
			break;
		case "Buy Massage Counter":
			if (Massage.counters==10){
				
			}else{
			MainView.m = new Massage(1,0);
			mv.stations.add(MainView.m);
			mv.stations.revalidate();
			Massage.counters++;
			mv.snmStat.setCurrentCash(mv.snmStat.getCurrentCash()-Massage.upgradeCost);
			mv.currentCash.setText(""+mv.snmStat.getCurrentCash());
			MainView.massageStations.add(MainView.m);
			MainView.activityLog.append("You Bought a Massage Counter\n");
			}
			break;
		case "Quit": 
			try{
				PrintWriter pw = new PrintWriter("output.txt");
				pw.println("Current Cash: "+mv.snmStat.getCurrentCash());
				pw.println("---------------------------------");
				pw.println("Number of Current Spa Sessions: "+ mv.snmStat.getCurrentSpaSessionsCount());
				pw.println("---------------------------------");
				pw.println("Number of Current Massage Sessions: "+mv.snmStat.getCurrentMassageSessionsCount());
				pw.println("---------------------------------");
				pw.println("Total cost paid for maintenance: "+mv.snmStat.getTotalMaintainanceCost());
				pw.println("---------------------------------");
				pw.println("Average earnings per minute: "+mv.snmStat.computeAverageEarningsPerMinute());
				pw.println("---------------------------------");
				pw.println("Total sales per second: "+mv.snmStat.computeSalesPerSecond());
				pw.println("---------------------------------");
				pw.println("Sales for spa sessions: "+mv.snmStat.getTotalSpaSales());
				pw.println("---------------------------------");
				pw.println("Sales received for massage sessions:"+mv.snmStat.getTotalSpaSales());
				pw.println("---------------------------------");
				pw.close();
				}
				catch(Exception x){
					
				}
			System.exit(0);
			break;
		}

		
	}
	
	
}