package edu.wit.cs.comp1050;

import java.util.ArrayList;

//Validate command-line arguments for a single colored triangle and use the method you just completed to output the corresponding CSV to the terminal.
public class PA4b {
	
	/**
	 * Error if incorrect command-line arguments are supplied
	 */
	public static final String ERR_USAGE = "Please supply correct inputs: color x1 y1 x2 y2 x3 y3";
	
	/**
	 * Number of command-line arguments
	 */
	public static final int NUM_ARGS = 7;
	
	/**
	 * Produces a string representing
	 * all vertex information in CSV
	 * format:
	 * "color",x,y
	 * 
	 * For all shape vertices,
	 * including axis-aligned bounding
	 * boxes for any included triangles
	 * 
	 * @param shapes array of shapes
	 * @return string of CSV information
	 */
	public static String shapeVertices(Shape2D[] shapes) {
		StringBuilder sb = new StringBuilder();
        for (Shape2D shape : shapes) {
            Point2D[] vertices = shape.getVertices();
            for (Point2D vertex : vertices) {
                sb.append(String.format("\"%s\",%.3f,%.3f%n", shape.getColor(), vertex.getX(), vertex.getY()));
            }
            if (shape instanceof Triangle) {
                Rectangle boundingBox = ((Triangle) shape).getAxisAlignedBoundingBox();
                Point2D[] boundingVertices = boundingBox.getVertices();
                for (Point2D vertex : boundingVertices) {
                    sb.append(String.format("\"%s\",%.3f,%.3f%n", shape.getColor(), vertex.getX(), vertex.getY()));
                }
            }
        }
        return sb.toString();	
	}

	/**
	 * Outputs vertex information in CSV
	 * format about the triangle supplied
	 * via command-line arguments, including
	 * its axis-aligned bounding box
	 * 
	 * @param args command-line arguments: color x1 y1 x2 y2 x3 y3
	 */
	public static void main(String[] args) {
		if(args.length != NUM_ARGS) {
			System.out.println(ERR_USAGE);
			System.exit(0);
		}
		ArrayList<Double> array = new ArrayList<Double>();
		try {
			for(int i = 1; i < 7  ; i++) {
				
				array.add(Double.parseDouble(args[i]));
		
				}
			
		 } catch (NumberFormatException e) {
			System.out.println(ERR_USAGE);
			System.exit(0);
		 }
		
		Point2D p1 = new Point2D(array.get(0), array.get(1));
		Point2D p2 = new Point2D(array.get(2), array.get(3));
		Point2D p3 = new Point2D(array.get(4), array.get(5));
		Triangle a = new Triangle(args[0], p1, p2, p3);
		
		Shape2D[] shapes = { a };
        String output = shapeVertices(shapes);
        System.out.print(output);
	}

}
