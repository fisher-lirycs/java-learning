package chapter.o2.mysample05;

import java.time.LocalDate;

public class Employee01 {

	private static int nextId = 1;
	
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee01() {
		name = "";
		salary = 0;
		hireDay = LocalDate.now();
	}

	public Employee01 (String n, double s, int year, int month, int day) {
		name =n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
}
