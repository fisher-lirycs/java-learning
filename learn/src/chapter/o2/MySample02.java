package chapter.o2;

import java.time.LocalDate;

import chapter.o2.mysample02.Employee;

/*
 2、自定义类
 在Java 中，没有类就无法做任何事情，
 在之前，我们已经开始编写一些简单的类。
 但是，那些类都只包含一个简单的main方法。
 现在来学习如何编写更复杂的应用所需要的那种主力类。
 通常，这 些类没有 main方法，而有自己的实例字段和实例方法。
 要想构建一个完整的程序，会结合使用多个类，其中只有一个类有 main 方法。

*/

public class MySample02 {
	public static void main(String[] args) {
//		在 Java 中，最简单的类定义形式为：
//		class  ClassName {
//			field1
//			field2
//
//			constructor1
//			constructor2
//
//			method1
//			method2
//		}

		// 2-1、Employee 类
//		下面看一个非常简单的Employee类：learn/src/chapter/o2/mysample02/Employee.java
		
//		我们构造了一个 Employee数组，并填入了3个 Employee 对象：
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("TonyTester", 40000, 1990, 3, 15);
		
		// 接下来，使用Employee类的raiseSalary方法将每个员工的薪水提高5%:
		for(Employee e : staff) {
			e.raiseSalary(5);
		}
		
		// 最后，调用getName方法、getSalary 方法和 getHireDay 方法打印各个员工的信息： 
		for(Employee e : staff) {
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary() + ",hireDay = " + e.getHireDay());
		}
		
		// 2-2、剖析Employee类
		// 下面各小节将对 Employee类进行剖析。
		// 首先从这个类的方法开始。通过查看源代码会发现，这个类包含一个构造器和4个方法：
//		public Employee (String n, double s, int year, int month, int day)
//		public String getName()
//		public double getSalary()
//		public LocalDate getHireDay()
//		public void raiseSalary (double byPercent)
		
		// 这个类的所有方法都被标记为public。
		// 关键字public意味着任何类的任何方法都可以调用这些方法
		
//		接下来，需要注意在 Employee类的实例中有3个实例字段，用来存放将要操作的数据：
//		private String name;
//		private double salary;
//		private LocalDate hireDay;
//		关键字 private 确保只有 Employee类本身的方法能够访问这些实例字段，任何其他类的方法都不能读写这些字段。
//		hireDay 字段是LocalDate类对象的引用。

		// 2-3、从构造器开始
		// 下面先看看 Employee 类的构造器：
//		public Employee (String n, double s, int year, int month, int day) {
//			name =n;
//			salary = s;
//			hireDay = LocalDate.of(year, month, day);
//		}
		
		// 造器与类同名。
		// 构造 Employee类的对象时，构造器会运行，这会将实例字段初始化为所希望的初始状态。
		// 例如，使用下面这个代码创建 Employee 类的一个实例时：
		Employee james = new Employee("James Bond", 100000, 1950, 1, 1);
		// 将如下设置实例字段：
//		name = "James Bond";
//		salary = 100008;
//		hireDay = LocalDate.of(1950, 1, 1); // January 1,1950

//		构造器与其他方法有一个重要的不同。构造器总是结合new操作符来调用。
//		不能对一个已经存在的对象调用构造器来重新设置实例字段。
//		james.Employee("James Bond", 250000, 1958, 1, 1); //ERROR
		
//		● 构造器与类同名。
//		● 每个类可以有一个以上的构造器。
//		● 构造器可以有0个、1个或多个参数。
//		● 构造器没有返回值。
//		● 构造器总是结合new操作符一起调用。

		// 2-4、用var声明局部变量
		// 在 Java  10 中，如果可以从变量的初始值推导出它们的类型，那么可以用var 关键字声明局部变量，而无须指定类型。
		// 例如，可以不这样声明：
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		// 只需要写为：
		var harry01 =new Employee("Harry Hacker", 50000, 1989, 10, 1);
		// 这一点很好，因为这样可以避免重复写类型名 Employee。
		
