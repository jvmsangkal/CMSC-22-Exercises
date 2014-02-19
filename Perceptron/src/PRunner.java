import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*Author: John Viscel M. Sangkal
 * U-4L
 * 2011-62193
 * Made using eclipse.
 * reads from file input.txt
 * _______________
 * |b t r
 * |training data
 * |
 * |______________
 * 
 * displays how many iterations and if fires or not fires in the console or terminal
 * */
public class PRunner {

	static JTextField bTextField;
	static JTextField tTextField;
	static JTextField rTextField;
	static JTextArea trainingDataField;
	static JTextArea iterationLog;
	static JPanel centerPane;
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("Perceptron");
		mainFrame.setMinimumSize(new Dimension(700, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane=new JPanel(new BorderLayout());
		mainFrame.setContentPane(pane);
		
		centerPane=new JPanel();
		centerPane.setPreferredSize(new Dimension(550,500));
		
		JPanel eastPane=new JPanel();
		eastPane.setPreferredSize(new Dimension(150,500));
		
		pane.add(centerPane,BorderLayout.CENTER);
		pane.add(eastPane,BorderLayout.EAST);
		
		iterationLog=new JTextArea(28, 43);
		iterationLog.setFocusable(false);
		JScrollPane scroll = new JScrollPane (iterationLog,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		centerPane.add(scroll);
		
		JLabel bLabel=new JLabel("Bias: ");
		JLabel tLabel=new JLabel("Treshold: ");
		JLabel rLabel=new JLabel("Rate: ");
		JLabel trainingdataLabel=new JLabel("Training Data:");
		
		bTextField= new JTextField(5);
		tTextField= new JTextField(5);
		rTextField= new JTextField(5);
		trainingDataField=new JTextArea(10, 10);
		JScrollPane scroll2 = new JScrollPane (trainingDataField,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton start=new JButton("Start");
		start.addActionListener(new PRunnerListener());
		
		eastPane.add(bLabel);
		eastPane.add(bTextField);
		eastPane.add(tLabel);
		eastPane.add(tTextField);
		eastPane.add(rLabel);
		eastPane.add(rTextField);
		eastPane.add(trainingdataLabel);
		eastPane.add(scroll2);
		eastPane.add(start);
		
		StringTokenizer st;
		try{
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line = br.readLine();
			st=new StringTokenizer(line," ");
			bTextField.setText(st.nextToken());
			tTextField.setText(st.nextToken());
			rTextField.setText(st.nextToken());
			line=br.readLine();
			while(line!=null){
				st=new StringTokenizer(line," ");
				while(st.hasMoreTokens()){
					trainingDataField.append(" ");
					trainingDataField.append(st.nextToken());
				}
				line =br.readLine();
				if(line!=null){
				trainingDataField.append("\n");
				}
			}
			br.close();
		}
		catch(Exception e){
			
		}
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
}

class PRunnerListener implements ActionListener{
	private int b;
	private double t;
	private double r;
	private int[][] trainingData;
	private int[] x;
	private double[] w;
	private double[] wNew;
	private int y;
	private int z;
	private double a=0;
	
	public PRunnerListener(){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PRunner.iterationLog.setText("");
		this.b=Integer.parseInt(PRunner.bTextField.getText());
		this.t=Double.parseDouble(PRunner.tTextField.getText());
		this.r=Double.parseDouble(PRunner.rTextField.getText());
		
		int row=0,col=0;
		StringTokenizer st = new StringTokenizer(PRunner.trainingDataField.getText(),"\n");
		row=st.countTokens();
		StringTokenizer st2 =new StringTokenizer(st.nextToken()," ");
		col=st2.countTokens();
		
		trainingData=new int[row][col];
		st = new StringTokenizer(PRunner.trainingDataField.getText(),"\n");
		for(int i=0;i<row;i++){
			st2 =new StringTokenizer(st.nextToken()," ");
			for(int j=0;j<col;j++){
			 trainingData[i][j]=Integer.parseInt(st2.nextToken());	
			}
		}
		
		int count=0;
		int iterationCount=0;
		x=new int[col];
		w=new double[col];
		wNew=new double[col];
		for(int i=0;i<col;i++){
			w[i]=0;
			wNew[i]=0;
		}
		x[0]=b;
		int index=0;
		while(count!=row){
			iterationCount++;
			for(int i=1;i<col;i++){
				this.x[i]=trainingData[index][i-1];
			}
			
			z=trainingData[index][col-1];
			a=0;
			for(int i=0;i<col;i++){
				this.a+=x[i]*w[i];
			}
			
			if(a>=t){
				this.y=1;
			}else{
				y=0;
			}
			
			for(int i=0;i<col;i++){
				wNew[i]=w[i]+r * (z-y) * x[i];
			}
			DecimalFormat df=new DecimalFormat("#.####");
			for(int i=0;i<col;i++){
				PRunner.iterationLog.append(" x["+i+"]="+x[i]+" ");
			}
			PRunner.iterationLog.append("\tz="+z+" ");
			for(int i=0;i<col;i++){
				PRunner.iterationLog.append("\tw["+i+"]="+df.format(w[i])+" ");
			}
			PRunner.iterationLog.append("\ta="+df.format(a)+" ");
			PRunner.iterationLog.append("\ty="+y+" ");
			for(int i=0;i<col;i++){
				PRunner.iterationLog.append("\tWnew["+i+"]="+df.format(wNew[i])+" ");
			}
			PRunner.iterationLog.append("\n");
			
			boolean equal=true;
			for(int i=0;i<col;i++){
				if(w[i]!=wNew[i]){
					equal=false;
					break;
				}else{equal=true;}
			}
			if(equal){count++;}else{count=0;}
			for(int i=0;i<col;i++){
				w[i]=wNew[i];
			}
			index++;
			if(index==row){
				index=0;
			}
		}
		JOptionPane op=new JOptionPane();
		op.showMessageDialog(PRunner.centerPane, iterationCount+" iterations.\n a="+a+" y="+y);
		if(y==1){
			System.out.println("Fires.");
		}else{
			System.out.println("Not Fires.");
		}
	}
	
}