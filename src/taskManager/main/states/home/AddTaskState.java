package taskManager.main.states.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import taskManager.main.Main;
import taskManager.main.states.State;
import taskManager.main.states.StateManeger;
import taskManager.main.tasks.Tasks;

public class AddTaskState extends State {
	private JPanel panel;
	private Main main;
	private Tasks t;
	private StateManeger states;
	private int x, y;

	public AddTaskState(JPanel panel, Main main, Tasks t, StateManeger states) {
		super(panel, main);
		this.panel = panel;
		this.main = main;
		this.t = t;
		this.states = states;
		x = 30;
		y = 100;
	}

	@Override
	public void start() {
		panel.removeAll();
		drawUI();
		panel.updateUI();
	}

	private void drawUI() {
		JLabel enterName = new JLabel("<html>Enter name </br> of task:</html>");
		JTextField name = new JTextField();
		JButton b = new JButton("Save");
		enterName.setLocation(x , y);
		enterName.setSize(100, 30);
		enterName.setVisible(true);
		b.setBounds(x, y+400, 95, 30);
		String[] choices = { "D", "H" , "M" };
		JTextField length = new JTextField();
		final JComboBox<String> cb = new JComboBox<String>(choices);
		length.setBounds(x + 100, y + 100, 100, 30);
		length.setVisible(true);
		panel.add(length);
		cb.setVisible(true);
		cb.setBounds(x, y + 100, 100, 30);
		panel.add(cb);
		b.setVisible(true);
		panel.add(b);
		panel.add(enterName);
		name.setLocation(x + 100, y);
		name.setVisible(true);
		name.setSize(100,30);
		panel.add(name);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(String.valueOf(cb.getSelectedItem()));
				try {
					t.addTask(name.getText(), Integer.parseInt(length.getText()), String.valueOf(cb.getSelectedItem()));
				} catch (Exception err) {

				}
				states.startHome();
			}
		});

		

	}

	@Override
	public void update() {

	}

}
