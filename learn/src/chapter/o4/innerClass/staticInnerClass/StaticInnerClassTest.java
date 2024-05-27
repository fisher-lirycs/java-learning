package chapter.o4.innerClass.staticInnerClass;

public class StaticInnerClassTest {

	public static void main(String[] args) {
		var values = new double[20];
		for(int i = 0; i < values.length; i++) {
			values[i] = 100 * Math.random();
		}
		ArrayAlg.Pair p = ArrayAlg.minmax(values);
		System.out.println("min = " + p.getFirst());
		System.out.println("max =" + p.getSecond());
	}

}
