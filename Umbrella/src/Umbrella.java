/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: all variables were easy-to-understand and meaningful
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: all variables were written in lowerCamelCase
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: all code has been indented properly
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 20
       Comment: input was read correctly as appropriate questions were asked
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 
       Comment: an appropriate amount of if statements were used
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 15
       Comment: I output the correct answer for each possibility in an easy to read format
   7. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I answered truthfully and filled it out fully
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner ;
		public class Umbrella {

			public static void main(String[] args) {

				System.out.println("This program will determine if you should bring an umbrella by asking questions,"
						+ "\n please answer true or false :) ");

				System.out.println("Is it currently raining? ");
				Scanner scan = new Scanner(System.in) ;
				Boolean currentlyRaining = scan.nextBoolean() ;
				if (currentlyRaining == true)
				{
					System.out.print("--Bring an umbrella and put it up") ;
				}

				else
				{
					System.out.println("Does it look like it will rain while you are out? ");
					Boolean mightRain = scan.nextBoolean() ;
					if (mightRain == true)
					{
						System.out.print("--Bring an umbrella and put it up if it rains") ;
					}
					
					else
					{
						System.out.print("--There is no need to bring an umbrella when you go out") ;
					}
					
					
				}
			
			
			
	}

}
