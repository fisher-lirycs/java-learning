package chapter.o3.mysample02;

public class EqualsTest {

	public static void main(String[] args) {
		var alicel = new Employee("Alice Adams", 75000, 1987, 12, 15);
		var alice2 = alicel;
		var alice3 =new Employee("Alice Adams", 75000, 1987, 12, 15);
		var bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
		System.out.println("alicel == alice2:" + (alicel == alice2));
		System.out.println("alicel == alice3:" + (alicel == alice3));
		System.out.println("alicel.equals(alice3): " + alicel.equals(alice3));
		System.out.println("alicel.equals(bob):" + alicel.equals(bob));
		System.out.println("bob,toString():" + bob);
		
		var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		var boss =new Manager("Carl Cracker",80000,1987, 12, 15);
		boss.setBonus(5000);
		System.out.println("boss.toString():" + boss);
		System.out.println("carl.equals(boss):" + carl.equals(boss));
	}
}
