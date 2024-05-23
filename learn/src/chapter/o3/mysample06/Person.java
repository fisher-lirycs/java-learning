package chapter.o3.mysample06;

public abstract class Person {
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public abstract String getDescription();
	
}
