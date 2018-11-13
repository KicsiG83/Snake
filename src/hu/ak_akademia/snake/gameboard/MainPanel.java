package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel implements JPanelController {

	@Override
	public JPanel createPanel(JButton[] buttons) {
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png")), BorderLayout.NORTH);
		pn.add(createMainPanel(4, 1, buttons), BorderLayout.CENTER);
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png")), BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(row, column));
		for (int i = 0; i < buttons.length; i++) {
			pn.add(buttons[i]);
		}
		return pn;
	}
}
