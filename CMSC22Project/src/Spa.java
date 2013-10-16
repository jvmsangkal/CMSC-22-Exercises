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



public class Spa extends Equipment{

	static int counters=0;
	static double rate;
	static double upgradeCost;
	final public LinkedList<Guest> ll = new LinkedList<Guest>();
	static JLabel time;
	public JPanel slotTimer= new JPanel();
	final public ArrayList<JLabel> al = new ArrayList<JLabel>();
	public Spa(int totalSlots, int occupiedSlots) {
		super(totalSlots, occupiedSlots);
		// TODO Auto-generated constructor stub
		
		this.setLayout(new GridLayout(3,1));
		ImageIcon image = new ImageIcon(SNMStat.loadImage("spa.jpeg"));
		JButton b = new JButton(image);
		JButton upgradeButton= new JButton("Upgrade");
		//JPanel slotTimer=
		
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
		b.addActionListener(new SpaListener(this, b));
		upgradeButton.addActionListener(new SpaListener(this, upgradeButton));
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for(int i=0; i<al.size();i++){
					if((Integer.parseInt(al.get(i).getText()))==0){
						Guest g=ll.peek();
						if(ll.peek()!=null){
							g=ll.poll();
							if(g.isMember()){
							MainView.activityLog.append("A member left the Spa\n");
							}else{
								MainView.activityLog.append("A non member left the Spa\n");
							}
							if(g.isMember()){
								MainView.snmStat.setTotalSpaSales(MainView.snmStat.getTotalSpaSales()+Spa.rate-MainView.snmStat.getMemberDiscount());
								MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()+Spa.rate-MainView.snmStat.getMemberDiscount());
								MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
							}else{
							MainView.snmStat.setTotalSpaSales(MainView.snmStat.getTotalSpaSales()+Spa.rate);
							MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()+Spa.rate);
							}
							MainView.salesSpa.setText(""+MainView.snmStat.getTotalSpaSales());
							//MainView.snmStat.setCurrentSpaSessionsCount(MainView.snmStat.getCurrentSpaSessionsCount()-1);
							//MainView.currentSpaSessions.setText(""+MainView.snmStat.getCurrentSpaSessionsCount());
							MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
							
						}
						if(g!=null && g.isWillMassage()){
							boolean flag=false;
							MainView.activityLog.append("Someone from a Spa wants massage.\n");
							for(int j=0;j<MainView.massageStations.size();j++){
								if(MainView.massageStations.get(j).ll.size()<MainView.massageStations.get(j).getTotalSlots()){
									
									for(int k=0;k<MainView.massageStations.get(j).getTotalSlots();k++){
										if(Integer.parseInt(MainView.massageStations.get(j).al.get(k).getText())==0){
											MainView.massageStations.get(j).ll.add(g);
											MainView.massageStations.get(j).al.get(k).setText(""+(5+MainView.randomGenerator.nextInt(4)));
										MainView.snmStat.setCurrentMassageSessionsCount(MainView.snmStat.getCurrentMassageSessionsCount()+1);
										MainView.currentMassageSessions.setText(""+MainView.snmStat.getCurrentMassageSessionsCount());
										flag=true;
										break;
		
										}
										
										}
									if(flag){
										//flag=false;
										break;
									}
												
								}
							}
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

class SpaListener implements ActionListener{

	private Spa s;
	private JButton b;
	
	public SpaListener(Spa s, JButton b){
		this.s=s;
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(b.getName()=="logo"){
			for(int i=0;i<s.getTotalSlots();i++){
			if(Integer.parseInt(s.al.get(i).getText())==0 && MainView.guestQueue.size()!=0){
				if(MainView.guestQueue.peek().isMember()){
					MainView.activityLog.append("A member is in a Spa\n");
				}else{
					MainView.activityLog.append("A non-member is on a Spa\n");
				}
			s.ll.add(MainView.guestQueue.poll());
			//m.setOccupiedSlots(m.getOccupiedSlots()+1);
			s.al.get(i).setText(""+(5+MainView.randomGenerator.nextInt(4)));
			MainView.snmStat.setCurrentSpaSessionsCount(MainView.snmStat.getCurrentSpaSessionsCount()+1);
			MainView.currentSpaSessions.setText(""+MainView.snmStat.getCurrentSpaSessionsCount());
			}}
			MainView.queueCount.setText(""+MainView.guestQueue.size());
			
		}else if(b.getText()=="Upgrade") {
			if(s.getTotalSlots()==5){}
			else{
			MainView.snmStat.setCurrentCash(MainView.snmStat.getCurrentCash()-Spa.upgradeCost);
			MainView.currentCash.setText(""+MainView.snmStat.getCurrentCash());
			s.setTotalSlots(s.getTotalSlots()+1);
			Spa.time= new JLabel(""+0);
			s.slotTimer.add(Spa.time);
			s.al.add(Spa.time);
			s.slotTimer.revalidate();
			MainView.activityLog.append("You upgraded a Spa Station!\n");
			}
		}
	}
	
}