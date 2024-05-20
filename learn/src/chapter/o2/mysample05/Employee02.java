package chapter.o2.mysample05;

public class Employee02 {

	private static int nextId;
	
	private String name;
	private double salary;
	private int id;

	{
		id = nextId;
		nextId ++;
	}

	public Employee02 () {
		name = "";
		salary = 0;
	}

	public Employee02 (String n, double s) {
		name = n;
		salary = s;
	}
	



}
