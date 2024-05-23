package chapter.o3;

import java.util.ArrayList;

/*
 4、对象包装器与自动装箱

*/

public class MySample04 {
	public static void main(String[] args) {
//		有时，需要将 int 这样的基本类型转换为对象。所有的基本类型都有一个与之对应的类。 
//		Integer类对应基本类型 int。通常，这些类称为包装器
//		这些包装器类有显 而易见的名字： Integer、Long、Float、Double、Short、Byte、Character 和 Boolean(前6个类派生 于公共超类 Number)。
//		包装器类是不可变的，即一旦构造了包装器，就不允许更改包装在其中的值。
//		包装器类还是 final,   因此不能派生它们的子类。
		
//		假设想要定义一个整型数组列表。
//		尖括号中的类型参数不允许是基本类型， 也就是说，不允许写成ArrayList<int> 。
//		这里就可以用到Integer 包装器类。
		var list = new ArrayList<Integer>();
//		有一个很有用的特性，从而可以很容易地向 ArrayList<Integer> 添加 int 类型的元素。
		list.add(3);
//		将自动地转换成
		list.add(Integer.valueOf(3));
//		这种转换称为自动装箱
		
//		当将一个 Integer 对象赋给一个 int 值时，将会自动拆箱
		int n = list.get(1);
//		转换成
		n = list.get(1).intValue();
		
//		自动装箱和自动拆箱甚至也适用于算术表达式。
		Integer nn = 3;
		nn ++;
//		编译器将自动地插入指令对对象拆箱，然后将结果值增1,最后再将其装箱。
		
//		大多数情况下容易有一种假象，认为基本类型与它们的对象包装器是一样的。
//		但它们有一点有很大不同：同一性。
//		==运算符可以应用于包装器对象，不过检测的是对象是否有相同的内存位置
		Integer a = 1000;
		Integer b = 1000;
		if (a == b) {}
//		Java 实现可以(如果选择这么做)将经常出现的值包装到相同的对象中，这样一 来，以上比较就可能成功。
//		但这种不确定性并不是我们想要的。
//		解决这个问题的办法是在比较两个包装器对象时调用equals方法。
		
		
//		关于自动装箱还有几点需要说明。
//		首先，由于包装器类引用可以为null,所以自动装箱有可能会抛出一个NullPointerException 异常：
		Integer num = null;
		a = num * 2;
		
//		另外，如果在一个条件表达式中混合使用Integer 和 Double类型，
//		则 Integer 值就会拆箱，提升为 double,再装箱为 Double:
		num = 1;
		Double d = 2.0;
		System.out.println(true ? num : d);
	}
}
