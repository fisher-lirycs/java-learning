package chapter.o3;

import java.time.LocalDate;

/*
 1、类、超类和子类
 现在让我们回忆一下在前一章中讨论过的 Employee类。
 假设你在某个公司工作，这个公  司里经理的待遇与普通员工的待遇存在着一些差异。
 不过，当然他们之间也存在着很多相同  的地方，例如，他们都领取薪水。
 只是普通员工在完成本职任务之后仅领取薪水，而经理在  完成了预期的业绩之后还能得到奖金。
 这种情形就需要使用继承。为什么呢?
 因为需要为经理定义一个新类 Manager, 并增加一些新功能，
 但可以重用Employee类中已经编写的部分代码，并保留原来Employee类中的所有字段。
 在Manager与 Employee 之间存在着明显的“is-a” (是)关系，每个经理都是一个员工：
 “is-a” 关系是继承的一个明显特征。
*/

public class MySample01 {
	public static void main(String[] args) {
		
		class Employee {

			private String name = "";
			private double salary;
			private LocalDate hireDay;
			
			public Employee () {
				name = "";
				salary = 0;
			}

			public Employee (String n, double s, int year, int month, int day) {
				name =n;
				salary = s;
				hireDay = LocalDate.of(year, month, day);
			}
			public String getName() {
				return name;
			}

			public double getSalary() {
				return salary;
			}

			public LocalDate getHireDay(){
				return hireDay;
			}

			public void raiseSalary(double byPercent) {
				double raise = salary * byPercent /100;
				salary += raise;
			}
		}

//		1-1、定义子类
//		可以使用如下代码继承 Employee类来定义Manager 类，这里使用关键字 extends 表示继承：
//		public class Manager extends Employee
//			added methods and fields
//		}
		
//		关键字 extends 指示正在构造的新类派生于一个已存在的类。
//		这个已存在的类称为超类、基类或父类
//		新类称为子类或派生类
		
//		尽管Employee类是一个超类，但并不是因为它优于子类或者拥有比子类更多的功能。
//		实际上恰恰相反，子类比超类拥有的功能更多。
		
		class Manager01 extends Employee {
			private double bonus;
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
		}
		
//		如果有一个 Manager 对象，就可以使用 setBonus 方法。
		Manager01 boss = new Manager01();
		boss.setBonus(50000);
		
//		如果有一个 Employee 对象，则不能使用setBonus方法，这不是 Employee类中定义的方法。
//		Employee employee = new Employee();
//		employee.setBonus(50000);
		
//		尽管在Manager类中没有显式地定义getName 和 getHireDay 等方法，
//		但是可以对Manager 对象使用这些方法，这是因为Manager类自动地继承了超类 Employee 中的这些方法。
		
//		每个 Manager 对象有4个字段： name、salary、hireDay 和 bonus。
//		其中， name、salary 和 hireDay字段是从超类得来的。

//		通过扩展超类定义子类的时候，只需要指出子类与超类的不同之处。
//		因此，在设计类的时候，应该将最一般的方法放在超类中，而将更特殊的方法放在子类中，

//		1-2、覆盖方法
//		超类中的有些方法对子类 Manager并不一定适用。
//		具体来说， Manager类中的 getSalary 方法 应该返回薪水和奖金的总和。
//		需要提供一个新的方法来覆盖(override)超类中的这个方法：
		class Manager02 extends Employee {
			private double bonus;
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			
//			public double getSalary() {
//			
//			}
		}
		
//		应该如何实现这个方法呢?乍看起来似乎很简单，只要返回 salary 和 bonus 字段的总和就可以了：
		class Manager03 extends Employee {
			private double bonus;
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			
//			public double getSalary() {
//				return salary + bonus;
//			}
		}
//		
//		不过，这样做是不行的。
//		只有Employee方法能直接访问Employee类的私有字段。
//		Manager类的 getSalary方法不能直接访问salary字段。
//		如果Manager类的方法想 要访问那些私有字段，就必须像所有其他方法一样使用公共接口，
//		在这里就是要使用 Employee类中的公共方法 getSalary。
		class Manager04 extends Employee {
			private double bonus;
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			
			public double getSalary() {
				double baseSalary = getSalary();
				return baseSalary + bonus;
			}
		}
		
//		这段代码仍然有问题。
//		问题出现在调用 getSalary 的语句上，它只是在调用自身，
//		这是因为 Manager类也有一个getSalary 方法(就是我们正在实现的这个方法),
//		所以这条语句将会导致无限地调用自己，直到整个程序最终崩溃。
		
//		我们希望调用超类Employee中的getSalary方法，而不是当前类的这个方法。
//		为此，可以使用特殊的关键字 super解决这个问题：
		class Manager05 extends Employee {
			private double bonus;
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			
			public double getSalary() {
				double baseSalary = super.getSalary();
				return baseSalary + bonus;
			}
		}
		
//		子类可以增加字段、增加方法或覆盖超类的方法，
//		不过，继承绝对不会删除任何字段或方法。

//		1-3、子类构造器
//		最后，我们来提供一个构造器。
		class Manager06 extends Employee {
			private double bonus;
			
			public Manager06 (String name, double salary, int year, int month, int day) {
				super(name, salary, year, month, day);
				bonus = 0;
			}
			// 这里的关键字 super具有不同的含义。
			// 是“调用超类 Employee 中带有 n、s、year、month 和 day 参数的构造器”的简写形式。
			// 由于Manager类的构造器不能访问Employee类的私有字段，所以必须通过一个构造器来初 始化这些私有字段。
			// 可以利用特殊的 super语法调用这个构造器。
			// 使用super调用构造器的语句必须是子类构造器的第一条语句。
			// 如果构造子类对象时没有显式地调用超类的构造器，那么超类必须有一个无参数构造器。
			// 这个构造器要在子类构造之前调用。

			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			
			public double getSalary() {
				double baseSalary = super.getSalary();
				return baseSalary + bonus;
			}
		}

		// 重新定义 Manager 对象的 getSalary方法之后，奖金就会自动地添加到经理的薪水中。
		Manager06 boss06 = new Manager06("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		// 下面定义一个包含3个员工的数组：
		var staff = new Employee[3];
		
		// 在数组中混合填入经理和员工：
		staff[0] = boss06;
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
		// 输出每个人的薪水：
		for(Employee e : staff) {
			System.out.println(e.getName() + " " + e.getSalary());
		}
		
		// 运行这条循环语句将会输出以下数据：
		// Carl Cracker 85000.0
		// Harry Hacker 50000.0
		// Tommy Tester 40000.0
		
		// 这里的 staff[1] 和 staff[2] 仅输出了基本薪水，这是因为它们是 Employee对象，
		// 而 staff[0]是一个 Manager 对象，它的 getSalary 方法会将奖金与基本薪水相加。
		
		// 令人赞叹的是，以下调用
		// e.getSalary()
		// 会选出正确的getSalary方法。
		// 需要指出，尽管这里将e 声明为Employee类型，
		// 但实际上e 既可以引用 Employee类型的对象，也可以引用Manager类型的对象。
		// 当e 引 用Employee对象时， e.getSalary()调用的是 Employee类中的 getSalary方法；
		// 当e 引 用Manager对象时，e.getSalary()调用的则是 Manager类中的 getSalary 方法。
		// 虚拟机知道e 实际引用的对象类型，因此能够调用正确的方法。

//		1-4、继承层次结构
//		继承并不仅限于一个层次。
//		例如，可以由Manager类派生Executive类。
//		由一个公共超类派生出来的所有类的集合称为继承层次结构
//		通常，一个祖先类可以有多个子孙 链。

//		1-5、多态
//		有一个简单的规则可以用来判断是否应该将数据设计为继承关系，这就是 “is-a”规则
//		它指出子类的每个对象也是超类的对象。
//		例如，每个经理都是员工，因此，将Manager类设计为 Employee 类的子类是有道理的；
//		反之则不然，并不是每一名员工都是经理。
		
//		“is-a”规则的另一种表述是替换原则
//		它指出程序中需要超类对象的任何地方都可以使用子类对象替换。
		
//		例如，可以将子类的对象赋给超类变量。
		Employee e;
		e = new Employee("Harry Hacker",50000,1989,10,1);
		e = new Manager06("Carl Cracker", 80000, 1987, 12, 15);
		
//		在Java 程序设计语言中，对象变量是多态的
		staff[0] = boss06;
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
//		这个例子中、我们就利用了这个替换原则：
//		变量staff[0] 与 boss引用同一个对象。
//		但编译器只将staff[0]看成是一个 Employee 对象。
		
//		可以这样调用
		boss06.setBonus(5000);
//		但不能这样调用
//		staff[0].setBonus(5000);
//		这是因为staff[0]声明的类型是 Employee,而 setBonus 不是 Employee类的方法。
//		不过，不能将超类的引用赋给子类变量。例如，下面的赋值是非法的：
//		Manager06 m = staff[1];

//		1-6、阻止继承：final类和方法
//		有时候，我们可能希望阻止人们定义某个类的子类。不允许扩展的类被称为final 类。
//		如果在类定义中使用了 final 修饰符，就表明这个类是 final 类。
		final class Executive01 extends Employee {
		}
		
//		也可以将类中的某个特定方法声明为final。
//		如果这样做，那么所有子类都不能覆盖这个方法(final类中的所有方法自动地成为final方法)。
		class Employee01 {
			String name = "";
			
			public final String getName() {
				return name;
			}
		}
		
//		将方法或类声明为final只有一个原因：确保它们不会在子类中改变语义。
//		例如， Calendar类中的 getTime和 setTime方法都声明为 final。
//		这表明 Calendar类的设计者负责实现 Date类与日历状态之间的转换，而不允许子类来添乱。

//		1-7、强制类型转换
//		将一个类型强制转换成另外一个类型的过程称为强制类型转换
//		Java程序设计语言为强制类型转换提供了一种特殊的表示法。例如：
		double x = 3.1415926;
		int nx = (int) x;
//		将表达式x 的值转换成整数类型，舍弃了小数部分。
		
//		正像有时候需要将浮点数转换成整数一样，可能还需要将某个类的对象引用转换成另外 一个类的对象引用。
//		再以混合有 Employee 和 Manager 对象的数组为例：
		staff[0] = new Manager06("Harry Hacker",50000,1989,10,1);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
//		要完成对象引用的强制类型转换，转换语法与数值表达式的强制类型转换类似。
//		用一对圆括号将目标类名括起来，并放置在需要转换的对象引用之前
		Manager06 boss666 = (Manager06)staff[0];
		
		Manager06 boss66 = (Manager06)staff[1]; //ERROR
//		运行这个程序时，Java 运行时系统将注意到你的承诺不符，并产生一个 ClassCastException 异常。
//		因此，应该养成这样一个良好的编程习惯：在进行强制类型转换之前，先查看是否能够成功地转换。为此只需要使用instanceof作符。
		if( staff[1] instanceof Manager06) {
			boss66 = (Manager06)staff[1];
		}
		
//		综上所述：
//		●只能在继承层次结构内进行强制类型转换。
//		●在将超类强制转换成子类之前，应该使用instanceof 进行检查。
//		一般情况下，最好尽量少用强制类型转换和instanceof 操作符。

//		1-8、instanceof 模式匹配
		if(staff[1] instanceof Manager06) {
			Manager06 boss066 = (Manager06) staff[1];
			boss066.setBonus(5000);
		}
//		代码实在有些冗长。
//		在Java16中，还有一种更简便的方法。可以直接在 instanceof 测试中声明子类变量：
		if(staff[1] instanceof Manager06 boss066) {
			boss066.setBonus(5000);
		}
//		如果staff[1]是Manager类的一个实例，则变量boss设置为staff[1],可以将其作为一个 Manager。这样可以跳过强制类型转换。
//		如果staff[1]并非引用一个 Manager,那么不会设置boss066, instanceof 操作符会生成 false值。这样一来，将跳过if 语句的主体。
		
//		1-9、受保护访问
//		最好将类中的字段标记为private, 而方法标记为public
//		任何声明为 private的特性都不允许其他类访问。
//		这对于子类也同样适用，即子类也不能访问超类的私有字段。
//		不过，有些时候，你可能希望限制超类中的某个方法只允许子类访问，或者更少见地，可能希望允许子类的方法访问超类的某个字段。
//		在这种情况下，可以将一个类特性(方 法或字段)声明为受保护(protected) 。
//		如果将超类 Employee中的 hireDay字段声明为 protected,而不是 private, Manager 方法就可以直接访问这个字段。
		
//		在Java 中，受保护字段只能由同一个包中的类访问。
		
//		下面对 Java 中的4个访问控制修饰符做个小结：
//		1.仅本类可以访问——private。
//		2.可由外部访问——public。
//		3.本包和所有子类可以访问——protected。
//		4.本包中可以访问——默认(很遗憾),不需要修饰符。




	}
}
