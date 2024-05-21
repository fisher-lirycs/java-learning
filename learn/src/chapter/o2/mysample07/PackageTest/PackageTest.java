package chapter.o2.mysample07.PackageTest;

import chapter.o2.mysample07.Employee.*;
import static java.lang.System.*;

public class PackageTest {

	public static void main(String[] args) {
		var harry = new Employee("Harry Hacker", 50000, 1989, 12, 1);
		harry.raiseSalary(5);
		out.print("name = " + harry.getName() + ", salary = " + harry.getSalary());
	}
}
