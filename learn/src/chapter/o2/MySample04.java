package chapter.o2;

import chapter.o2.mysample04.Employee;

/*
 4、方法参数
 Java程序设计语言总是采用按值调用。
 也就是说，方法会得到所有参数值的一个副本。
 具体来讲，方法不能修改传递给它的任何参数变量的内容。
*/

public class MySample04 {
	public static void main(String[] args) {
//		Java程序设计语言总是采用按值调用。
//		也就是说，方法会得到所有参数值的一个副本。
//		具体来讲，方法不能修改传递给它的任何参数变量的内容。
		Employee james = new Employee("James Bond", 100000);
		double percent = 10;
		james.raiseSalary(percent);
		
//		不论这个方法具体如何实现，在这个方法调用之后，percent 的值还是10。
//		下面再仔细研究一下这种情况。假定一个方法试图将一个参数值增加至3倍：tripleValue
//		然后调用这个方法：
		tripleValue(percent);
		System.out.println(percent);
		
//		不过，这并不起作用。调用这个方法之后，percent的值还是10。
//		1、x 初始化为 percent 值的一个副本(也就是10)。
//		2、x乘以3后等于30,但是 percent 仍然是10
//		3、这个方法结束之后，参数变量x不再使用。
		
//		不过，有两种不同类型的方法参数：
//		● 基本数据类型(数字、布尔值)。
//		● 对象引用。

//		一个方法不可能修改基本数据类型的参数，而对象参数就不同了，
//		可以很容易地实现一个方法将一个员工的工资增至3倍：tripleSalary
		tripleSalary(james);
		System.out.println(james.getSalary());
		
//		具体的执行过程为：
//		1.x初始化为james值的一个副本，这里就是一个对象引用。
//		2.raiseSalary方法应用于这个对象引用。 x和james同时引用的那个Employee对象的工资提高了200%。
//		3.方法结束后，参数变量x不再使用。当然，对象变量james继续引用那个工资增至3倍的员工对象

//		可以看到，实现方法改变对象参数的状态是完全可以的，实际上也相当常见。
//		理由很简单，方法得到的是对象引用的副本，原来的对象引用和这个副本都引用同一个对象。

//		有些程序员声称Java对对象采用的是按引用调用，实际上，这是不对的。
//		如果Java对对象采用的是按引用调用，那么swap方法就应该能够实现交换：
		var a  = new Employee("Alice", 100000);
		var b = new Employee("Bob", 200000);
		swap(a, b);
		System.out.println(a.getName());
		System.out.println(b.getName());
//		但是，这个方法并没有改变存储在变量a 和 b中的对象引用。
//		Swap方法的参数x和y初始化为两个对象引用的副本，这个方法交换的是这两个副本。
//		方法结束时，参数变量x 和 y 被丢弃了。原来的变量a 和 b 仍然引用这个方法调用之前所引用的对象

//		这说明：Java 程序设计语言对对象采用的不是按引用调用。实际上，对象引用是按值传递的。
//		下面来总结在 Java 中对方法参数能做什么和不能做什么:
//		●方法不能修改基本数据类型的参数(即数值型或布尔型)。
//		●方法可以改变对象参数的状态。
//		●方法不能让一个对象参数引用一个新对象。







	}
	
	public static void tripleValue(double x) {
		x = 3 * x;
	}
	
	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
	}
	
	public static void swap (Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
	}



}
