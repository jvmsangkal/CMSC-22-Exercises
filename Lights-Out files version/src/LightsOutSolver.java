import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	private int[][] temp= null;
	 static JFrame mainFrame = new JFrame("Solution");
	
	public LightsOutSolverListener(JButton b){
		this.b=b;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			PrintWriter pw = new PrintWriter("states.txt");
			pw.write("");
			pw.close();
		}catch(Exception c){
			
		}
		// TODO Auto-generated method stub
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(LightsOutRunner.lightGrid[i][j].isSwitchState()){
					initialState[i][j]=1;
				}else{
					initialState[i][j]=0;
				}
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				currentState[i][j]=initialState[i][j];
			}
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader("states.txt"));
			String line;
			
		while(checkSolution()){
		generateChildren();
			for(int i=0;i<5;i++){
				line=br.readLine();
				for(int j=0;j<5;j++){
					if(line==null){
						break;
					}
					currentState[i][j]=Integer.parseInt(""+line.charAt(j));
				}
				
			}
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					System.out.print(currentState[i][j]);
				}
				System.out.println("");
			}
			System.out.println("________");
		}	
		br.close();
		}catch(Exception c){
			c.printStackTrace();
		}
		/*if(states.peek()==null){
			LightsOutRunner.op.showMessageDialog(mainFrame, "No Solution.");
			break;
		}
		temp=states.poll();
		for(int x=0;x<5;x++){
			for(int y=0;y<5;y++){
				currentState[x][y]=temp[x][y];
			}
		}
		*/
		
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
		mainFrame.setMinimumSize(new Dimension(600, 600));
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(600,600));
		mainFrame.setContentPane(pane);
		pane.setLayout(new GridLayout(5,5,3,3));
		JButton clickMe=null;
		ImageIcon click=new ImageIcon(LightsOutRunner.loadImage("clickme.jpg"));
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				pane.add(clickMe=new JButton());
				if(solution[i][j]==1){
					clickMe.setIcon(click);
					//clickMe.setLabel("Click Me");
				}else{
					clickMe.setIcon(LightsOutRunner.lightoff);
				}
			}
		}
		mainFrame.setBounds(600, 0, 600, 600);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
	
	public void generateChildren(){
		int[][] child=null;
		try{	
			BufferedReader br = new BufferedReader(new FileReader("states.txt"));
			String line = br.readLine();
			ArrayList al = new ArrayList();
			while(line !=null){
				al.add(line);
				line =br.readLine();
			}
			br.close();
			
			
		PrintWriter pw = new PrintWriter("states.txt");
		for(int i=0;i<al.size();i++){
			pw.println(al.get(i));
		}
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
						for(int k=0;k<5;k++){
							for(int l=0;l<5;l++){
								pw.append(""+child[k][l]);
							}	
							pw.append('\n');
						}
						
										
					}
			}	
		}
		pw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public boolean checkSolution(){
		int[][] lightState=new int[5][5];
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				lightState[i][j]=1;
			}
		}
		//System.out.println(currentState[0][0]);
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