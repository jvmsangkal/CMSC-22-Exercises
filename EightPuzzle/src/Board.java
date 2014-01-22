import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Board extends JPanel{
	public static Tile[][] tileGrid=new Tile[3][3];
	
	public Board(){
		this.setLayout(new GridLayout(3,3));
		this.setPreferredSize(new Dimension(300,300));
		

		
		try{
			BufferedReader br = new BufferedReader(new FileReader("initialState.txt"));
			String line = br.readLine();
			int i=0;
			while(line !=null){
			
				for(int j=0;j<3;j++){
					tileGrid[i][j]=new Tile(""+line.charAt(j),i,j);
					if(line.charAt(j)=='0'){
						tileGrid[i][j].setText("");
					}
					
					tileGrid[i][j].addActionListener(new BoardListener(tileGrid[i][j]));
					this.add(tileGrid[i][j]);
				}
				i++;
				line =br.readLine();
			}
			br.close();
		}catch(Exception e){
			
		}
		
		
	}

}

class BoardListener implements ActionListener{
	Tile b;
	public BoardListener(Tile b){
		this.b=b;
	}
	
	public void actionPerformed(ActionEvent e) {
		int X=b.getPositionX();
		int Y=b.getPositionY();
		String bottom=null;
		String top=null;
		String left=null;
		String right=null;
		if(Y!=2){
		bottom=Board.tileGrid[X][Y+1].getText();
		}
		if(Y!=0){
		top=Board.tileGrid[X][Y-1].getText();
		}
		if(X!=0){
		left=Board.tileGrid[X-1][Y].getText();
		}
		if(X!=2){
		right=Board.tileGrid[X+1][Y].getText();
		}
		try{
			if(bottom==""){
				Board.tileGrid[X][Y+1].setText(b.getText());
				b.setText("");
			}else if(top==""){
				Board.tileGrid[X][Y-1].setText(b.getText());
				b.setText("");
			}else if(right==""){
				Board.tileGrid[X+1][Y].setText(b.getText());
				b.setText("");
			}else if(left==""){
				Board.tileGrid[X-1][Y].setText(b.getText());
				b.setText("");
			}
		}catch(Exception c){
			c.printStackTrace();
		}
	}
	
}
