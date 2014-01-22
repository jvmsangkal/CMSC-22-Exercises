import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EPSolver extends JPanel{

	public EPSolver(){
		this.setPreferredSize(new Dimension(100,300));
		JButton solve= new JButton("Solve!");
		solve.addActionListener(new EPSolverActionListener());
		this.add(solve);
	}
}

class EPSolverActionListener implements ActionListener{
	
	private State initialState = new State();
	private ArrayList<State> openList = new ArrayList<State>();
	private ArrayList<State> closedList = new ArrayList<State>();
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(Board.tileGrid[i][j].getText()==""){
				initialState.getCurrState()[i][j]=0;	
				}else{
				initialState.getCurrState()[i][j]=Integer.parseInt(Board.tileGrid[i][j].getText());
				}
			}
		}
		initialState.setPrevState(null);
		initialState.computeH();
		initialState.computeF();
		
		State bestNode=ASearch();
		if(bestNode==null){
			JOptionPane op= new JOptionPane();
			op.showMessageDialog(EPRunner.pane, "No solution!");
		}else{
			SolutionFrame sf = new SolutionFrame(bestNode);
		}
	}
	
	public State ASearch(){
		openList.clear();
		closedList.clear();
		State bestNode=new State();
		
		openList.add(initialState);
		
		while(!openList.isEmpty()){
			
			State temp=openList.get(0);
			int index=0;
			for(int i=1;i<openList.size();i++){
				if(openList.get(i).getF()<temp.getF()){
					temp=openList.get(i);
					index=i;
				}
			}
			bestNode=openList.remove(index);
			closedList.add(bestNode);
			
			if(goalTest(bestNode)){
				return bestNode;
			}
			
			ArrayList<State> actions = generateChildren(bestNode);

			for(State a : actions){
				if(isNotElementOfOpenClosed(a) || lessThanF(a)){
					
					a.setPrevState(bestNode);
					a.computeG();
					a.computeH();
					a.computeF();
					openList.add(a);
				}
			}
			
		}
		return null;
	}
	
	public boolean isNotElementOfOpenClosed(State s){
		boolean containFlag=false;
		boolean equalFlag=true;
		boolean containFlag2=false;
		boolean equalFlag2=true;
		for(int x=0;x<openList.size();x++){
			State temp=openList.get(x);
			equalFlag=true;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(temp.getCurrState()[i][j]!=s.getCurrState()[i][j]){
						equalFlag=false;
					}
				}
			}
			
			if(equalFlag){
				containFlag=true;
				break;
			}
		}
		
		for(int x=0;x<closedList.size();x++){
			State temp=closedList.get(x);
			equalFlag2=true;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(temp.getCurrState()[i][j]!=s.getCurrState()[i][j]){
						equalFlag2=false;
					}
				}
			}
			
			if(equalFlag2){
				containFlag2=true;
				break;
			}
		}
		if(containFlag || containFlag2){
			return false;
		}
		else{return true;}
	}
	
	public boolean lessThanF(State s){
		boolean equalFlag=true;
		boolean equalFlag2=true;
		for(int x=0;x<openList.size();x++){
			State temp=openList.get(x);
			equalFlag=true;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(temp.getCurrState()[i][j]!=s.getCurrState()[i][j]){
						equalFlag=false;
					}
				}
			}
			
			if(equalFlag){
				if(s.getF()<temp.getF()){
					return true;
				}
			}
		}
		
		for(int x=0;x<closedList.size();x++){
			State temp=closedList.get(x);
			equalFlag2=true;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(temp.getCurrState()[i][j]!=s.getCurrState()[i][j]){
						equalFlag2=false;
					}
				}
			}
			
			if(equalFlag2){
				if(s.getF()<temp.getF()){
					return true;
				}
			}
		}
		return false;
	}
	public ArrayList<State> generateChildren(State bestNode){
		ArrayList<State> children = new ArrayList<State>();
		State temp= null;
		boolean stop=false;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(bestNode.getCurrState()[i][j]==0){
					try{
						temp= new State();
						for(int x=0;x<3;x++){
							for(int y=0;y<3;y++){
								temp.getCurrState()[x][y]=bestNode.getCurrState()[x][y];
							}
						}	
						temp.getCurrState()[i][j]=temp.getCurrState()[i][j+1];
						temp.getCurrState()[i][j+1]=0;
						children.add(temp);
					}catch(Exception e){
						
					}
					try{
						temp= new State();
						for(int x=0;x<3;x++){
							for(int y=0;y<3;y++){
								temp.getCurrState()[x][y]=bestNode.getCurrState()[x][y];
							}
						}	
						temp.getCurrState()[i][j]=temp.getCurrState()[i][j-1];
						temp.getCurrState()[i][j-1]=0;
						children.add(temp);
					}catch(Exception e){
						
					}
					try{
						temp= new State();
						for(int x=0;x<3;x++){
							for(int y=0;y<3;y++){
								temp.getCurrState()[x][y]=bestNode.getCurrState()[x][y];
							}
						}	
						temp.getCurrState()[i][j]=temp.getCurrState()[i+1][j];
						temp.getCurrState()[i+1][j]=0;
						children.add(temp);
					}catch(Exception e){
						
					}
					try{
						temp= new State();
						for(int x=0;x<3;x++){
							for(int y=0;y<3;y++){
								temp.getCurrState()[x][y]=bestNode.getCurrState()[x][y];
							}
						}	
						temp.getCurrState()[i][j]=temp.getCurrState()[i-1][j];
						temp.getCurrState()[i-1][j]=0;
						children.add(temp);
					}catch(Exception e){
						
					}
					stop=true;
					break;
				}
				if(stop){
					break;
				}
			}
		}
		return children;
	}
	
	public boolean goalTest(State bestNode){
		int n=1;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(n==9){
					n=0;
				}
				if(bestNode.getCurrState()[i][j] != n){
					return false;
				}else{
					n++;
				}
			}
		}
		return true;
	}
	

	
	
	
}
