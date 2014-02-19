import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*Author: John Viscel M. Sangkal
 * 2011-62193
 * U-4L
 * Description: Made using eclipse. no bugs.
 * */

public class KNNRunner {

	/**
	 * @param args
	 */
		static int k;
		static int n;
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("KNN");
		mainFrame.setMinimumSize(new Dimension(650, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel pane=new JPanel(new BorderLayout());
		mainFrame.setContentPane(pane);
		
		final Plane p=new Plane();
		JPanel inputPane= new JPanel();
		inputPane.setPreferredSize(new Dimension(150,500));
		pane.add(p,BorderLayout.CENTER);
		pane.add(inputPane,BorderLayout.EAST);
		
		JLabel xLabel=new JLabel("X: ");
		JLabel yLabel=new JLabel("Y: ");
		
		final JTextField xTextField=new JTextField(8);
		final JTextField yTextField=new JTextField(8);
		
		JButton classify=new JButton("Classify");
		
		classify.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane op=new JOptionPane();
				if(!isInteger(xTextField.getText()) || !isInteger(yTextField.getText())){
					op.showMessageDialog(pane, "Please enter an integer.");
				}else {
					int x = Integer.parseInt(xTextField.getText());
					int y = Integer.parseInt(yTextField.getText());
					KNNRunner.n++;
					ArrayList<Double> distances = new ArrayList<Double>();
					distances.clear();
					for(int i=0;i<Plane.dataset.size();i++){
						double temp=(Plane.dataset.get(i).getX()-x);
						double temp2=(Plane.dataset.get(i).getY()-y);
						Double d=Math.sqrt((temp*temp)+(temp2*temp2));
						distances.add(d);
					}
					ArrayList<Integer> leastKIndexes = new ArrayList<Integer>();
					
					for(int i=0;i<k;i++){
						int index=0;
						for(int j=0;j<distances.size();j++){
							boolean found=false;
							for(int f=0;f<leastKIndexes.size();f++){
								if(leastKIndexes.get(f)==j){
									found=true;
									break;
								}
								found=false;
							}
							if(found==false){
							if(distances.get(index)>distances.get(j)){
								index=j;
							}
							}
						}
						leastKIndexes.add(index);
					}
					
					int[] count=new int[Plane.classificationColor.size()];
					for(int i=0;i<Plane.classificationColor.size();i++){
						count[i]=0;
					}
					
					for(int i=0;i<leastKIndexes.size();i++){
						count[Plane.dataset.get(leastKIndexes.get(i)).getC()-1]++;
					}
					int c=0;
					int max=count[0];
					for(int i=0;i<Plane.classificationColor.size();i++){
						if(max<count[i]){
							max=count[i];
							c=i;
						}
					}
					Plane.dataset.add(new Point(x, y, c+1));
					p.repaint();
				}
				xTextField.setText("");
				yTextField.setText("");
			}
		});
		
		inputPane.add(xLabel);
		inputPane.add(xTextField);
		inputPane.add(yLabel);
		inputPane.add(yTextField);
		inputPane.add(classify);
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}

	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
}
