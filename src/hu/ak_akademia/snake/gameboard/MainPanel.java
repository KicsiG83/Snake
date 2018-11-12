package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel implements JPanelController{

	private final JButton btGame = new Buttons().createButton("resources/pictures/buttons/game.png");
	private final JButton btDemo = new Buttons().createButton("resources/pictures/buttons/demo.png");
	private final JButton btScores = new Buttons().createButton("resources/pictures/buttons/scores.png");
	private final JButton btExit = new Buttons().createButton("resources/pictures/buttons/exit.png");
	
	@Override
	public JPanel createPanel() {
		JPanel pn = new JPanel();
		pn.setBackground(Color.decode("#8cb404"));
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png")), BorderLayout.NORTH);
		pn.add(createMainPanel(4, 1), BorderLayout.CENTER);
		pn.add(new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png")), BorderLayout.SOUTH);
		return pn;
	}
	
	@Override
	public JPanel createMainPanel(int row, int column) {
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(row, column));
		pn.add(btGame);
		pn.add(btDemo);
		pn.add(btScores);
		pn.add(btExit);
		return pn;
	}
}
