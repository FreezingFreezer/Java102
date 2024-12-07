public class RightTriangle implements Shape {
    private final Point corner;
    private final double base;
    private final double height;

    public RightTriangle(Point corner, double base, double height){
        this.corner = corner;
        this.base = base;
        this.height = height;
    }
    public double area(){
        double Area = (base*height)/2;
        return Area;
    }
    public double perimeter(){
        double Perimeter = base + height + Math.hypot(height, base);
        return Perimeter;
    }
    public RightTriangle translate(double x, double y){
        return new RightTriangle(new Point(corner.x+x,corner.y+y), base, height);
    }
    public RightTriangle scale(double m){
        return new RightTriangle(corner, base*m, height*m);
    }
}
