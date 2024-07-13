package edu.wit.cs.comp1050;

//Find points, area, perimeter, center, and vertices for a triangle
public class Triangle extends Shape2D {
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	/**
	 * Constructs a triangle given
	 * three points
	 * 
	 * @param color color
	 * @param p1 point 1
	 * @param p2 point 2
	 * @param p3 point 3
	 */
	public Triangle(String color, Point2D p1, Point2D p2, Point2D p3) {
		super(color, "Triangle");
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
	
	}
	
	/**
	 * Returns the axis-aligned
	 * bounding box for this
	 * triangle
	 * 
	 * @return axis-aligned bounding box
	 */
	public Rectangle getAxisAlignedBoundingBox() {
		double minX = Math.min(Math.min(p1.getX(), p2.getX()), p3.getX());
        double minY = Math.min(Math.min(p1.getY(), p2.getY()), p3.getY());
        double maxX = Math.max(Math.max(p1.getX(), p2.getX()), p3.getX());
        double maxY = Math.max(Math.max(p1.getY(), p2.getY()), p3.getY());
        Point2D lowerLeft = new Point2D(minX, minY);
        Point2D upperRight = new Point2D(maxX, maxY);
        return new Rectangle("BoundingBox", lowerLeft, upperRight);
	}

	@Override
	public double getArea() {
		 double x1 = p1.getX();
		 double y1 = p1.getY();
		 double x2 = p2.getX();
		 double y2 = p2.getY();
		 double x3 = p3.getX();
		 double y3 = p3.getY();

		 return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
	}

	@Override
	public double getPerimeter() {
		double side1 = Point2D.distance(p1, p2);
	    double side2 = Point2D.distance(p2, p3);
	    double side3 = Point2D.distance(p3, p1);

	    return side1 + side2 + side3;
	}

	@Override
	public Point2D getCenter() {
		double centerX = (p1.getX() + p2.getX() + p3.getX()) / 3;
        double centerY = (p1.getY() + p2.getY() + p3.getY()) / 3;
        return new Point2D(centerX, centerY);
	}

	@Override
	public Point2D[] getVertices() {
		return new Point2D[]{p1, p2, p3};
	}

}
