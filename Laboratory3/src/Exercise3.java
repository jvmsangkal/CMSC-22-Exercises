import java.util.Scanner;

public class Exercise3 {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int userInput;
		
		 do{
			 System.out.print("Enter integer [1,10]:");
			 userInput=sc.nextInt();
			 
			 if(userInput<1 || userInput>10){
				 System.out.println("Invalid input.Try again!");
			 }else{
				 System.out.println("1st pattern:");
				 for(int i=userInput;i>0;i--){
					 for(int k=userInput;k>i;k--){
							System.out.print(" ");
						}
					for(int j=userInput-1;j>=userInput-i;j--){
						
						System.out.print(" "+i);
					}
					System.out.println("");
				 }
				 
				 System.out.println("2nd pattern:");
				 
				 for(int i=userInput; i>0; i--){
					 for(int j=userInput-1;j>=userInput-i;j--){
						 System.out.print(" "+i);
					 }
					 if(i!=1){
					 System.out.println("");
					 }
				 }
				 for(int i=0;i<=userInput;i++){
						for(int j=0;j<i;j++){
							System.out.print(" "+i);
							
						}
						System.out.println();
					}
				 
			 }
			 
		 }while(userInput<1 || userInput>10);
		
		
	}
	
}
