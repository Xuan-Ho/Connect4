import java.awt.GridLayout;

import javax.swing.JPanel;

public class Connect4BoardBuilder {

	
		private JPanel connectfour;//panel of game board
		private int dimension;// dimension of game board
		
		/**ConnectFourMaker
		 * connect fours constructor
		 */
		public Connect4BoardBuilder(int dimension)
		{
			connectfour=new JPanel();
			this.dimension = dimension;
			makeConnectFour(dimension);
		}
		
		/**makeConnectFour
		 * sets the layout of the game
		 * @param dimension of game board
		 */
		private void makeConnectFour(int dimension)
		{
			connectfour.setLayout(new GridLayout(dimension+1, dimension));
			addCircles(dimension);
		}
		
		/**addCircles
		 * adds the circles/slots
		 * @param dimension of game board
		 */
		private void addCircles(int dimension)
		{
			int a = dimension*dimension;
			for(int i =0; i<a;i++)
			{
				connectfour.add(new Circle());
			}
			addButtons(dimension);
		}
		
		/**addButtons
		 * adds the buttons to the game board
		 * @param dimension of game board
		 */
		private void addButtons(int dimension)
		{
			for(int i =0;i<dimension;i++)
			{
				connectfour.add(new DropButton());
			}
		}
		
		/**getConnectFourPanel
		 * returns the connect four game board panel
		 * @return the connect four 
		 */
		public JPanel getConnectFourPanel()
		{
			return connectfour;
		}
		
		/**
		 * resets the game board
		 */
		public void reset()
		{
			addCircles(dimension);
		}
}
