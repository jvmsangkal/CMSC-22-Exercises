
public class Hero extends Character implements HeroInterface{
	private String powerup;
	private int lives=5;
	private int score=0;
	private int coins=0;
	
	public Hero(String name){
		super(name);
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	@Override
	public void Jump() {
		System.out.println("boing..");
		
	}

	@Override
	public void KillMonster(Monster m) {
		// TODO Auto-generated method stub
		m.die();
		m.setAlive(false);
	}

	@Override
	public void Run() {
		// TODO Auto-generated method stub
		System.out.println("I'm running.");
	}

	@Override
	public void Fire() {
		// TODO Auto-generated method stub
		if(powerup.equals("flower")){
			System.out.println("bang bang bang");
		}else{
			System.out.println("Nothing Happens");
		}
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		lives--;
		System.out.println("Hero: "+ name+ "  Lives: x"+lives);
	}

	@Override
	public void savePrincess(MainVillain b,Princess p) {
		// TODO Auto-generated method stub
		if(b.isAlive()){
			p.scream(name);
			System.out.println("Kill Villain First.");
		}else{
			p.getSaved(name);
		};
	}

	public String getPowerup() {
		return powerup;
	}

	public void setPowerup(String powerup) {
		this.powerup = powerup;
	}

}
