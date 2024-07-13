package edu.wit.cs.comp1050;

//Find distance between two points
public class Point2D {
	private double x;
	private double y;
	/**
	 * Constructor to initialize coordinates
	 * 
	 * @param x x value
	 * @param y y value
	 */
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get the x coordinate
	 * 
	 * @return x coordinate
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Get the y coordinate
	 * 
	 * @return y coordinate
	 */
	public double getY() {
		return this.y;	
	}
	
	/**
	 * Gets a String representation
	 * of the coordinate in the form
	 * "(x, y)" (each with three decimal
	 * places of precision)
	 * 
	 * @return "(x, y)"
	 */
	@Override
	public String toString() {
		return String.format("(%.3f, %.3f)", x, y);
	}
	
	/**
	 * Returns true if provided another
	 * point that is at the same (x,y)
	 * location (that is, the distance
	 * is "close enough" according to
	 * Shape2D)
	 * 
	 * @param o another object
	 * @return true if the other object is a point and the same location (within threshold)
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return true;
		} 
		return false;
		
	

	}
	
	/**
	 * Method to compute the Euclidean/L2
	 * distance between two points in 2D
	 * space
	 * 
	 * @param p1 point 1
	 * @param p2 point 2
	 * @return straightline distance between p1 and p2
	 */
	public static double distance(Point2D p1, Point2D p2) {
		double x = p2.getX() - p1.getX();
		double y = p2.getY() - p1.getY();
		
		return Math.sqrt((y * y) + (x * x));	
	}
	
	/**
	 * Method to compute the Euclidean
	 * distance between this point
	 * and a supplied point
	 * 
	 * @param p input point
	 * @return straightline distance between this point and p
	 */
	public double distanceTo(Point2D p) {
		return distance(this, p);
	}

}
