package chapter.o1;
/*
 7、控制流程
 Java 支持使用条件语句和循环结构来确定控制流程。
 */

public class MySample07 {

	public static void main(String[] args) {
//		7-1、块作用域
//		块由若干条Java 语句组成，并用一对大括号括起来。块确定了变量的作用域。
//		一个块可以嵌套在另一个块中。下面就是嵌套在main方法块中的一个块。
//		public static void main(String[] args) {
//			int n;
//			{
//				int k;
//			} // k is only defined up to here
//		}

//		但是，不能在嵌套的两个块中声明同名的变量。
//		public static void main(String[] args) {
//		int n;
//		{
//			int k;
//			int n; // ERROR--can't redeclare n in inner block
//		} // k is only defined up to here
//	}

//		7-2、条件语句
//		在Java 中，条件语句的形式为
//		if (condition) statement
//		这里的条件必须用小括号括起来。
//		在Java 中，常常希望在某个条件为真时执行多条语句。
//		在这种情况下，就可以使用块语句, 形式如下：
//		当yourSales大于或等于target时，将执行大括号中的所有语句

		int yourSales = 10000;
		int target = 8000;
		String performance = "";
		int bonus = 0;
		if(yourSales >= target) {
			performance = "Satisfactory";
			bonus = 100;
		}
		
//		在Java中，更一般的条件语句如下所示
//		if (condition) statement1 else statement2
		if(yourSales >= target) {
			performance = "Satisfactory";
			bonus = 100;
		} else {
			performance = "Unsatisfactory";
			bonus = 0;
		}

//		其中else部分总是可选的。else子句与最邻近的if 构成一组。
		int x = 0;
		int sign = -1;
		if (x <= 0) if (x == 0) sign=6; else sign =-1;
		
//		else 与 第 2 个if  配对。使用大括号可以让这段代码更加清晰：
		if (x <= 0) {if (x == 0) {sign=6;} else {sign =-1;}}
		
//		反复使用if...else if...很常见
		if(yourSales >= 2 * target) {
			performance = "Excellent";
			bonus = 1000;
		} else if (yourSales >= 1.5 * target) {
			performance = "Fine";
			bonus = 500;
		} else if (yourSales >= target) {
			performance = "Satisfactory";
			bonus = 100;
		} else {
			System.out.println("You're fired");
		}

//		7-3、循环语句
//		while循环会在条件为 true时执行一个语句(也可以是一个块语句)
//		while (condition) statement
//		如果开始时循环条件就为false,那么 while 循环一次也不执行
		int balance = 500;
		int goal = 10000;
		int payment = 500;
		int interestRate = 10;
		int years = 1;
		while (balance < goal) {
			balance += payment;
			double interest = balance * interestRate / 100;
			balance +=interest;
			years ++;
			System.out.println(years + "years.");
		}
		
//		如果希望循环体至少执行一次，需要使用do/while循环将检测放在最后。
//		do statement while(condition);
		do {
			balance += payment;
			double interest = balance * interestRate / 100;
			balance +=interest;
			years ++;
			System.out.println(years + "years.");
		} while (balance < goal);

		
//		7-4、确定性循环
//		for 循环语句是支持迭代的一种通用结构，它由一个计数器或类似的变量控制迭代次数，每次迭代后这个变量将会更新。
//		下面的循环将在屏幕上显示出打印数字1～10:
		for (int i = 1; i <= 10; i ++) {
			System.out.println(i);
		}
//		for 语句的第1部分通常是对计数器初始化；第2部分给出每次新一轮循环执行前要检测的循环条件；第3部分指定如何更新计数器
		
//		在 for 语句的第1部分中声明一个变量之后，这个变量的作用域会扩展到这个 for 循环体的末尾。
		for (int i=1; i <= 10; i++) {
		}
		//i no longer defined here

//		如果在 for 语句内部定义一个变量， 这个变量就不能在循环体之外使用。
//		因此，如果希望 在 for 循环体之外使用循环计数器的最终值，就要确保在循环体之外声明这个变量。
		int   i;
		for (i=1; i <= 10; i ++) {
		}
		//i is still defined here


		// for 循环语句只是while 循环的一种简化形式。
		for(int j = 10; j > 0; j --) {
			System.out.println("Counting down..." + j);
		}
//		可以重写为：
		int j = 10;
		while (j > 0) {
			System.out.println("Counting down..." + j);
			j --;
		}

//		7-5、多重选择：switch语句
//		在处理同一个表达式的多个选项时，使用if/else  结构会显得有些笨拙。
//		switch语句会让这个工作变得容易，特别是采用Java14引入的形式时会更简单。

//		int choice = 1;
//		switch(choice) {
//			case 1 -> 
//				...
//			case 2 ->
//				...
//			case 3 ->
//				...
//			case 4 ->
//				...
//			default ->
//				System.out.print("Bad choice");
//		}

//		case 标签可以是：
//		●类型为 char、byte、short 或 int的常量表达式
//		●枚举常量
//		●字符串字面量
//		●多个字符串，用逗号分隔 

//		String input = ...;
//		switch(input.toLowerCase())
//		{
//			case "yes", "y"->
//				...
//			case "no", "n" ->
//				...
//			default ->
//				...
//		}


//		switch语句的“经典”形式
//		int choice = ...;
//		switch(choice)
//		{
//			case 1:
//				...
//				break;
//			case 2:
//				...
//				break;
//			case 3:
//				...
//				break;
//			case 4:
//				...
//				break;
//			default:
//				...
//				break;
//		}

//		switch 语句从与选项值相匹配的 case 标签开始执行，直到遇到下一个break语句，或者执行到switch语句结束。
//		如果没有匹配的case标签，则执行default子句(如果有default子句)。
		
//		在有直通行为的形式中，每个 case 以一个冒号结束。如果 case 以箭头->结束，则没有直通行为。
//		不能在一个 switch 语句中混合使用冒号和箭头。
//		注意switch表达式中的 yield关键字。与 break类 似 ，yield会终止执行。
//		但与 break不同的 是 ，yield 还会生成一个值，这就是表达式的值。
//		总共有4种不同形式的 switch
		
		String seasonName = "Sprint";

		// 表达式（无直通行为）
		int numLetter01 = switch (seasonName) {
			case "Sprint" -> {
				System.out.println("Spring time !");
				yield 6;
			}
			case "Summer", "Winter" -> 6;
			case "Fall" -> 4;
			default -> -1;
		}; 

		// 语句（无直通行为）
		int numLetter02 = -1;
		switch (seasonName) {
			case "Sprint" -> {
				System.out.println("Spring time !");
				numLetter02 =  6;
			}
			case "Summer", "Winter" -> numLetter02 = 6;
			case "Fall" -> numLetter02 = 4;
			default -> numLetter02 = -1;
		} 
		
		// 表达式（有直通行为）
		int numLetter03 = switch (seasonName) {
			case "Sprint" : 
				System.out.println("Spring time !");
			case "Summer", "Winter" : yield 6;
			case "Fall" : yield 4;
			default : yield -1;
		}; 

		// 语句（无直通行为）
		int numLetter04= -1;
		switch (seasonName) {
			case "Sprint" : 
				System.out.println("Spring time !");
			case "Summer", "Winter" : numLetter04 = 6;
			case "Fall" : numLetter04 = 4;
			default : numLetter04 = -1;
		} 
		
//		switch 有这么多种形式，要如何选择呢?
//		switch 表达式优于语句。如果每个分支会为一个变量赋值或方法调用计算值，则用一个表达式生成值，然后使用这个值。
//		只有在确实需要直通行为时，或者必须为一个switch表达式增加语句时，才需要使用break或 yield。不过这些情况非常少见。

//		7-6、中断控制流程的语句
//		尽管Java 的设计者将goto 仍作为一个保留字，但实际上并不打算在语言中包含 goto。
		while(years <= 100)
		{
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			if(balance >= goal) {
				break;
			}
			years ++;
		}
		// 循环开始时，如果 years>100, 或者如果循环中间 balance≥goal, 则退出循环。
		
//		Java 还提供了一种带标签的 break 语句，允许跳出多重嵌套的循环。
//		有时候，在嵌套很深的循环语句中会发生一些不可预料的事情。此时你可能希望完全跳出所有嵌套循环。
//		标签必须放在你想跳出的最外层循环之前，并且必须紧跟一个冒号。
//		int n;
//		read_data:
//		while (...) { // this loop statement is tagged whit the label
//			...
//			for (...) { // this inner loop is not labeled
//				n = ...
//				if (n < 0) {
//					break read_data;
//				}
//			}
//		}
//		
//		还有一个 continue语句。与break语句一样，它将中断正常的控制流程。
//		continue语句将控制转移到最内层外围循环的首部。

		while(years <= 100)
		{
			balance += payment;
			double interest = balance * interestRate / 100;
			if (interest > 100000) {
				continue;
			}
			balance += interest;
			if(balance >= goal) {
				break;
			}
			years ++;
		}
		
		// 如果interest > 100000, 则 continue 语句会越过当前循环体的剩余部分，直接跳到循环首部。


	}
}