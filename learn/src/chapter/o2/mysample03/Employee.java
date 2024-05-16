package chapter.o2.mysample03;

public class Employee {
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;

	public Employee (String n, double s) {
		name = n;
		salary = s;
		id = advanceId();
	}

	public String getName () {
		return name;
	}

	public double getSalary() {
		return  salary;
	}

	public int getId() {
		return  id;
	}

	public static int advanceId() {
		int r = nextId;
		nextId ++;
		return r;
	}
}
