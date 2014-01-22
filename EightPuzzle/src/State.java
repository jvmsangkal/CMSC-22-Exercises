//Subject CMSC 170 U-4L Exer2
public class State {

	private State prevState;
	private int[][] currState=new int[3][3];
	private int f;
	private int g=0;
	private int h;
	
	public State(){
		
	}
	
	public State getPrevState() {
		return prevState;
	}
	public void setPrevState(State prevState) {
		this.prevState = prevState;
	}
	public int[][] getCurrState() {
		return currState;
	}
	public void setCurrState(int[][] currState) {
		this.currState = currState;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	public void computeG(){
		this.g=this.prevState.getG()+1;	
	}
	
	public void computeH(){
		int[] goalPositionX={2,0,1,2,0,1,2,0,1};
		int[] goalPositionY={2,0,0,0,1,1,1,2,2};
		int[] positionX=new int[9];
		int[] positionY=new int [9];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				positionX[this.currState[i][j]]=j;
				positionY[this.currState[i][j]]=i;
			}
		}
		this.h=0;
		for(int i=0;i<9;i++){
			this.h=this.h+Math.abs(goalPositionX[i]-positionX[i])+Math.abs(goalPositionY[i]-positionY[i]);
		}
	}
	
	public void computeF(){
		this.f= this.g+this.h;
	}
	
}
