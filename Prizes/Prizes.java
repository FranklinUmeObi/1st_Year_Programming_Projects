import java.util.Scanner;

public class Prizes {

	public static void main(String[] args) {

		System.out.println("How many cometitors are in the competitition? : ");
		Scanner scan = new Scanner(System.in) ;
		if (scan.hasNextInt())
		{
			int totalCompetitors = scan.nextInt() ;
			int count = 0 ;
			int primeNumber = 0 ;
			String numberEnding = "" ;
			int lastDigit = 0 ;
			int secondLastDigit = 0 ;
			
			System.out.println("Prizes should be given to the competitors"
					+ " who come  1st, 2nd, 3rd, ");
			for (count = 4 ; count <= totalCompetitors ; count++)
			{
				// next line = if a prime number, fix with a for loop
				if (count % 2 != 0 && count % 3 != 0 && count % 5 != 0 && count % 7 != 0 
						&& count % 11 != 0 && count % 13 != 0 && count % 17 != 0 )
				{
					
					primeNumber = count ;
				}
				
				lastDigit = primeNumber % 10 ;
				secondLastDigit = primeNumber % 100 ;
				if (secondLastDigit != 1)
				{
					switch (lastDigit)
					{
					case 1:
					numberEnding = "st" ;
					break ;
					case 2:
						numberEnding = "nd" ;
					break ;
					case 3:
						numberEnding = "rd" ;
					break ;
					default:
						numberEnding = "th" ;
					break ;
					}
					
				}
				
				System.out.print(primeNumber + numberEnding + ", ");
			}
			
		}
		else
		{
			System.out.println("That is not a valid number");
		}
		
		
		
		
		
		

	}

}
