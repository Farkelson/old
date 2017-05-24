package asteroids;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Bullet extends Participant{
	
	private Shape outline;

	/**
	 * Creates a Bullet object
	 */
	public Bullet(Ship ship){
		Ellipse2D.Double poly = new Ellipse2D.Double(0,0,2,2);
		setPosition(ship.getXNose(),ship.getYNose());
		outline = poly;
		this.setVelocity(15, ship.getRotation());
	}
	

	@Override
	protected Shape getOutline() {
		return outline;
	}

}
