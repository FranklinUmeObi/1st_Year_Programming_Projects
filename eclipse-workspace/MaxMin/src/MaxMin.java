import java.util.Scanner ;
public class MaxMin {

	public static void main(String[] args) {

		System.out.print("Please input a list of numbers,  " 
				+  "no commas are needed, eg. 1 2 3  :") ;
		Scanner scan = new Scanner(System.in) ;
		
		if (scan.hasNextInt())
		{
			System.out.println("For the list of numbers");
			int MaxNumber = 0 ;
			int MinNumber = 0 ;
			while (scan.hasNextInt())
			{
				
			
			int inputNumber = scan.nextInt() ;
		//	int inputNumber2 = scan.nextInt() ;
		//	int inputNumber3 = scan.nextInt() ;
		//	int inputNumber4 = scan.nextInt() ;
		//	int inputNumber5 = scan.nextInt() ;
		//	int inputNumber6 = scan.nextInt() ;
			
			System.out.print(inputNumber + ", ");
			int maxnumber = 0 ;
			if (maxnumber < inputNumber) 
			{
				int maxNumber = inputNumber ;
			}
		//	System.out.print(Maxnumber);
			
			
				if (!scan.hasNextInt() )
				{
				
				}
			
			
			}
			
		}

		
		
		
		
		
		
		
		
	}

}
