/* SELF ASSESSMENT

Connect4Game class (35/35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would 
like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the 
Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the 
game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling 
methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: My class does all that it is asked to do

Connect4Grid interface (10/10 marks)
I define all 7 methods within this interface.
Comment: I define all 7 methods within this interface.

Connect4Grid2DArray class (25/25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation 
of the method to check whether the column to drop the piece is valid. It provides as implementation 
of the method to check whether the column to drop the piece is full. It provides as implementation 
of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: I implemented all the methods from this class

ConnectPlayer abstract class (10/10 marks)
My class provides at least one non-abstract method and at least one abstract method. 
Comment: My class provides at least one non-abstract method and at least one abstract method.

C4HumanPlayer class (10/10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class extends the ConnectPlayer class and overrides the abstract method

C4RandomAIPlayer class (10/10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class extends the ConnectPlayer class and overrides the abstract method

Total Marks out of 100: 100

*/


import javax.swing.JOptionPane;
import java.util.Scanner ;

public class Connect4 {

	public static void main(String[] args) 
	{
		char piece1 = 'R';
		char piece2 = 'Y';
		Connect4Grid2DArray theBoard = new Connect4Grid2DArray();
		C4HumanPlayer player1 = new C4HumanPlayer(piece1);
		C4HumanPlayer player2 = null;
		C4RandomAIPlayer ai = null ;
		Scanner scan = new Scanner(System.in) ;
		int gameMode = 0 ;
		boolean finished = false ;

		Object[] possibleChoices = { "Play against another player", "Play against an AI" };
			
		Object selectedOption = JOptionPane.showInputDialog(null, "Pick an OPPONENT", "Pick here",
				JOptionPane.INFORMATION_MESSAGE, null, possibleChoices, possibleChoices[0]);
		
		if (selectedOption == "Play against another player") 
		{
			player2 = new C4HumanPlayer(piece2);
			gameMode = 0 ;
		} 
		else if (selectedOption == "Play against an AI") 
		{
			ai = new C4RandomAIPlayer(piece2) ;
			gameMode = 1 ;
		} 
		
		theBoard.emptyGrid();
		System.out.println(theBoard.toString());
		while(!finished) 
		{
			try {
				
			
			if(theBoard.isGridFull()) 
			{
				System.out.println("It's a draw!");
				break ;
			}
			System.out.println("Player 1  pick a column or type quit : ");
			if(scan.hasNext("quit")) break ;
			int pickedColumn = scan.nextInt() ;
			player1.makeMove(theBoard, pickedColumn);
			if(theBoard.didLastPieceConnect4()) 
			{
				System.out.println("Player 1 wins!!!");
				break ;
			}
			
			if(gameMode == 0)
			{
				System.out.println("Player 2  pick a column or type quit : ");
				if(scan.hasNext("quit")) break ;
				pickedColumn = scan.nextInt() ;
				player2.makeMove(theBoard, pickedColumn);
				if(theBoard.didLastPieceConnect4()) 
				{
					System.out.println("Player 2 wins!!!");
					break ;
				}
			}
			else
			{
				System.out.println("AI picked a column");
				pickedColumn = ai.randomPick() ;
				ai.makeMove(theBoard, pickedColumn);
				if(theBoard.didLastPieceConnect4()) 
				{
					System.out.println("Player 2 wins!!!");
					break ;
				}
			}
		}catch(Exception Miss)
		{
			if(gameMode == 1) System.out.println("You missed the board, try again");
			else System.out.println("The board was missed, Player 1 will now");
			
		}
	}
}
}
