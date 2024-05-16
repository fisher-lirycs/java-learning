package chapter.o2.mysample04;

public class ParamTest {

	public static void main(String[] args) {
		
		// Test 1: Methods can't modify numeric parameters
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before:percent = " + percent);
		tripleValue(percent);
		System.out.println("After:percent = " + percent);
		
		// Test 2: Methods can change the state of object parameters
		System.out.println("Testing tripleSalary:");
		var harry = new Employee("Harry", 50000.0);
		System.out.println("Before:salary = " + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary = " + harry.getSalary());
		
		// Test 3: Methods can't attach new objects to object parameters
		System.out.println("Testing swap:");
		var a = new Employee("Alice", 70000);
		var b = new Employee("Bob", 60000);
		System.out.println("Before:a = "+ a.getName());
		System.out.println("Before:b = "+ b.getName());
		swap(a,b);
		System.out.println("After:a = "+a.getName());
		System.out.println("After:b = "+b.getName());
	}

	public static void tripleValue(double x) {
		x = 3 * x;
	}

	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
	}

	public static void swap (Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
	}
}
