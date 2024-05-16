package chapter.o1;

import java.math.BigInteger;

/*
8、大数
*/
public class MySample08 {

	public static void main(String[] args) {
//		如果基本的整数和浮点数精度不足以满足需求，那么可以使用java.math包中两个很有用的类：BigInteger和BigDecimal。
//		这两个类可以处理包含任意长度数字序列的数值。
//		BigInteger类实现任意精度的整数运算，BigDecimal实现任意精度的浮点数运算。
//		使用静态的 valueOf 方法可以将一个普通的数转换为大数：
		BigInteger a = BigInteger.valueOf(100);
		BigInteger b = BigInteger.valueOf(200);
		
//		对于更长的数，可以使用一个带字符串参数的构造器：
		BigInteger reallyBig = new BigInteger("222232244629420445529739893461909967206666939096499764990979600");

//		另外还有一些常量：BigInteger.ZERO、BigInteger.ONE 和 BigInteger.TEN,Java 9 之后还增加了 BigInteger,TWO。

//		遗憾的是，不能使用人们熟悉的算术运算符(如：+和*)来组合大数，而需要使用大数类中的 add和 multiply方法。
		 
		BigInteger c = a.add(b); // c = a + b
		BigInteger d = c.multiply(b.add(BigInteger.valueOf(2))); // d = c * (b + 2)
		
//		BigInteger:
//		● BigInteger add(BigInteger other)
//		● BigInteger subtract(BigInteger other)
//		● BigInteger multiply(BigInteger other)
//		● BigInteger divide(BigInteger other)
//		● BigInteger mod(BigInteger other)
//		  返回这个大整数和另一个大整数 other 的和、差、积、商以及余数。
//		● BigInteger sqrt()  Java9
//		  得到这个BigInteger的平方根。
//		● int compareTo(BigInteger other)
//		  如果这个大整数与另一个大整数other相等，返回0;如果这个大整数小于另一个大整数other, 返回负数；否则，返回正数。
//		● static BigInteger valueOf(long  x)
//		  返回值等于x 的大整数。

//		BigDecimal:
//		● BigDecimal add(BigDecimal other)
//		● BigDecimal subtract(BigDecimal other)
//		● BigDecimal multiply(BigDecimal other)
//		● BigDecimal divide(BigDecimal other)
//		● BigDecimal mod(BigDecimal other)
//		  返回这个大整数和另一个大整数 other 的和、差、积、商以及余数。
//		● BigInteger sqrt()  Java9
//		● int compareTo(BigDecimal other)
//		  如果这个大整数与另一个大整数other相等，返回0;如果这个大整数小于另一个大整数other, 返回负数；否则，返回正数。
	}
}