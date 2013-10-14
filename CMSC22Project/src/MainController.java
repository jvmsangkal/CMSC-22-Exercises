
public class MainController extends SuperController{
	private MainView mainView;
	
	public MainController(MainView mainGameView){

		this.mainView = mainGameView;
		
		SNMStat.mainFrame.setContentPane(mainGameView);
		
		SNMStat.controller = this;
		
		mainGameView.setFocusable(true);
		mainGameView.requestFocus();
		
		SNMStat.mainFrame.pack();
		SNMStat.mainFrame.repaint();
	
	}

}
