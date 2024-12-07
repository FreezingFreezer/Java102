import java.util.ArrayList;

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
        //challenge 3
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
        //practice
        ArrayList<String> arr = new ArrayList<>();  
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.set(0, "Goodbye");
        System.out.println(arr); 
        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));    
        System.out.println(conditions); 
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
	        intArr.add(0);
        }
        System.out.println(intArr.size());
        System.out.println(intArr.get(32));
        //grid
        
    }

    public static void returnAll(LibraryItem[] items) {
        for (LibraryItem item : items) {
            item.returnItem();
        }
    }

    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> availableItems = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.available()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }
    
}