import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Massage extends Equipment{

	static int counters=0;
	static double rate;
	static double upgradeCost;
	final public LinkedList<Guest> ll = new LinkedList<Guest>();
	static JLabel time;
	public JPanel slotTimer;
	public ArrayList<JLabel> al = new ArrayList<JLabel>();
	public Massage(int totalSlots, int occupiedSlots) {
		super(totalSlots, occupiedSlots);
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(3,1));
		ImageIcon image = new ImageIcon(SNMStat.loadImage("massage.jpg"));
		JButton b = new JButton(image);
		JButton upgradeButton= new JButton("Upgrade");
		slotTimer= new JPanel();
		
		b.setName("logo");
		this.add(b);
		this.add(upgradeButton);
		this.add(slotTimer);
		
		this.setPreferredSize(new Dimension(150,250));
		slotTimer.setPreferredSize(new Dimension(150,50));
		for(int i=0;i<totalSlots;i++){	
			time = new JLabel(""+0);
			slotTimer.add(time);
			al.add(time);
		}
		b.addActionListener(new MassageListener(this, b));
		upgradeButton.addActionListener(new MassageListener(this, upgradeButton));
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for(int i=0; i<al.size();i++){
					if((Integer.parseInt(al.get(i).getText()))==0){
						if(ll.peek()!=null){
							Guest g=ll.poll();
							if(g.isMember()){
								MainView.activityLog.append("A member left the Spa\n");
								}else{
									MainView.activityLog.append("A non member left the Spa\n");
								}
							if(g.isMember()){
								MainView.snmStat.setTotalMassageSales(MainView.snmStat.getTotalMassageSales()+Massage.rate-MainView.snmStat.getMemberDiscount());
								MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()+Massage.rate-MainView.snmStat.getMemberDiscount());
								MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
							}else{
							MainView.snmStat.setTotalMassageSales(MainView.snmStat.getTotalMassageSales()+Massage.rate);
							MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()+Massage.rate);
							}
							MainView.salesMassage.setText(""+MainView.snmStat.getTotalMassageSales());
							//MainView.snmStat.setCurrentMassageSessionsCount(MainView.snmStat.getCurrentMassageSessionsCount()-1);
							//MainView.currentMassageSessions.setText(""+MainView.snmStat.getCurrentMassageSessionsCount());
							MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
							
						}
					}
					else{
					al.get(i).setText(""+(Integer.parseInt(al.get(i).getText())-1));
					}
				}
			}
		}, 1000, 1000);
		
	}
}

class MassageListener implements ActionListener{
	private Massage m;
	private JButton b;
	
	public MassageListener(Massage m, JButton b){
		this.m=m;
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(b.getName()=="logo"){
			for(int i=0;i<m.getTotalSlots();i++){
			if(Integer.parseInt(m.al.get(i).getText())==0 && MainView.guestQueue.size()!=0){
				if(MainView.guestQueue.peek().isMember()){
					MainView.activityLog.append("A member is in a Massage Station\n");
				}else{
					MainView.activityLog.append("A non-member is on a Massage Station\n");
				}
			m.ll.add(MainView.guestQueue.poll());
			m.al.get(i).setText(""+(5+MainView.randomGenerator.nextInt(4)));
			MainView.snmStat.setCurrentMassageSessionsCount(MainView.snmStat.getCurrentMassageSessionsCount()+1);
			MainView.currentMassageSessions.setText(""+MainView.snmStat.getCurrentMassageSessionsCount());
			}}
			MainView.queueCount.setText(""+MainView.guestQueue.size());
			
		}else if(b.getText()=="Upgrade") {
			if(m.getTotalSlots()==5){}
			else{
			MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()-Massage.upgradeCost);
			MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
			m.setTotalSlots(m.getTotalSlots()+1);
			Massage.time= new JLabel(""+0);
			m.slotTimer.add(Massage.time);
			m.al.add(Massage.time);
			m.slotTimer.revalidate();
			MainView.activityLog.append("You upgraded a Massage Station!\n");
			}
		}
	}
	
	
}
