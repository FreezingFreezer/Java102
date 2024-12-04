public class Main{
    public static void main(String[]args){
        Point point = new Point(4,3);
        System.out.println("x: " + point.x + "y: " + point.y);
        Point xTranslation = point.translateX(3);
        Point yTranslation = point.translateY(-7);
        Point xyTranslation = point.translateX(-4).translateY(-3);
        Point a = new Point(3,4);
        Point b = new Point(2,7);
        Double abDistance = Point.distance(a, b);
        System.out.println("x transl: (" + xTranslation.x + ", " + xTranslation.y + ")");
        System.out.println("y transl: (" + yTranslation.x + ", " + yTranslation.y + ")");
        System.out.println("xy transl: (" + xyTranslation.x + ", " + xyTranslation.y + ")");
        System.out.println("x transl: (" + xTranslation.x + ", " + xTranslation.y + ")");// next 3 lines since they arent a string automaticly call the function toString()
        System.out.println("y transl: (" + yTranslation.x + ", " + yTranslation.y + ")");
        System.out.println("xy transl: (" + xyTranslation.x + ", " + xyTranslation.y + ")");    
        System.out.println("point: " + point);
        System.out.println(Point.distance(a, b));
        System.out.println(abDistance); 
        //challenge 1
        Point[] points = {new Point(4,1), new Point(5,7), new Point(10,8)};
        Point centerMass = Point.centerOfMass(points);
        System.out.println(centerMass);
        System.out.println(points.length);
        //challenge 2
        Point testangle = new Point(-2,-8);
        double tested = testangle.angle();
        System.out.println(tested);
        // Left off at Polymorphism
    }
}