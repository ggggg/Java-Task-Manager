package taskManager.main.display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Display {

	private JFrame frame;
	private JPanel panel;


	private String title;
	private int width, height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay() {
		frame = new JFrame(title);
		getFrame().setSize(width, height);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setResizable(false);
		getFrame().setLocationRelativeTo(null);
		getFrame().setVisible(true);
		panel = new JPanel();
		panel.setEnabled(true);
		
		panel.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		 
		  
	       

	}




	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {

		return panel;
	}

}