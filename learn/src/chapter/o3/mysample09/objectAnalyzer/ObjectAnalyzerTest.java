package chapter.o3.mysample09.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import chapter.o3.mysample09.Employee;

public class ObjectAnalyzerTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		var harry = new Employee("Harry Hacker", 50000, 1989, 12, 20);
		Class clHarry = harry.getClass();
		Field[] fields = clHarry.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		for(Field f : fields) {
			Object v = f.get(harry);
			System.out.println(v);
		}
	}

}
