package chapter.o2.mysample06;

import java.util.Date;

public class RecordTest {

	public static void main(String[] args) {
		var p = new Point(3, 4);
		System.out.println("Coordinates of p: " + p.x() + " " + p.y());
		System.out.println("Distance from origin: " + p.distanceFromOrigin());
		
		// Same computation with static field and method
		System.out.println("Distance from origin: " + Point.distance(Point.ORIGIN, p));
		
		// A mutable record
		var pt = new PointInTime(3, 4, new Date());
		System.out.println("Before: " + pt);
		pt.when().setTime(0);
		System.out.println("After: " + pt);
		
		// Invoking a compact constructor
		var r = new Range(4, 3);
		System.out.println("r: " + r);
	}
}
