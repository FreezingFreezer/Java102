public class Circle {
	public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	/** 
	* @return Whether point p is inside of the circle.
	*/
	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	/** 
	* @return Whether point p part of/on the border of the circle.
	*/
	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	/** 
	* @param x How much to translate the circle by in the + x direction.
	* @param y How much to translate the circle by in the + y direction.
	* @return The circle that results from the translation.
	*/
	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	/** 
	* @return The circle that results from scaling by k.
	*/
	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}
    public static Circle fromPoints(Point p1, Point p2, Point p3){
        double xP1 = p1.x;
        double yP1 = p1.y;
        double xP2 = p2.x;
        double yP2 = p2.y;
        double xP3 = p3.x;
        double yP3 = p3.y;
        double A1 = xP1*(yP2-yP3)-yP1*(xP2-xP3)+xP2*yP3-xP3*yP2; //this equation lost me
        double A2 = (xP1 * xP1 + yP1 * yP1) * (yP3 - yP2) + (xP2 * xP2 + yP2 * yP2) * (yP1 - yP3) + (xP3 * xP3 + yP3 * yP3) * (yP2 - yP1);
        double A3 = (xP1 * xP1 + yP1 * yP1) * (xP2 - xP3) + (xP2 * xP2 + yP2 * yP2) * (xP3 - xP1) + (xP3 * xP3 + yP3 * yP3) * (xP1 - xP2);
        double A4 = (xP1 * xP1 + yP1 * yP1) * (xP3 * yP2 - xP2 * yP3) + (xP2 * xP2 + yP2 * yP2) * (xP1 * yP3 - xP3 * yP1) + (xP3 * xP3 + yP3 * yP3) * (xP2 * yP1 - xP1 * yP2);

        double Xcenter = -A2/(2*A1);
        double centerY = -A3/(2*A1);
        double radius = Math.sqrt((A2*A2+A3*A3-4*A1*A4)/(4*A1*A1));
        return new Circle(new Point(Xcenter,centerY), radius);
    }
}