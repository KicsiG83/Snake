package hu.ak_akademia.snake.gameboard;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateReturnPanel implements JPanelController {

	private final JButton btReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	
	@Override
	public JPanel createPanel() {
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.add(btReturn);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column) {
		return null;
	}

}
