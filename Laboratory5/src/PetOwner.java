
//int[] a;
//a=new int[5]
public class PetOwner {
 public static int numGlobalPetOwners;
 public String name;
 public int age;
 public int[] birthday=new int[3];
 public String job;
 public float salary;
 
 public PetOwner(String name, int age, int month,int day, int year,String job,float salary){
	 this.name=name;
	 this.age=age;
	 birthday[0]=month;
	 birthday[1]=day;
	 birthday[2]=year;
	 this.job=job;
	 this.salary=salary;
 }
 
 public void getDetails(){
	 System.out.println(" name: "+this.name);
	 System.out.println(" age: "+this.age);
	 System.out.println(" birthday: "+birthday[0]+"/"+birthday[1]+"/"+birthday[2]);
	 System.out.println(" job: "+job);
	 System.out.println(" salary: "+salary);
 }
 public void buyPet(){
	 
 }
 
}
