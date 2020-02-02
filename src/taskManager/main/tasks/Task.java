package taskManager.main.tasks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import taskManager.main.states.StateManeger;

public class Task {

	JButton button;
	private boolean checked;
	private String name;
	private long time;
	private long timeNow;
	private long exparationTime;
	private String length;
	private long expartion;
	private JPanel panel;
	private Tasks tasks;
	private StateManeger states;
	private boolean overDue;

	public Task(String name, JPanel panel, Tasks tasks, long exparationTime, String length, StateManeger states) {
		checked = false;
		this.name = name;
		this.tasks = tasks;
		this.panel = panel;
		this.states = states;
		this.length = length;
		timeNow = System.currentTimeMillis();
		overDue=false;

		if (length == "D") {
			expartion = timeNow + daysToMs(exparationTime);
		} else if (length == "H")
			expartion = timeNow + hoursToMs(exparationTime);
		 else if (length == "M")
				expartion = timeNow + minutesToMs(exparationTime);
		

	}

	public void drawTask(int x, int y) {
		JLabel name = new JLabel(this.name);
		name.setLocation(x + 200, y);
		name.setSize(86, 14);
		name.setVisible(true);
		panel.add(name);
		JButton b = new JButton();
		b.setBounds(x, y, 95, 30);
		panel.add(b);
		b.setText("x");
		Task t = this;
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
					tasks.removeTask(t);
				
				states.update();
			}
		});
		JButton check = new JButton();
		check.setBounds(x + 100, y, 95, 30);
		panel.add(check);
		check.setText("v");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checked) {
					checked = false;
				} else {
					checked = true;

				}
				states.update();
			}
		});
		if (checked) {
			name.setText("<html><strike>" + this.name + "</strike></html>");

		} else {
			name.setText("<html>"+this.name+"</html>");
		}

		JLabel timeLeft = new JLabel();
		if (!isOverDue()) {
		if (((((expartion - timeNow) / (1000*60)) % 60)) < 1) {
			timeLeft.setText("Time left: " + String.valueOf(((expartion - timeNow) / 1000) % 60) + "S");
		}else if((((expartion - timeNow) / (1000 * 60 * 60)) % 24 < 1)){
			timeLeft.setText("Time left: " + String.valueOf(((expartion - timeNow) /60000)+"M"));
		}
		else {
		
			timeLeft.setText("Time left: " + String.valueOf(((expartion - timeNow) /3600000)+"H"));
		}
		}else {
			timeLeft.setForeground(Color.red);
			timeLeft.setText("OVER DUE");
		}
		timeLeft.setLocation(x + 200, y + 50);
		timeLeft.setSize(86, 14);
		timeLeft.setVisible(true);
		panel.add(timeLeft);

	}

	private long daysToMs(long time2) {
		System.out.println(time2 * 86400000);
		return (time2 * 86400000);

	}

	private long hoursToMs(long time2) {
		return time2 * 3600000;
	}

	private long minutesToMs(long time2) {
		return time2 * 6000;
	}

	public boolean expired() {
		timeNow = System.currentTimeMillis();
		if (timeNow > expartion)
			return true;
		else
			return false;
	}
	public boolean checked() {
		return checked;
	}
	public void overDue() {
		overDue = true;
		System.out.println("overDue");
	}

	public boolean isOverDue() {
		return overDue;
	}

}
