package cs1410;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LightsOut2 {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Gui ttt = new Gui();
		ttt.setVisible(true);
	}

}
class Board {

	private int ywins;
	private boolean[] boxValues;


	public Board () {
		ywins = 0;
		boxValues = new boolean[25];
	}


	/**
	 * If the current position is a win for X, a win for Y, or a draw, throws
	 * an IllegalArgumentException.
	 * 
	 * If the specified square is already occupied, throws
	 * an IllegalArgumentException.
	 * 
	 * If square is invalid (less than 1 or greater than 9), throws
	 * an IllegalArgumentException.
	 * 
	 * Otherwise, if it is X's turn to move, records an X move to the specified
	 * square and returns "X".  If it is O's turn to move, records an O move to
	 * the specified square and returns "O".  If the move makes the position
	 * a win for X, the "wins for X" count is incremented.  If the move makes
	 * the position a win for O, the "wins for O" count is incremented.  If the
	 * move makes the position a draw, the "draws" count is incremented.
	 */
	public String move (int square) {
		if (isWon()){
			throw new IllegalArgumentException();
		}
		if (square < 1 || square > 26){
			throw new IllegalArgumentException();
		}
		return "Light";

	}

	/**
	 * Reports whether or not the board has a won position (either X or O
	 * has three in a row).
	 */
	public boolean isWon () {
		return (allFalse(boxValues));
	}

	public boolean allFalse(boolean [] a){
		for (int i = 0; i<25; i++){
			if(a[i]==true){
				return false;
			}
		}
		return true;
	}


	/**
	 * Resets the board so that a fresh game can be played.
	 */
	public void reset () {
		boxValues = new boolean[25];
	}
}
class Controller implements ActionListener {

	private Gui gui;      // The user interface component
	private Board board;  // The state of the game


	/**
	 * Creates a controller whose job is to coordinate the behaviors
	 * of gui and board.
	 */
	public Controller (Gui gui, Board board) {
		this.gui = gui;
		this.board = board;
	}


	/**
	 * Resets the controller to begin a new game.
	 */
	public void reset () {
		board.reset();
		gui.clearBoard();
	}


	/**
	 * Called when one of the buttons in the user interface is clicked.
	 */
	public void actionPerformed (ActionEvent e) {

		// Get the button that was clicked
		JButton button = (JButton)e.getSource();

		// It was the randomize button
		if (button.getText().equals("Randomize")) {
			reset();
		}

		// It was one of the nine board buttons
		else {

			// Get the row and column that were clicked
			int row = button.getName().charAt(0) - '0';
			int col = button.getName().charAt(1) - '0';

			// Make the move.  Illegal moves will result in
			// an exception and are ignored.
			String symbol;
			try {
				symbol = board.move(row*3+col+1);
			}
			catch (IllegalArgumentException ex) {
				return;
			}

			// Display the symbol that was just played
			button.setText(symbol);
		}

	}


	/**
	 * Updates the gui to display whose turn it is.
	 */
	private void displayStatus () {
		displayStatus(board.getToMove() + " to move");
	}


	/**
	 * Updates the gui to display the specified message.
	 */
	private void displayStatus (String msg) {
		gui.setStatus(msg);
	}

}
}

class Gui extends JFrame {

	/**
	 * Launches a game of tic-tac-toe
	 */
	public static void main (String[] args) {
		Gui ttt = new Gui();
		ttt.setVisible(true);
	}


	private JLabel status;    // Where status messages are displayed
	private JLabel score;     // Where the score is displayed
	private BoardPanel boardPanel; // The main part of the GUI


	/**
	 * Creates a top-level tic-tac-toe window
	 */
	public Gui () {

		// When this window is closed, the program exits
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");

		// Represents the state of the game
		TTTBoard board = new TTTBoard();

		// Controls the interaction between the GUI and the board
		TTTController controller = new TTTController(this, board);	

		// Top-level panel within the window
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		// Lay out the main panel
		boardPanel = new BoardPanel(controller);
		mainPanel.add(boardPanel, "Center");
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(1,2));
		labels.add(status = new JLabel());
		labels.add(score = new JLabel());
		mainPanel.add(labels, "North");
		JButton reset = new JButton("Start New Game");
		reset.addActionListener(controller);
		mainPanel.add(reset, "South");

		// Compose the top-level window and get going.
		setContentPane(mainPanel);
		setSize(300,300);
		controller.reset();

	}


	/**
	 * Sets the status label
	 */
	public void setStatus (String s) {
		status.setText(s);
	}


	/**
	 * Sets the score label
	 */
	public void setScore (String s) {
		score.setText(s);
	}


	/**
	 * Clears the board
	 */
	public void clearBoard () {
		boardPanel.clear();
	}

}


/**
 * Represents the playing area of a TTTGui.
 */
class BoardPanel extends JPanel {

	private Font font;        // Font used to display X and O


	/**
	 * Creates a BoardPanel given the controller and the board state.
	 */
	public BoardPanel (ActionListener listener) {
		setLayout(new GridLayout(3,3));
		font = new Font(getFont().getFamily(), 0, 72);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton b = new JButton(" ");
				b.setFont(font);
				b.setName("" + i + j);
				add(b);
				b.addActionListener(listener);
			}
		}
	}


	public void clear () {
		for (int i = 0; i < 9; i++) {
			JButton b = (JButton) getComponent(i);
			b.setText("");
		}
	}

}
