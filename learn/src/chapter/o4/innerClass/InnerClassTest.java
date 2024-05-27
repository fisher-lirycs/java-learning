package chapter.o4.innerClass;

import javax.swing.JOptionPane;

public class InnerClassTest {

	public static void main(String[] args) {
		var clock = new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
