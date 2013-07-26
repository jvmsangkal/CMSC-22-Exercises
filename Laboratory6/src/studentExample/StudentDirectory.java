package studentExample;
import java.util.Scanner;


public class StudentDirectory {
	private Student[] students;
	private int numStudents;
	public StudentDirectory(int numStudents){
		students=new Student[numStudents];
		this.numStudents = students.length;
	}
	
	public void fillInformation(){
		for(int i=0;i<students.length;i++){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter name for student "+(i+1)+":");
			students[i]=new Student(sc.nextLine());
		}
		
	}
	
	public void printInformation(){
		/*for(Student x: students){
			System.out.println(x.getName());
		}*/
		for(int i=0;i<students.length;i++){
			System.out.println(students[i].getName());
		}
	}
	
	public void changeInformation(int index){
		String temp =students[index].getName();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter new name: ");
		students[index].setName(sc.nextLine());
		System.out.println("Changed "+temp+" to "+students[index].getName());
		
	}
	public void changeInformation(int index,String name){
		String temp =students[index].getName();;
		students[index].setName(name);
		System.out.println("Changed "+temp+" to "+students[index].getName());
		
	}
	
	public Student[] getStudents(){
		return this.students;
	}
	
	public void setNumStudents(int num){
		this.numStudents = num;
	}
	
	public int getNumStudents(){
		return this.numStudents;
	}
	
}
