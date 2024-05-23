package chapter.o3;

/*
 5、参数个数可变的方法

*/

public class MySample05 {
	public static void main(String[] args) {
//		可以提供参数个数可变的方法
//		方法： printf
		int n = 5;
		System.out.printf("%d", n);
		System.out.printf("%d %s", n, "widgets");
		
//		这两条语句都调用同一个方法，不过一个调用有2个参数，另一个调用有3个参数。
//		printf  方法是这样定义的：
//	    public PrintStream printf(String format, Object ... args) {
//	        return format(format, args);
//	    }
		
//		这里的省略号 … 是Java 代码的一部分，它表明这个方法可以接收任意数量的对象(除format参数以外)。
//		printf方法接收两个参数， 一个是格式字符串，另一个是0bject[]数组，其中保存着所有其他参数(如果调用者提供的是整数或者其他基本类型的值，则会把它们自动 装箱为对象)。

		
//		自己也可以定义有可变参数的方法，可以为参数指定任意类型，甚至是基本类型。
		double m = max(3.1, 40.4, -5);
//		编译器将 new double[]{3.1,40.4,-5}传递给 max 函数。
	}

	public static double max (double ... values) {
		double largest = Double.NEGATIVE_INFINITY;
		for (double x : values) {
			if (x > largest) {
				largest = x;
			}
		}
		return largest;
	}
}
