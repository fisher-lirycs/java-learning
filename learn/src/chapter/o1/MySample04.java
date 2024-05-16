package chapter.o1;
/*
 4、变量与常量
 Java使用变量来存储值。常量就是值不变的变量。
 */

public class MySample04 {
	public static void main(String[] args) {
		// 4-1、声明变量
		// 在Java 中，每个变量都有一个类型 (type) 。 声明一个变量时，先指定变量的类型，然后是变量名。
		// 注意每个声明都以分号结束。
		// 由于声明是一个完整的Java语句，而所有Java语句都以分号结束，所以这里的分号是必须的。
		double salary;
		int vacationDays;
		long earthPopulation;
		boolean done;

		// 4-2、初始化变量
		// 声明一个变量之后，必须用赋值语句显式地初始化变量，千万不要使用未初始化的变量的值。
		// System.out.println(vacationDays); 
		// ERROR--variable not initialized
		
		// 要想对一个已声明的变量进行赋值，需要将变量名放在等号(=)左侧，再把一个有适当值的Java 表达式放在等号的右侧。
		vacationDays = 12;
		// 也可以将变量的声明和初始化放在同一行中
		int vacationDays2 = 13;
		
		// 4-3、常量
		// 在Java中，可以用关键字final指示常量。
		final double CM_PER_INCH = 2.54;
		double  paperwidth  =8.5;
		double  paperHeight  =11;
		System.out.println("Paper size in centimeters:"+ paperwidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
		
		// 关键字 final 表示这个变量只能被赋值一次。一旦赋值，就不能再更改了。
		// 习惯上，常量名使用全大写。

	}
}

class MySample0401 {
	// 在Java中，可能经常需要创建一个常量以便在一个类的多个方法中使用，通常将这些常 量称为类常量。
	// 可以使用关键字 static final 设置一个类常量。
	public static final double CM_PER_INCH = 2.54;
	public void test() {
		double  paperwidth  =8.5;
		double  paperHeight  =11;
		System.out.println("Paper size in centimeters:"+ paperwidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
	}
}

class MySample0402 {
	public void test() {
		// 4-4、枚举类型
		// 有时候， 个变量只包含有限的一组值。例如，销售的服装或比萨只有小、中、大。
		// 针对这种情况，可以自定义枚举类型。枚举类型包括有限个命名值。
		enum Size {SMALL, MEDIUM, LARGE};
		// 现在，可以声明这种类型的变量：
		Size s = Size.MEDIUM;
	}
}