import java.util.Scanner;


public class World {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Name your Hero: ");
		String name = sc.nextLine();
		Hero m = new Hero(name);
		System.out.print("Name your Princess: ");
		name = sc.nextLine();
		Princess p= new Princess(name);
		System.out.println("Name your Main Villain: ");
		name = sc.nextLine();
		MainVillain b = new MainVillain(name);
		
		int choice=0;
		while(choice!=5){
			System.out.println("What will "+ m.getName()+ " do?");
			System.out.println("[1] Kill a monster");
			System.out.println("[2] Get Item");
			System.out.println("[3] Kill "+b.getName());
			System.out.println("[4] Save Princess");
			System.out.println("[5] Give up");
			System.out.println("Choice:");
			choice=sc2.nextInt();
			
			switch(choice){
				case 1: System.out.print("Name the monster: ");
						name=sc.nextLine();
						Monster mamaw=new Monster(name);
						System.out.print(mamaw.getName()+": ");
						mamaw.die();
					break;
				case 2: System.out.print("Name the item(mushroom,flower,star,coin,oneup): ");
						name=sc.nextLine();
						Item q=new Item(name);
						q.getEaten(m);
					break;
				case 3: System.out.print("How would you like to kill him?");
				System.out.print("[1] Jump");
				System.out.print("[2] Fire");
				System.out.print("Attack:");
					int attack= sc.nextInt();
					 switch(attack){
					 case 1:m.Jump();
					 		b.die();
						 break;
					 case 2: m.Fire();
					 		b.die();
						 break
					 }
					break;
				case 4: m.savePrincess(b, p);
					break;
				case 5:System.out.print("Program Terminated.");
					break;
					default:System.out.println("Invalid.");
			}
		}
	}
}
