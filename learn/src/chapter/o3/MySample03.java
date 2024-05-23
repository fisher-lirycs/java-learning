package chapter.o3;

import java.util.ArrayList;

/*
 3、泛型数组列表

*/

public class MySample03 {
	public static void main(String[] args) {
//		在一些程序设计语言(如C 或 C++)  中，必须在编译时就确定所有数组的大小。
//		在Java 中，情况就好多了。它允许在运行时确定数组的大小。
		class Employee {
			private static int nextId = 1;

			private int id;
			private String name;
			private double salary;

			public Employee (String n, double s) {
				name = n;
				salary = s;
				id = advanceId();
			}

			public String getName () {
				return name;
			}

			public double getSalary() {
				return  salary;
			}

			public int getId() {
				return  id;
			}

			public static int advanceId() {
				int r = nextId;
				nextId ++;
				return r;
			}
		}
		int actualSize = 100;
		var e = new Employee[actualSize];
		
//		当然，这个代码并没有完全解决运行时动态修改数组的问题。 一旦确定了数组的大小， 就无法再轻松地改变了。
//		在Java 中，要处理这个常见的情况，可以使用Java 中的另外一个 类，名为ArrayList。
//		ArrayList类与数组类似，但在添加或删除元素时，它能够自动地调整容量，而不需要为此额外编写代码。
		
//		ArrayList 是一个有类型参数的泛型类。
//		为了指定数组 列表保存的元素对象的类型，需要用一对尖括号将类名括起来追加到ArrayList后面，例如 ArrayList<Employee>。
		
//		3-1、声明数组列表
//		可以如下声明和构造一个保存 Employee 对象的数组列表：
		ArrayList<Employee> staff01 = new ArrayList<Employee>();
//		可以省略右边的类型参数
		ArrayList<Employee> staff02 = new ArrayList<>();
		
//		在 Java10 中，最好使用var关键字以避免重复写类名：
		var staff = new ArrayList<Employee>();

//		使用add方法可以将元素添加到数组列表中。
		staff.add(new Employee("Harry Hacker", 35008));
		staff.add(new Employee("Tony Tester", 45008));
		
//		数组列表管理着一个内部的对象引用数组。
//		最终，这个数组的空间有可能全部用尽。
//		这时就显现出数组列表的魅力了：如果调用add 而内部数组已经满了，数组列表就会自动地创建一个更大的数组，并将所有对象从较小的数组拷贝到较大的数组中。
		
//		如果已经知道或能够估计出数组可能存储的元素数量，就可以在填充数组之前调用ensureCapacity 方法：
		staff.ensureCapacity(100);
		
//		这个方法调用将分配一个包含100个对象的内部数组。这样一来，前100次 add 调用不会带来开销很大的重新分配空间。
//		另外，还可以把初始容量传递给ArrayList 构造器：
		ArrayList<Employee> staff03 = new ArrayList<Employee>(100);
		
//		size 方法将返回数组列表中包含的实际元素个数。
		staff.size();
//		将返回 staff 数组列表的当前元素个数，它等价于数组a 的 a.length。
		
		
//		一旦能够确认数组列表的大小将保持恒定，不再发生变化，就可以调用trimToSize方法。
//		这个方法将内存块的大小调整为保存当前元素数量所需要的存储空间。垃圾回收器将回收多余的存储空间。
//		一旦削减了数组列表的大小，添加新元素就需要再次移动内存块，这很耗费时间，所以应当只有在确认不会再向数组列表添加任何元素时才调用 trimToSize。

//		3-2、访问数组列表元素
//		很遗憾，天下没有免费的午餐。为了提供数组列表自动扩展容量的便利，这要求使用一 种更复杂的语法来访问元素。
//		不能使用我们喜爱的[]语法格式访问或改变数组的元素，而要使用 get 和 set 方法。
//		要设置第i 个元素
		int i = 5;
		var harry = new Employee("Harry Hacker", 35008);
		staff.set(i, harry);
		
//		它等价于对数组a的元素赋值(与数组一样，索引值从0开始):
//		a[i] = harry;

		
//		要得到一个数组列表的元素，可以使用
		var ee = staff.get(i);
//		这等价于
//		Employee ee = a[i];

		
//		下面这个技巧可以一举两得，既可以灵活地扩展数组，又可以方便地访问数组元素。
//		首先，创建一个数组列表，并添加所有的元素：
		
		var list = new ArrayList<Employee>();
		while (i < 100) {
			var eee = new Employee("Harry Hacker" + i, 35008);
			list.add(eee);
			i ++;
		}
		
		// 执行完上述操作后，使用toArray方法将数组元素复制到一个数组中：
		var a = new Employee[list.size()];
		list.toArray(a);


//		有时需要在数组列表的中间增加元素，为此可以使用 add 方法并提供一个索引参数：
		int n = staff.size() / 2;
		staff.add(n, new  Employee("Harry Hacker", 35008));
//		位置n及之后的所有元素都要向后移动一个位置，为新元素留出空间。
//		插入新元素后，如果数组列表的新大小超过了容量，数组列表就会重新分配它的存储数组。
		
//		类似地，可以从数组列表中间删除一个元素：
		Employee delE = staff.remove(n);
//		位于这个位置之后的所有元素都向前移动一个位置，并且数组的大小减1。
//		插入和删除元素的效率很低。
		
//		可以使用 “for each” 循环遍历数组列表的内容：
		for(Employee s : staff) {
			
		}
		
//		这个循环和以下代码具有相同的效果：
		for (int j = 0; j < staff.size(); j++) {
			Employee ss = staff.get(j);
		}

		// MySample03.ArrayListTest
		



	}
}
