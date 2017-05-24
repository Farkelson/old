package cs1410;

import java.util.Scanner;

/**
 * Represents a variety of information about a geocache.
 * A geocache has a title, an owner, a difficulty rating, a terrain
 * rating, a GC code, a latitude, and a longitude.  The two ratings
 * are doubles; the other attributes are strings.
 */
public class Cache {
	
	/**
	 * For testing the Cache class
	 */
	public static void main (String[] args) {
		// TODO:  Put testing code for the Cache class here
		Cache test = new Cache ("GCRQWK	Old Three Tooth	geocadet	3.5	3	N40° 45.850	W111° 48.045");
		System.out.println(test.getGcCode());
		System.out.println(test.getTitle());
		System.out.println(test.getOwner());
		System.out.println(test.getDifficulty());
		System.out.println(test.getTerrain());
		System.out.println(test.getLatitude());
		System.out.println(test.getLongitude());
		System.out.println(test.toString());
	}
	
	private String title;		//Title of the geocache
	private String owner;		//Name of the owner of the geocache
	private double difficulty;  //Difficulty rating of the geocache as a number
	private double terrain;		//Terrain rating of the geocache as a number
	private String GCode;		//The GC code of the geocache
	private String lat;			//Latitude of the geocache
	private String log;			//Longitude of the geocache
	
	/**
	 * Creates a Cache from a string that contains its seven attributes.  The string must consist of
	 * the GC code, the title, the owner, the difficulty rating, the terrain rating, the latitude, and
	 * the longitude, in that order, separated by TAB ('\t') characters.
	 */
	public Cache(String attributes) {
		Scanner s = new Scanner (attributes);
		s.useDelimiter("\\t");
		GCode = s.next();
		title = s.next();
		owner = s.next();
		difficulty = s.nextDouble();
		terrain = s.nextDouble();
		lat = s.next();
		log = s.next();
		s.close();
	}
	
	/**
	 * Converts this cache into a string.
	 */
	public String toString () {
		return getTitle();
	}

	/**
	 * Returns the owner of this cache
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Returns the title of this cache
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the difficulty rating of this cache
	 */
	public double getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Returns the terrain rating of this cache
	 */
	public double getTerrain() {
		return terrain;
	}

	/**
	 * Returns the GC code of this cache
	 */
	public String getGcCode() {
		return GCode;
	}

	/**
	 * Returns the latitude of this cache
	 */
	public String getLatitude() {
		return lat;
	}
	
	/**
	 * Returns the longitude of this cache
	 */
	public String getLongitude() {
		return log;
	}

}
