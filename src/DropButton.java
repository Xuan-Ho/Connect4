import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DropButton extends JComponent{
	
	private final Color COLOR_BACKGROUND = Color.GRAY;
	private final Color COLOR_FONT = Color.WHITE;

	/**
	 * override method that draws button
	 * @param g graphics
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(COLOR_BACKGROUND);
		g.fillRect(5, 5, 75, 75);
		g.setColor(COLOR_FONT);
		g.drawString("Press", 20, 35);
		
	}
}
