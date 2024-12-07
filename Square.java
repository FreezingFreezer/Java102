public class Square {
	public final Point corner;
	public final double sideLength;

	/**
	* @param corner The bottom left corner of the square
	* @param sideLength
	*/
	public Square(Point corner, double sideLength) {
		this.corner = corner;
		this.sideLength = sideLength;
	}

	public double area() {
		double squareArea = Math.pow(sideLength, 2);
        return squareArea;
	}
	
	public double perimeter() {
		double squarePerimeter = sideLength*4;
        return squarePerimeter;
	}
	
	/** 
	* @return Whether point p is inside of the square.
	*/
	public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return 0 < xDist && xDist < sideLength &&
			   0 < yDist && yDist < sideLength;
	}

	/** 
	* @return Whether point p part of/on the border of the square.
	*/
	public boolean isOn(Point p) {
        boolean OnX = (p.x == corner.x);
        boolean OnY = (p.y == corner.y);
        return OnX == true && OnY == true;
    }
	
	/** 
	* @param x How much to translate the sqaure by in the + x direction.
	* @param y How much to translate the squarer by in the + y direction.
	* @return The sqaure that results from the translation.
	*/
	public Square translate(double x, double y) {
		return new Square(new Point(corner.x+x, corner.y+y),sideLength);
	}

	/** 
	* @return The sqaure that results from scaling the side length and maintaining the bottom left corner
	*/
	public Square scale(double k) {
		return new Square(corner, sideLength * k);
	}

	public Point[] corners() {
        
        return new Point[] {
            new Point(corner.x+sideLength,corner.y),
            new Point(corner.x, corner.y + sideLength),
            new Point(corner.x + sideLength, corner.y + sideLength),
            corner
        };
	}

	@Override
	public String toString() {
		return "(corner: " + corner + "; side length: " + sideLength + ")";
	}
}