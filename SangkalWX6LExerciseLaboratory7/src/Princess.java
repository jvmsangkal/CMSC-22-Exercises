
public class Princess extends Character{

	private boolean isSaved=false;
	
	public Princess(String name){
		super(name);
	}

	public void scream(String hero){
		System.out.println("Help me "+ hero);
	}
	public void getSaved(String hero){
		System.out.println("Thank you "+ hero+"!:*");
	}
	
	public boolean isSaved() {
		return isSaved;
	}

	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}
}
