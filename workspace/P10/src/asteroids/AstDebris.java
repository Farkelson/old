package asteroids;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class AstDebris extends Participant{


	private Shape outline;

	/**
	 * Displays debris if an asteroid is hit
	 */
	public AstDebris(Asteroid a){
		Path2D.Double dust = new Path2D.Double();

		dust.moveTo(0, 0);
		dust.lineTo(-2, 4);
		dust.lineTo(0, 4);
		dust.closePath();
		dust.moveTo(5, 5);
		dust.lineTo(-2+5, 3+5);
		dust.lineTo(2+5, 7+5);
		dust.lineTo(4+5, 5+5);
		dust.closePath();
		dust.moveTo(-2-9, 4-9);
		dust.lineTo(-1-9, 5-9);
		dust.closePath();
		setPosition(a.getX(),a.getY());
		setVelocity(0.5, 2);
		outline = dust;
	}	


	@Override
	protected Shape getOutline() {
		return outline;
	}

}
