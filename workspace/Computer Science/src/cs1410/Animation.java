package cs1410;


import java.awt.*;
/* Scott Glass making a square shooting house animation
 * 
 */

public class Animation {
	
	/**
	 * This is the method that you need to rewrite to create
	 * a custom animation.  This method is called repeatedly
	 * as the animation proceeds.  It needs to draw to g
	 * how the animation should look after t milliseconds
	 * have passed.
	 * @param g Graphics object on which to draw
	 * @param t Number of milliseconds that have passed since
	 * animation started
	 */
	public static void paintFrame (Graphics g, int t) {
		int w = 0;
		int h = 0;
		/*The color alternates between red and blue every second*/
		if (t/1000 % 2 == 0) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLUE);
		}
		
		/* The object moves steadily from right to left*/
		int x = 5 + t/ 10;
		
		/*The object moves down for two seconds, then moves up for two seconds, and 
		finally down until the house moves off the screen*/
		int y;
		if (t < 2000) {               
	       	y = 50 + t/10; 
		}
		else if (t < 4000){
			y = 250 - (t-2000)/10;
		}
		else {
			y = 50 + (t-4000)/10;
		}
		
		/* Draw the object*/
		g.drawRect(x, y, 50, 30);     
		g.drawLine(x, y, x+25, y-15);
		g.drawLine(x+25, y-15, x+50, y);
		
		/*Executes squareShooter every second*/
		int c = 0;
		while (c<12){
			c++;
		squareShooter(g, x, y, t, c);
		}
		circle(g, t, x, y, w, h);
	}
	
	/*Draws a circle in the middle of the house that follows the house and grows and shrinks
	every two seconds for up to 12 seconds*/
	public static void circle(Graphics g, int t, int x, int y, int w, int h){
		if ((t/1000)<2){
			w = 20 + t/20;
			h = 20 + t/20;
			x = x - t/40;
			y = y - t/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else if ((t/1000)<4){
			w = 120 - (t-2000)/20;
			h = 120 - (t-2000)/20;
			x = x - 100 + t/40;
			y = y - 100 +  t/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else if ((t/1000)<6){
			w = 20 + (t-4000)/20;
			h = 20 + (t-4000)/20;
			x = x - (t-4000)/40;
			y = y - (t-4000)/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else if ((t/1000)<8){
			w = 120 - (t-6000)/20;
			h = 120 - (t-6000)/20;
			x = x - 50 + (t-6000)/40;
			y = y - 50 + (t-6000)/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else if ((t/1000)<10){
			w = 20 + (t-8000)/20;
			h = 20 + (t-8000)/20;
			x = x - (t-8000)/40;
			y = y - (t-8000)/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else if ((t/1000)<12){
			w = 120 - (t-10000)/20;
			h = 120 - (t-10000)/20;
			x = x - 50 + (t-10000)/40;
			y = y - 50 + (t-10000)/40;
			g.drawOval(x+15, y+5, w, h);
		}
		else {
		}
	}
	
	/*Has four squares shoot from the house in the cardinal directions of the house while
	moving proportionately to the house and changing color with the house*/
	public static void squareShooter (Graphics g , int x, int y, int t, int sec){
		int pow = (t-(sec*1000));
		if ((t/1000)>=sec){
		g.drawRect(x, y + (pow)/5, 50, 30);
		g.drawRect(x + (pow)/5, y, 50, 30);
		g.drawRect(x, y - (pow)/5, 50, 30);
		g.drawRect(x - (pow)/5, y, 50, 30);
		g.drawOval(x - 2*(pow/10) , y - 2*(pow)/10, 50 + 2*(pow)/5, 30 + 2*(pow)/5);
		g.drawOval(x+50 - 2*(pow/10) , y+30 - 2*(pow)/10, -50 + 2*(pow)/5, -30 + 2*(pow)/5);
		}
		else{	
		}
	}	
}
