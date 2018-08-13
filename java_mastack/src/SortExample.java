import java.util.*;

class Point2 implements Comparable<Point2>{
	int x;
	int y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point2 p) {
		return (this.x + this.y) - (p.x + p.y);
	}
}

public class SortExample {
	public static void main(String[] args) {
		ArrayList<Point2> Point2List = new ArrayList<Point2>();
		Point2List.add(new Point2(0, 8));
		Point2List.add(new Point2(1, 6));
		Point2List.add(new Point2(2, 9));
		Point2List.add(new Point2(3, 3));

		Collections.sort(Point2List);

		for(Point2 p : Point2List) {
			System.out.println("(" + p.x + "," + p.y +")->" + (p.x + p.y));
		}
	}
}
