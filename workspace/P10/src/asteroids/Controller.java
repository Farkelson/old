package asteroids;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import static asteroids.Constants.*;

/**
 * Controls a game of asteroids
 * @author Joe Zachary
 */
public class Controller implements CollisionListener, ActionListener, KeyListener, CountdownTimerListener {

	// Shared random number generator
	private Random random;

	// The ship (if one is active) or null (otherwise)
	private Ship ship;

	// When this timer goes off, it is time to refresh the animation
	private Timer refreshTimer; 

	// Count of how many transitions have been made.  This is used to keep two
	// conflicting transitions from being made at almost the same time.
	private int transitionCount;

	// Number of lives left
	private int lives;

	//The score the player has earned
	private int score;

	private int score4addLives;

	// The Game and Screen objects being controlled
	private Game game;
	private Screen screen;

	//When these keys are pressed then they read true
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean space;

	//Keeps track of how many bullets are on screen
	private int bullets;


	/**
	 * Constructs a controller to coordinate the game and screen
	 */
	public Controller (Game game, Screen screen) {

		// Record the game and screen objects
		this.game = game;
		this.screen = screen;

		// Initialize the random number generator
		random = new Random();

		// Set up the refresh timer.
		refreshTimer = new Timer(FRAME_INTERVAL, this);
		transitionCount = 0;

		// Bring up the splash screen and start the refresh timer
		splashScreen();
		refreshTimer.start();

	}


	/**
	 * Configures the game screen to display the splash screen
	 */
	private void splashScreen () {

		// Clear the screen and display the legend
		screen.clear();
		screen.setLegend("Asteroids");

		// Place four asteroids near the corners of the screen.
		placeAsteroids();

		// Make sure there's no ship
		ship = null;

	}


	/**
	 * Get the number of transitions that have occurred.
	 */
	public int getTransitionCount () {
		return transitionCount;
	}


	/**
	 * The game is over.  Displays a message to that effect and
	 * enables the start button to permit playing another game.
	 */
	private void finalScreen () {
		screen.setLegend(GAME_OVER);
		screen.removeCollisionListener(this);
		screen.removeKeyListener(this);
	}



	/**
	 * Places four asteroids near the corners of the screen.
	 * Gives them random velocities and rotations.
	 */
	private void placeAsteroids () {

		Participant a = new Asteroid(0, 2, EDGE_OFFSET, EDGE_OFFSET);
		a.setVelocity(3, random.nextDouble()*2*Math.PI);
		a.setRotation(2*Math.PI * random.nextDouble());
		screen.addParticipant(a);

		a = new Asteroid(1, 2, SIZE-EDGE_OFFSET, EDGE_OFFSET);
		a.setVelocity(3, random.nextDouble()*2*Math.PI);
		a.setRotation(2*Math.PI * random.nextDouble());
		screen.addParticipant(a);

		a = new Asteroid(2, 2, EDGE_OFFSET, SIZE-EDGE_OFFSET);
		a.setVelocity(3, random.nextDouble()*2*Math.PI);
		a.setRotation(2*Math.PI * random.nextDouble());
		screen.addParticipant(a);

		a = new Asteroid(3, 2, SIZE-EDGE_OFFSET, SIZE-EDGE_OFFSET);
		a.setVelocity(3, random.nextDouble()*2*Math.PI);
		a.setRotation(2*Math.PI * random.nextDouble());
		screen.addParticipant(a);

	}


	/**
	 * Set things up and begin a new game.
	 */
	private void initialScreen () {

		// Clear the screen
		screen.clear();

		// Place four asteroids
		placeAsteroids();

		// Place the ship
		placeShip();
		
		// Reset statistics
		lives = 3;
		score = 0;
		score4addLives = 1;
		game.setLives(lives);
		game.setScore(score);

		// Start listening to events.  In case we're already listening, take
		// care to avoid listening twice.
		screen.removeCollisionListener(this);
		screen.removeKeyListener(this);
		screen.addCollisionListener(this);
		screen.addKeyListener(this);

		// Give focus to the game screen
		screen.requestFocusInWindow();

	}


	/**
	 * Place a ship in the center of the screen.
	 */
	private void placeShip () {
		if (ship == null) {
			ship = new Ship();
		}
		ship.setPosition(SIZE/2, SIZE/2);
		ship.setRotation(-Math.PI/2);
		screen.addParticipant(ship);
	}


	/**
	 * Deal with collisions between participants.
	 */
	@Override
	public void collidedWith(Participant p1, Participant p2) {
		if (p1 instanceof Asteroid && p2 instanceof Ship) {
			asteroidCollision((Asteroid)p1);
			shipCollision((Ship)p2);
		}
		else if (p1 instanceof Ship && p2 instanceof Asteroid) {
			asteroidCollision((Asteroid)p2);
			shipCollision((Ship)p1);
		}
		else if (p1 instanceof Asteroid && p2 instanceof Bullet) {
			asteroidCollision((Asteroid)p1);
			bulletCollision((Bullet)p2);

		}
		else if (p1 instanceof Bullet && p2 instanceof Asteroid) {
			asteroidCollision((Asteroid)p2);
			bulletCollision((Bullet)p1);
		}
	}


