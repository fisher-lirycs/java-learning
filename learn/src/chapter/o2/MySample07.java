package chapter.o2;

import java.time.*;
import java.time.LocalDate;
import java.util.*;
import java.sql.*;
import static java.lang.System.*;
import static java.lang.Math.sqrt;


/*
 7、包
 Java 允许使用包(package)将类组织在一个集合中。
 借助包可以方便地组织你的代码，并将你自己的代码与其他人提供的代码库分开。

*/

public class MySample07 {
	public static void main(String[] args) {
//		7-1、包名
//		使用包的主要原因是确保类名的唯一性。
//		假如两个程序员不约而同地提供了Employee类，只要他们将自己的类放置在不同的包中，就不会产生冲突。
//		为了保证包名的绝对唯一性，可以使用一个因特网域名(这显然是唯一的)以逆序的形式作为包名，然后对于不同 的项目使用不同的子包。
//		考虑域名linkstec.com
//		如果逆序来写，就得到了包名com.linkstec。然后可以追加一个项目名，如 com.linkstec.corejava。
//		如果再把 Employee类放在这个包里，那么这个类的“完全限定”名就是 com.linkstec.corejava.Employee。

//		7-2、类的导入
//		一个类可以使用所属包(这个类所在的包)中的所有类，以及其他包中的公共类 (public class)。
//		我们可以采用两种方式访问另一个包中的公共类。
//		第一种方式是使用完全限定名
		java.time.LocalDate today = java.time.LocalDate.now();
		
//		这显然很烦琐。更简单且更常用的方式是使用import语句。
//		import语句的关键是可以提供一种简写方式来引用包中各个类。
//		一旦增加了import语句，在使用类时，就不必写出类的全名了。
		
//		可以使用下面这条语句导入java.time包中的所有类。
//		import java.time.*;

//		然后，就可以使用
		LocalDate today01 = LocalDate.now();
		
//		还可以导入一个包中的特定类：
//		import java.time.LocalDate;
		
//		java.time.* 的语法比较简单，对代码的规模也没有任何负面影响。
//		但是，需要注意的是，只能使用星号(*)导入一个包，而不能使用import java.*或 import java.*.*导入以 java 为前缀的所有包。

//		在大多数情况下，可以只导入你需要的包，并无须过多考虑。
//		但在发生命名冲突的时候，就要注意包了。
//		例如，java.util  和 java.sql 包都有 Date类。假设在程序中导入了这两个包：
//		import java.util.*;
//		import java.sql.*;
		
//		在程序中使用Date类的时候，就会出现一个编译错误：
//		Date today03; // ERROR--java.util.Date or java.sql.Date?

//		7-3、静态导入
//		有一种 import语句允许导入静态方法和静态字段，而不只是类。
//		import static java.lang.System.*;
		
//		就可以使用System 类的静态方法和静态字段，而不必加类名前缀：
		out.println("Goodbye,World!");
		
//		还可以导入特定的方法或字段：
//		import static java.lang.Math.sqrt;
		sqrt(Math.pow(2, 2) + Math.pow(3, 2));

//		7-4、在包中增加类
//		要想将类放入包中，就必须将包名放在源文件的开头，即放在定义这个包中各个类的代码之前。
//		Employee.java开头是这样的：
//		package chapter.o2.mysample07;

	}
}
