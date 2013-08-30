import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Deserialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> al=new ArrayList<Person>();
		Person p =null;
		
		try{
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("serinput.ser"));
			for(int i=0;i<4;i++){
		    p = (Person)ois.readObject();
		    al.add(p);
			}
			ois.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		try{
		PrintWriter pw = new PrintWriter("output.txt");
		for(int i=0;i<al.size();i++){
		pw.println("Name: "+al.get(i).getName());
		pw.println("Alias: "+al.get(i).getAlias());
		pw.println("Age: "+al.get(i).getAge());
		pw.println("Height: "+al.get(i).getHeight());
		pw.println("---------------------------------");
		}
		pw.close();
		}
		catch(Exception e){
			
		}
	}

}
