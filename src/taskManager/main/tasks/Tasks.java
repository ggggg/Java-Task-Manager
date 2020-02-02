package taskManager.main.tasks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import taskManager.main.states.StateManeger;

public class Tasks {

	int x = 30, y;

	private List<Task> tasks;
	private JPanel panel;
	StateManeger states;

	public Tasks(JPanel panel, StateManeger states) {
		tasks = new ArrayList<Task>();
		this.panel = panel;
		this.states = states;

	}

	public void addTask(String name, long exparationTime, String length) {
		tasks.add(new Task(name, panel, this, exparationTime, length, states));

	}

	void removeTask(Task t) {
		tasks.remove(tasks.indexOf(t));
	}

	void removeTask(int t) {
		tasks.remove(t);
	}

	public void drawTasks() {
		y = 50;
		panel.removeAll();
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).expired() && !tasks.get(i).isOverDue()) {
				if (tasks.get(i).checked()) {
					System.out.println("Removed task " + i);
					removeTask(i);
				}else {
					tasks.get(i).overDue();
					states.update();
				}
			} else {
				tasks.get(i).drawTask(x, y);
				y += 100;
			}
		}

		JButton b = new JButton("Add Task");
		b.setBounds(x, y, 95, 30);

		b.setVisible(true);
		panel.add(b);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				states.addTask();
			}
		});

		panel.updateUI();

	}

}
