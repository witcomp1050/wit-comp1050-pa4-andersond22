package edu.wit.cs.comp1050;

//A simple arithmetic to implement such functionality as computing area, perimeter, and center point.
public class Rectangle extends Shape2D {
	private Point2D p1;
	private Point2D p2;
	/**
	 * Constructs a rectangle given two points
	 * 
	 * @param color rectangle color
	 * @param p1 point 1
	 * @param p2 point 2
	 */
	public Rectangle(String color, Point2D p1, Point2D p2) {
		super(color, "Rectangle");
		this.p1 = p1;
		this.p2 = p2;
	

	}
	
	/**
	 * Returns true if provided
	 * another rectangle whose 
	 * lower-left and upper-right
	 * points are equal to this
	 * rectangle
	 * 
	 * @param o another object
	 * @return true if the same rectangle
	 */
	@Override
	public boolean equals(Object o) {
		Rectangle other = (Rectangle) o;
		if(o == this) {
			return true;
		}
		if(this.getLowerLeft().equals(other.getLowerLeft()) && this.getUpperRight().equals(other.getUpperRight())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the lower-left corner
	 * 
	 * @return lower-left corner
	 */
	public Point2D getLowerLeft() {
        double minY = Math.min(p1.getY(), p2.getY());
        double minX = Math.min(p1.getX(), p2.getX());
        return new Point2D(minX, minY);
	}
	
	/**
	 * Gets the upper-right corner
	 * 
	 * @return upper-right corner
	 */
	public Point2D getUpperRight() {
		double maxY = Math.max(p1.getY(), p2.getY());
        double maxX = Math.max(p1.getX(), p2.getX());
        return new Point2D(maxX, maxY);
	}

	@Override
	public double getArea() {
		Point2D lowerLeft = getLowerLeft();
        Point2D upperRight = getUpperRight();
        double width = upperRight.getX() - lowerLeft.getX();
        double height = upperRight.getY() - lowerLeft.getY();
        return width * height;
	}

	@Override
	public double getPerimeter() {
		Point2D lowerLeft = getLowerLeft();
	    Point2D upperRight = getUpperRight();
	    double width = upperRight.getX() - lowerLeft.getX();
	    double height = upperRight.getY() - lowerLeft.getY();
	    return 2 * (width + height);
	}

	@Override
	public Point2D getCenter() {
		Point2D lowerLeft = getLowerLeft();
        Point2D upperRight = getUpperRight();
        double centerX = (lowerLeft.getX() + upperRight.getX()) / 2;
        double centerY = (lowerLeft.getY() + upperRight.getY()) / 2;
        return new Point2D(centerX, centerY);
	}

	@Override
	public Point2D[] getVertices() {
		Point2D lowerLeft = getLowerLeft();
        Point2D upperRight = getUpperRight();
        Point2D lowerRight = new Point2D(upperRight.getX(), lowerLeft.getY());
        Point2D upperLeft = new Point2D(lowerLeft.getX(), upperRight.getY());
        return new Point2D[]{lowerLeft, upperLeft, upperRight, lowerRight};
	}

}
