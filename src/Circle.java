import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Circle extends JComponent{
	private Color color;//color of circle
	private final int DIAMETER=40;//diameter of circle
	private final Color PLAYER_ONE=Color.RED;
	private final Color PLAYER_TWO = Color.YELLOW;
	private final int X_CORDINATE= 20;
	private final int Y_CORDINATE=0;
	
	
	
	/**
	 * Circle constructor
	 */
	public Circle()
	{
		color = Color.WHITE;
		
	}
	
	
	
	/**
	 * circle constructor
	 * @param c the color for the circle
	 */
	public Circle(Color c)
	{
		color=c;
	}
	
	/**
	 * draws the circle
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(X_CORDINATE, Y_CORDINATE, DIAMETER, DIAMETER);
	}
	
	/**
	 * colors the circle
	 * @param player1 whether player 1 or player2
	 */
	public void fill(boolean player1)
	{
		if(player1)
		{
			color=PLAYER_ONE;
		}
		else
		{
			color=PLAYER_TWO;
		}
	}
	
	
	/**
	 * checks the color
	 * @return the color of circle
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * hashcode of color
	 * @return int hashcode of circle
	 */
	@Override
	public int hashCode()
	{
		return color.hashCode();
	}

	
	/**
	 * sets the circle color
	 * @param Color c new color of circle
	 */
	@Override
	public void setBackground(Color c)
	{
		color=c;
	}

}
