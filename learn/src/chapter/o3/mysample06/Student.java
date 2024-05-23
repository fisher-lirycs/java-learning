package chapter.o3.mysample06;

public class Student extends Person{

	private String  major;

	public Student (String n, String m) {
		super(n);
		major = m;
	}

	public String getMajor() {
		return major;
	}


	public String getDescription() {
		return "a student majoring in" + major;
	}

}
