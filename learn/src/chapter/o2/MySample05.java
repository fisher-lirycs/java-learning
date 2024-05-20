package chapter.o2;

/*
 5、对象构造
 前面已经学习了如何编写简单的构造器来定义对象的初始状态。
 不过，由于对象构造非常重要，所以Java提供了多种编写构造器的机制。
*/

public class MySample05 {
	public static void main(String[] args) {
//		5-1、重载
//		有些类有多个构造器。例如，可以如下构造一个空的 StringBuilder 对象：
		var messages = new StringBuilder();
//		或者，可以指定一个初始字符串：
		var todolist = new StringBuilder("Todo:");
		
//		这种功能叫作重载。如果多个方法有相同的方法名但有不同的参数，便出现了重载。
//		编译器用各个方法首部中的参数类型与特定方法调用中所使用的值类型进行匹配，来选出正确的方法。
//		如果编译器无法匹配参数，就会产生编译时错误
		
//		5-2、默认字段初始化
//		如果在构造器中没有显式地为一个字段设置初始值，就会将它自动设置为默认值：
//			数值将：θ
//			布尔值：false
//			对象引用：null

//		5-3、默认字段初始化
//		很多类都包含无参数的构造器，由无参数构造器创建对象时，对象的状态会设置为适当的默认值。
//		例如，以下是 Employee类的一个无参数构造器：
//		public Employee() {
//			name = "";
//			salary = 0;
//			hireDay = LocalDate.now();
//		}

//		如果你写的类没有构造器，就会为你提供一个无参数构造器。这个构造器将所有的实例字段设置为相应的默认值。
//		Employee01
//		public Employee (String n, double s, int year, int month, int day) 
//		对于这个类，构造默认的员工就是不合法的。
//		var e= new Employee();
		
//		5-4、显式字段初始化
//		通过重载类的构造器方法，可以采用多种形式设置类实例字段的初始状态。
//		不论调用哪个构造器，每个实例字段都要设置为一个有意义的初始值
		
//		可以在类定义中直接为任何字段赋值, 在执行构造器之前完成这个赋值。
		class Employee01 {
			private String name ="";
		}

//		初始值不一定是常量值。在下面的例子中，就是利用方法调用初始化一个字段。
//		考虑以下Employee 类，其中每个员工有一个 id 字段。可以使用以下方式进行初始化：
		class Employee02 {
			private static int nextId;
			private int id = advanceId();

			private static int advanceId() {
				int r = nextId;
				nextId ++;
				return r;
			}
		}
	}

//	5-5、调用另一个构造器
//	如果构造器的第一个语句形如 this(…),这个构造器将调用同一个类的另一个构造器。
//	public Employee(double s)
//		//calls Employee(String, double)
//		this("Employee#" + nextId, s);
//		nextId ++;
//	}
//	当调用new Employee(60000)时 ，Employee(double)构造器将调用Employee(String,double)构造器。
//	采用这种方式使用 this 关键字非常有用，这样只需要写一次公共构造代码。

//	5-6、初始化块
//	前面已经介绍过两种初始化实例字段的方法：
//	●在构造器中设置值；
//	●在声明中赋值。

//	Java 还有第三种机制，称为初始化块
//	在一个类的声明中，可以包含任意的代码块。构造这个类的对象时，这些块就会执行。
//	Employee02
//	在这个示例中，无论使用哪个构造器构造对象，id 字段都会在对象初始化块中初始化。
//	首先运行初始化块，然后才运行构造器的主体部分。
//	这种机制不是必需的，也不常见。通常会直接将初始化代码放在构造器中
	
//	由于初始化实例字段有多种途径，所以列出构造过程的所有路径可能让人很费解。下面是调用构造器时的具体处理步骤：
//	1.如果构造器的第一行调用了另一个构造器，则基于所提供的参数执行第二个构造器。
//	2.否则，
//		a) 所有实例字段初始化为其默认值(0、false 或 null)。
//		b) 按照在类声明中出现的顺序，执行所有字段初始化方法和初始化块。
//	3.执行构造器主体代码。


	
//	可以通过提供一个初始值，或者使用一个静态的初始化块来初始化静态字段。
//	private static int nextId =1;
	
//	如果类的静态字段需要很复杂的初始化代码，那么可以使用静态的初始化块。
//	将代码放在一个块中，并标记关键字 static 。 
//	下面是一个示例。我们希望将员工ID 的起始值赋为一个小于10000的随机整数。
//	private static Random generator =new Random();
//	static {
//		nextId = generator.nextInt(10000);
//	}

	
//	在类第一次加载的时候，会完成静态字段的初始化。
//	与实例字段一样，除非将静态字段 显式地设置成其他值，否则默认的初始值为0、false 或 null 。
//	所有的静态字段初始化方法以及静态初始化块都将依照类声明中出现的顺序执行。
	
	
//	Employee
//	●重载构造器；
//	●用this(…)调用另一个构造器；
//	●无参数构造器；
//	●对象初始化块；
//	●静态初始化块；
//	●实例字段初始化。
}
