import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
public class KMeansRunner {
		static int k;
		static int n;
		static ArrayList<Point[]> log= new ArrayList<>();
		static int displayIndex=0;
	public static void main(String[] args){
		JFrame mainFrame = new JFrame("KMeans");
		mainFrame.setMinimumSize(new Dimension(650, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel pane=new JPanel(new BorderLayout());
		mainFrame.setContentPane(pane);
		
		final Plane p=new Plane();
		JPanel inputPane= new JPanel();
		inputPane.setPreferredSize(new Dimension(150,500));
		pane.add(p,BorderLayout.CENTER);
		pane.add(inputPane,BorderLayout.EAST);
		
		JButton next=new JButton("Next");
		JButton previous=new JButton("Previous");
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Point[] tmp=new Point[KMeansRunner.k];
				for(int i=0;i<KMeansRunner.k;i++){
					tmp[i]=Plane.chosenPoints[i];
				}
				if(KMeansRunner.log.add(tmp)){
				KMeansRunner.displayIndex++;
				}
				int[] sumsX=new int[KMeansRunner.k];
				int[] sumsY=new int[KMeansRunner.k];
				int[] elementsCount=new int[KMeansRunner.k];
				for(int i=0;i<KMeansRunner.k;i++){
					sumsX[i]=0;
					sumsY[i]=0;
					elementsCount[i]=0;
				}
				for(int i=0;i<Plane.dataset.size();i++){
					sumsX[Plane.dataset.get(i).getC()-1]+=Plane.dataset.get(i).getX();
					sumsY[Plane.dataset.get(i).getC()-1]+=Plane.dataset.get(i).getY();
					elementsCount[Plane.dataset.get(i).getC()-1]++;
				}
				for(int i=0;i<KMeansRunner.k;i++){
					int x=sumsX[i]/elementsCount[i];
					int y=sumsY[i]/elementsCount[i];
					Point p=new Point(x, y);
					p.setC(i+1);
					Plane.chosenPoints[i]=p;
					System.out.println(x+","+y);
				}
				
				Plane.classify();
				p.repaint();
			}
		});
		
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(KMeansRunner.displayIndex!=0){
				KMeansRunner.displayIndex--;
				for(int i=0;i<KMeansRunner.k;i++){
					Plane.chosenPoints[i]=KMeansRunner.log.get(displayIndex)[i];
				}
				Plane.classify();
				p.repaint();
				}
			}
		});
		
		inputPane.add(next);
		inputPane.add(previous);
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
}
