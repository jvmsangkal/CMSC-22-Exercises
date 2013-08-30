import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Serialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st;
		ArrayList<Person> al= new ArrayList<>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line = br.readLine();
			while(line !=null){
				st=new StringTokenizer(line,";");
				String name=st.nextToken()+" "+st.nextToken();
				String alias=st.nextToken();
				int age=Integer.parseInt(st.nextToken());
				String height=st.nextToken()+" "+st.nextToken();
				Person p= new Person(name, alias, age, height);
				al.add(p);
				Person.count++;
				line =br.readLine();
			}
			br.close();
			
		}
		catch(Exception e){
			
		}
		
		try{
			FileOutputStream fileOut = new FileOutputStream("serinput.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			for(int i=0;i<Person.count;i++){
			oos.writeObject(al.get(i));
			}
			fileOut.close();
		}
		catch(Exception e){
			
		}
		
		
	}
}
