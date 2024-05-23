package chapter.o3.mysample06;

import java.time.LocalDate;

public class Employee extends Person{

	private double salary;
	private LocalDate hireDay;

	public Employee (String n, double s, int year, int month, int day) {
		super(n);
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}


	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public String getDescription() {
		 return"an employee with a salary of $%.2f".formatted(salary);
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent /100;
		salary += raise;
	}
}
