import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Tester {
	public static void main(String[] args){
		SNMStat snm = new SNMStat();
		ArrayList<Parameter> al= new ArrayList<Parameter>();
		Parameter p = null;
		try{
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("wx6lparameter.ser"));
			for(int i=0;i<11;i++){
			p= (Parameter)ois.readObject();
		    al.add(p);
			}
			ois.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		snm.setCurrentCash(al.get(0).getDoubleValue());//capital
		Spa.counters=al.get(1).getIntValue();//spa counters
		Massage.counters=al.get(2).getIntValue();//massage counters
		Spa.rate=al.get(3).getDoubleValue();//rate spa
		Massage.rate=al.get(4).getDoubleValue();//rate massage
		snm.setMaintainanceCost(al.get(5).getDoubleValue());//maintenance cost
		Spa.upgradeCost=al.get(6).getDoubleValue();//upgrade cost spa
		Massage.upgradeCost=al.get(7).getDoubleValue();//upgrade cost massage
		snm.setMemberDiscount(al.get(8).getDoubleValue());//member discount
		Guest.guestCount=al.get(9).getIntValue();//initial size guest
		snm.setRateOfQueuedGuest(al.get(10).getIntValue());//rate of queued guest
		
		ArrayList<Guest> g= new ArrayList<Guest>();
		Guest guest=null;
		Random n = new Random();
		for(int i=0;i<Guest.guestCount;i++){
				guest=new Guest(n.nextBoolean());
				g.add(guest);
				System.out.println(guest.isMember());
		}
		
		JFrame mf = new JFrame("MassageBang!");
		mf.setSize(600,600);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel stations = new JPanel();
		JPanel status = new JPanel();
		
		pane.add(stations,BorderLayout.CENTER);
		pane.add(status,BorderLayout.EAST);
		
		status.setLayout(new BorderLayout());
		stations.setLayout(new GridLayout(4,5));
		
		JTextArea textArea1= new JTextArea(10, 15);
		textArea1.setFocusable(false);
		status.add(textArea1,BorderLayout.SOUTH);
		
		mf.setContentPane(pane);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}
