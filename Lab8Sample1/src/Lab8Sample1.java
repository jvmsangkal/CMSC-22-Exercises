import java.io.*;
import java.util.*;
public class Lab8Sample1 {

	/**
	 * @param args
	 *//**
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line = br.readLine();
			double avg=0.0;
			int count = 0;
			while(line !=null){
				st=new StringTokenizer(line);
				
				for(int i=0;i<st.countTokens();i++){
					avg+=Double.parseDouble(st.nextToken());
					count++;
				}
				line =br.readLine();
			}
			br.close();
			avg=avg/count;
			System.out.println("Avg: "+avg);
			
			PrintWriter pw = new PrintWriter("output.txt");
			pw.println("Avg: "+avg);
			pw.close();
		}
		catch(Exception e){
			
		}
	}
**/
}
