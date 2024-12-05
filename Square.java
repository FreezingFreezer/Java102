public class Square {
    public final Point corner;
    public final double sideLength;

    
    public Square(Point corner, double sideLength) {
        this.corner = corner;
        this.sideLength = sideLength;
    }

    public double area() {
        return sideLength * sideLength;
    }

    public double perimeter() {
        return 4 * sideLength;
    }

    
    public boolean isInside(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return 0 < xDist && xDist < sideLength &&
               0 < yDist && yDist < sideLength;
    }

    
    public boolean isOn(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return (xDist == 0 || xDist == sideLength) && 0 <= yDist && yDist <= sideLength ||
               (yDist == 0 || yDist == sideLength) && 0 <= xDist && xDist <= sideLength;
    }

    
    public Square translate(double x, double y) {
        return new Square(corner.translateX(x).translateY(y), sideLength);
    }

    
    public Square scale(double k) {
        return new Square(corner, sideLength * k);
    }

    public Point[] corners() {
        return new Point[] {
            corner,
            corner.translateX(sideLength),
            corner.translateX(sideLength).translateY(sideLength),
            corner.translateY(sideLength)
        };
    }

    @Override
    public String toString() {
        return "(corner: " + corner + "; side length: " + sideLength + ")";
    }
}
