import java.util.Scanner;


public class ArithmeticSample {

	public static void main(String params[]){
			Scanner sc=new Scanner(System.in);
			float grade=sc.nextFloat();
			if(grade<96){
				System.out.println("Less than 1.0");
				
			}
			if(grade>91 && grade<=96){
				System.out.println("Less than 1.0 but equal to 1.25");
				
			}
	}
}
