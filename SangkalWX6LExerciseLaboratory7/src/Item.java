
public class Item {
	protected String name;
	
	public Item(String name){
		this.name=name;
	}
	
	public void getEaten(Hero m){
		m.setPowerup(name);
		if(name.equals("mushroom")){
			System.out.println(m.getName()+" is now bigger.");
			}
		if(name.equals("flower")){
			System.out.println(m.getName()+" can fire.");
			}
		if(name.equals("star")){
			System.out.println(m.getName()+" is invulnerable.");
			}
		if(name.equals("one-up")){
			System.out.println(m.getName()+" has increased life.");
			m.setLives(m.getLives()+1);
			}
		if(name.equals("coin")){
			System.out.println(m.getName()+" gained coin.");
			m.setCoins(m.getCoins()+1);
			}
	}
}
