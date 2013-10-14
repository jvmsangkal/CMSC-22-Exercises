
public class SNMMainController extends SuperController{
	private SNMMainView snmMainView;
	
	public SNMMainController(SNMMainView snmMainView){

		this.snmMainView= snmMainView;
	
		SNMStat.mainFrame.setContentPane(snmMainView);
		snmMainView.setFocusable(true);
		snmMainView.requestFocus();
		
		SNMStat.controller = this;

		SNMStat.mainFrame.pack();
		SNMStat.mainFrame.repaint();
	
	}
}
