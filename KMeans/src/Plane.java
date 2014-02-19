import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JPanel;


public class Plane extends JPanel{
	
	static ArrayList<Point> dataset=new ArrayList<Point>();
	static ArrayList<Color> classificationColor = new ArrayList<Color>();
	static Point[] chosenPoints;
	static double[][] distances;
	public Plane(){
		super();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500,500));
		StringTokenizer st;
		try{
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line = br.readLine();
			st=new StringTokenizer(line," ");
			KMeansRunner.k=Integer.parseInt(st.nextToken());
			KMeansRunner.n=Integer.parseInt(st.nextToken());
			line=br.readLine();
			for(int i=0;i<KMeansRunner.n;i++){
				st=new StringTokenizer(line," ");
				Point p= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				dataset.add(p);
				line =br.readLine();
			}
			br.close();
		}
		catch(Exception e){
			
		}
		float interval = 360f / KMeansRunner.k; 
		for (float x = 0; x < 360; x += interval) {
	        Color c = Color.getHSBColor(x / 360, 1, 1);
	        classificationColor.add(c);
		}
		chosenPoints=new Point[KMeansRunner.k];
		Random randomGenerator=new Random();
		for(int h=0;h<KMeansRunner.k;h++){
			int index=0;
		for(int i=0;i<KMeansRunner.n;i++){
			boolean contains=true;
			while(contains){
			index = randomGenerator.nextInt(KMeansRunner.n);
			for(int j=0;j<KMeansRunner.k;j++){
				if(chosenPoints[j]==dataset.get(index)){
					contains=true;
					break;
				}
				contains=false;
			}
			}
		}
		chosenPoints[h]=dataset.get(index);
		System.out.println(index);
		}
		classify();
	}

	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		for(int i=0;i<dataset.size();i++){
			g.setColor(classificationColor.get(dataset.get(i).getC()-1));
			g.fillArc(dataset.get(i).getX()*10-3, 480-dataset.get(i).getY()*10-3, 6, 6, 0, 360);
		}
		for(int i=0;i<KMeansRunner.k;i++){
			g.setColor(classificationColor.get((chosenPoints[i].getC()-1)));
			int x=chosenPoints[i].getX()*10;
			int y=480-chosenPoints[i].getY()*10;
			int[] xPoints={x,x-6,x+6};
			int[] yPoints={y-6,y+3,y+3};
			g.fillPolygon(xPoints, yPoints, 3);
		}
	}
	
	public static void classify(){
		distances=new double[KMeansRunner.n][KMeansRunner.k];
		for(int i=0;i<KMeansRunner.n;i++){
			for(int j=0;j<KMeansRunner.k;j++){
				double temp=(dataset.get(i).getX()-chosenPoints[j].getX());
				double temp2=(dataset.get(i).getY()-chosenPoints[j].getY());
				Double d=Math.sqrt((temp*temp)+(temp2*temp2));
				distances[i][j]=d;
			}
		}
		for(int i=0;i<KMeansRunner.n;i++){
			double min=distances[i][0];
			int c=1;
			for(int j=0;j<KMeansRunner.k;j++){
				if(min>distances[i][j]){
					min=distances[i][j];
					c=j+1;
				}
			}
			dataset.get(i).setC(c);
		}
	}
}
