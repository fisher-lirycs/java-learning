package chapter.o2;

import chapter.o2.mysample03.Employee;

/*
 3、静态字段与静态方法
 在前面给出的示例程序中， main方法都标记了 static  修饰符。
*/

public class MySample03 {
	public static void main(String[] args) {
//		3-1、静态字段
//		如果将一个字段定义为static,那么这个字段并不出现在每个类的对象中。
//		每个静态字段只有一个副本。可以认为静态字段属于类，而不属于单个对象。
		
//		假设需要为每一个员工分配唯一的标识码，这里为Employee类添加一个实例字段 id 和一个静态字段 nextId:
//		public class Employee {
//			private static int nextId  =1;
//			private int id;
//		}

//		现在，每一个Employee 对象都有自己的id字段，但这个类的所有实例将共享一个 nextId 字段。
//		换句话说，如果有1000个Employee类对象，则有1000个实例字段id,每个对象有一 个实例字段id。
//		但是，只有一个静态字段 nextId。即使没有 Employee对象，静态字段 nextId 也存在。
//		它属于类，而不属于任何单个对象。

//		3-2、静态常量
//		静态变量使用得比较少，但静态常量却很常用。例如，Math类中定义了一个静态常量：PI
//		在程序中，可以用Math.PI 来访问这个常量。
		System.out.println(Math.PI);
		
//		如果省略关键字 static,那么PI就变成了Math类的一个实例字段。
//		也就是说，需要通过Math类的一个对象来访问PI,并且每一个Math对象都有它自己的一个PI副本。

//		3-3、静态方法
//		静态方法是不操作对象的方法。例如，Math类的 pow方法就是一个静态方法。以下表达式：
		Math.pow(2, 3);
//		它并不使用任何Math 对象来完成这个任务。换句话说，它没有隐式参数。
//		可以认为静态方法是没有 this 参数的方法
		
//		Employee类的静态方法不能访问id实例字段，因为它并不操作对象。
//		但是，静态方法可以访问静态字段。
//		public static int advanceId() {
//			int r = nextId;
//			return r;
//		}

//		要调用这个方法，需要提供类名：
		int n = Employee.advanceId();
		
//		下面两种情况可以使用静态方法：
//		●方法不需要访问对象状态，因为它需要的所有参数都通过显式参数提供(例如 Math.pow)。
//		●方法只需要访问类的静态字段(例如 Employee.advanceId)。

//		3-4、main方法
//		需要指出，可以调用静态方而不需要任何对象。
//		同理，main方法也是一个静态方法。
//		main 方法不对任何对象进行操作。事实上，启动程序时还没有任何对象。
//		将执行静态main 方法，并构造程序所需要的对象。


	}
}
