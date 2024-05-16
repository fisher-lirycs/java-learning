package chapter.o1;

import java.util.Arrays;

/*
 9、数组
  数组存储相同类型值的序列。
*/
public class MySample09 {

	public static void main(String[] args) {
//		9-1、声明数组
//		数组是一种数据结构，用来存储同一类型值的集合。通过一个整型索引可以访问数组中的每一个值。
//		在声明数组变量时，需要指出数组类型(元素类型后面紧跟[])和数组变量名。
		int[] a;
//		不过，这条语句只声明了变量a, 并没有将a初始化为一个真正的数组。应该使用new操作符创建数组。
		int[] a0 = new int[100];
		var a1 = new int[100];
		
//		这条语句声明并初始化了一个可以存储100个整数的数组。
//		数组长度不要求是常量： new int[n] 会创建一个长度为n 的数组。
//		一旦创建了数组，就不能再改变它的长度(不过，当然可以改变单个数组元素)。
//		创建数组对象提供初始值的简写形式。
		int[] smallPrimes ={2, 3, 5, 7, 11, 13};
//		这个语法中不需要使用new, 甚至不用指定长度。
//		这个表达式会分配一个新数组并填入大括号中提供的值。它会统计初始值个数，并相应地设置数组大小。

//		9-2、访问数组元素
		// 数组元素从0开始编号。最后一个合法的索引为数组长度减1。
		//  一旦创建了数组，就可以在数组中填入元素。
		int[] b = new int[100];
		for (int i = 0; i < 100; i++) {
			b[i] = i; // fills the array with numbers θ to 99
		}
		
//		创建一个数字数组时，所有元素都初始化为0。boolean数组的元素会初始化为 false 。
//		对象数组的元素则初始化为一个特殊值null, 表示这些元素(还)未存放任何对象。
		
		String[] names = new String[10];
		// 会创建一个包含10个字符串的数组，所有字符串都为null。
		// 要想获得数组中的元素个数，可以使用array.length。
		for (int i=0; i < names.length; i++) {
			System.out.println(names[i]);
		}

//		9-3、for each 循环
//		Java有一种功能很强的循环结构，可以用来依次处理数组(或者任何其他元素集合)中的每个元素，而不必考虑指定索引值。
//		for(variable : collection) statement
//		它将给定变量 (variable) 设置为集合中的每一个元素，然后执行语句 (statement)
		for (String name : names) {
			System.out.println(name);
		}

//		9-4、数组拷贝
//		在 Java 中，允许将一个数组变量拷贝到另一个数组变量。这时，两个变量将引用同一个数组：
		int[]luckyNumbers = smallPrimes; // {2, 3, 5, 7, 11, 13};
		System.out.println(Arrays.toString(smallPrimes));
		luckyNumbers[5] = 12;
		System.out.println(Arrays.toString(smallPrimes)); // {2, 3, 5, 7, 11, 12};
		
		// 如果确实希望将一个数组的所有值拷贝到一个新的数组中，就要使用Arrays类的 copyof 方法：
		int[] copiedLuckyWumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
		
		// 第2个参数是新数组的长度。这个方法通常用来增加数组的大小：
		luckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
//		如果数组元素是数值型，那么新增的元素将填入θ;如果数组元素是布尔型，则填入false。
//		相反，如果长度小于原数组的长度，则只拷贝前面的值。

//		9-5、数组排序
//		要想对数值型数组进行排序，可以使用Arrays类中的 sort 方法：
		int[] aa = new int [10000];
		Arrays.sort(aa);
		
//		● static String  toString(xxx[] a)
//		    返回一个字符串，其中包含a 中的元素，这些元素用中括号包围，并用逗号分隔。
//		    在这个方法以及后面的方法中，数组元素类型xxx可以是 int 、long 、short 、char、byte、boolean、float或double。
//		● static xxx[] copyof(xxx[] a, int end)
//		● static xxx[] copyofRange(xxx[] a, int start, int end)
//		    返回与a 类型相同的一个数组，其长度为end 或者 end - start,并填入a 的值。
//		    如果 end 大于 a.length, 结果会填充θ或false值。
//		● static void sort(xxx[] a)
//		    使用优化的快速排序算法对数组进行排序。
//		● static void fill(xxx[] a, xxx v)
//		    将数组的所有元素设置为v。
//		● static boolean equals(xxx[] a, xxx[] b)
//		    如果两个数组长度相同，并且相同索引对应的元素都相同，则返回 true。



	}
}