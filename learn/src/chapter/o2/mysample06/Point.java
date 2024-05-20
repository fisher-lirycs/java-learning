package chapter.o2.mysample06;

record Point(double x, double y) {
	public Point(){
		this(0, 0);
	}
	
	public double distanceFromOrigin() {
		return  Math.hypot(x, y);
	}
	
	public static Point ORIGIN = new Point();
	
	public static double distance(Point p, Point q) {
		return Math.hypot(p.x - q.x, p.y - q.y);
	}
}
