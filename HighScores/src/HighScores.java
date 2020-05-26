/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:5, Yes i did  

 2. Did I indent the code appropriately?

        Mark out of 5:5, Yes i did  

 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:15, Yes i did   

 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:15, Yes i did   

 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:15, Yes i did   

 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20, Yes i did   

 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

       Mark out of 20:20, Yes i did   

 8. How well did I complete this self-assessment?

        Mark out of 5:5, I completed it really well

 Total Mark out of 100 (Add all the previous marks):100

*/ 
import java.util.Scanner ;
public class HighScores {

	public static void main(String[] args) {
	
	System.out.print("Welcome to the highscore leaderboard, \nhow many "
			+ "scores would you like the scoreboard to store? : ");
	Scanner scan = new Scanner(System.in) ;
	int numberOfScores = scan.nextInt() ;
	int[] scoreboard = new int[numberOfScores] ;
	scoreboard = initialiseHighScores(scoreboard).clone() ;
	printHighScores(scoreboard) ;
	do
	{
		try
		{
			System.out.print("\nPlease enter a score to be added to the scoreboard : ") ;
			int inputScore = scan.nextInt() ;
			printHighScores(insertScore(scoreboard, inputScore)) ;
		}
		catch(Exception invalid)
		{
			System.out.print("That is not a valid score :( try again ") ;
			scan.nextLine();
			
		}
	}while (true) ;
	
	}
	public static int[] initialiseHighScores (int[] scoreboard)
	{
		for( int count = 0 ; count < scoreboard.length ; count ++ )
		{
			scoreboard[count] = 0 ;
		}
		return scoreboard ;
	}
	public static void printHighScores(int[] scoreboard)
	{
		System.out.print("This is the current highscore scoreboard : ") ;
		
		for( int count = 0 ; count < scoreboard.length ; count ++ )
		{
			
			System.out.print(scoreboard[count] + ", ") ;
		}
	}
	public static boolean higherThan(int[] scoreboard, int inputScore)
	{
		boolean higherScoreFound = false ;
		for( int count = 0 ; count < scoreboard.length ; count ++ )
		{
			if(inputScore > scoreboard[count])
			{
				higherScoreFound = true ;
			}
		}
		return higherScoreFound ;
	}
	public static int[] insertScore(int[] scoreboard, int inputScore)
	{
		if(higherThan(scoreboard, inputScore))
		{
			for( int count = 0 ; count < scoreboard.length ; count ++ )
			{
				if(inputScore > scoreboard[count])
				{
					int scoreToMoveDown = scoreboard[count] ;
					scoreboard[count] = inputScore ;
					inputScore = scoreToMoveDown ;
				}
			}
			return scoreboard ;
		}
		else
		{
			return scoreboard ;
		}
	}
}
