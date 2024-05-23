package chapter.o3;

/*
 7、枚举类

*/

public class MySample07 {
	public static void main(String[] args) {
//		之前已经看到如何定义枚举类型。下面是一个典型的例子：
		enum Size {
			SMALL, 
			MEDIUM, 
			LARGE, 
			EXTRA_LARGE
		};

//		实际上，这个声明定义的类型是一个类，它刚好有4个实例，不可能构造新的对象。
//		因此，在比较枚举类型的值时，并不需要使用equals,可以直接使用==来比较。
		
//		如果需要的话，可以为枚举类型增加构造器、方法和字段。，构造器只是在构造枚举常量的时候调用。

		enum Size01 {
			SMALL("S"), MEDIUN("N"), LARGE("L"), EXTRA_LARGE("XL");

			private String abbreviation;
			
			Size01(String abbreviation) {
				this.abbreviation = abbreviation;
			}
			
			public String getAbbreviation() {
				return abbreviation;
			}
		}
		
//		枚举的构造器总是私有的。可以像前例中一样省略 private 修饰符。
//		如果声明一个 enum 构造器为 public 或 protected, 则会出现语法错误。
		
//		所有的枚举类型都是抽象类 Enum的子类。它们继承了这个类的许多方法。
//		其中，最有用的一个是 toString,这个方法会返回枚举常量名。

		
//		toString 的逆方法是静态方法 value0f。
		Size01 s = Enum.valueOf (Size01.class, "SMALL"); // 将s设置成 Size01.SMALL
		System.out.println(s.toString());

//		每个枚举类型都有一个静态的 values 方法，它将返回一个包含全部枚举值的数组。
		Size01[] values = Size01.values();
		System.out.println(values[1]);
		
//		ordinal 方法返回一个枚举常量在enum声明中的位置，位置从0开始计数。
		System.out.println(Size01.MEDIUN.ordinal());

	}
}
