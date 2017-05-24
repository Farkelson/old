package asteroids;

import javax.swing.*;
import java.awt.*;
import static asteroids.Constants.*;


/**
 * Implements an asteroid game.
 * @author Joe Zachary
 *
 */
public class Game extends JFrame {
	
	private JLabel lives;
	private JLabel score;
	
	/**
	 * Launches the game
	 */
	public static void main (String[] args) {
		Game a = new Game();
		a.setVisible(true);
	}

	
	/**
	 * Lays out the game and creates the controller
	 */
	public Game () {
		
		// Title at the top
		setTitle(TITLE);
		
		// Default behavior on closing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The main playing area and the controller
		Screen screen = new Screen();
		Controller controller = new Controller(this, screen);

		// This panel contains the screen to prevent the screen from being resized
		JPanel screenPanel = new JPanel();
		screenPanel.setLayout(new GridBagLayout());
		screenPanel.add(screen);
		
		JPanel controls = new JPanel();
		
		// The button that starts the game
		JButton startGame = new JButton(START_LABEL);
		controls.add(startGame);
		
		lives = new JLabel();
		setLives(3);
		controls.add(lives);
		
		score = new JLabel();
		setScore(controller.getScore());
		controls.add(score);
		
		// Organize everything
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(screenPanel, "Center");
		mainPanel.add(controls, "North");
		setContentPane(mainPanel);
		pack();
		
		// Connect the controller to the start button
		startGame.addActionListener(controller);
		
	}
	public void setLives(int liv){
		lives.setText("Lives:" + liv);
	}
	public void setScore(int sco){
		score.setText("Score:" + sco);
	}
	
	
	
	
	
	
	

}











		
