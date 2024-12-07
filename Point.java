public class Point {
    public final double x;
    public final double y; 

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point translateX(double t){
        return new Point(x+t,y);
    }

    public Point translateY(double t){
        return new Point(x,y+t);
    }

    public String toString(){
        return "("+x+", "+y+")";
    }
    
    public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
    //challenge
    static double sumX = 0;
    static double sumY = 0;
    public static Point centerOfMass(Point[] points){
        if(points.length == 0){
            return null;
        }
        for(Point point : points){
            sumX += point.x;
            sumY += point.y;
            System.out.println(sumX + sumY);
        }
        return new Point(sumX/points.length, sumY/points.length);
    }

    public double angle(){
        if(x == 0 && y == 0){
            return 0.0;
        }
        //found out a simple
        double radianArc = Math.atan2(y , x);//I dont know how arc tan 2 works but I think it has to do something with the quadrants and the origin. Helped using online tutorials
        double degree = Math.toDegrees(radianArc);
        if(degree < 0){
            degree += 360; 
        }
        return degree;
        
    }
    public static void returnAll(LibraryItem[] items) {
        for (LibraryItem item : items) {
            item.returnItem();
        }
    }
}
