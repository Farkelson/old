package asteroids;

import java.awt.Shape;
import java.awt.geom.*;

public class ShipDebris extends Participant{

	private Shape outline;
	
	/**
	 * Displays debris if the ship is hit
	 */
	public ShipDebris(Ship ship){
		Path2D.Double line1 = new Path2D.Double();
		
		line1.moveTo(-10, 0);
		line1.lineTo(-22, 40);
		line1.closePath();
		line1.moveTo(10, 0);
		line1.lineTo(22, 40);
		line1.closePath();
		line1.moveTo(18, 38);
		line1.lineTo(8, 40);
		line1.closePath();
		setPosition(ship.getXNose(),ship.getYNose());
		setRotation(ship.getRotation() + Math.PI/2);
		setVelocity(-1, -2);
		outline = line1 ;
	}	
	

	@Override
	protected Shape getOutline() {
		return outline;
	}

}
