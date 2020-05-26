
public class C4HumanPlayer extends Connect4Player
{
	C4HumanPlayer(char piece)
	{
		super(piece) ;
	}
	
	@Override
	char getPiece()
	{
		return this.piece ;
	}
	
	void makeMove(Connect4Grid2DArray gridClass, int theChosenColumn)
	{
		gridClass.dropPiece(piece, theChosenColumn);
		System.out.println(gridClass.toString());
	}
	
	
}
