package hu.ak_akademia.snake.gameboard;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateReturnPanel implements JPanelController {

	@Override
	public JPanel createPanel(JButton[] buttons) {
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.add(buttons[5]);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		return null;
	}

}
