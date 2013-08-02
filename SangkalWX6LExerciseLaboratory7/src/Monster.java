
public class Monster extends Character implements MonsterInterface {
	protected boolean isAlive=true;
	
	public Monster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected String kind;
	
	public void setKind (String kind){
		this.kind=kind;
	}
	
	public String getName (){
		return kind;
	}

	@Override
	public void killMario(Hero mario) {
		// TODO Auto-generated method stub
		System.out.println("Die "+ mario.getName() +" Die");
		mario.die();
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println("Noooooooooooooooo!~");
		isAlive=false;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
