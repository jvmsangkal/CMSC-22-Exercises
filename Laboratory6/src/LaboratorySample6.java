import java.util.Scanner;

import studentExample.StudentDirectory;

public class LaboratorySample6 {

	public static void main(String[] args){
		/*Student s=new Student("Arian");
		System.out.println("Hello "+s.name);
		*//*
		Student.totalStudents=3;
		System.out.println("Number of students is "+Student.totalStudents);
	    */
		StudentDirectory sd = new StudentDirectory(2);
		sd.fillInformation();
		sd.printInformation();
		sd.changeInformation(1);
		int a=5;
		changeValue(a);
		System.out.println("Value is "+a);
		System.out.println("SD value is "+sd.getNumStudents());
		changeValue(sd);
		System.out.println("SD value is "+sd.getNumStudents());
	}
	
	private static void changeValue(int a){
		a=3;
	}
	
	private static void changeValue(StudentDirectory sd){
		sd.setNumStudents(5);
	}
}
