package chapter.o4.innerClass.anonymousInmerClass;

import javax.swing.JOptionPane;

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		var clock = new TalkingClock();
		clock.start(1000,true);
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
