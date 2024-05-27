package chapter.o4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;

/*
 3、内部类
*/

public class InnerClass {
	public static void main(String[] args) {
//		内部类是定义在另一个类中的类。为什么需要使用内部类呢?主要有两个原因：
//		●内部类可以对同一个包中的其他类隐藏。
//		●内部类方法可以访问定义这些方法的作用域中的数据，包括原本私有的数据。


//		3-1、使用内部类访问对象状态
//		内部类的语法相当复杂。
		class TalkingClock {
			private int interval;
			private boolean beep;
			public TalkingClock(int interval, boolean beep) {
				this.interval = interval;
				this.beep = beep;
			}
			
			public void start() {
				var listener = new TimePrinter();
				var timer = new Timer(interval, listener);
				timer.start();
			}

			class TimePrinter implements ActionListener {
				public void actionPerformed(ActionEvent event) {
					System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
					if(beep) {
						Toolkit.getDefaultToolkit().beep();
					}
				}
			}
		}
		
//		TimePrinter类位于TalkingClock类内部。
//		这并不意味着每个TalkingClock都有一个TimePrinter实例字段。
//		TimePrinter类没有实例字段或者名为beep的变量，实际上，beep指示创建这个TimePrinter 的 TalkingClock 对象中的字段。
//		一个内部类方法可以访问自身的实例字段，也可以访问创建它的外部类对象的实例字段。
//		为此，内部类的对象总有一个隐式引用，指向创建它的外部类对象，
//		这个引用在内部类的定义中是不可见的。
//		为了说明这个概念，我们将外部类对象的引用称为 outer 。于是 actionPerformed 方法将等价于以下代码：
//		public void actionPerformed(ActionEvent event) {
//			System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
//			if(outer.beep) {
//				Toolkit.getDefaultToolkit().beep();
//			}
//		}
		
//		外部类的引用在构造器中设置。
//		编译器会修改所有的内部类构造器，添加一个对应外部 类引用的参数。
//		因为TimePrinter类没有定义构造器，所以编译器为这个类生成了一个无参数构造器，生成的代码如下所示：
//		public TimePrinter(TalkingClock clock)
//			outer = clock;
//		}
		
//		在start方法中构造一个TimePrinter 对象后，编译器就会将当前语音时钟的 this 引用传递给这个构造器：


//		3-2、内部类的特殊语法规则
//		上一节中，我们解释了内部类有一个外部类的引用，我们把它叫作outer
//		事实上，这个外部类引用的正规语法还要更复杂一些。表达式OuterClass.this表示外部类引用。
//		public void actionPerformed(ActionEvent event) {
//			if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
//		}
		
//		反过来，可以采用以下语法更加明确地编写内部类对象的构造器：
//		outerObject.new InnerClass(construction parameters)
//		例如，ActionListener listener = this.new TimePrinter();
//		新构造的TimePrinter 对象的外部类引用被设置为创建内部类对象的方法的 this  引用。
//		通常， this.  限定符是多余的。
		
//		不过，也有可能通过显式地命名将外部类引用设置为其他对象。
//		例如，由于TimePrinter 是一个公共内部类，可以为任意的语音时钟构造一个 TimePrinter:
		var jabberer = new TalkingClock(1000, true);
		TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
		
//		需要注意，在外部类的作用域之外，可以这样引用内部类：
//		OuterClass.InnerClass

//		3-3、局部内部类
//		类型TimePrinter的名字只出现了一次：就是在start方法中创建这个类型的对象时使用了一次。
//		在类似这样的情况下，可以在一个方法中局部地定义这个类。
		class TalkingClock02 {
			private int interval;
			private boolean beep;
			public TalkingClock02(int interval, boolean beep) {
				this.interval = interval;
				this.beep = beep;
			}
			
			public void start() {
				class TimePrinter implements ActionListener {
					public void actionPerformed(ActionEvent event) {
						System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
						if(beep) {
							Toolkit.getDefaultToolkit().beep();
						}
					}
				}
				var listener = new TimePrinter();
				var timer = new Timer(interval, listener);
				timer.start();
			}
		}
		
//		声明局部类时不能有访问说明符(即public或 private) 。
//		局部类的作用域总是限定在声明这个局部类的块中。
//		局部类有一个很大的优势，即对外部世界完全隐藏，甚至TalkingClock类中的其他代码也不能访问它。
//		除 start 方法之外，没有任何方法知道 TimePrinter 类的存在。

//		3-4、由外部方法访问变量
//		与其他内部类相比较，局部类还有另外一个优点。它们不仅能够访问外部类的字段，还 可以访问局部变量!
//		不过，那些局部变量必须是事实最终变量
//		这说明，它们一旦赋值就绝不会改变。
		class TalkingClock03 {
			private int interval;
			private boolean beep;

			public TalkingClock03 (int interval, boolean beep) {
				this.interval = interval;
				this.beep = beep;
			}
			
			public void start(int interval, boolean beep) {
				class TimePrinter implements ActionListener {
					public void actionPerformed(ActionEvent event) {
						System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
						if(beep) {
							Toolkit.getDefaultToolkit().beep();
						}
					}
				}
				var listener = new TimePrinter();
				var timer = new Timer(interval, listener);
				timer.start();
			}
		}
		
//		将TalkingClock构造器的参数 interval 和 beep 移至 start 方法。
//		TalkingClock类不再需要存储beep实例字段。它只是引用 start  方法的 beep参数变量。
//		1.调 用start 方法。
//		2.调用内部类TimePrinter 的构造器，从而初始化对象变量listener。
//		3.将listener引用传递给Timer构造器，定时器开始计时，start方法退出。此时， start方法的 beep参数变量不复存在。
//		4.1秒之后，actionPerformed方法执行 if(beep) …。
		
//		要让 actionPerformed方法中的代码正常工作， TimePrinter类必须在 beep参数值消失之前将 beep字段复制为start方法的一个局部变量。


//		3-5、匿名内部类
//		使用局部内部类时，通常还可以再进一步。
//		假如只想创建这个类的一个对象，甚至不需要为类指定名字。这样一个类被称为匿名内部类
		class TalkingClock04 {
			private int interval;
			private boolean beep;

			public TalkingClock04 (int interval, boolean beep) {
				this.interval = interval;
				this.beep = beep;
			}
			
			public void start(int interval, boolean beep) {
				var listener = new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
						if(beep) {
							Toolkit.getDefaultToolkit().beep();
						}
					}
				};
				var timer = new Timer(interval, listener);
				timer.start();
			}
		}
		
//		它的含义是：创建一个类的新对象，这个类实现了ActionListener接口，
//		需要实现的方法 actionPerformed 是大括号{}中定义的方法 。
//		一般地，语法如下：
//		new SuperType(construction parameters) {
//			inner class methods and data
//		}

		
//		SuperType 可以是接口，如 ActionListener, 如果是这样，内部类就要实现这个。
//		SuperType 也可以是一个类，如果是这样，内部类就要扩展这个类。

//		由于构造器的名字必须与类名相同，而匿名内部类没有类名，所以，匿名内部类不能有 构造器。
//		实际上，构造参数要传递给超类 (superclass)  构造器。具体地，只要内部类实现一个接口，就不能有任何构造参数。
//		不过，仍然要提供一组小括号，如下所示：
//		new InterfaceType() {
//			methods and data
//		}
		
		
		// AnonymousInnerClassTest
		
		
		
//		3-6、静态内部类
//		有时候，使用内部类只是为了把一个类隐藏在另外一个类的内部，并不需要内部类有外部类对象的一个引用
//		为此，可以将内部类声明为 static,这样就不会生成那个引用。
		
//		下面是一个想要使用静态内部类的典型例子。考虑这样一个任务：计算数组中的最小值 和最大值。

	}



}
