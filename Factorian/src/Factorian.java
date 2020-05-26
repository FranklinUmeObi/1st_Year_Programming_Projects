import java.util.Scanner ;
public class Factorian {

	public static void main(String[] args) {

		System.out.print("What number would you like to see is a factorian number? :");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt() ;
		if(isFactorian(number))
		{
			System.out.print("The number " + number + " is a Factorian Number");
		}
		else
		{
			System.out.print("The number " + number + " is not a Factorian Number");
		}
		
		

	}
	public static int computeFactorial(int n) 
	{
		int numberFactorial = 0 ;
		do
		{
		numberFactorial = n * computeFactorial(n -1) ;
		}while(n != 0) ;
		
		return numberFactorial ;
		
	}
	
	public static boolean isFactorian(int number)
	{
		int numberOfDigits = 0 ;
		int remainingNumber = number ;
		do
		{
			remainingNumber = remainingNumber  / 10 ;
			numberOfDigits++ ;
		}while(remainingNumber != 0) ;
		
		switch(numberOfDigits)
		{
		case 1:
			int sumOfFactorials = computeFactorial(number);
		return (sumOfFactorials == number) ;
		case 2:
			int firstDigit = number / 10 ;
			int secondDigit = number % 10 ;
			sumOfFactorials = computeFactorial(firstDigit) + computeFactorial(secondDigit) ;
		
		
		
		
		
		
		
		}
		return (sumOfFactorials == number) ;
		
		
		
	}
}
