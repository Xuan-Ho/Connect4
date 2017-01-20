import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinResetPopUpScreen extends JFrame{
	
	private JLabel winner;
	private JButton reset;
	private JPanel winningPanel;
	/**
	 * creates a pop up screen 
	 * @param player the player who won
	 * @param controller frame of the connect 4 game
	 */
	public WinResetPopUpScreen(boolean player, Connect4Controller controller)
	{
		//Determine who won
		if(player)
		{
			winner = new JLabel("Player 1 wins!");
		}
		else
		{
			winner = new JLabel("Player 2 wins!");
		}
		
		
		winningPanel = new JPanel();//sets the panel
		reset = new JButton("Reset");// sets the button
		
		winningPanel.add(winner);// adds winner label to panel
		winningPanel.add(reset);// adds reset button to panel
		add(winningPanel);// adds panel to this frame
		
		setLocationRelativeTo(null);//sets screen to center
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes screen when exit
		setSize(200, 60);// the size of the screen, fixed
		controller.setEnabled(false);// disables the game board
		setAlwaysOnTop(true);//set screen to always on top
		
		//function when reset is pressed
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.resetGame();//calls reset game function of controller
				controller.setEnabled(true);//enables fram of connect 4 again
				setVisible(false);//disappears the screen
				dispose();//disposes screen
				
			}
		});
		
		
	}

}
