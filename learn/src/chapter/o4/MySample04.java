package chapter.o4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 4、代理类
*/

public class MySample04 {
	public static void main(String[] args) {
//		利用代理可以在运行时创建实现了一组给定接口的新类。
//		只有在编译时无法确定需要实现哪个接口时才有必要使用代理。
//		对于编写应用 程序的程序员来说，这种情况很少见
		
//		4-1、何时使用代理
//		假设你想构造一个类的对象，这个类实现了一个或多个接口，但是在编译时你可能并不知道这些接口到底是什么。
		
//		代理类可以在运行时创建全新的类。这样一个代理类能够实现你指定的接口。具体地，代理类包含以下方法：
//		●指定接口所需要的全部方法。
//		●0bject类中定义的全部方法(toString、equals 等)。
		
//		不过，不能在运行时为这些方法定义新代码。
//		实际上，必须提供一个调用处理器
//		调用处理器是实现了InvocationHandler 接口的类的对象。这个接口只有一个方法：
//		Object invoke(Object proxy, Method method, Object[]args)

//		无论何时调用代理对象的方法，都会调用这个调用处理器的 invoke方法，并提供 Method对象和原调用的参数。

//		4-2、创建代理对象
//		要想创建一个代理对象，需要使用Proxy类的newProxyInstance方法。这个方法有三个
//		● 一个类加载器(class loader)。作为Java安全模型的一部分，对于平台和应用类、从 因特网下载的类等等可以使用不同的类加载器。
//		● 一个 Class 对象数组，每个元素对应需要实现的各个接口。
//		●一个调用处理器。
		
//		在示例程序中，我们要使用代理和调用处理器跟踪方法调用。
//		我们定义了一个 TraceHandler 包装器类存储一个包装的对象，其invoke方法会打印所调用方法的名字和参数，
//		随后调用这个方法，并提供所包装的对象作为隐式参数。




	}
}
