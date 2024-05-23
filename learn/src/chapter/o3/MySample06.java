package chapter.o3;

/*
 5、抽象类

*/

public class MySample06 {
	public static void main(String[] args) {
//		如果自下而上在类的继承层次结构中上移，那么位于上层的类更具有一般性， 也可能更加抽象。
//		从某种角度看，祖先类更有一般性，人们只将它作为派生其他类 的基类，而不是用来构造你想使用的特定实例。
		
//		例如，考虑扩展 Employee类层次结 构。
//		员工是一个人，学生也是一个人。
//		下面扩展我们的类层次结构来加入类Person和类 Student。

//		为什么要那么麻烦提供这样一个高层次的抽象呢?
//		每个人都有一些属性，如姓名。学生与员工都有姓名，通过引入一个公共的超类，我们就可以把 getName 方法放在继承层次结构中更高的一层。
		
//		现在，再增加一个 getDescription 方法，它可以返回对一个人的简短描述，例如
//		an employee with a salary of 550,000.00
//		a student majoring in computer science

//		在 Employee类和 Student类中实现这个方法很容易。
//		但是在Person类中你能提供什么信息呢?
		
//		除了姓名之外， Person类对这个人一无所知。
//		当然，可以实现Person.getDescription()来返 回一个空字符串。
		
//		不过还有一个更好的方法，如果使用abstract 关键字，这样就根本不需要实现这个方法了。
//		public abstract String getDescription();
		
//		为了提高程序的清晰性，包含一个或多个抽象方法的类本身必须被声明为抽象的。
//		除了抽象方法之外，抽象类还可以包含字段和具体方法。
//		例如， Person类还保存着一个人的姓名，另外有一个返回姓名的具体方法。

		abstract class Person{
			private String name;
			
			public Person(String name) {
				this.name = name;
			}
			
			public abstract String getDescription();
			
			public String getName() {
				return name;
			}
		}
		
//		抽象方法相当于子类中实现的具体方法的占位符。
//		扩展一个抽象类时，可以有两种选择。
//		一种是在子类中保留抽象类中的部分或所有抽象方法仍未定义，这样就必须将子类也标记为抽象类；
//		另一种做法是定义全部方法，这样一来，子类就不再是抽象的。
		class Student extends Person {
			private String major;
			public Student(String name, String major) {
				super(name);
				this.major = major;
			}
	
			public String getDescription() {
				return"a student majoring in" + major;
			}
		}
		
//		即使不含抽象方法，也可以将类声明为abstract。
//		抽象类不能实例化。也就是说，如果将一个类声明为abstract,就不能创建这个类的对象。
//		new Person("Vince Vu");
		
//		仍然可以创建一个抽象类的对象变量,但是这样一个变量只能引用非抽象子类的对象。
		Person p = new Student("Vince Vu", "Economics");
		
//		Student类定义了getDescription方法。因此，在Student类中的全部方法都是具体的，这个类不再是抽象类。

		p.getDescription();
//		这不是调用了一个没有定义的方法吗?
//		由于不可能构造抽象类 Person 的对象 所以变量p 永远不会引用Person 对象，
//		而总是引用一个具体子类的对象。这些对象中都定义了getDescription 方法。
		
//		是否可以干脆省略Person超类中的抽象方法，而仅在Employee 和 Student 子类中定义 getDescription方法呢?
//		如果这样做，就不能在变量p 上调用getDescription方法了。编译器只允许调用在类中声明的方法。
	}
}
