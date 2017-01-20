import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4Controller extends JFrame{
	
	private Connect4WinningAlgorithm connect4winner;// winning algorithm
	private Connect4BoardBuilder cfmaker;//the connect four maker
	private JPanel gamePanel;// panel that will set gameboard visible
	private boolean player1;// determines what player is playing
	
	private int dimension;// dimension of board
	private int numberToWin;// number to win game
	private final int final_Dim=70;// sets dimensions per game piece
	
	/**GameMaker constructor
	 * constructs the gameboard, and sets the operations of buttons first-seventh
	 */
	public Connect4Controller(int dimension, int numToWin)
	{
		this.dimension=dimension;// sets the dimension
		numberToWin = numToWin;//sets number to win
		connect4winner=new Connect4WinningAlgorithm(dimension, numToWin);// sets wining algorithm
		player1=true;//set player to player 1
		cfmaker=new Connect4BoardBuilder(dimension);// sets the game building
		gamePanel=cfmaker.getConnectFourPanel();// sets the game board panel 
		
		add(gamePanel);// adds game panel to this frame
		setSize(final_Dim*dimension,final_Dim*dimension);// sets the size of the screen
		
		// if the user clicks the frame
		gamePanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getY()>=gamePanel.getComponent(dimension*dimension).getY())// if the user clicks the buttons
				{
					buttonAction(dimension, e.getX()/gamePanel.getComponent(1).getX());// calls action if user jits button
				}
			}
		});
		
	}
	
	
	
	/**switchPlayer
	 * switches the players turn
	 */
	private void switchPlayer()
	{
		if(player1)player1=false;
		else player1=true;
	}
	
	/**addChip
	 * adds the red or yellow chip into the next slot
	 * @param numberOfSlot the index of the slot that will be occupied
	 */
	private void addChip(int numberOfSlot)
	{
		
       boolean player = true;//what player plays
		
       //adds circle depending on player
		if(player1)
		{
		gamePanel.getComponent(numberOfSlot).setBackground(Color.red);player1=false;
		}
		else
		{
			gamePanel.getComponent(numberOfSlot).setBackground(Color.green);player1=true;player = false;
		}
		gamePanel.update(gamePanel.getGraphics());
		
		//checks if theres a winner
		if(connect4winner.addCircle(player, numberOfSlot))
		{
			stop(player);
		}
	}
	
	/**
	 * determines to what column the chip will be added
	 * @param dim the dimension of the connectfour game
	 * @param extra the column number
	 */
	private void buttonAction(int dim, int extra)
	{
		int bIndex = (dim*(dim-1))+extra;//index of button
		
		// looks for the right circle to fill
		for(int i = bIndex;i>=0;i=i-dim )
		{
			if(gamePanel.getComponent(i).hashCode()==Color.WHITE.hashCode())
			{
				addChip(i);
				return;
			}
		}
	}
	
	/**
	 * stops the game and pops up a window if player wins
	 * @param player the winning player, true for player 1, false for player 2
	 */
	private void stop(boolean player)
	{
		//calls pop up window
		new WinResetPopUpScreen(player, this).setVisible(true);
	}
	
	/**
	 * resets the game to play again
	 */
	public void resetGame()
	{
		// color all circles white
		for(int i =0; i< dimension*dimension;i++)
		{
			gamePanel.getComponent(i).setBackground(Color.WHITE);
		}
		
		connect4winner = new Connect4WinningAlgorithm(dimension, numberToWin);//sets a fresh algorithm
		player1=true;//sets to player 1
		update(getGraphics());//updates graphics
	}

}
