import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SolutionFrame{

	private State solution;
	static ArrayList<State> path;
	public static int displayIndex=1;
	static JButton[][] buttonGrid=new JButton[3][3];

	public SolutionFrame(State solution){
		displayIndex=1;
		this.solution = solution;
		path = new ArrayList<State>();
		JFrame mainFrame = new JFrame("Solution");
		mainFrame.setMinimumSize(new Dimension(300, 350));
		JPanel pane = new JPanel();
		JPanel mainPane = new JPanel();
		pane.setPreferredSize(new Dimension(300,300));
		mainFrame.setContentPane(mainPane);
		
		mainPane.setLayout(new BorderLayout());
		pane.setLayout(new GridLayout(3,3));
		
		mainPane.add(pane,BorderLayout.CENTER);
		JButton next=new JButton("Next");
		JButton prev=new JButton("Previous");
		JPanel buttonPane= new JPanel();
		buttonPane.add(prev);
		buttonPane.add(next);
		next.addActionListener(new SolutionFrameListener(next));
		prev.addActionListener(new SolutionFrameListener(prev));
		State node = new State();
		node = solution;
		while(node!=null){
			path.add(node);
			node=node.getPrevState();
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(path.get(path.size()-1).getCurrState()[i][j]==0){
					pane.add(buttonGrid[i][j]=new JButton(""));
				}
				else{
				pane.add(buttonGrid[i][j]=new JButton(""+path.get(path.size()-1).getCurrState()[i][j]));
				}
			}
		}
		
		mainPane.add(buttonPane,BorderLayout.SOUTH);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
}

class SolutionFrameListener implements ActionListener{
	JButton b;
	public SolutionFrameListener(JButton b){
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(b.getText()=="Next"){
			int n=SolutionFrame.displayIndex+1;
			int index=SolutionFrame.path.size()-n;
			if(index > -1){
				SolutionFrame.displayIndex++;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(SolutionFrame.path.get(index).getCurrState()[i][j]==0){
						SolutionFrame.buttonGrid[i][j].setText("");
					}
					else{
						SolutionFrame.buttonGrid[i][j].setText(""+SolutionFrame.path.get(index).getCurrState()[i][j]);
					}
				}
			}
			}
		}else if(b.getText().equals("Previous")){
			int n=SolutionFrame.displayIndex-1;
			int index=SolutionFrame.path.size()-n;
			if(index < SolutionFrame.path.size()){
				SolutionFrame.displayIndex--;
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(SolutionFrame.path.get(index).getCurrState()[i][j]==0){
							SolutionFrame.buttonGrid[i][j].setText("");
						}
						else{
							SolutionFrame.buttonGrid[i][j].setText(""+SolutionFrame.path.get(index).getCurrState()[i][j]);
						}
					}
				}
				}
		}
		
	}
	
}
