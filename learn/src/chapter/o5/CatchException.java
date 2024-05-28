package chapter.o5;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

/*
 2、捕获异常
*/
public class CatchException {
	public static void main(String[] args) throws IOException {
//		2-1、捕获异常概述
//		如果发生了某个异常，但没有在任何地方捕获这个异常，程序就会终止，并在控制台上 打印一个消息，其中包括这个异常的类型和一个栈轨迹。
//		要想捕获一个异常，需要建立 try/catch 语句块。最简单的 try 语句块如下所示：
//		try {
//			code
//			more code
//			more code
//		} catch(ExceptionType e) {
//			handler for this type
//		}

//		如果 try 语句块中的任何代码抛出了catch子句中指定的一个异常类，那么
//		1.程序将跳过 try 语句块的其余代码。
//		2.程序将执行 catch子句中的处理器代码。

//		如果 try 语句块中的代码没有抛出任何异常，那么程序将跳过catch子句。
//		如果方法中的任何代码抛出了一个异常，但不是catch子句中指定的异常类型，那么这个方法会立即退出
		
//		面给出一个很典型的读取数据的代码：
		class FileRead01 {
			public void read(String  filename) {
				try {
					var in = new FileInputStream(filename);
					int b;
					while ((b = in.read()) != -1) {
					}
				} catch(IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		
//		try子句中的大多数代码都很容易理解：读取并处理字节，直到遇到文件 结束符为止。
//		read方法有可能抛出一个IOException异常。
//		在这种情况下，将跳出整个while循环，进入catch子句，并生成一个栈轨迹。
		
//		通常，最好的选择是什么也不做，而只是将异常继续传递给调用者。
//		果read方法出现 了错误，就让read方法的调用者去操心这个问题!
//		如果采用这种处理方式，就必须声明这个方法可能会抛出一个 IOException。
		class FileRead02 {
			public void read(String  filename) throws IOException {
				var in = new FileInputStream(filename);
				int b;
				while ((b = in.read()) != -1) {
				}
			}
		}
		
//		编译器严格地执行 throws 说明符。如果调用了一个抛出检查型异常的方法，就必须处理这个异常，或者继续传递这个异常。


//		2-2、捕获多个异常
//		在一个try 语句块中可以捕获多个异常类型，并对不同类型的异常做出不同的处理。
//		要为每个异常类型使用一个单独的 catch子句
//		try {
//			code that might throw exceptions
//		} catch (FileNotFoundException e) {
//			mergency action for missing files
//		} catch (UnknownHostException e) {
//			emergency action for unknown hosts
//		} catch(IOException e) {
//			emergency action for all other I/O problems
//		}
		
		
//		异常对象可能包含有关异常性质的信息。要想获得这个对象的更多信息，可以尝试使用
//		e.getMessage()得到详细的错误消息(如果有的话),
//		或者使用e.getClass().getName()得到异常对象的实际类型。
		
		
//		同一个 catch子句中可以捕获多个异常类型。例如，假设对应缺少文件和未知主机异常的动作是一样的，就可以合并 catch 子句：
//		try {
//			code that might throw exceptions
//		} catch (FileNotFoundException | UnknownHostException e) {
//			emergeney action for missing fles and unknown hosts
//		} catch(IOException e) {
//			emergency action for all other I/O problems
//		}


//		2-3、再次抛出异常与异常链
//		可以在catch子句中抛出一个异常。通常，希望改变异常的类型时会这样做。
//		可以如下捕获异常并将它再次抛出：
//		try {
//			access the database
//		} catch (SQLException e) {
//			throw new ServletException("database error:" + e.getMessage());
//		}

//		不过，还有一种更好的想法，可以把原始异常设置为新异常的“原因”:
//		try {
//			access the database
//		} catch (SQLException original) {
//			var e = new ServletException("database error");
//			e.initCause(original);
//			throw e;
//		}		
		
//		捕获到这个异常时，可以使用下面这条语句获取原始异常：
//		Throwable original = caughtException.getCause();
//		强烈建议使用这种包装技术。这样可以在子系统中抛出高层异常，而不会丢失原始异常的细节信息。

//		有时你可能只想记录一个异常，再将它重新抛出，而不做任何改变：
//		try {
//			access the database
//		} catch (Exception e) {
//			logger.log(level, message, e);
//			throw e;
//		}	
		
		
//		2-4、finally 子句
//		代码抛出一个异常时，就会停止处理这个方法中剩余的代码，并退出这个方法。
//		如果这个方法已经获得了只有它自己知道的一些本地资源，而且这些资源必须清理，这就会有问题。
//		finally子句可以解决这个问题。
		
//		不管是否捕获到异常，finally子句中的代码都会执行。
//		var in = new FileInputStream(...);
//		try {
//			// STEP1
//			code that might throw exceptions
//			// STEP2
//		} catch (IOException e) {
//			// STEP3
//			show error message
//			// STEP4
//		} finally {
//			// STEP5
//			in.close();
//		}
//		// STEP6

//		下面来看这个程序执行 finally 子句的3种可能的情况：
//		1.代码没有抛出异常。
//			在这种情况下，程序首先执行try语句块中的全部代码，然后执行finally子句中的代码。
//			随后，继续执行 finally 子句之后的第一条语句。也就是说，执行的顺序是1、2、5、6。
		
//		2.代码抛出一个异常，并在一个catch子句中捕获。
//			在上面的示例中就是IOException 异常。
//			在这种情况下，程序将执行try语句块中的所有代码，直到抛出异常为止。
//			此时，将跳过try语句块中的剩余代码，转去执行与该异常匹配的catch 子句中的代码，然后执行finally子句中的代码。
//			如果catch子句没有抛出异常，程序将执行 finally子句之后的第一条语句。
//			在这种情况下，执行顺序是1、3、4、5、6。
//			如果 catch子句抛出了一个异常，异常将被抛回到这个方法的调用者。执行顺序则只是1、3、5。

//		3.代码抛出了一个异常，但没有任何catch子句捕获这个异常。
//			在这种情况下，程序将执行 try语句块中的所有语句，直到抛出异常为止。
//			此时，将跳过try 语句块中的剩余代码，然后执行finally子句中的语句，并将异常抛回给这个方法的调用者。
//			在这里，执行顺序只是1、5。


//		try 语句可以只有 finally 子句，而没有 catch子句。
//		无论在 try 语句块中是否遇到异常，finally 子句中的 in.close() 语句都会执行。

		
//		2-5、try-with-Resources 语句
//		对于以下代码模式：
//		open a resource
//		try {
//			work with the resource
//		} finally {
//			close the resource
//		}
		
//		假设这个资源属于一个实现了AutoCloseable接口的类
//		这种代码模式提供了一个很有用的快捷方式。
//		AutoCloseable 接口有一个方法：
//		void close() throws Exception
		
//		try-with-resources 语句(带资源的 try 语句)的最简形式为：
//		try (Resource res = ...) {
//			work with res
//		}
		
//		try 块退出时，会自动调用res.close()。
		try(var in = new Scanner(Path.of("in.txt"), StandardCharsets.UTF_8)) {
			while(in.hasNext()) {
				System.out.println(in.next());
			}
		}
//		这个块正常退出时，或者存在一个异常时，都会调用in.close()方法，就好像使用了 finally块一样。
		
//		还可以指定多个资源。例如：
//		try(var in = new Scanner(Path.of("in.txt"),StandardCharsets.UTF_8);
//				var out = new Printwriter("out,txt", StandardCharsets.UTF_8)) {
//			while(in.hasNext()) {
//				out.println(in.next().toUpperCase());
//			}
//		}
		
//		不论这个块如何退出，in 和out 都会关闭。如果用常规方式手动编程，就需要两个嵌套的 try/finally语句。
		
		
//		在Java9中，可以在 try 首部提供之前声明的事实最终变量：
//		public static void printAll(String[] lines, Printwriter out) {
//			try(out) {
//				for(String line: lines) {
//					out.println(line);
//				}
//			} // out.close() called ere
//		}
	}
}
