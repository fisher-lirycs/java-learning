package chapter.o4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.Timer;

import chapter.o4.interfaces.Employee;

/*
 1、接口
*/

public class Interfaces {
	public static void main(String[] args) {
//		1-1、接口的概念
//		在Java程序设计语言中，接口不是类，而是对希望符合这个接口的类的一组需求。
		
//		Arrays类中的 sort 方法承诺可以对对象数组进行排序，
//		但要求满足下面这个条件：对象所属的类必须实现 Comparable接口。

//		public interface Comparable {
//			int compareTo(Object other);
//		}

//		在这个接口中，compareTo方法是抽象的，它没有具体实现。
//		任何实现 Comparable接口的 类都需要包含一个 compareTo方法，
//		这个方法必须接受一个0bject参数，并返回一个整数。
		
//		接口中的所有方法都自动是public方法。
		
//		还有一个接口没有明确说明的额外要求：
//		调用x.compareTo(y)的时候，这个compareTo方法实际上必须能够比较两个对象，并返回比较的结果，即x和y哪一个更大。
//		当x小于y时，返回一个负数；当x 等于y 时，返回0;否则返回一个正数。
		
//		接口绝不会有实例字段
		
//		假设希望使用Arrays类的 sort 方法对 Employee 对象数组进行排序，
//		Employee类就必须实现Comparable接口。
		
//		为了让类实现一个接口，需要完成下面两个步骤：
//		1.将类声明为实现给定的接口。
//		2.对接口中的所有方法提供定义。
		
//		要声明一个类实现某个接口，需要使用关键字 implements:
//		Employee类需要提供 compareTo方法。
//		假设我们希望根据员工的薪水进行比较。以下是 compareTo 方法的一个实现：
		class Employee01 implements Comparable {
			double salary;
			public int compareTo(Object otherObject) {
				Employee01 other = (Employee01)otherObject;
				return Double.compare(salary, other.salary);
			}
		}

//		对Object 参数进行强制类型转换总是让人感觉不太顺眼，
//		以为泛型 Comparable 接口提供一个类型参数。
		class Employee02 implements Comparable<Employee02> {
			double salary;
			public int compareTo(Employee02 other) {
				return Double.compare(salary, other.salary);
			}
		}
		
		// EmployeeSortTest.java

//		1-2、接口的属性
//		接口不是类。具体来说，不能使用 new操作符实例化一个接口：
//		x = new Comparable();//ERROR
		
//		不过，尽管不能构造接口对象，但仍然能声明接口变量：
		Comparable x;
		
//		接口变量必须引用实现了这个接口的一个类对象：
		x = new Employee("Harry Hacker", 35000);

//		如同使用instanceof 检查一个对象是否属于某个特定类一样，
//		也可以使用instanceof 检查一个对象是否实现了某个特定的接口：
		if(x instanceof Comparable){
			
		}
		
//		与建立类的继承层次结构一样，也可以扩展接口。
		interface Moveable {
			void move(double x, double y);
		}
		
//		可以假设一个名为Powered的接口扩展了以上Moveable 接口：
//		interface Powered extends Moveable {}
		
//		虽然接口中不能包含实例字段，但是可以包含常量。
//		接口中的方法都自动为public,类似地，接口中的字段总是 public static final。
		interface Powered extends Moveable {
			double SPEED_LIMIT = 95;
			double milesPerGallon();
		}
		
//		尽管每个类只能有一个超类，但可以实现多个接口。
//		Java 程序设计语言有一个非常重要的内置接口，名为Cloneable
//		如果你的类实现了这个Cloneable接口，0bject 类中的clone方法就可以创建你 的类对象的一个完全副本。
//		果你希望自己设计的类既能够克隆又能够比较，只要实现这两个接口就可以了。
//		可以使用逗号将想要实现的各个接口分隔开。
//		class Employee implements Cloneable, Comparable

		
		
//		1-3、接口与抽象类
//		为什么Java 程序 设计语言的设计者要那么麻烦地引入接口概念呢?
//		为什么不将Comparable直接设计成一个抽象类呢?
		abstract class Comparable {
			public abstract int compareTo(Object other);
		}
		
//		这样一来， Employee类只需要扩展这个抽象类，并提供compareTo 方法：
//		class  Employee  extends  Comparable {
//			public int compareTo(0bject other){...}
//		}
		
//		每个类只能扩展一个类。
//		假设 Employee类已经扩展了另一个类，例如 Person,它就不能再扩展第二个类了。
//		class Employee extends Person,Comparable //ERROR
//		但每个类可以实现任意多个接口，如下所示：
//		class Employee extends Person implements Comparable //OK


//		1-4、静态和私有方法
//		在Java8中，允许在接口中增加静态方法。
//		理论上讲，没有任何理由认为这是不合法的。
//		只是这似乎有违于将接口作为抽象规范的初衷。
		
//		通常的做法都是将静态方法放在伴随类中。
//		在标准库中，你会看到成对出现的接口和实用工具类，如 Collection/Collections 或 Path/Paths
		
//		在Java9中，接口中的方法可以是private方法。
//		由于私有方法只能在接口本身的方法中使用，所以它们的用途很有限

		
		
//		1-5、默认方法
//		可以为任何接口方法提供一个默认实现。必须用default 修饰符标记这样一个方法。
		interface Comparable01<T> {
			default int  compareTo(T other){
				return 0;
			}
		}
		
//		这并没有太大用处，因为 Comparable的每一个具体实现都会覆盖这个方法。
		
//		不过 有些情况下，默认方法可能很有用。
//		有一个Iterator接口，用于访问一个数据结构中的元素。
//		这个接口声明了一个remove方法，
		
		interface Iterator<E> {
			boolean hasNext();
			
			E next();
			
			default void remove() throws Exception{
				throw new Exception("remove");
			}
		}
		
//		如果你要实现一个迭代器，就需要提供 hasNext 和 next 方法。
//		这些方法没有默认实现：它们依赖于你要遍历访问的数据结构。
//		如果你的迭代器是只读的，就不用操心实现remove方法 。


//		默认方法可以调用其他方法。
//		例如，Collection接口可以定义一个便利方法：
		interface Collection {
			int size();
			default boolean isEmpty(){
				return   size() == 0;
			}
		}
//		这样实现Collection的程序员就不用再操心实现isEmpty方法了。


//		1-6、解决默认方法冲突
//		如果先在一个接口中将一个方法定义为默认方法，然后又在超类或另一个接口中定义了 同样的方法，会发生什么情况?
//		1.超类优先。如果超类提供了一个具体方法，同名而且有相同参数类型的默认方法会被忽略。
//		2.接口冲突。如果一个接口提供了一个默认方法，另一个接口提供了一个同名而且参数类型相同的方法(不论是否是默认方法),必须覆盖这个方法来解决冲突。
		interface Person {
			default String getName() {
				return"";
			};
		}
		
		interface Named {
			default String getName() {
				return getClass().getName() + "_" + hashCode();
			}
		}

//		如果有一个类同时实现了这两个接口会怎么样呢?
//		class Student implements Person, Named {
//			
//		}
		
//		这个类会继承Person和 Named接口提供的两个不一致的getName方法。
//		并不是从中选择一 个，Java 编译器会报告一个错误，让程序员来解决这个问题
//		需要在Student类中提供一个 getName 方法即可。在这个方法中，可以选择两个冲突方法中的一个
		class Student implements Person, Named {
			public String getName() {
				return Person.super.getName();
			}
		}


//		如果Named接口没有为getName提供默认实现：
//		interface Named {
//			String getName() {
//				return getClass().getName() + "_" + hashCode();
//			}
//		}
		
//		两个接口如何冲突并不重要。如果至少有一个接口提供了一个实现，编译器就会报告错误
		
		
//		一个类扩展了一个超类， 同时实现了一个接口，并从超类和接口继承了相同的方法。
//		class Student extends Person implements Named {}
//		在这种情况下，只会考虑超类方法，接口的所有默认方法都会被忽略。

		
		
		
//		1-7、接口与回调
//		回调(callback) 是一种常见的程序设计模式。在这种模式中，可以指定某个特定事件发 生时应该采取的动作。
//		在 java.swing 包中有一个Timer类，如果希望经过一定时间间隔就得到通知，Timer类就很有用。
		
//		构造定时器时，需要设置一个时间间隔，并告诉定时器经过这个时间间隔时要做些什么。
//		定时器需要知道要调用哪一个方法。它要求你指定一个类的对象，这个类要实现 java.awt.event包的ActionListener接口。下面是这个接口：
//		interface ActionListener {
//			void actionPerformed(ActionEvent event);
//		}
		
//		当达到指定的时间间隔时，定时器就调用actionPerformed方法。
//		假设你希望每秒打印一条消息 “At the tone, the time is...”, 然后响一声，
//		那么可以定义一个实现ActionListener接口的类，然后将想要执行的语句放在actionPerformed方法中。
		
		class TimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
		
//		需要注意 actionPerformed 方法的 ActionEvent 参数。这个参数提供了事件的相关信息.
		
//		接下来，构造这个类的一个对象，并将它传递到Timer构造器。
		var listener = new TimePrinter();
		Timer t = new Timer(1000, listener);
		
//		Timer 构造器的第一个参数是一个时间间隔(单位是毫秒),即经过多长时间通知一次。
//		启动定时器：
		t.start();


//		1-8、Comparator 接口
//		我们已经了解了如何对一个对象数组进行排序，前提是这些对象是实现了 Comparable接口的类的实例
//		例如，可以对一个字符串数组排序，因为String 类实现了 Comparable<String>,  而且 String.compareTo 方法可以按字典顺序比较字符串。
		
//		现在假设我们希望按长度递增的顺序对字符串进行排序，而不是按字典顺序进行排序。
//		肯定不能让String类用两种不同的方式实现 compareTo方法,更何况， String类也不应由我们来修改。
//		要处理这种情况，Arrays.sort方法还有第二个版本，接受一个数组和一个比较器(comparator)作为参数，比较器是实现了 Comparator 接口的类的实例。
		
//		interface Comparator<T> {
//			int compare(T first, T second);
//		}
		
//		要按长度比较字符串，可以如下定义一个实现 Comparator<String>的类：
		
		class Lengthcomparator implements Comparator<String> {
			public int compare(String first, String second) {
				return  first.length() - second.length();
			}
		}
		
		
//		具体完成比较时，需要建立一个实例：
//		var comp = new Lengthcomparator();
//		if(comp.compare(words[i], words[j])>θ)
//		将这个调用与 words[i].compareTo(words[j])做个比较。这个 compare方法要在比较器对象上调用，而不是在字符串本身调用。
		
//		要对一个数组排序，需要为Arrays.sort方法传入一个 LengthComparator 对象：
		String[] friends = {"Peter", "Paul", "Mary"};
		Arrays.sort(friends, new Lengthcomparator());
	}
}
