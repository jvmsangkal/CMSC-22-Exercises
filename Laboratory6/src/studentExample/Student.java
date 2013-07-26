package studentExample;

public class Student {
    private static int totalStudents;
    private String name;
    private String student_number;
    private int age;
    private String degree;
	
	public Student(){
		
	}
	
	public Student(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
