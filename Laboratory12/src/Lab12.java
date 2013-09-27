
public class Lab12 {
	
	public static void main(String[] args){
		Callee target=new Callee();
		Caller c1=new Caller("Hi!", target);
		Caller c2 =  new Caller ("Easy",target);
		Caller c3 =  new Caller ("Synch!",target);
		try{
			c1.getT().join();
			c2.getT().join();
			c3.getT().join();
		}catch(Exception e){
			System.out.println("Interrupted.");
			
		}
		
	}
	
}