		// 从现在开始，倘若无须了解JavaAPI 就能从等号右边明显看出类型，在这种情况下我们都 将使用var 表示法。
		// 不过我们不会对数值类型使用var,  如 int 、long 或 double, 这样你就不用当心θ、L 和0.0之间的区别。
		
		// 注意 var 关键字只能用于方法中的局部变量。参数和字段的类型必须声明。

		// 2-5、使用 null 引用
		// 在之前我们已经了解到，对象变量包含一个对象的引用，或者包含一个特殊值null, 后者表示没有引用任何对象。
		// 听上去这是一种处理特殊情况的便捷机制，如未知的名字或雇用日期。不过使用null值时要非常小心。
		// 如果对 null 值应用一个方法，会产生一个 NullPointerException 异常。
		LocalDate rightNow = null;
		String s = rightNow.toString(); //NullPointerException
		
		// 这是一个很严重的错误，类似于“索引越界”异常。
		// 如果你的程序没有“捕获”异常，那么程序就会终止。
		// 正常情况下，程序并不捕获这些异常，而是依赖于程序员从一开始就不要带来异常。
		
		// 定义一个类时，最好清楚地知道哪些字段可能为null 。
		
		// 在我们的例子中，我们不希望name或 hireDay字段为null。
		// (不用担心 salary字段，这个字段是基本类型，所以不可能是null。)
		
		// hireDay字段肯定是非null的，因为它初始化为一个新的LocalDate对象。
		// 但是 name可能为null, 如果调用构造器时为n 提供的实参是null,name  就会是null。
		
		// 对此有两种解决方法。“宽容”方法是把null 参数转换为一个适当的非null值：
//		if (n == null) {
//			name = "unknown";
//		} else {
//			name = n;
//		}

		// Objects 类对此提供了一个便利方法：
//		public Employee (String n, double s, int year, int month, int day) {
//			name =Objects.requireNonNullElse(n, "unknown");
//			salary = s;
//			hireDay = LocalDate.of(year, month, day);
//		}
		
		// “严格”方法则干脆拒绝 null 参数：
//		public Employee (String n, double s, int year, int month, int day) {
//			name = Objects.requireNonNull(n, "The name cannot be null");
//			salary = s;
//			hireDay = LocalDate.of(year, month, day);
//		}
	
//		如果用null 名字构造一个 Employee 对象，就会产生NullPointerException 异常。
//		乍看上去这种补救方法好像不太有用，不过这种方法有两个好处：
//		1.异常报告会提供这个问题的描述。
//		2.异常报告会准确地指出问题所在的位置，否则NullPointerException异常会出现在其他地方，而很难追踪到真正导致问题的构造器参数。

		// 2-6、隐式参数与显式参数
		// 方法会操作对象并访问它们的实例字段。
//		public void raiseSalary(double byPercent) {
//			double raise = salary * byPercent /100;
//			salary += raise;
//		}

//		将调用这个方法的对象的salary 实例字段设置为一个新值。
		harry01.raiseSalary(5);
		
		// 其作用是将 harry01.salary字段的值增加5%。具体地说，这个调用将执行以下指令：
//		double raise = harry01.salary *5 / 100;
//		harry01.salary += raise;
		
//		raiseSalary方法有两个参数。第一个参数称为隐式参数，是出现在方法名前的 Employee类型的对象。
//		第二个参数是位于方法名后面括号中的数值，这是一个显式参数。(有人把隐式参数称为方法调用的目标或接收者。)
		
//		可以看到，显式参数显式地列在方法声明中，例如 double byPercent。隐式参数则没有出现在方法声明中。
//		在每一个方法中，关键字 this 指示隐式参数。如果愿意，可以如下改写 raiseSalary 方法：
//		public void raiseSalary(double byPercent) {
//			double raise = this.salary * byPercent /100;
//			this.salary += raise;
//		}

