
public class Connect4Grid2DArray implements Connect4Grid

{
	protected char board[][] ;
	
	Connect4Grid2DArray()
	{
		board = new char[6][7];
	}
	
	public void emptyGrid() 
	{
		int col = 0 ;
		int row = 0 ;
		for(row = 0 ; row < 6 ; row++)
		{
			for(col = 0 ; col < 7 ; col++)
			{
				board[row][col] = 'O' ;
			}
			col = 0 ;
		}
	}
	
	@Override
	public String toString()
	{
		int col = 0 ;
		int row = 0 ;
		String theBoard = "-1--2--3--4--5--6--7-\n" ;
		for(row = 0 ; row < 6 ; row++)
		{
			for(col = 0 ; col < 7 ; col++)
			{
				theBoard += "|" ;
				theBoard += board[row][col] ;
				theBoard += "|" ;
			}
			col = 0 ;
			theBoard += "\n" ;
		}
		return theBoard ;
	}
	
	public boolean isValidColumn(int column)
	{
		if(column <= 7) return true ;
		else return false ;
	}
	
	public boolean isColumnFull(int column)
	{
		if(board[0][column-1] != 'O') return true ;
		else return false ;
	}
	
	public void dropPiece(char playerPiece, int column)
	{
		if(!isColumnFull(column) && isValidColumn(column))
		{
			boolean piecePlaced = false ;
			
			while(!piecePlaced) 
			{
				for(int row = 5 ; row > -1 ; row--)
				{
					if(board[row][column-1] == 'O')
					{
						board[row][column-1] = playerPiece ;
						piecePlaced = true ;
						break ;
					}
				}
			}
		}
		else
		{
			System.out.println("That wasnt a valid move");
		}
	}
	
	public boolean didLastPieceConnect4()
	{
		//Check if there is a horizontal win
		int row = 0;
        while(row < 6)
        {
            int column = 0;
            while(column < 4)
            {
                if(board[row][column  ] == 'R'
                && board[row][column+1] == 'R' 
                && board[row][column+2] == 'R'
                && board[row][column+3] == 'R'
                ) return true;
                else if(board[row][column  ] == 'Y'
                && board[row][column+1] == 'Y' 
                && board[row][column+2] == 'Y'
                && board[row][column+3] == 'Y'
                ) return true;
  
                column++ ;;
            }
            row = row + 1;
        }
        
        //Check if there is a vertical win
        row = 0;
        while(row < 3)
        {
            int column = 0;
            while(column < 7)
            {
                if(board[row  ][column] == 'R' 
                && board[row+1][column] == 'R'  
                && board[row+2][column] == 'R' 
                && board[row+3][column] == 'R' 
                ) return true;
                else if(board[row  ][column] == 'Y' 
                && board[row+1][column] == 'Y'  
                && board[row+2][column] == 'Y' 
                && board[row+3][column] == 'Y' 
                ) return true;
                column = column + 1;
            }
            row = row + 1;
        }
        
      //Check if there is a diagonal1 win
        row = 0;
        while(row < 3)
        {
            int column = 0;
            while(column < 2)
            {
                if(board[row  ][column+3] == 'R'
                && board[row+1][column+2] == 'R'
                && board[row+2][column+1] == 'R'
                && board[row+3][column  ] == 'R'
                ) return true;
                else if(board[row  ][column+3] == 'Y'
                && board[row+1][column+2] == 'Y'
                && board[row+2][column+1] == 'Y'
                && board[row+3][column  ] == 'Y'
                ) return true;
                column = column + 1;
            }
            row = row + 1;
        }
        
      //Check if there is a diagonal2 win
        row = 0;
        while(row < 3)
        {
            int column = 0;
            while(column < 2)
            {
                if(board[row][column] == 'R' 
                && board[row+1][column+1] == 'R' 
                && board[row+2][column+2] == 'R'
                && board[row+3][column+3] == 'R'
                ) return true;
                else if(board[row][column] == 'Y' 
                && board[row+1][column+1] == 'Y' 
                && board[row+2][column+2] == 'Y'
                && board[row+3][column+3] == 'Y'
                ) return true;
                column = column + 1;
            }
            row = row + 1;
        }
        return false;
	}
	
	public boolean isGridFull()
	{
		boolean spaceFree = false ;
		for(int row = 0 ; row < 6 ; row++)
		{
			for(int col = 0 ; col < 7 ; col++)
			{
				if(board[row][col] == 'O') spaceFree = true ;
			}
		}
		return !spaceFree ;
	}
	
	
	
	
	
	
	
	
}
