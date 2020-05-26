/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:5          Comment: I used proper variable names

 2. Did I indent the code appropriately?

        Mark out of 5:5         Comment: It is indented correctly

 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20          Comment: I used both functions and wrote them correctly

 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20          Comment: I wrote the function correctly

 5. Did I calculate and/or check triangle numbers correctly?

       Mark out of 15:15          Comment: i checked that the function output triangle numbers 
       									   correctly before implementing it in my final code

 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?

       Mark out of 10:10          Comment: i used the given constant of Integer.MAX_VALUE as a way to stop loops

 7. Does my program compute and print all the correct triangular star numbers?

       Mark out of 20:20        Comment: the program pints the 5 possible triangular star numbers possible within the max int 

 8. How well did I complete this self-assessment?

        Mark out of 5:5        Comment: i did a good job

 Total Mark out of 100 (Add all the previous marks):100

*/ 
public class StarNumbers {

	public static void main(String[] args) 
	{
		int number = 0 ;
		int triangleNumber = 0 ;
		System.out.print("Numbers that are both Star numbers and Triangle numbers are ");
		
		do
		{
			triangleNumber = determineTriangleNumber(number, triangleNumber) ;
			++number ;
			if (isStarNumber(triangleNumber))
			{
				System.out.print(triangleNumber + ", ");
			}
			
		}while(triangleNumber >= 0) ;
	}

	public static boolean isStarNumber(int ifStarNumber) {
		int starNumber = 1;
		for(int count = 1 ; (starNumber >= 1 ) && (starNumber < Integer.MAX_VALUE) ; count++)
		{
			starNumber = ((6 * count) * (count - 1) + 1) ;
			if(ifStarNumber == starNumber)
			{
				return true ;
			}
			
		}
		return false ;
	}
	public static boolean isTriangleNumber(int number) {
		int index = 0 ;
		int triangleNumber = 0 ;
		boolean triangleNumberFound = false ;
		do 
		{
			triangleNumberFound = false ;
			triangleNumber += index ;
			index++;

			if (triangleNumber == number)
			{
				return true ;
			}
			
		} while (triangleNumber < Integer.MAX_VALUE && triangleNumber >=1);
			return (triangleNumberFound) ;
		
	}
	public static int determineStarNumber(int number) {
		int starNumber = 0;
		starNumber = 6 * number * (number - 1) + 1;
		return starNumber;
	}
	public static int determineTriangleNumber(int number, int triangleNumber)
	{
		int nextTriangleNumber = triangleNumber + number ;
		return nextTriangleNumber ;
	}
}

