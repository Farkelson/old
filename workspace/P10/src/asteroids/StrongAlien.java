package asteroids;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class StrongAlien  extends Participant {
	
	// The outline of the asteroid
	private Shape outline;
	
	
	/**
	 * Create an alien who is good at shooting the ship
	 */
	public StrongAlien (Ship ship) {
		Path2D.Double poly = new Path2D.Double();
		poly.moveTo(20, 40);
		poly.lineTo(0, 40);
		poly.lineTo(5, 37);
		poly.curveTo(5, 37, 10, 20, 15, 37);
		poly.closePath();
		outline = poly;
		this.setVelocity(8, 0);
	}
	

	protected Shape getOutline () {
		return outline;
	}
	
	
}
