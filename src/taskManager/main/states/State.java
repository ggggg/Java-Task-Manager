package taskManager.main.states;

import javax.swing.JPanel;

import taskManager.main.Main;

public abstract class State {

	public State(JPanel panel, Main main) {
		
	}
	protected abstract void start();
	public abstract void update();
	
	
}
