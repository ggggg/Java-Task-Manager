package taskManager.main.states;

import javax.swing.JPanel;

import taskManager.main.Main;
import taskManager.main.states.home.AddTaskState;
import taskManager.main.states.home.HomeState;
import taskManager.main.tasks.Tasks;

public class StateManeger {

	HomeState home;
	JPanel panel;
	Main main;
	int state;
	Tasks t;
	private AddTaskState add;

	public StateManeger(JPanel panel, Main main) {

		this.panel = panel;
		this.main = main;
		state = 1;
		t = new Tasks(panel, this);
		home = new HomeState(this.panel, this.main, t, this);
		add = new AddTaskState(this.panel, this.main, t, this);
	}

	public void update() {

		if (state == 1) {
			panel.removeAll();
			home.update();
		} else if (state == 2) {
			add.update();
		}
		panel.updateUI();
	}

	public void startHome() {
		state = 1;
		panel.removeAll();
		home.start();
	}

	public void addTask() {
		state = 2;
		panel.removeAll();
		add.start();
	}

}
