package taskManager.main;

import taskManager.main.display.Display;
import taskManager.main.states.StateManeger;

public class Main {

	private Display display;

	// Initialize the window variables
	private int width;
	private int height;
	private String title;

	private StateManeger states;

	// Start the class
	public Main(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init() {
		display = new Display(title, width, height);
		states = new StateManeger(display.getPanel(), this);

	}

	public void run() {
		init();

		states.update();
		try {
			while (true) {
				states.update();
				System.out.println("updated");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
