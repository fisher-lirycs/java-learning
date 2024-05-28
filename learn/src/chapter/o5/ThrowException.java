package chapter.o5;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 1、处理错误
*/
public class ThrowException {
	public static void main(String[] args) {
//		1-1、异常分类
//		在Java 程序设计语言中，异常对象都是派生于Throwable类的一个类的实例。
		
//		所有的异常都是由Throwable继承而来，但在这个层次结构中，下一层立 即分为两个分支： Error 和 Exception。
//		Error类层次结构描述了Java 运行时系统的内部错误和资源耗尽问题。
//		编写Java 程序时，要重点关注 Exception层次结构。
		
//		Exception层次结构又分为两个分支： 一个分支派生于RuntimeException;另一个分支包括其他异常，不继承这个类。
		
//		一般规则是：由编程错误导致的异常属于RuntimeException;
//		如果程序本身没有问题，但由于I/O错误之类的问题导致的异常属于其他异常。
		
//		继承自RuntimeException 的异常包括以下问题：
//		●错误的强制类型转换。
//		●越界的数组访问。
//		●访问 null 指针

//		不继承自RuntimeException的异常包括：
//		●试图越过文件末尾继续读取数据。
//		●试图打开一个不存在的文件。
//		●试图根据给定的字符串查找Class 对象，而这个字符串表示的类并不存在。

//		“如果出现 RuntimeException 异常，那么一定是你的问题”

//		如何处理不存在的文件呢?难道不能先检查文件是否存在再打开它吗?
//		这个文件有 可能在你检查它是否存在之后就被立即删除。因此，“是否存在”取决于环境，而不只是取决于你的代码。

//		Java语言规范将派生于Error类或RuntimeException类的所有异常称为非检查型异常，所有其他异常称为检查型异常。


//		1-2、声明检查型异常
//		如果遇到了无法处理的情况，Java方法可以抛出一个异常。
//		这个道理很简单：方法不仅需要告诉编译器将要返回什么值，还要告诉编译器有可能发生什么错误。
		
//		要在方法的首部指出这个方法可能抛出一个异常，所以要修改方法首部，以反映这个方法可能抛出的检查型异常。
//		public FileInputStream(String name) throws FileNotFoundException
//		这个声明表示这个构造器将根据给定的String参数生成一个FileInputStream对象，但也有可能出错而抛出一个FileNotFoundException异常。
		
//		编写你自己的方法时，不必声明你的方法可能抛出的所有throwable对象。
//		至于什么时候需要在所写的方法中用throws子句声明异常，以及要用throws子句声明哪些异常，需要记住在遇到下面4种情况时会抛出异常：
//		●调用了一个抛出检查型异常的方法，例如，FileInputStream构造器。
//		●检测到一个错误，并且利用throw语句抛出一个检查型异常
//		●程序出现错误，例如，a[-1]=0会抛出一个非检查型异常
//		●Java 虚拟机或运行时库出现内部错误。
		
//		如果出现前两种情况，则必须告诉使用这个方法的程序员有可能抛出异常。
//		因为任何一个抛出异常的方法都有可能是一个死亡陷阱。如果没有处理器捕获这个异常，当前的执行线程就会终止。
		
		
//		有些Java 方法包含在对外提供的类中，对于这些方法，应该通过方法首部的异常规范声明这个方法可能抛出异常。
		class MyAnimation01 {
			public void loadImage(String s) throws IOException {}
		}
		
//		如果一个方法有可能抛出多个检查型异常类型，那么就必须在方法的首部列出所有的异常类。每个异常类之间用逗号隔开。
		class MyAnimation02 {
			public void loadImage(String s) throws FileNotFoundException, IOException {}
		}


//		但是，不需要声明Java 的内部错误，即从 Error继承的异常。任何代码都有可能抛出那些异常，而我们对此完全无法控制。
//		也不应该声明从RuntimeException继承的那些非检查型异常。

		class MyAnimation03 {
			public void drawImage(String s) throws ArrayIndexOutOfBoundsException {} // bad style
		}
		
//		这些运行时错误完全在我们的控制之中。
//		如果特别担心数组索引错误，就应该多花时间修正这些错误，而不只是声明这些错误有可能发生。
		
//		如果类中的一个方法声明它会抛出一个异常，而这个异常是某个特定类的实例，那么这个 方法抛出的异常可能属于这个类，也可能属于这个类的任意一个子类。
//		FileInputStream构造器声明有可能抛出一个IOExcetion异常，
//		在这种情况下，你并不知道具体是哪种 IOException异常。
//		它既可能是 IOException, 也可能是其某个子类的对象，例如，FileNotFoundException。

//		1-3、如何抛出异常
//		现在假设在程序代码中发生了糟糕的事情。
//		一个名为 readData 的方法正在读取一个文件，文件首部承诺文件长度为1024个字符：
//		Content-length:1024
//		不过，读到733个字符之后文件就结束了。认为这是一种不正常的情况，希望抛出一个异常。
		
		
//		首先要决定应该抛出什么类型的异常。可能某种 IOException 是个不错的选择。(Java API)
//		EOFException 异常的描述是：“指示输入过程中意外遇到了EOF” 。
//		throw new EOFException();
//		或者，也可以写为
//		var e = new EOFException();
//		throw e;

//		String readData(Scanner in) throws EOFException {
//			while(...) {
//				if(!in.hasNext()) { // EOF encountered
//					if(n < len) {
//						throw new EOFException();
//					}
//				}
//			}
//			return s;
//		}
		
//		EOFException 类还有一个带一个字符串参数的构造器。
//		你可以很好地利用这个构造器，更细致地描述异常情况。
//		String gripe = "Content-length:" + len + ",Received:" + n;
//		throw new EOFException(gripe);
		
		
//		如果一个已有的异常类能够满足你的要求，抛出这个异常非常容易。
//		在这种情况下：
//		1.找到一个合适的异常类。
//		2.创建这个类的一个对象。
//		3.将对象抛出。

//		1-4、创建异常类
//		你的代码可能会遇到任何标准异常类都无法描述清楚的问题。
//		在这种情况下，创建自己 的异常类就是一件顺理成章的事情了，这也很容易。
//		定义一个派生于Exception 的类，或者派生于Exception的某个子类，如 IOException。
		
//		习惯做法是，自定义的这个类应该包 含两个构造器，一个是默认的构造器，另一个是包含详细描述信息的构造器
		class FileFormatException extends IOException {
			public FileFormatException(){}
			public FileFormatException(String gripe) {
				super(gripe);
			}
		}




	}
}
