package chapter.o2;

/*
 6、记录

*/

public class MySample06 {
	public static void main(String[] args) {
//		有时，数据就只是数据，而面向对象程序设计提供的数据隐藏有些碍事。
//		考虑一个类Point, 这个类描述平面上的一个点，有x 和y 坐标。
		class Point {

			private final double  x;
			private final double y;
			
			public Point(double x, double y){
				this.x = x;
				this.y =y;
			}
			
			public double getX() {
				return x;
			}
			public double getY(){
				return y;
			}
			
			public String toString(){
				return "Point[x=%d,y=%d]".formatted(x, y);
			}
		}
//		将来不会改变Point的实现
//		为了更简洁地定义这些类，JDK14引入了一个预览特性：“记录”。
//		最终版本在JDK 16中发布。

//		6-1、记录概念
//		记录 (record) 是一种特殊形式的类，其状态不可变，而且公共可读。
//		可以如下将 Point定义为一个记录：
		record Point01(double x,double y){
			
		}
//		其结果是有以下实例字段的类：
//		private final double x;
//		private final double y;

//		一个记录的实例字段称为组件 (component)。
//		这个类有一个构造器：
//		Point(double x, double y)
//		和以下访问器方法：
//		public double x()
//		public double y()
//		注意，访问器方法名为x 和 y, 而不是getX和getY 
		
//		除了字段访问器方法，每个记录有3个自动定义的方法：toString 、equals 和 hashCode。
		
//		可以为一个记录增加你自己的方法：
		record  Point02(double x, double y) {
			public double distanceFromOrigin() {
				return Math.hypot(x,y);
			}
		}

//		与所有其他类一样，记录可以有静态字段和方法：
		record Point03(double x, double y) {
			public static Point ORIGIN = new Point(0,0);
			public static double distance(Point p, Point q) {
				return Math.hypot(p.x - q.x, p.y - q.y);
			}
		}
		
//		不过，不能为记录增加实例字段：
//		record Point(double x, double y) {
//			private double r; //ERROR
//		}
		
		
//		6-2、构造器：标准、自定义和简洁
//		自动定义地设置所有实例字段的构造器称为标准构造器
//		还可以定义另外的自定义构造器
//		这种构造器的第一个语句必须调用另一个构造器，所以最终会调用标准构造器。
		record Point04(double x, double y) {
			public Point04(){
				this(0, 0);
			}
		}
//		这个记录有两个构造器：标准构造器和一个生成原点的无参数构造器。
		
//		如果标准构造器需要完成额外的工作，那么可以提供你自己的实现：
		record Range01(int from, int to) {
			public Range01(int from, int to) {
				if(from <= to) {
					this.from = from;
					this.to  = to;
				} else {
					this.from = to;
					this.to =from;
				}
			}
		}
		
		// 实现标准构造器时，建议使用一种简洁形式,不用指定参数列表
		record Range02(int from, int to) {
			public Range02 {
				if(from > to) {
					int temp = from;
					from = to;
					to = temp;
				}
			}
		}

	}
}
