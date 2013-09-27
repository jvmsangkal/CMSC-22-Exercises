
public class Caller implements Runnable{

	private String msg;
	private Callee target;
	private Thread t;
	int i;
	public Caller(String msg, Callee target) {
		super();
		this.msg = msg;
		this.target = target;
		i=0;
		t=new Thread(this);
		t.start();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Callee getTarget() {
		return target;
	}
	public void setTarget(Callee target) {
		this.target = target;
	}
	public Thread getT() {
		return t;
	}
	public void setT(Thread t) {
		this.t = t;
	}
	
	public void run() {
		/**while(true){
			try {
				Thread.sleep(1000);
				System.out.println(""+i);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//synchronized(target){
		target.showMessage(msg);
	
		//}
	}
}
