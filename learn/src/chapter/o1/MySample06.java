package chapter.o1;
/*
 6、字符符
 Java没有内置的字符串类型，而是标准Java类库中提供了一个预定义类，很自然地叫作String。
 每个用双引号括起来的字符串都是String类的一个实例
 String e = ""; //an empty string
 String greeting  = "Hello";

 */

public class MySample06 {

	public static void main(String[] args) {
		// 6-1、子串
		// String 类的 substring 方法可以从一个较大的字符串提取出一个子串。
		String greeting = "Hello";
		String s = greeting.substring(0, 3); // 会创建一个由字符"Hel" 组成的字符串。
		// 字符串中的代码单元和码点从θ开始计数。
		// substring 的工作方式有一个优点：很容易计算子串的长度。
		// 字符串s.substring(a, b)的长度为b-a。
		// 例如，子串"Hel"的长度为3 - 0 = 3。

		// 6-2、拼接
		// Java允许使用+号连接(拼接)两个字符串。
		String expletive = "Expletive";
		String PG13 = "deleted";
		String message = expletive + PG13; // "Expletivedeleted"
		
		// 当将一个字符串与一个非字符串的值进行拼接时，后者会转换成字符串
		int age = 13;
		String rating = "PG" + age; // "PG13"
		
		String ss = 13 + "";
		
		// 这个特性通常用在输出语句中。例如：
		String answer = "no";
		System.out.println("The answer is" + answer);
		
		// 如果需要把多个字符串放在一起，用一个界定符分隔，可以使用静态join 方法：
		String all = String.join("/", "S", "M", "L", "XL"); // all is the string "S/M/L/XL"
		
		// 在Java 11中，还提供了一个 repeat 方法：
		String repeated = "Java".repeat(3); // repeated is "JavaJavaJava"

		// 6-3、字符串不可变
		// String 类没有提供任何方法来修改字符串中的某个字符。
		// 如果希望将 greeting 的内容修改 为 "Help!", 不能直接将greeting的最后两个位置的字符修改为 'p'和'!'。
		// 可以提取想要保留的子串，再与希望替换的字符拼接：
		greeting = greeting.substring(0, 3) + "p!";
		
		// 由于不能修改Java字符串中的单个字符，所以在Java 文档中将String 类对象称为是不可变的 (immutable),
		// 如同数字3永远是数字3一样，字符串"Hello"永远包含字符H、e、l、 1 和o 的代码单元序列。
		// 你不能修改这些值，不过，可以修改字符串变量greeting的内容，让它指向另外一个字符串，
		// 这就如同可以让原本存放3的数值变量改成存放4一样。

		// 6-4、检测字符串是否相等
		// 可以使用equals方法检测两个字符串是否相等。对于表达式：
		// s.equals(t)
		// 如果字符串s与字符串t相等，则返回true; 否则，返回false 。需要注意的是，
		// s与t可以是字符串变量，也可以是字符串字面量。例如，以下表达式是合法的：
		"Hello".equals(greeting);
		
		// 要想检测两个字符串是否相等，而不区分大小写，可以使用equalsIgnoreCase 方法。
		"Hello".equalsIgnoreCase("hello");
		
		// 不要使用==运算符检测两个字符串是否相等!
		// 这个运算符只能够确定两个字符串是否存放在同一个位置上。

		// 6-5、空串与Null串
		// 空串""是长度为0的字符串。可以调用以下代码检查一个字符串是否为空：
		String str = "";
		if(str.length() == 0) { }
		// 或
		if("".equals(str)) { }
		// 常量在前
		
		// 空串是一个Java 对象，有自己的串长度(0)和内容(空)。
		// 不过，String 变量还可以存 放一个特殊的值，名为null,表示目前没有任何对象与该变量关联
		// 要检查一个字符串是否为 null,  可以使用以下代码：
		if(str == null) { }

		// 有时要检查一个字符串既不是 null 也不是空串，这种情况下可以使用：
		if (str != null  && str.length() != 0) { }
		
		// 6-6、String API
		// Java中的String类包含近100个方法。下面的 API 注释汇总了最常用的一些方法。
		// ● int compareTo(String other)
		//     按照字典顺序，如果字符串位于other 之前，返回一个负数；
		//     如果字符串位于other 之后，返回一个正数；
		//     如果两个字符串相等，返回θ。
		// ● boolean isEmpty()
		//   boolean isBlank() ※Java11
		//     如果字符串为空或者由空白符组成，返回 true。
		// ● boolean equals(0bject other)
		//     如果字符串与 other 相等，返回 true。
		// ● boolean equalsIgnoreCase(String other)
		//     如果字符串与other 相等(忽略大小写),返回 true。
		// ● boolean startsWith(String prefix)
		//   boolean endsWith(String suffix)
		//     如果字符串以prefix开头或以suffix或结尾，则返回true。
		// ● boolean indexOf(String str)
		//   boolean indexOf(String str, int fromIndex)
		//     返回与字符串str 相等的第一个子串的开始位置。从索引θ或fromIndex开始匹配。如果str不在字符串中，则返回-1。
		// ● boolean lastIndexOf(String str)
		//   boolean lastIndexOf(String str, int fromIndex)
		//     返回与字符串str 相等的最后一个子串的开始位置。从字符串末尾或fromIndex开始匹配。如果str不在字符串中，则返回-1。
		// ● int length()
		//     返回字符串代码单元的个数。
		// ● String replace(CharSequence oldString, CharSequence newString)
		//     返回一个新字符串，这是用newString替换原始字符串中与oldString匹配的所有子串得到的。可以用String 或 StringBuilder对象作为CharSequence参数。
		// ● String substring(int beginIndex)
		//   String substring(int beginIndex, int endIndex)
		// 返回一个新字符串，这个字符串包含原始字符串中从beginIndex到字符串末尾或endIndex - 1的所有代码单元。
		// ● String toLowerCase()
		//   String toUpperCase()
		// 返回一个新字符串，这个字符串包含原始字符串中的所有字符，不过将原始字符串中的大写字母改为小写，或者将原始字符串中的小写字母改成大写母。
		// ● String strip() ※Java11
		//   String stripLeading() ※Java11
		//   String stripTrailing() ※Java11
		// 返回一个新字符串，这个字符串要删除原始字符串头部和尾部或者只是头部或尾部 的空白符。
		// 要使用这些方法，而不要使用古老的trim 方法删除小于等于U+0020的字符。
		// ● String join(CharSequence delimiter, CharSequence..elements)
		//     返回一个新字符串，用给定的定界符连接所有元素。
		// ● String repeat(int count) ※Java11
		//     返回一个字符串，将当前字符串重复count次。


		// 6-7、构建字符串
		// 有些时候，需要由较短的字符串构建字符串，例如，按键或文件中的单词。
		// 如果采用字符串拼接的方式来达到这个目的，效率会比较低。每次拼接字符串时，都会构建一个新的String对象，既耗时，又浪费空间。
		// 使用StringBuilder类就可以避免这个问题。
		
		// 构建一个空的字符串构建器：
		StringBuilder builder =new StringBuilder();
		// 当每次需要添加另外一部分时，就调用append 方法。
		builder.append(str);
		// 字符串构建完成时，调用toString方法。你会得到一个String对象
		String completedString = builder.toString();

		// 6-8、文本块
		// 利用Java15新增的文本块特性，可以很容易地提供跨多行的字符串字面量。
		// 文本块以"""开头(这是开始"""),后面是一个换行符，并以另一个"""结尾(这是结束"""):
		String greeting02 = """
				<html>
					<div>
					</div>
				</html>
				""";
		System.out.println(greeting02);

		// 如果不想要最后一行后面的换行符，可以让结束"""紧跟在最后一个字符后面：
		String prompt = """
		Hello,my name is Hal.
		Please enter your name:""";
		System.out.println(prompt);
		
		// 需要说明的是， 一般不用对引号转义。只有两种情况下需要对引号转义：
		// ●文本块以一个引号结尾。
		// ●文本块中包含三个或更多引号组成的一个序列。

	}
}