
public class Callee {

	public synchronized void showMessage(String msg){
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("]\n");
	}
}
