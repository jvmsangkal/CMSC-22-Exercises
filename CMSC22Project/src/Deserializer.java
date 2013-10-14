import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Deserializer {

	public static void main(String[] args) {
		ArrayList<Parameter> al= new ArrayList<Parameter>();
		Parameter p = null;
		
		try{
			ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("wx6lparameter.ser"));
			for(int i=0;i<11;i++){
				p=(Parameter)ois.readObject();
				al.add(p);
			}
				
			
			ois.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		try {
			PrintWriter pw = new PrintWriter("parameters.txt");
			for(int i=0;i<al.size();i++){
				pw.println("Label: "+ al.get(i).getLabel());
				pw.println("StringValue: "+al.get(i).getStringValue());
				pw.println("IntValue: "+al.get(i).getIntValue());
				pw.println("DoubleValue: "+al.get(i).getDoubleValue());
				pw.println("---------------------------------");
				}
				pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