	/**
	 * The ship has collided with something
	 */
	private void shipCollision (Ship s) {

		// Remove the ship from the screen and null it out
		screen.removeParticipant(s);
		ship = null;

		//Adds debris
		ShipDebris db = new ShipDebris(s);
		new CountdownTimer(this, db, 700);
		screen.addParticipant(db);

		// Display a legend and make it disappear in one second
		screen.setLegend("Ouch!");
		new CountdownTimer(this, null, 1000);

		// Decrement lives
		lives--;
		game.setLives(lives);

		// Start the timer that will cause the next round to begin.
		new TransitionTimer(END_DELAY, transitionCount, this);

	}


	/**
	 * Something has hit an asteroid
	 */
	private void asteroidCollision (Asteroid a) {

		// The asteroid disappears
		screen.removeParticipant(a);


		// Create two smaller asteroids.  Put them at the same position
		// as the one that was just destroyed and give them a random
		// direction.
		int size = a.getSize();
		size = size - 1;
		if (size >= 0) {
			int level = score/2080;
			int speed = 5 - size + level;
			Asteroid a1 = new Asteroid(random.nextInt(4), size, a.getX(), a.getY());
			Asteroid a2 = new Asteroid(random.nextInt(4), size, a.getX(), a.getY());
			a1.setVelocity(speed, random.nextDouble()*2*Math.PI);
			a2.setVelocity(speed, random.nextDouble()*2*Math.PI);
			a1.setRotation(2*Math.PI*random.nextDouble());
			a2.setRotation(2*Math.PI*random.nextDouble());
			screen.addParticipant(a1);
			screen.addParticipant(a2);
		}

		//Adds debris
		AstDebris db = new AstDebris(a);
		new CountdownTimer(this, db, 500);
		screen.addParticipant(db);

		size = a.getSize();
		if (size == 2){
			score= score + 20;
		}
		else if(size == 1){
			score= score + 50;
		}
		else if(size == 0){
			score= score + 100;
		}
		game.setScore(score);
		if (score%2080 == 0){
			placeAsteroids();
		}
		if (score/5000 ==score4addLives){
			score4addLives++;
			lives++;
			game.setLives(lives);
		}
	}

	/**
	 * Something has hit a bullet
	 */

	private void bulletCollision(Bullet a){
		screen.removeParticipant(a);
		a = null;
	}



	/**
	 * This method will be invoked because of button presses and timer events.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// The start button has been pressed.  Stop whatever we're doing
		// and bring up the initial screen
		if (e.getSource() instanceof JButton) {
			transitionCount++;
			initialScreen();
		}


		// Time to refresh the screen
		else if (e.getSource() == refreshTimer) {

			if (left == true) { 
				if (ship != null) ship.rotate(-Math.PI/16);
			}
			else if (right == true) {
				if (ship != null) ship.rotate(Math.PI/16);
			}
			if (up == true) {
				if (ship != null) ship.accelerate(1);
			}
			if (space == true) {
				if (ship != null){
					if (bullets <= 8){
						Bullet a = new Bullet(ship);
						new CountdownTimer(this, a, BULLET_DURATION);
						screen.addParticipant(a);
						bullets++;
					}
				}
			}
				//StrongAlien sa = new StrongAlien(ship);
				//sa.setPosition(-20,3);
				//new CountdownTimer(this, sa, 5000);
				//screen.addParticipant(sa);
			

			// Refresh screen
			screen.refresh();
		}
	}


	/**
	 * Based on the state of the controller, transition to the next state.
	 */
	public void performTransition () {

		// Record that a transition was made.  That way, any other pending
		// transitions will be ignored.
		transitionCount++;

		// If there are no lives left, the game is over.  Show
		// the final screen.
		if (lives == 0) {
			finalScreen();
		}

		// The ship must have been destroyed.  Place a new one and
		// continue on the current level
		else {
			placeShip();
		}

	}


	/**
	 * Deals with certain key presses
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
			if (ship != null) ship.rotate(-Math.PI/16);
			left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (ship != null) ship.rotate(Math.PI/16);
			right = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (ship != null) ship.accelerate(1);
			up = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			if (ship != null){
				if(bullets >= 8){
					space = false;
				}
				else{
					space = true;
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_T) { 
			if (ship != null) ship.setPosition(random.nextInt(750), random.nextInt(750));
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}


	/**
	 * Callback for countdown timer.  Used to create transient effects.
	 */
	@Override
	public void timeExpired(Participant p) {
		if(p instanceof Bullet){
			screen.removeParticipant(p);
			bullets--;
		}
		if(p instanceof ShipDebris){
			screen.removeParticipant(p);
		}
		if(p instanceof AstDebris){
			screen.removeParticipant(p);
		}
		if(p instanceof StrongAlien){
			screen.removeParticipant(p);
		}
		screen.setLegend("");
	}

	public int getLives(){
		return lives;
	}
	public int getScore(){
		return score;
	}

}
