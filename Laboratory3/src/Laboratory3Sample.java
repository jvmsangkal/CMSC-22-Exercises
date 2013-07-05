import java.util.Scanner;


public class Laboratory3Sample {

	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		/**int caseInput= sc.nextInt();
		
		switch(caseInput){
			case 0: System.out.println("First Case");
					break;
			case 1: System.out.println("Second Case");
					break;
			default: System.out.println("Invalid Case");
					break;
		
		}*/
		
		/**int userInput=0;
		
		while(userInput!=1){
			System.out.println("Enter a number besides 1:");
			userInput =sc.nextInt();
			if (userInput!=1){
				System.out.println("Not 1,Looping...");		
			}else{
				System.out.println("Received 1,Exiting...");
			}
		}*/
		
		/**int counter=0;
		
		do{
			System.out.println("Printing "+counter);
			counter++;
		}while(counter<=10);*/
		
		//int counter=0;
		/**for(int counter=0;counter<10;counter++){
			System.out.println("Printing "+counter);
			
		}*/
		
		/**float userInput=1;
		
		while(userInput!=0){
			System.out.print("Enter Grade:");
			userInput=sc.nextFloat();
			
			if(userInput>60.0){
				if(userInput>=60 && userInput <=65){
					System.out.println("Grade is 3.0 \n\n");
				}
				if(userInput>=60 && userInput <70){
					System.out.println("Grade is 2.75 \n\n");
				}
			}
		}*/
		
		/**for(int i=0;i<=5;i++){
			for(int j=0;j<i;j++){
				System.out.print(i);
				
			}
			System.out.println();
		}*/
		
		/**String name =null;
		
		try{
			if(name.equals("Ali")){
				System.out.println("You're Ali!!");
				
			}
			
		}catch(Exception e){
			System.out.println("There was an error!");
		}
		
		System.out.println("Tried printing name.");*/
		
		
		try{
			int testNumber=12/0;
			
		}catch(Exception e){
			System.out.println("There was an error!");
		}
	}
}