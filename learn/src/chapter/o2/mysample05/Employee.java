package chapter.o2.mysample05;

import java.util.Random;

public class Employee {

	private static int nextId;
	
	private int id;
	// instance field initialization
	private String name = "";
	private double salary;
	
	private static Random generator =new Random();
	
	// static initialization  block
	static {
		// 调用generator.nextInt(n)方法来生成随机数。
		nextId = generator.nextInt(10000); 
	}

	// object initialization block
	{
		id = nextId;
		nextId ++;
	}

	// three overloaded constructors
	public Employee () {}

	public Employee (double s) {
		this("Employee#" + nextId, s);
	}

	public Employee (String n, double s) {
		name = n;
		salary = s;
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
}
