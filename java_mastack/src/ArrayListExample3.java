import java.util.*;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ArrayListExample3 {
	public static void main(String[] args) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		pointList.add(new Point(0, 0));
		pointList.add(new Point(1, 1));
		pointList.add(new Point(2, 4));
		pointList.add(new Point(3, 9));
		
		for(int i = 0; i < pointList.size(); i++) {
			Point p = pointList.get(i);
			System.out.println("(" + p.x + "," + p.y +")");
		}
	}
}
