package chapter.o3.mysample07;

import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		var in = new Scanner(System.in);
		System.out.print("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size=" + size);
		System.out.println("abbreviation=" + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE) {
			System.out.println("Good job--you paid attention to the _.");
		}
	}
	
	enum Size {
		SMALL("S"), MEDIUN("N"), LARGE("L"), EXTRA_LARGE("XL");
		private String abbreviation;

		Size(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		public String getAbbreviation() {
			return abbreviation;
		}
	}
}
