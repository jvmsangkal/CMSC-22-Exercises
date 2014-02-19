import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JPanel;


public class Plane extends JPanel{
	
	static ArrayList<Point> dataset=new ArrayList<Point>();
	static ArrayList<Color> classificationColor = new ArrayList<Color>(); 
	
	public Plane(){
		super();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500,500));
		StringTokenizer st;
		int classificationCount=0;
		try{
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line = br.readLine();
			st=new StringTokenizer(line," ");
			KNNRunner.k=Integer.parseInt(st.nextToken());
			KNNRunner.n=Integer.parseInt(st.nextToken());
			line=br.readLine();
			for(int i=0;i<KNNRunner.n;i++){
				st=new StringTokenizer(line," ");
				Point p= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				if(classificationCount<p.getC()){
					classificationCount=p.getC();
				}
				dataset.add(p);
				line =br.readLine();
			}
			br.close();
		}
		catch(Exception e){
			
		}
		float interval = 360f / classificationCount; 
		for (float x = 0; x < 360; x += interval) {
	        Color c = Color.getHSBColor(x / 360, 1, 1);
	        classificationColor.add(c);
		}
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		for(int i=0;i<dataset.size();i++){
			g.setColor(classificationColor.get(dataset.get(i).getC()-1));
			g.fillArc(dataset.get(i).getX()*10-3, 480-dataset.get(i).getY()*10-3, 6, 6, 0, 360);
		}
	}

}
