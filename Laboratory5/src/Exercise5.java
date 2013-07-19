import java.util.Scanner;

public class Exercise5 {
	
	public static void main(String args[]){
		String name;
		int age=0;
		int month=0;
		int day=0;
		int year=0;
		String job;
		float salary;
        boolean isValid=false;
		Scanner sc= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);
		System.out.print("How many pet owners:");
		PetOwner.numGlobalPetOwners=sc.nextInt();
		PetOwner[] pos=new PetOwner[PetOwner.numGlobalPetOwners];
		for(int i=0;i<PetOwner.numGlobalPetOwners;i++){
			System.out.println("Pet Owner "+(i+1));
			System.out.print(" name:");
			name=sc2.nextLine();
			while(isValid==false){
				System.out.print(" age:");
				age=sc.nextInt();
					if(age>0){
					isValid=true;
					}else{
						System.out.println(" Invalid.");
					}
				}
				isValid=false;
			while(isValid==false){
			System.out.print(" Birthmonth:");
			month=sc.nextInt();
				if(month>0 && month<13){
				isValid=true;
				}else{
					System.out.println(" Invalid.");
				}
			}
			isValid=false;
			while(isValid==false){
				System.out.print(" Birthdate:");
				day=sc.nextInt();
					if(day>0 && day<32){
					isValid=true;
					}else{
						System.out.println(" Invalid.");
					}
				}
			isValid=false;
			while(isValid==false){
				System.out.print(" Birthyear:");
				year=sc.nextInt();
					if(year<2014){
					isValid=true;
					}else{
						System.out.println(" Invalid.");
					}
				}
			isValid=false;
			System.out.print(" Job:");
			job=sc2.nextLine();
			System.out.print(" Salary:");
			salary=sc.nextFloat();
			pos[i]=new PetOwner(name,age,month,day,year,job,salary);
			
		}
		System.out.println("\n\n");
		for(int i=0;i<PetOwner.numGlobalPetOwners;i++){
			System.out.println("------------------------------");
			System.out.println("Pet Owner "+(i+1));
			pos[i].getDetails();
		}
		System.out.println("Program terminated.");
	}
}
