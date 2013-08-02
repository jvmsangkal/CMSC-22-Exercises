
public class Dragon extends Pet implements DragonInterface{

	private float wingSpan;
	private String dragonBreed;
	
	public Dragon(String name, int age, float wingSpan, String dragonBreed){
		super(name, age);
		this.setWingSpan(wingSpan);
		this.setDragonBreed(dragonBreed);
	}

	public String getDragonBreed() {
		return dragonBreed;
	}

	public void setDragonBreed(String dragonBreed) {
		this.dragonBreed = dragonBreed;
	}

	public float getWingSpan() {
		return wingSpan;
	}

	public void setWingSpan(float wingSpan) {
		this.wingSpan = wingSpan;
	}

	@Override
	public void breatheFire(float temp) {
		// TODO Auto-generated method stub
		System.out.println("Breathing fire at this temperature "+temp+"C.");
	}

	@Override
	public void eatHuman(String personName) {
		// TODO Auto-generated method stub
		System.out.println("Eating " + personName);
		
	}
	
}
