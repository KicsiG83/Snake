package hu.ak_akademia.snake.gameboard;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateReturnPanel implements JPanelController {

	@Override
	public JPanel createPanel(JButton[] buttons) {
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(3, 1, 5, 10));
		pn.setBackground(Color.decode("#8cb404"));
		for (JButton jButton : buttons) {
			pn.add(jButton);
		}
		return pn;
	}

	public JPanel createPanel(JButton[] buttons, int index) {
		JPanel pn = new CreateJPanel().createPanel();
		pn.setLayout(new FlowLayout());
		for (int i = index; i < buttons.length; i++) {
			pn.add(buttons[i]);
		}
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		return null;
	}
}
