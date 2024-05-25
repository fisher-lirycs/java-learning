package chapter.o3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import chapter.o3.mysample09.Employee;
import chapter.o3.mysample09.Manager;

/*
 9、反射
*/

public class MySample09 {
	public static void main(String[] args) throws 
		ClassNotFoundException, 
		InstantiationException, 
		IllegalAccessException, 
		IllegalArgumentException, 
		InvocationTargetException, 
		NoSuchMethodException, 
		SecurityException, 
		NoSuchFieldException {
//		反射库提供了一个丰富且精巧的工具集，可以用来编写动态操纵Java代码的程序。
//		反射机制的功能极其强大，可以用它来：
//		●在运行时分析类的能力。
//		●在运行时检查对象，例如，编写一个适用于所有类的 toString 方法。
//		●实现泛型数组操作代码。
//		●利用Method对象，这个对象很像C++中的函数指针。
		
//		反射是一种功能强大且复杂的机制，主要是开发工具的程序员对它感兴趣，
//		一般的应用程序员并不需要考虑反射机制。
		
//		9-1、Class类
//		0bject类中的 getClass()方法将会返回一个Class类型的实例。
		Employee harryE = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Employee harryM = new Manager("Harry Hacker",50000, 1989, 10, 1);
		Class cle = harryE.getClass();
		Class clm = harryM.getClass();
		
//		就像 Employee 对象描述一个特定员工的属性一样，Class 对象会描述一个特定类的属性。
//		可能最常用的Class方法就是 getName，这个方法将返回类的名字。(如果类在一个包里，包名也作为类名的一部分)
		System.out.println(cle.getName() + " " + harryE.getName());
		System.out.println(clm.getName() + " " + harryM.getName());
		
		var generator = new Random();
		Class clg = generator.getClass();
		String className = clg.getName();

//		还可以使用静态方法 forName获得类名对应的Class对象。
		Class cl0 = Class.forName(className);
		
//		如果类名保存在一个字符串中，这个字符串会在运行时变化，就可以使用这个方法。
//		如果 className 是一个类名或接口名，这个方法可以正常执行。
//		否则，forName方法将抛出一个检查型异常(ClassNotFoundException),无论何时使用这个方法，都应该提供一个异常处理器
		
		
//		获得Class类对象的第三种方法是一个很方便的快捷方式。
//		如果T 是任意的Java类型(或 void关键字),T.class将是匹配的类对象。
		Class cl1 = Random.class;
		Class cl2 = int.class;
		Class cl3 = Double[].class;
		System.out.println(cl1);
		System.out.println(cl2);
		System.out.println(cl3);
		
//		Class对象实际上描述的是一个类型，这可能是类，也可能不是类。
//		int不是类，但 int.class 确实是一个 Class类型的对象。
		
//		虚拟机为每个类型管理一个唯一的Class对象。因此，可以使用=运算符比较两个类对象。
//		与条件e instanceof Employee不同，如果e是某个子类(如 Manager)的实例，则这个测试将失败。

		if (cle == Employee.class) {
			System.out.println("class check is ok");
		}

		if (harryE instanceof Employee) {
			System.out.println("instanceof is ok");
		}
		
		if (clm == Employee.class) {
			System.out.println("class check is ok");
		} else {
			System.out.println("class is ng");
		}

		if (harryM instanceof Employee) {
			System.out.println("instanceof is ok");
		} else {
			System.out.println("instanceof is ng");
		}

		
//		如果有一个Class 类型的对象，可以用它构造类的实例。
//		调用getConstructor方法将得到一个 Constructor类型的对象，
//		然后使用newInstance 方法来构造一个实例。
		
		className ="java.util.Random";
		Class cl = Class.forName(className);
		Object obj = cl.getConstructor().newInstance();
		// 如果这个类没有无参数的构造器，则getConstructor方法会抛出一个异常。

//		9-2、声明异常入门
//		当运行时发生错误时，程序就会“抛出一个异常”。
//		抛出异常比终止程序要灵活得多，这是因为你可以提供一个处理器(handler)“捕获”这个异常并进行处理
//		如果没有提供处理器，程序就会终止，并在控制台上打印出一个消息，给出异常的类型。
		
//		异常有两种类型：非检查型(unchecked)异常和检查型(checked)异常。
//		对于检查型异常，编译器将会检查你(程序员)是否知道这个异常并做好准备来处理后果。
//		不过，有很多常见的异常(例如，越界错误或者访问null引用)都属于非检查型异常。
//		编译器并不期望你 为这些异常提供处理器。你应该集中精力避免这些错误的发生，而不是为它们编写处理器。
		
//		不是所有的错误都是可以避免的。
//		如果竭尽全力还是可能发生异常，大多数Java API都会抛出一个检查型异常。
//		Class.forName 方法就是一个例子。没有办法确保有指定名字的类一定存在。
		
//		如果一个方法包含一条可能抛出检查型异常的语句，则在方法名上增加一个 throws 子句。
//		public static void doSomethingWithClass (String className) throws ClassNotFoundException {
//			Class cl = Class.forName(className);
//		}
		
//		调用这个方法的任何方法也都需要一个 throws 声明，这也包括 main方法。
//		如果一个异常 确实出现，则main方法将终止并提供一个栈轨迹。

//		9-3、资源
//		类通常有一些关联的数据文件，例如：
//		●图像和声音文件。
//		●包含消息字符串和按钮标签的文本文件。
		
//		在Java 中，这些关联的文件被称为资源
//		Class 类提供了一个很有用的服务可以查找资源文件。下面给出必要的步骤：
//		1.获得拥有资源的类的Class 对象，例如 ResourceTest.class。
//		2.有些方法(如 ImageIcon类的getImage方法)接受描述资源位置的 URL。那么,可以调用
//		URL url = cl.getResource("about.gif");
//		3.否则，使用 getResourceAsStream 方法得到一个输入流来读取文件中的数据。
		
//		这里的重点在于Java 虚拟机知道如何查找一个类，所以它能搜索相同位置上的关联资源。

//		9-4、利用反射分析类的能力
//		下面简要介绍反射机制最重要的内容，这允许你检查类的结构。
//		java.lang.reflect 包中有三个类 Field、Method 和 Constructor,分别用于描述类的字段、方法和构造器。
//		这三个类都有一个名为 getName 的方法，用来返回字段、方法或构造器的名字。
//		Field类有一个 getType方法，用来返回描述字段类型的一个对象，这个对象的类型同样是 Class。
//		Method 和Constructor类有报告参数类型的方法， Method 类还有一个报告返回类型的方法。
//		这三个类都有一个名为getModifiers 的方法，它将返回一个整数，用不同的0/1位描述所使用的修饰符，如 public 和 static。
//		然后，可以利用java.lang.reflect 包中Modifier类的静态方法分析 getModifiers返回的这个整数

//		例如，可以使用Modifier类中的isPublic、isPrivate 或isFinal 判断一个方法或构造器是 public 、private 还是 final。
//		我们需要做的就是在 getModifiers 返回的整数上调用Modifier类中适当的方法。
//		可以利用Modifier.toString 方法打印修饰符。

//		Class类中的 getFields、getMethods 和getConstructors 方法将分别返回这个类支持的公共字段、 方法和构造器的数组，其中包括超类的公共成员。
//		Class类的 getDeclaredFields、getDeclaredMethods和getDeclaredConstructors方法将分别返回
//		这个类中声明的全部字段、方法和构造器组成的数组，其中包括私有成员、包成员和受保护成员，以及有包访问权限的成员，但不包括超类的成员。

//		reflection/ReflectionTest.java
		
//		9-5、使用反射在运行时分析对象
//		我们已经知道如何查看任意对象实例字段的名字和类型：
//		●获得对应的Class对象。
//		●在这个Class对象上调用getDeclaredFields。
		
//		本节将进一步具体查看字段的内容。
//		当然，在编写程序时，如果知道想要查看的字段名 和类型，查看对象中指定字段的内容是一件很容易的事情。
//		而利用反射机制可以查看在编译时还不知道的对象字段。
		
//		要做到这一点，关键方法是 Field类中的 get 方法。
//		如果f 是一个 Field类型的对象(例如，通过getDeclaredFields 得到的对象), 
//		obj是某个包含f字段的类的对象，则f.get(obj)将返回一个对象，其值为obj 的当前字段值。
		var harry = new Employee("Harry Hacker", 50000, 1989, 12, 20);
		Class clHarry = harry.getClass();
		Field f = clHarry.getDeclaredField("name");
		Object v = f.get(harry);
		System.out.println(f);
		System.out.println(v);
		
//		当然，不仅可以获得值，也可以设置值。
//		调用f.set(obj,value)  将把对象obj中f表示的字段设置为新值。
		f.set(harry, "Harry Man");
		System.out.println(f.get(harry));
		
//		由于name 是一个私有字段，所以get 和 set 方法会抛 出一个IllegalAccessException。只能对可以访问的字段使用get和 set方法。
//		Java安全机制允许查看一个对象有哪些字段，但是除非拥有访问权限，否则不允许读写那些字段的值。
		
//		反射机制的默认行为受限于Java的访问控制。
//		不过，可以调用Field、Method 或 Constructor对象的 setAccessible方法覆盖Java 的访问控制。
		f.setAccessible(true);
//		setAccessible方法是Accessible0bject类中的一个方法，它是 Field、Method 和 Constructor 类的公共超类。
//		如果不允许访问， setAccessible 调用会抛出一个异常。
//		objectAnalyzer.ObjectAnalyzerTest

//		9-6、使用反射编写泛型数组代码
//		java.lang.reflect包中的Array类允许动态地创建数组。
//		例如，Arrays 类的 copyOf 方法实现中就使用了这个类。
		var a = new Employee[100];
		a = Arrays.copyOf(a, 2 * a.length);
		
//		如何编写这样一个通用的方法呢?
//		好在 Employee[]数组能够转换为0bject[] 数组，
//		public static Object[] badCopyOf(Object[] a, int newLength) {
//			var newArray = new Object[newLength];
//			System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
//			return newArray;
//		}

//		不过，在实际使用得到的数组时会遇到一个问题。这段代码返回的数组类型是一个对象数组 (Object[]),
//		对象数组不能强制转换成员工数组 (Employee[])。
		
//		Java数组会记住每个元素 的类型，即创建数组时new表达式中使用的元素类型。
//		将一个 Employee[] 临时转换成 Object[]数组，然后再把它转换回来是可以的，但一个从开始就是0bject[]的数组却永远不能转换成 Employee[] 数组。
		
//		为此，需要使用java.lang.reflect 包中 Array类的一些方法。
//		最关键的是 Array类的静态方法 newInstance,这个方法能够构造一个新数组。
//		在调用这个方法时必须提供两个参数，一个是数组的元素类型，另一个是期望的数组长度。
//		Object newArray = Array.newInstance(componentType, newLength);
		
//		为了具体执行这个调用，需要获得新数组的长度和元素类型。
//		可以通过调用Array.getLength(a)获得数组的长度。
//		Array类的静态 getLength方法会返回一个数组的长度。
//		要获得新数组的元素类型，
//		1.首先获得a的类对象。
//		2.确认它确实是一个数组。
//		3.使用Class类的getComponentType方法(只为表示数组的类对象定义了这个方法)得到数组的正确类型。
//		4.反过来，对于表示类C的Class对象，arrayType方法会生成表示C[]的Class对象。
//		public static Object goodCopyOf(Object a, int newlength) {
//			Class cl = a.getClass();
//			if(!cl.isArray()) {
//				return null;
//			}
//			Class componentType = cl.getComponentType();
//			int length = Array.getLength(a);
//			Object newArray = Array.newInstance(componentType, newlength);
//			System.arraycopy(a, 0, newArray, 0, Math.min(length, newlength));
//			return newArray;
//		}
		
		// 这个 CopyOf 方法可以用来扩展任意类型的数组，而不仅是对象数组。
		int[] aa = {1, 2, 3, 4, 5};
		aa = (int[])goodCopyOf(a, 18);
		
//		为了使用这个方法，要将 goodCopyOf 的参数声明为Object 类型，而不是一个对象数组(Object[]) 。
//		整型数组类型int[]可以转换为一个Object,而不是转换成对象数组!
//		arrays.CopyOfTest
		
		
//		9-7、调用任意方法和构造器
//		反射机制允许你调用任意的方法。
//		Method 类有一个invoke 方法，允许你调用包装在当前 Method对象中的方法。invoke方法的签名为
//		Object invoke (Object obj, Object...args)
//		第一个参数是隐式参数，其余的对象提供了显式参数。
//		对于静态方法，第一个参数会忽略，即可以将它设置为null。
		
//		假设用m1表示 Employee类的 getName 方法，下面这条语句显示了如何调用这个方法：
		Employee harryHacker = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Class clharryHacker = harryHacker.getClass();
		Method m1 = clharryHacker.getMethod("getName");
		
		String n = (String)m1.invoke(harryHacker);
		
//		如果返回类型是基本类型，则invoke方法会返回其包装器类型。
		Method m2 = clharryHacker.getMethod("getSalary");
		double s = (Double)m2.invoke(harryHacker);
		
//		如何得到 Method 对象呢?
//		调用getDeclaredMethods 方法，然后搜索返回的 Method 对象数组，直到发现想要的方法为止。
//		调用调用Class类的 getMethod 方法。不过，有可能存 在若干个同名的方法，因此要准确地得到想要的那个方法必须格外小心。
//		methods.MethodTableTest

	}

	public static Object[] badCopyOf(Object[] a, int newLength) {
		var newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}
	
	public static Object goodCopyOf(Object a, int newlength) {
		Class cl = a.getClass();
		if(!cl.isArray()) {
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newlength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newlength));
		return newArray;
	}

}
