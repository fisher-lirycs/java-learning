package chapter.o4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import javax.swing.Timer;


/*
 2、lambda表达式
*/

public class MySample02 {
	public static void main(String[] args) {
//		2-1、为什么引入lambda表达式
//		lambda 表达式是一个可传递的代码块，可以在以后执行一次或多次。
		
//		在之前，已经了解了如何按指定时间间隔完成工作。将这个工作放在一个ActionListener的actionPerformed方法中 ：
		class Worker implements ActionListener {
			public void actionPerformed(ActionEvent event) {
			}
		}

//		想要反复执行这个代码时，可以构造Worker类的一个实例。再把这个实例提交到一个Timer对象 。
//		这里的重点是actionPerformed方法包含希望以后执行的代码。
		
		
//		或者可以考虑如何用一个定制比较器完成排序。
//		如果想按长度而不是默认的字典顺序对字符串进行排序，可以向sort 方法传入一个 Comparator 对象：
		class  LengthComparator implements Comparator<String> {
			public int compare(String first,String second) {
				return first.length() - second.length();
			}
		}
		String[] friends = {"Peter", "Paul", "Mary"};
		Arrays.sort(friends, new LengthComparator());
		
//		compare方法并不是立即调用
//		这两个例子有一些共同点，都是将一个代码块传递到某个目标(一个定时器，或者一个sort 方法)。
//		这个代码块会在将来某个时间调用。
		
//		到目前为止，在Java 中传递一个代码段并不容易，你不能直接传递代码段。
//		Java是一种面向对象语言，所以必须构造一个对象，这个对象的类要有一个方法包含所需的代码。

//		2-2、lambda表达式的语法
//		再来考虑上一节讨论的排序例子。我们传入代码来检查一个字符串是否比另一个字符串短。
//		这里要计算first.length()-second.length()
//		first 和 second 是什么?
//		它们都是字符串。Java是一种强类型语言，所以我们还要指定它们的类型：

//		(String first, String second) -> first.length() - second.length();
		
//		这就是lambda 表达式。lambda 表达式就是一个代码块，以及必须传入代码的所有变量的规范。
		
//		Java 中一种简单的lambda 表达式形式：参数，箭头(->)以及一个表达式。
//		如果代码要完成的计算无法放在一个表达式中，就可以像写方法一样，把这些代码放在{}中，并包含显式的 return 语句。
//		(String first, String second) ->{
//			if(first.length() < second.length()) {
//				return -1;
//			} else if(first.length() > second.length()) {
//				return 1;
//			}
//			else {
//				return 0;
//			}
//		};

//		即使 lambda 表达式没有参数，仍然要提供空括号，就像无参数方法一样：
//		() -> {
//			for(inti=100;i>=θ; i--) {
//				System.out.println(i);
//			}
//		};

//		如果可以推导出一个lambda 表达式的参数类型，则可以忽略其类型。例如：
		Comparator<String> comp = (first, second) -> first.length() - second.length();
		
//		如果方法只有一个参数，而且这个参数的类型可以推导得出，那么甚至还可以省略小括号：
		ActionListener listener = event -> System.out.println("The time is" + Instant.ofEpochMilli(event.getWhen()));
		
//		无须指定lambda 表达式的返回类型。lambda 表达式的返回类型总是会由上下文推导得出
//		(String first, String second) -> first.length() - second.length();

		
		
//		2-3、函数式接口
//		Java 中有很多封装代码块的接口，如ActionListener 或 Comparator。lambda表达式与这些接口是兼容的。
//		对于只有一个抽象方法的接口，需要这种接口的对象时，就可以提供一个lambda表达式。这种接口称为函数式接口
		
		
//		为了展示如何转换为函数式接口，下面考虑Arrays.sort方法。
//		它的第二个参数需要一个Comparator实例，Comparator 就是只有一个方法的接口，所以可以提供一个lambda 表达式：
		Arrays.sort(friends, (first, second) -> first.length() - second.length());
		
//		在底层，Arrays.sort方法会接收实现了Comparator<String>的某个类的对象。
//		在这个对象上调用compare方法会执行这个lambda 表达式的体。
//		这些对象和类的管理完全取决于具体实现， 与使用传统的内联类相比，这样可能要高效得多。
//		最好把lambda 表达式看作是一个函数，而不是一个对象
//		外要接受一个事实： lambda 表达式可以传递到函数式接口。
		
		
//		lambda 表达式可以转换为接口，这一点让lambda 表达式很有吸引力。
		var timer =new Timer(1000, event -> {
			System.out.println("At the tone,the time is" + Instant.ofEpochMilli(event.getWhen()));
			Toolkit.getDefaultToolkit().beep();
		});
		
//		与使用实现了ActionListener 接口的类相比，这段代码的可读性要好得多。
//		在Java中，对lambda 表达式所能做的也只是转换为函数式接口。
	
//		Java API在 java.util.function 包中定义了很多非常通用的函数式接口。
//		其中一个接口 BiFunction<T,U,R>描述了参数类型为T和 U而且返回类型为R的函数。
//		可以把我们的字符串比较 lambda 表达式保存在这个类型的变量中：
		BiFunction<String, String, Integer> comp01 = (first, second) -> first.length() - second.length();
		
//		不过，这对于排序并没有帮助。没有哪个Arrays.sort方法想要接收一个 BiFunction。


//		2-4、方法引用
//		有时， lambda 表达式涉及一个方法。
		var timer01 = new Timer(1000, event -> System.out.println(event));
		
//		如果直接把println方法传递到Timer构造器就更好了。
		var timer02 =new Timer(1000, System.out::println);
		
//		表达式 System.out::println是一个方法引用, 它指示编译器生成一个函 数式接口的实例，覆盖这个接口的抽象方法来调用给定的方法。
//		在这个例子中，会生成一个ActionListener, 它的actionPerformed(ActionEvent e) 方法要调用System.out.println(e)。

//		再来看一个例子，假设你想对字符串进行排序，而不考虑字母的大小写。可以传递以下方法表达式：
		Arrays.sort(friends, String::compareToIgnoreCase);
		
		
//		从这些例子可以看出，要用::操作符分隔方法名与对象或类名。主要有3种情况：
//		1.object::instanceMethod
//		2.Class::instanceMethod
//		3.Class:staticMethod
		
//		在第1种情况下，方法引用等价于一个lambda 表达式，其参数要传递到方法。
//		对于System.out::println, 对象是System.out,所以这个方法表达式等价于x -> System.out.println(x)
		
//		对于第2种情况，第1个参数会成为方法的隐式参数。
//		例如，String::compareToIgnoreCase等同于(x, y) -> x.compareToIgnoreCase(y)
		
//		在第3种情况下，所有参数都传递到静态方法： Math::pow等价于(x, y) -> Math.pow(x, y)
		
		
//		只有当lambda表达式的体只调用一个方法而不做其他操作时，才能把lambda表达式重写为方法引用。
//		s -> s.length() == 0;
//		这里有一个方法调用。但是还有一个比较，所以这里不能使用方法引用。
		
		
//		方法引用示例
//		方法引用	                 等价的lambda表达式               说 明
//
//		separator::equals        x -> separator.equals(x)       这是包含一个对象和一个实例方法的方法表达式。
//																lambda参数作为这个方法的显式参数传入
//		String::trim             x -> x.strip()                 这是包含一个类和一个实例方法的方法表达式。
//																lambda表达式会成为隐式参数
//		String::concat           (x, y) -> x.concat(y)          这里有一个实例方法，不过这一次有一个显式参数。
//																与前面一样，第一个lambda参数会成为隐式参数，其余的参数会传递到方法
//		Integer.valueOf          x -> Integer.value0f(x)        这是包含一个静态方法的方法表达式。
//																lambda参数会传递到这个静态方法
//		Integer.sum              (x, y) -> Integer.sum(x, y)    这是另一个静态方法，不过这一次有两个参数。
//																两个lambda参 数都传递到这个静态方法。
//																Integer.sum方法专门创建为作为一个方法引用。对于lambda表达式，可以直接写作(x, y) -> x + y
//		String::new	             x -> new String(x)				这是一个构造器引用。
//																lambda参数传递到这个构造器
//		String[]::new            n ->new String[n]				这是一个数组构造器引用。
//																lambda参数是数组长度



//		可以在方法引用中使用this参数。
//		例如，this::equals  等同于x -> this.equals(x)。
//		使用super也是合法的。
//		super::instanceMethod
		
//		使用this作为目标，会调用给定方法的超类版本。为了展示这一点，下面给出一个假想的例子：
//		RepeatedGreeter.greet 方法开始执行时，会构造一个Timer,  每次定时器滴答时会执行super::greet 方法。

		class Greeter {
			public void greet(ActionEvent event) {
				System.out.println("Hello,the time is " + Instant.ofEpochMilli(event.getWhen()));
			}
		}

		class RepeatedGreeter extends Greeter {
			public void greet(ActionEvent event) {
				var timer = new Timer(1000, super::greet);
				timer.start();
			}
		}



//		2-5、构造器引用
//		构造器引用与方法引用很类似，只不过方法名为new。
//		Person::new是Person构造器的一个引用。
//		哪一个构造器呢?
		class Person {
			String name = "";
			double salary = 0.0;
			public Person (String name) {
				this.name = name;
			}
			
			public Person (String name, double salary) {
				this.name = name;
				this.salary = salary;
			}
			
			String getName() {
				return"";
			};
		}
		
		ArrayList<String> names = new ArrayList();
		names.add("Peter");
		names.add("Paul");
		names.add("Mary");
		Stream<Person> stream = names.stream().map(Person::new);
		List<Person>people=stream.toList();
//		map方法会为各个列表元素调用Person(String) 构造器。
//		如果有多个 Person构造器，编译器会选择有一个 String参数的构造器，因为它从上下文推导出这是在调用带一个字符串的构造器。
		
//		可以用数组类型建立构造器引用。
//		例如， int[]::new 是一个构造器引用，它有一个参数：数组的长度。这等价于lambda 表达式x -> new int[x]。


//		2-6、变量作用域
//		通常，你可能希望能够在lambda表达式中访问外围方法或类中的变量。
//		public static void repeatMessage(String text, int delay) {
//			ActionListener listener = event -> {
//				System.out.println(text);
//				Toolkit.getDefaultToolkit().beep();
//			};
//			new Timer(delay, listener).start();
//		}
//		来看这样一个调用：
		repeatMessage("Hello", 1000);
		
//		现在来看lambda 表达式中的变量 text 。
//		这个变量并不是在这个lambda表达式中定义的。这是 repeatMessage 方法的一个参数变量。
		
//		这里好像有问题
//		lambda 表达式的代码可能在 repeatMessage调用返回很久以后才运行，而那时这个参数变量已经不存在了。 
//		text 变量是如何保留下来的呢?
		
//		lambda 表达式有3个部分：
//		1.一个代码块；
//		2.参数；
//		3.自由变量的值，这是指非参数而且不在代码中定义的变量。
		
//		在例子中，这个lambda 表达式有一个自由变量 text 。
//		表示lambda表达式的数据 结构必须存储自由变量的值，在这里就是字符串"Hello"。
//		我们说这些值被lambda表达式捕获 
		
//		lambda 表达式可以捕获外围作用域中变量的值。
//		在Java 中，为了确保所捕 获的值是明确定义的，这里有一个重要的限制。
//		在lambda 表达式中，只能引用值不会改变的变量。
//		下面的做法是不合法的：
//		public static void countDown(int start, int delay) {
//			ActionListener listener = event -> {
//				start --;
//				System.out.println(start);
//			};
//			new Timer(delay, listener).start();
//		}
		
//		这个限制是有原因的。如果在 lambda 表达式中更改变量，并发执行多个动作时就会不安全。
		
		
//		如果在lambda 表达式中引用一个变量，而这个变量可能在外部改变，这也是不合法的。
//		public static void repeat(String text, int count) {
//			for(int i=1; i <= count; i++) {
//				ActionListener listener = event -> System.out.println(i + ":" + text);
//			}
//			new  Timer(1000, listener).start();
//		}
//		这里有一条规则： lambda表达式中捕获的变量必须是事实最终变量,事实最终变量是指，这个变量初始化之后就不会再为它赋新值。
		
//		lambda 表达式的体与嵌套块有相同的作用域。
//		这里同样适用命名冲突和遮蔽的有关规则。
//		Path first = Path.of("/usr/bin");
//		Comparator<String> comp05 = (first, second)->first.length() - second.length();
//		在一个方法中，不能有两个同名的局部变量，因此， lambda  表达式中同样也不能有同名的局部变量。


//		在一个 lambda 表达式中使用this 关键字时，是指创建这个 lambda 表达式的方法的 this参数。
		class Application {
			public void init() {
				ActionListener listener = event -> System.out.println(this.toString());
			}
		}
		
//		表达式this.toString()会调用Application对象的toString方法， 而不是ActionListener 实例 的方法。
	}

	public static void repeatMessage(String text, int delay) {
		ActionListener listener = event -> {
			System.out.println(text);
			Toolkit.getDefaultToolkit().beep();
		};
		new Timer(delay, listener).start();
	}

}
