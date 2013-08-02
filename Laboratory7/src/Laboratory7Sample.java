import java.util.Scanner;


public class Laboratory7Sample {

	public static void main(String[] args){
		
		System.out.print("Enter Pet name: ");
		Scanner sc =  new Scanner(System.in);
		String name =  sc.nextLine();
		System.out.print("Enter age: ");
		Scanner sc2 = new Scanner(System.in);
		int age = sc2.nextInt();
		Pet p = new Pet(name, age);
		
		System.out.println("Name: "+p.getName()+" Age: "+p.getAge());
		
		System.out.print("Enter Dragon name: ");
		name = sc.nextLine();
		System.out.print("Enter Dragon age: ");
		age = sc2.nextInt();
		System.out.print("Enter Dragon wingspan: ");
		float wingSpan = sc2.nextFloat();
		System.out.print("Enter Dragonbreed: ");
		String breed = sc.nextLine();
		Dragon d = new Dragon(name, age, wingSpan, breed);
		System.out.println("Dragon Name: "+d.getName()+ " Age: "+d.getAge()+" Wingspan: "+d.getWingSpan()+" Breed: "+d.getDragonBreed() );
		d.breatheFire(2000.789f);
		d.eatHuman("Sir Arian");
	}
	
}
