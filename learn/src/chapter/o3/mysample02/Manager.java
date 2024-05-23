package chapter.o3.mysample02;

public class Manager extends Employee {
	
	private double bonus;
	
	public Manager (String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}

		var other  =(Manager)otherObject;
		return bonus == other.bonus;
	}
	
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}
}
