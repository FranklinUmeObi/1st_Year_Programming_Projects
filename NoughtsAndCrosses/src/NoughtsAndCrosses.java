/*Write a Java program which allows users to play the game “Noughts and Crosses” 
(sometimes called Xs and Os). Users take turns entering crosses (X) and noughts (O)
into a 3 by 3 grid until one player gets three of their pieces in a row OR the board is full.

You must write the following methods:

	/		void clearBoard (char[][] board) which sets all locations on the board 
	/		to the BLANK (' ') character.

void printBoard (char[][] board) which prints the board to the screen.

boolean canMakeMove (char[][] board, int row, int column) which takes a 
board and a location and returns whether a move can be made there.

void makeMove (char[][] board, char currentPlayerPiece , int row, int column)
 which adds a piece (NOUGHT or CROSS) to the board in the specified location.
 
	/		boolean isBoardFull(char[][] board) which indicates whether the board is full.

char winner ( char[][] board) which returns the piece which has won or BLANK if no-one has yet won.

main which gets input (location on the board) from the user until there is a 
winner or the board is full. It calls all of the above methods and when the 
game is over presents the winner.
 
 */
import java.util.Scanner ;

public class NoughtsAndCrosses {
	public static final char[][] BOARD = new char[3] [3] ;

	public static void main(String[] args) 
	{
		try
		{
			
			boolean finished = true ;
			int rowValue ;
			int columnValue ;
			int playerPiece = 1 ;
			//1 = x, -1 = o
			
			clearBoard (BOARD) ;
			System.out.print("Welcome to X's and O's, to play type in the number that "
					+ "refrences the square you want to put your piece\nHere is a reference "
					+ "guide of the board\n[1][2][3]\n[4][5][6]\n[7][8][9]\nPlayer X will go first") ;
			do
			{
				System.out.print("\nWhere do you want to place your piece? input a number from 1-9 : ") ; 
				Scanner scan = new Scanner(System.in) ;
				int newPieceLocation = scan.nextInt() ;
				if(newPieceLocation >=1 && newPieceLocation <= 9 && !isBoardFull(BOARD))
				{
					 switch (newPieceLocation) {
			            case 1: rowValue = 0 ;
			            		columnValue = 0 ;
			                    break;
			            case 2: rowValue = 0 ;
	           		 			columnValue = 1 ;
			                    break;
			            case 3: rowValue = 0 ;
			            		columnValue = 2 ;
			                    break;
			            case 4: rowValue = 1 ;
			            		columnValue = 0 ;
			                    break;
			            case 5: rowValue = 1 ;
	            				columnValue = 1 ;
	            				break;
			            case 6: rowValue = 1 ;
			            		columnValue = 2 ;
			            		break;
			            case 7: rowValue = 2 ;
			            		columnValue = 0 ;
			            			break;
			            case 8: rowValue = 2 ;
	            				columnValue = 1 ;
	            					break;
			            case 9: rowValue = 2 ;
	            				columnValue = 2 ;
	            					break;
			        }
					 
					 
				}
				else if(isBoardFull(BOARD))
				{
					System.out.print("\nThe board is full and there was no winner, Tie Game") ;
					finished = false ;
				}
				else
				{
					System.out.print("\nThat was Invalid Input") ;
					finished = false ;
				}
			}while(finished) ;
		}
		
		catch(Exception invalid)
		{
			System.out.print("That is not a valid number :( ") ;
		}
		

	}
	public static void clearBoard (char[][] board)
	{
		board[0][0]= ' ' ;
		board[0][1]= ' ' ;
		board[0][2]= ' ' ;
		board[1][0]= ' ' ;
		board[1][1]= ' ' ;
		board[1][2]= ' ' ;
		board[2][0]= ' ' ;
		board[2][1]= ' ' ;
		board[2][2]= ' ' ;
	}
	public static void printBoard (char[][] board)
	{
		
	}
	public static boolean canMakeMove (char[][] board, int row, int column)
	{
		
	}
	public static void makeMove (char[][] board, char currentPlayerPiece , int row, int column)
	{
		
	}
	public static boolean isBoardFull(char[][] board)
	{
		if(board[0][0]== ' ' 
		|| board[0][1]== ' ' 
		|| board[0][2]== ' ' 
		|| board[1][0]== ' ' 
		|| board[1][1]== ' ' 
		|| board[1][2]== ' ' 
		|| board[2][0]== ' ' 
		|| board[2][1]== ' ' 
		|| board[2][2]== ' ' )
		{
			return false ;
		}
		else
		{
			return true ;
		}
	}
	public static char winner ( char[][] board)
	{
		
	}
	

}
