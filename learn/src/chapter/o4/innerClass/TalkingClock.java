package chapter.o4.innerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;

public class TalkingClock {
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		var listener = new TimePrinter();
		var timer = new Timer(interval, listener);
		timer.start();
	}

	class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));
			if(beep) {
				System.out.println("The beep is true ");
			}
		}
	}
}
