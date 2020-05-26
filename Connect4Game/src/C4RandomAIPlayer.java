
public class C4RandomAIPlayer extends Connect4Player
{
	C4RandomAIPlayer(char piece)
	{
		super(piece) ;
	}
	
	int randomPick()
	{
		int column = (int)(Math.random() * 7 + 1);
		return column ;
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
