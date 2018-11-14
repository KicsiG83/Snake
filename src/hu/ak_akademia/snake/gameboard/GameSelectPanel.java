package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameSelectPanel implements JPanelController {

	@Override
	public JPanel createPanel(JButton[] jbuttons) {
		JPanel pn = new CreateJPanel().createPanel();
		pn.add(snakeMainPicture, BorderLayout.NORTH);
		pn.add(createMainPanel(5, 2, jbuttons), BorderLayout.CENTER);
		pn.add(menuSouthPicture, BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column, JButton[] buttons) {
		JPanel gameSelectMainPanel = new CreateJPanel().createPanel();
		gameSelectMainPanel.setLayout(new GridLayout(2, 1));
		JPanel gsb = new CreateJPanel().createPanel();
		gsb.setLayout(new GridLayout(row, column));
		for (int i = 0; i < buttons.length-1; i++) {
			gsb.add(buttons[i]);
		}
		gameSelectMainPanel.add(gsb);
		gameSelectMainPanel.add(new CreateReturnPanel().createPanel(buttons));
		return gameSelectMainPanel;
	}
}
