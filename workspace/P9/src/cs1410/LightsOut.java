package cs1410;

import java.awt.*;

import java.util.*;

import java.awt.event.*;

import javax.swing.*;

public class LightsOut extends JFrame implements ActionListener {

	private JButton[][] board;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LightsOut p = new LightsOut();
		p.setVisible(true);

	}

	/**
	 * Creates the board
	 */
	public LightsOut(){

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lights Out");

		JPanel view = new JPanel();
		setContentPane(view);
		view.setLayout(new BorderLayout());

		BoardPanel grid = new BoardPanel();
		grid.randomize(grid);
		view.add(grid, "Center");
		BottomSetup BS = new BottomSetup();
		view.add(BS, "South");


		// Ready to go
		setPreferredSize(new Dimension(500,500));
		pack();
	}

	@Override
	public void actionPerformed (ActionEvent e) {

		// Get the button that was clicked
		JButton button = (JButton)e.getSource();

		// It was the randomize button
		/*if (button.getText().equals("Randomize")) {
			randomize();
		}

		// It was the start manual setup button
		else if (button.getText().equals("Start Manual Setup")) {
			manSet();
		}

		// It was one of the 25 board buttons
		else {
		**/
			// Get the row and column that were clicked
			int row = button.getName().charAt(0) - '0';
			int col = button.getName().charAt(1) - '0';

			// Make the move.  Illegal moves will result in
			// an exception and are ignored.
			JButton symbol;
			try {
				symbol = board[row][col];
			}
			catch (IllegalArgumentException ex) {
				return;
			}

			// Display the symbol that was just played
			button.setBackground(Color.yellow);


		}

	//}
	public BoardPanel randomize(BoardPanel BP){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				JButton b = new JButton("");
				b.setName("" + i + j);
				Random p = new Random();
				if(true){
					b.setBackground(Color.yellow);
				}
				if(Math.abs(p.nextInt())%2==0){
					b.setBackground(Color.yellow);
				}
			}
		}
		return BP;
	}
}

class BoardPanel extends JPanel {

	/**
	 * Creates a BoardPanel given the controller and the board state.
	 */
	public BoardPanel () {
		setLayout(new GridLayout(5,5));
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				JButton b = new JButton("");
				b.setName("" + i + j);
				add(b);
			}
		}
	}

	public BoardPanel randomize(BoardPanel BP){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				JButton b = new JButton("");
				b.setName("" + i + j);
				Random p = new Random();
				if(true){
					b.setBackground(Color.yellow);
				}
				if(Math.abs(p.nextInt())%2==0){
					b.setBackground(Color.yellow);
				}
			}
		}
		return BP;
	}
}
class BottomSetup extends JPanel {

	/**
	 * Creates a BoardPanel given the controller and the board state.
	 */
	public BottomSetup () {
		setLayout(new GridLayout(1,2));
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				JButton random = new JButton("Randomize");
				random.setName("" + i + j);
				add(random);
				JButton manual = new JButton("Enter Manual Setup");
				manual.setName("" + i + j);
				add(manual);
			}
		}
	}
}