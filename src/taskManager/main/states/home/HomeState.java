package taskManager.main.states.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import taskManager.main.Main;
import taskManager.main.states.State;
import taskManager.main.states.StateManeger;
import taskManager.main.tasks.Tasks;

public class HomeState extends State {

	private JPanel panel;
	private Main main;
	private Tasks t;

	public HomeState(JPanel panel, Main main, Tasks t, StateManeger states) {
		super(panel, main);
		this.panel = panel;
		this.main = main;
		this.t = t;
	}

	@Override
	public void start() {

		t.drawTasks();

	}

	@Override
	public void update() {
		t.drawTasks();
	}

}
