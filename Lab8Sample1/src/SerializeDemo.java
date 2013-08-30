import java.io.*;
public class SerializeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.name ="Arian";
		s.age = 59;
		
		try{
			FileOutputStream fileOut = new FileOutputStream("soutput.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fileOut);
			oos.writeObject(s);
			fileOut.close();
		}
		catch(Exception e){
			
		}
	}

}
