package chapter.o4.mysample01.interfaces.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
	public  void  actionPerformed(ActionEvent  event) {
		System.out.println("At the tone, the ime is" + Instant.ofEpochMilli(event.getWhen()));
		Toolkit.getDefaultToolkit().beep();
	}
}
