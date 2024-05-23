package chapter.o3;

import java.awt.Point;
import java.time.LocalDate;

/*
 2、Object: 所有类的超类
 0bject 类是Java 中所有类的始祖， Java 中的每一个类都扩展了Object。
 但是并不需要这样写：
 public class Employee extends Object
 如果没有明确地指出超类，那么理所当然Object就是这个类的超类。
*/

public class MySample02 {
	public static void main(String[] args) {

//		2-1、Object 类型的变量
//		可以使用0bject类型的变量引用任何类型的对象：
		class Employee {
			private static int nextId = 1;

			private int id;
			private String name;
			private double salary;

			public Employee (String n, double s) {
				name = n;
				salary = s;
				id = advanceId();
			}

			public String getName () {
				return name;
			}

			public double getSalary() {
				return  salary;
			}

			public int getId() {
				return  id;
			}

			public static int advanceId() {
				int r = nextId;
				nextId ++;
				return r;
			}
		}

		Object obj = new Employee("Harry Hacker", 35008);
		
//		Object类型的变量只能用于作为任意值的一个泛型容器。
//		要想对其中的内容进行具体的操作，还需要清楚对象的原始类型，并进行相应的强制类型转换：
		Employee e = (Employee) obj;
		
//		在Java 中，只有基本类型不是对象，例如，数值、字符和布尔类型的值都不是对象。
//		所有的数组类型(不管是对象数组还是基本类型的数组)都扩展了0bject 类的类类型。
		
		Employee[] staff =new Employee[10];
		obj = staff;
		obj = new int[10];

//		2-2、equals 方法
//		0bject类中的equals方法用于检测一个对象是否等于另外一个对象。
//		0bject类中实现的equals方法将确定两个对象引用是否相同。
//		这是一个合理的默认行为：如果两个对象相同， 则这两个对象肯定就相等。
//		不过，经常需要基于状态检测对象的相等性，也就是说，如果两个对象有相同的状态，则认为这两个对象是相等的。
		
//		例如，如果两个员工对象的姓名、薪水和雇用日期都一样，就认为它们是相等的
		class Employee01 {
			private String name;
			private double salary;
			private LocalDate hireDay;

			public Employee01 (String n, double s, int year, int month, int day) {
				name =n;
				salary = s;
				hireDay = LocalDate.of(year, month, day);
			}
			
			public boolean equals(Object otherObject) {
				if(this == otherObject) {
					return true;
				}

				if(otherObject == null) {
					return false;
				}

				if(getClass() != otherObject.getClass()) {
					return false;
				}
				
				Employee01 other = (Employee01) otherObject;
				return name.equals(other.name)
						&& salary == other.salary
						&& hireDay.equals(other.hireDay);

			}
		}
		
//		在子类中定义 equals方法时，首先调用超类的 equals。如果检测失败，那么对象就不可能相等。
//		如果超类中的字段都相等，则可以继续比较子类中的实例字段。
		class Manager01 extends Employee01 {
			private double bonus;
			public Manager01 (String n, double s, int year, int month, int day, double bonus) {
				super(n, s, year, month, day);
				this.bonus = bonus;
			}

			public boolean equals(Object otherObject) {
				if (!super.equals(otherObject)) {
					return false;
				}
				Manager01 other  =(Manager01)otherObject;
				return bonus == other.bonus;
			}
		}
		
//		2-3、相等测试与继承
//		如果隐式和显式的参数不属于同一个类， equals 方法将如何处理呢?
//		在前面的例子中，如果发现类不能完全匹配， equals方法就返回 false 。
//		许多程序员喜欢使用 instanceof 进行检测：
//		if(!(otherObject instanceof Employee)) {
//			return false;
//		}
		
//		这样就允许 otherObject 属于一个子类。但是这种方法可能会招致一些麻烦。

//		Java 语言规范要求 equals 方法具有下述性质。
//		1.自反性：对于任何非null引 用x,x.equals(x)应该返回 true。
//		2.对称性：对于任何引用x和y,当且仅当y.equals(x)返回true时，x.equals(y)返回true。
//		3.传递性：对于任何引用x 、y和z,如果x.equals(y)返回true,y,equals(z)返回 true,则x.equals(z)也应该返回 true。
//		4.一致性：如果x和y引用的对象没有发生变化，则反复调用x.equals(y) 应该返回同样的结果。
//		5.对于任意非null引用x,x.equals(null)应该返回false。
		
//		这些规则当然很合理。你肯定不希望类库实现者在查找数据结构中的一个元素时纠结调用x.equals(y)还是调用y.equals(x)。
//		不过，就对称性规则来说，当参数属于不同的类时会有一些微妙的结果。
		Employee01 e01 = new Employee01("Harry Hacker",50000, 1989,10,1);
		Manager01 m01 = new Manager01("Harry Hacker",50000, 1989,10,1, 8000);
		e01.equals(m01);
		
//		这里的e01是一个Employee01对象， m01是一个Manager01对象，并且这两个对象恰好有相同的姓名、 薪水和雇用日期。
//		如果在Employee01, equals使用instanceof进行检测， 则这个调用将返回true。
//		根据对称性规则,m01.equals(e01)也需要返回 true。
		m01.equals(e01);
		
//		这就使得Manager041类陷入困境。这个类的equals方法必须愿意将自己与任何一个 Employee01对象进行比较，而不考虑经理特有的那部分信息!
		
//		下面给出编写完美 equals 方法的技巧：
//		1.将显式参数命名为otherObject,  稍后需要将它强制转换成另一个名为other 的变量。
//		2.检测 this 与otherObject 是否相同：
//			if(this == otherObject) return true;
//		3.检测otherObject是否为null,如果为null,则返回 false。这个检测是必要的。
//			if(otherObject == null) return false;
//		4.比较this与otherObject 的类。 如果equals的语义可以在子类中改变，就使用getClass 检测：
//			if(getClass() != otherObject.getClass()) return false;
//			ClassName other = (ClassName)otherObject;
//			如果所有的子类都有相同的相等性语义，则可以使用instanceof 检测：
//			if(!(otherObject instanceof ClassName other)) return false;
//			注意，如果 instanceof 检测成功，它会把other设置为otherObject。不再需要强制类型转换。
//		5.现在根据相等性概念的要求来比较字段。使用==比较基本类型字段,
//		使用0bjects.equals 比较对象字段。如果所有的字段都匹配，就返回true;否则，返回false。
//			return field1 ==other.field1
//					&& Objects.equals(field2, other.field2)
//					&& ...
//		如果在子类中重新定义 equals,  就要在其中包含一个 super.equals(other) 调用。

//		2-4、toString 方法
//		Object 中还有一个重要的方法，就是 toString方法，它会返回一个字符串，表示这个对象的值。
//		Point类的 toString方法将返回字符串：java.awt.Point [x=10,y=20]
		Point p = new Point(10, 20);
		System.out.println(p.toString());
		
//		绝大多数(但不是全部)toString 方法都遵循这样的格式：首先是类名，随后是一对方括号括起来的字段值。
		class Employee02 {
			private String name;
			private double salary;
			private LocalDate hireDay;

			public Employee02 (String n, double s, int year, int month, int day) {
				name =n;
				salary = s;
				hireDay = LocalDate.of(year, month, day);
			}
			
			public boolean equals(Object otherObject) {
				if(this == otherObject) {
					return true;
				}

				if(otherObject == null) {
					return false;
				}

				if(getClass() != otherObject.getClass()) {
					return false;
				}
				
				Employee01 other = (Employee01) otherObject;
				return name.equals(other.name)
						&& salary == other.salary
						&& hireDay.equals(other.hireDay);
			}

			// 实际上，最好通过调用getClass().getName() 获得类名的字符串，而不要将类名硬编码写到 toString方法中。
			public String toString() {
				// return "Employee02[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay;
				return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
			}
		}
		
//		这样的 toString 方法也适用于子类。
//		设计子类的程序员应该定义自己的 toString 方法，并加入子类的字段。
//		如果超 类使用了getClass().getName(), 那么子类只要调用super.toString()就可以了。
		class Manager02 extends Employee02 {
			private double bonus;
			public Manager02 (String n, double s, int year, int month, int day, double bonus) {
				super(n, s, year, month, day);
				this.bonus = bonus;
			}

			public boolean equals(Object otherObject) {
				if (!super.equals(otherObject)) {
					return false;
				}
				Manager01 other  =(Manager01)otherObject;
				return bonus == other.bonus;
			}
			
			public String toString() {
				return super.toString() + "[bonus=" + bonus + "]";
			}
		}
		
//		现在，Manager02 对象将打印为：Manager02[name=...,salary=...,hireDay=...][bonus=...]
		
//		toString 方法无处不在，这有一个重要的原因：只要对象与一个字符串通过操作符“+”拼接起来，
//		Java 编译器就会自动地调用toString 方法来获得这个对象的字符串描述。

		


	}
}