		// 2-7、封装的优点
		// 最后再仔细看一下非常简单的 getName方法、getSalary 方法和 getHireDay 方法。
//		public String getName() {
//			return name;
//		}
//		
//		public double getSalary() {
//			return salary;
//		}
//
//		public LocalDate getHireDay(){
//			return hireDay;
//		}
		
		// 这些都是典型的访问器方法。由于它们只返回实例字段的值，因此又称为字段访问器
		// 如果将 name、salary 和 hireDay 字段标记为公共，而不是编写单独的访问器方法，不是更容易一些吗?
		// 不过， name 是一个只读字段， 一旦在构造器中设置，就没有办法能够修改这个字段。这样我们可以确保name字段不会受到外界的破坏。
		
		// 虽然 salary 不是只读字段，但是它只能用raiseSalary 方法修改。
		// 具体地，如果这个值出 现了错误，那么只需要调试这个 raiseSalary 方法就可以了。
		// salary 字段是公共的，破坏这个字段值的罪魁祸首有可能出没在任何地方(那就很难调试了)。
		
		// 有些时候，可能想要获得或设置实例字段的值，那么你需要提供下面三项内容：
//		● 一个私有的实例字段；
//		● 一个公共的字段访问器方法；
//		● 一个公共的字段更改器方法。
		
		// 这样做要比提供一个简单的公共实例字段复杂些，但有很多明显的好处。
		// 首先，可以改变内部实现，而不影响该类方法之外的任何其他代码。
		
		// 例如，如果将存储姓名的字段改为：
		// String firstName;
		// String lastName;
		
		// 那么 getName 方法可以改为返回
		// firstName + " " + lastName
		// 这个修改对于程序的其余部分是完全不可见的。
		
		// 第二点好处：更改器方法可以完成错误检查，而只对字段赋值的代码不会费心这么做。
		// 例如， setSalary方法可以检查工资是否小于0。

		// 2-8、基于类的访问权限
		// 方法可以访问调用这个方法的对象的私有数据。
		// 一个类的方法可以访问这个类的所有对象的私有数据，这令很多人感到奇怪。
		// 例如，下面来看用来比较两个员工的equals方法。
//		class Employee
//			public boolean equals (Employee other) {
//				return name.equals(other.name);
//			}
//		}

//		下面是一个典型的调用：
//		if(harry.equals(boss))
		
		// 这个方法访问harry的私有字段，这并不让人奇怪，不过，它还访问了boss的私有字段。
		// 这是合法的，其原因是 boss是 Employee类型的对象，而Employee类的方法可以访问任何Employee类型对象的私有字段。

		// 2-9、私有方法
		// 实现一个类时，我们会将所有实例字段都设置为私有字段，因为公共数据很危险。
		// 大多数方法都是公共的，但在某些情况下，私有方法可能很有用。
		// 望将一个计算代码分解成若干个独立的辅助方法。
		// 通常，这些辅助方法不应该成为公共接口的一部分，这是因为它们往往与当前实现关系非常紧密，或者需要一个特殊协议或调用次序。最好将这样的方法实现为私有方法。
		// 要实现一个私有方法，只需将关键字 public 改为 private 即可。

		// 2-10、final 实例字段
		// 可以将实例字段定义为 final 。 这样的字段必须在构造对象时初始化。
		// 必须 确保在每一个构造器执行之后，这个字段的值已经设置，并且以后不能再修改这个字段。
		// 例如，可以将 Employee类中的 name字段声明为final, 因为在对象构造之后，这个值不会再改变，即没有 setName方法。
//		class Employee {
//			private final String name;
//		}
		
		// final修饰符对于类型为基本类型或者不可变类的字段尤其有用。
		// 对于可变类，使用 final 修饰符可能会造成混乱。
		// private final StringBuilder evaluations;
		// 它在 Employee构造器中初始化为
		// evaluations = new StringBuilder();
		// final 关键字只是表示存储在evaluations 变量中的对象引用不会再指示另一个不同的 StringBuilder 对象。
		// 不过这个对象可以更改：
//		public void giveGoldStar() {
//			evaluations.append(LocalDate.now()+":Gold star!\n");
//		}











	}
}
