package chapter.o4.mysample01.interfaces.timer;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {
		var listener = new TimePrinter();
		var timer = new Timer(1000, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
