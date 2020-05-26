/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment: I used appropriate CONSTANTS instead of numbers
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: I used easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment:  I used easy-to-understand meaningful variable names
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment:  I formated the variable names properly (in lowerCamelCase)
   5. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment:  I indented the code appropriately
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20: 20 
       Comment:  I use an appropriate loop to allow the user to enter their guesses until they win or lose
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment:  I checked the input to ensure that invalid input was handled appropriately
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment:  I generated the cards properly using random number generation
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment:  I outputed the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment:  I reported whether the user won or lost the game before the program finished
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment:  I completed this self-assessment properly
   Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Random;
import java.util.Scanner;

public class HigherLower {

	public static final int WIN_CONDITION = 4;
	public static final int NUMBER_OF_CARDS = 13;

	public static void main(String[] args) {

		Random generator = new Random();
		boolean finished = false;
		int count = 0;
		int randomCard = generator.nextInt(NUMBER_OF_CARDS) + 2;
			
		do 
		{
			Scanner scan = new Scanner(System.in);
			int newRandomCard = generator.nextInt(NUMBER_OF_CARDS) + 2;
			System.out.println("You have currently guessed " + count + " out of 4 ");
				
			if (randomCard == 11) 
			{
				System.out.println("The card is a jack");
			} 
			else if (randomCard == 12) 
			{
				System.out.println("The card is a queen");
			} 
			else if (randomCard == 13) 
			{
				System.out.println("The card is a king");
			} 
			else if (randomCard == 14) 
			{
				System.out.println("The card is an ace");
			} 
			else 
			{
				System.out.println("The card is a " + randomCard);
			}

			System.out.println("Do you think the next card will be higher, "
					+ "lower or equal? : ");

			if (scan.hasNext("higher")) 
			{
				if (newRandomCard > randomCard) 
				{
					count += 1;
					System.out.println("Correct");
					randomCard = newRandomCard;
				} 
				else 
				{
					System.out.println("Incorrect, lets try again with a "
							+ "new random card and using the same starting card.");
					count = 0;
				}
			}

			else if (scan.hasNext("lower")) 
			{
				if (newRandomCard < randomCard) 
				{
					count += 1;
					System.out.println("Correct");
					randomCard = newRandomCard;
				} 
				else 
				{
					count = 0;
					System.out.println("Incorrect, lets try again with a "
							+ "new random card and using the same starting card.");
				}
			}

			else if (scan.hasNext("equal")) 
			{
				if (newRandomCard == randomCard) 
				{
					count += 1;
					System.out.println("Correct");
					randomCard = newRandomCard;
				} 
				else 
				{
					System.out.println("Incorrect, lets try again with a "
							+ "new random card and using the same starting card.");
					count = 0;
				}
			}

			else 
			{
				System.out.println("That was an invalid answer please restart");
				count = 0;
			}
			
			if (count == WIN_CONDITION) 
			{
				System.out.print("Congratulations you have won the game!.");
				finished = true;
			}
				
		} while (!finished);

	}

}