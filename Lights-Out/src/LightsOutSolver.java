import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DefaultEditorKit.CutAction;


public class LightsOutSolver extends JPanel{

	public LightsOutSolver(){
		this.setPreferredSize(new Dimension(200, 600));
		
		JButton solve=new JButton("Solve!");
		solve.addActionListener(new LightsOutSolverListener(solve));
		this.add(solve);
	}
	
}

class LightsOutSolverListener implements ActionListener{

	private JButton b;
	private int[][] currentState=new int[5][5];
	private int[][] initialState=new int[5][5];
	private LinkedList<int[][]> states=new LinkedList<int[][]>();
	private int[][] temp= null;
	 static JFrame mainFrame = new JFrame("Solution");
	public static int cost=0;
	private LinkedList costList=new LinkedList<>();
	
	public LightsOutSolverListener(JButton b){
		this.b=b;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cost=0;
		costList.clear();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				
				if(LightsOutRunner.lightGrid[i][j].isSwitchState()){
					initialState[i][j]=1;
				}else{
					initialState[i][j]=0;
				}
				System.out.print(""+initialState[i][j]);
			}
			System.out.println("");
		}
		System.out.println("----------");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				currentState[i][j]=initialState[i][j];
			}
		}
		
		while(checkSolution()){
		generateChildren();
		if(states.peek()==null){
			LightsOutRunner.op.showMessageDialog(mainFrame, "No Solution.");
			break;
		}
		temp=states.poll();
		cost=(int)costList.poll();
		for(int x=0;x<5;x++){
			for(int y=0;y<5;y++){
				currentState[x][y]=temp[x][y];
			}
		}

	
		}
		
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(currentState[i][j]);
			}
			System.out.println("");
		}
		System.out.println("________");
		int[][] solution= new int[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(initialState[i][j]==currentState[i][j]){
					solution[i][j]=0;
				}else{
					//solution[i][j]=currentState[i][j];
					solution[i][j]=1;
				}
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(solution[i][j]);
			}
			System.out.println("");
		}
		System.out.println("________");
		mainFrame.dispose();
		mainFrame = new JFrame("Solution");
		mainFrame.setMinimumSize(new Dimension(600, 650));
		JPanel pane = new JPanel();
		JPanel mainPane = new JPanel();
		pane.setPreferredSize(new Dimension(600,600));
		mainFrame.setContentPane(mainPane);
		pane.setLayout(new GridLayout(5,5,3,3));
		
		JButton clickMe=null;
		ImageIcon click=new ImageIcon(LightsOutRunner.loadImage("clickme.jpg"));
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				pane.add(clickMe=new JButton());
				if(solution[i][j]==1){
					clickMe.setIcon(click);
				}else{
					clickMe.setIcon(LightsOutRunner.lightoff);
				}
			}
		}
		JLabel costLabel = new JLabel("Cost: " +cost);
		mainPane.setLayout(new BorderLayout());
		mainPane.add(pane,BorderLayout.CENTER);
		mainPane.add(costLabel,BorderLayout.SOUTH);
		mainFrame.setBounds(600, 0, 600, 650);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
	
	public void generateChildren(){
		int[][] child=null;
		int n;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
					if(currentState[i][j]==0){
						child=new int[5][5];
						for(int k=0;k<5;k++){
							for(int l=0;l<5;l++){
								child[k][l]=currentState[k][l];
							}		
						}
						child[i][j]=1;
						n=cost;
						n++;
						costList.add(n);
					states.add(child);
					
					}
					
								
			}	
		}

		
	}
	
	public boolean checkSolution(){
		int[][] lightState=new int[5][5];
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				lightState[i][j]=1;
			}
		}
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
					if(currentState[i][j]==1){
					if(lightState[i][j]==1){
					lightState[i][j]=0;
					}else{
						lightState[i][j]=1;
					}
					try{
						if(lightState[i+1][j]==1){
							lightState[i+1][j]=0;
							}else{
								lightState[i+1][j]=1;
							}
					}catch(Exception e){
						
					}
					try{
						if(lightState[i-1][j]==1){
							lightState[i-1][j]=0;
							}else{
								lightState[i-1][j]=1;
							}
					}catch(Exception e){
						
					}
					try{
						if(lightState[i][j+1]==1){
							lightState[i][j+1]=0;
							}else{
								lightState[i][j+1]=1;
							}
					}catch(Exception e){
						
					}
					try{
						if(lightState[i][j-1]==1){
							lightState[i][j-1]=0;
							}else{
								lightState[i][j-1]=1;
							}
					}catch(Exception e){
						
					}
				}
			}
		}
		boolean flag=false;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(lightState[i][j]==1){
					flag=true;
				}
			}
		}
		if(flag){
			return true;
		}else{
			return false;
		}
	}
	
}