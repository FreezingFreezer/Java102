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
    * @return Whether point p is part of/on the border of the circle.
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

    public static Circle fromPoints(Point p1, Point p2, Point p3) {
        double x1 = p1.x, y1 = p1.y;
        double x2 = p2.x, y2 = p2.y;
        double x3 = p3.x, y3 = p3.y;

        double midX1 = (x1 + x2) / 2;
        double midY1 = (y1 + y2) / 2;
        double midX2 = (x2 + x3) / 2;
        double midY2 = (y2 + y3) / 2;

        double slope1 = (x2 - x1) == 0 ? Double.POSITIVE_INFINITY : (y2 - y1) / (x2 - x1);
        double slope2 = (x3 - x2) == 0 ? Double.POSITIVE_INFINITY : (y3 - y2) / (x3 - x2);

        double perpSlope1 = (slope1 == 0) ? Double.POSITIVE_INFINITY : -1 / slope1;
        double perpSlope2 = (slope2 == 0) ? Double.POSITIVE_INFINITY : -1 / slope2;

        double centerX, centerY;

        if (Double.isInfinite(perpSlope1)) {
            centerX = midX1;
            centerY = perpSlope2 * (centerX - midX2) + midY2;
        } else if (Double.isInfinite(perpSlope2)) {
            centerX = midX2;
            centerY = perpSlope1 * (centerX - midX1) + midY1;
        } else {
            centerX = (perpSlope1 * midX1 - perpSlope2 * midX2 + midY2 - midY1) / (perpSlope1 - perpSlope2);
            centerY = perpSlope1 * (centerX - midX1) + midY1;
        }

        Point center = new Point(centerX, centerY);
        double radius = Point.distance(center, p1); 

        return new Circle(center, radius);
    }

    @Override
    public String toString() {
        return "(center: " + center + "; radius: " + radius + ")";
    }
}
