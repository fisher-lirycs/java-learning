package chapter.o3.mysample09.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {

	public static void main(String[] args) {
		int []a = {1, 2, 3};
		a = (int[])goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));

		String[]b = {"Tom", "Dick", "Harry"};
		b=(String[])goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
	}
	
	public static Object goodCopyOf(Object a, int newlength) {
		Class cl = a.getClass();
		if(!cl.isArray()) {
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newlength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newlength));
		return newArray;
	}
}
