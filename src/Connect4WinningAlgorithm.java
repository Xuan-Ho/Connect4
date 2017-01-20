
public class Connect4WinningAlgorithm {
	
	private int dimension;//dimension of gameboard
	private int [][] playerArray;//gameboard
	private int numWin;//number of connections to win
	private final int PLAYER_ONE=1;//player 1 key number
	private final int PLAYER_TWO=2;//player 2 key number
	
	
	/**
	 * constructs Connect4WinningAlgorithm
	 * @param dimension
	 * @param numToWin
	 */
	public Connect4WinningAlgorithm(int dimension, int numToWin)
	{
		this.dimension = dimension;
		this.numWin=numToWin;
		this.playerArray = new int[dimension][dimension];
		
		
		//fills the 2D array
		for(int i=0; i<dimension;i++)
		{
			for(int x=0; x<dimension;x++)
			{
				playerArray[i][x]=0;
			}
		}
	}
	
	
	/**
	 * adds a circle to the game
	 * @param player true for player 1, false for player 2
	 * @param index of where the circle will be added
	 * @return true if player wins, false if player doesn't win
	 */
	public boolean addCircle(boolean player, int index )
	{
		int row=index/dimension;//finds row
		int column = index%dimension;//finds column
		
		
		if(player)
		{
			return winner(PLAYER_ONE, index, row, column);
		}
		else
		{
			return winner(PLAYER_TWO, index, row, column);
		}
		
		
	}
	
	
	/**
	 * calculates if the player wins
	 * @param playerKeyNumber the number key that belongs to player, 1 for player1, 2 for player 2
	 * @param index in which the circle is been added
	 * @param row row in which the circle falls
	 * @param column in which the circle falls
	 * @return true if player wins, false if player doesn't win
	 */
	private boolean winner(int playerKeyNumber, int index, int row, int column)
	{
		playerArray[row][column]= playerKeyNumber;// adds the playerkeynumber to the 2D array
		
		if(leftToRight(playerKeyNumber, index, row, column))//checks for horizontal connection
		{
			return true;
		}
		else if(topToBottom(playerKeyNumber, index, row, column))//check for vertical connection
		{
			return true;
		}
		else if(southWestToNorthEast(playerKeyNumber, index, row, column))//checks for northEast diagonal connection
		{
			return true;
		}
		else if(northWestToSouthEast(playerKeyNumber, index, row, column))//checks for southEast diagonal connection
		{
			return true;
		}
		
		
		
		return false;//if there's no connection
	
	}
	
	
	/**
	 * checks for left to right, horizontal connection
	 * @param playerKeyNumber 1 for player 1, 2 for player 2
	 * @param index int where players circle will fall
	 * @param row int of row where player's circle falls
	 * @param column int of column where player's circle will fall
	 * @return true if there's a horizontal connection, false if there's not
	 */
	private boolean leftToRight(int playerKeyNumber, int index, int row, int column)
	{
		int counter=1;//counts connection
		
		//checks for left side
		for(int i =column; i>0; i--){
			if(playerKeyNumber== playerArray[row][i-1])//it matches the player's key number
			{
				
				counter++;
			}
			else
			{
				break;
			}
		}
		// checks for right side
		for(int i = column; i<dimension-1; i++)
		{
			if(playerKeyNumber == playerArray[row][i+1])//if it matches the player's key number
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		
		if(counter>=numWin)// if the connection is enough to win
		{

			return true;
		}
		return false;//returns false if no winner
	}
	
	
	/**
	 * checks for vertical connection
	 * @param playerKeyNumber 1 for player 1, 2 for player 2
	 * @param index int where players circle will fall
	 * @param row int of row where player's circle falls
	 * @param column int of column where player's circle will fall
	 * @return true if the player wins, false if the player doesn't wins
	 */
	private boolean topToBottom(int playerKeyNumber, int index, int row, int column)
	{
		int counter=1;// counts connections
		
		for(int i=row; i<dimension-1; i++)// checkc for vertical connection
		{
			if(playerKeyNumber==playerArray[i+1][column])// if it matches players key number
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		
		if(counter>=numWin)//if ther's a connection enough to win
		{

			return true;
		}
		return false;//if no winner yet
	}
	
	
	/**
	 * checks if there is a connection northEast diagonally
	 * @param playerKeyNumber 1 for player 1, 2 for player 2
	 * @param index int where players circle will fall
	 * @param row int of row where player's circle falls
	 * @param column int of column where player's circle will fall
	 * @return false if no connection, true if connection
	 */
	private boolean southWestToNorthEast(int playerKeyNumber, int index, int row, int column)
	{
		int counter=1;//counts the connections
		
		// checks for northwest
		for(int i =1; row-i>=0 && column-i>=0; i++)
		{
			if(playerKeyNumber== playerArray[row-i][column-i])//if it matches player's key number
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		// checks for south east
		for(int i =1; i+row<=dimension-1 && i+column<=dimension-1;i++)//if it matches player's key number
		{
			if (playerKeyNumber==playerArray[row+i][column+i])
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		
		if(counter>=numWin)//if it has enough to win
		{

			return true;
		}
		return false;// if the player doesn't win
	}
	
	
	
	/**
	 * checks for south east connection
	 * @param playerKeyNumber 1 for player 1, 2 for player 2
	 * @param index int where players circle will fall
	 * @param row int of row where player's circle falls
	 * @param column int of column where player's circle will fall
	 * @return
	 */
	private boolean northWestToSouthEast(int playerKeyNumber, int index, int row, int column)
	{
		int counter=1;
		
		//checks for south east
		for(int i =1; row-i>=0 && i+column<=dimension-1;i++)//if it matches player's key number
		{
			if(playerKeyNumber==playerArray[row-i][column+i])
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		//checks for northwest
		for(int i=1; row+i<=dimension-1 && column-i>=0; i++)//if it matches player's key number
		{
			if(playerKeyNumber==playerArray[row+i][column-i])
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		
		
		if(counter>=numWin)//enough to win?
		{

			return true;
		}
		
		return false;// not enough to win
	}

}
