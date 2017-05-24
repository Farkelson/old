package cs1410;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The area where painting takes place.
 */
public class Demo2 extends JPanel implements MouseListener,
                   MouseMotionListener {

	// Position and size of the oval displayed on this PaintPanel
	int centerX;
	int centerY;
	int diamX;
	int diamY;
	
	/**
	 * Creates a PaintPanel containing a single oval
	 */
	public Demo2 () {
		centerX = 100;
		centerY = 100;
		diamX = 50;
		diamY = 50;
		setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	/**
	 * Extend the default paintComponent method 
	 */
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawOval(centerX, centerY, diamX, diamY);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}