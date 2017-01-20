import javax.swing.JFrame;

/*
 	By Xuan Ho, Jorge Murillo, Mahmood Abuzaina
 	San Jose State University (SJSU) 
 	Spring 2016 
 	CS151 - Object Orientated Program
 */

public class Connect4 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame connect4= new Connect4Controller(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		connect4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connect4.setTitle("Connect Four[ Player 1:RED, Player 2: GREEN]");//sets the title
		connect4.setLocationRelativeTo(null);// sets to the center
		connect4.setVisible(true);//sets visible

	}

}
