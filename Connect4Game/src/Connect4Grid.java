
public interface Connect4Grid 
{

	public void emptyGrid();
	
	public String toString();
	
	public boolean isValidColumn(int column);
	
	public boolean isColumnFull(int column);
	
	public void dropPiece(char playerPiece, int column);
	
	public boolean didLastPieceConnect4();
	
	public boolean isGridFull();   
	
}
