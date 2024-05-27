package chapter.o4.innerClass.anonymousInmerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;

public class TalkingClock {
	public void start(int interval, boolean beep) {
		var listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
				if(beep) {
					System.out.println("The beep is true ");
				}
			}
		};
		var timer = new Timer(interval, listener);
		timer.start();
	}
}
