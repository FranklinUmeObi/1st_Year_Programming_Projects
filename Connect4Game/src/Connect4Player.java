
public abstract class Connect4Player 
{
	protected char piece ;
	
	Connect4Player(char piece)
	{
		this.piece = piece ;
	}
	
	char getPiece()
	{
		return this.piece ;
	}
	
	abstract void makeMove(Connect4Grid2DArray gridClass, int theChosenColumn) ;
	
}
