import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class DeserializeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = null;
		try{
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("soutput.txt"));
			s = (Student)ois.readObject();
			ois.close();
		}
		catch(Exception e){
			
		}
		System.out.println(s.name+" "+s.age);
	}

}
