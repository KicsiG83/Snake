package hu.ak_akademia.snake.gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameSelectPanel implements JPanelController{

	private final JButton btBoard1 = new Buttons().createButton("resources/pictures/boards/01.png");
	private final JButton btBoard2 = new Buttons().createButton("resources/pictures/boards/02.png");
	private final JButton btBoard3 = new Buttons().createButton("resources/pictures/boards/03.png");
	private final JButton btBoard4 = new Buttons().createButton("resources/pictures/boards/04.png");
	private final JButton btBoard5 = new Buttons().createButton("resources/pictures/boards/05.png");
	private final JButton btBoard6 = new Buttons().createButton("resources/pictures/boards/06.png");
	private final JButton btBoard7 = new Buttons().createButton("resources/pictures/boards/07.png");
	private final JButton btBoard8 = new Buttons().createButton("resources/pictures/boards/08.png");
	private final JButton btBoard9 = new Buttons().createButton("resources/pictures/boards/09.png");
	private final JButton btBoard10 = new Buttons().createButton("resources/pictures/boards/10.png");
	
	@Override
	public JPanel createPanel() {
		JPanel pn = new CreateJPanel().createPanel();
		pn.add(snakeMainPicture, BorderLayout.NORTH);
		pn.add(createMainPanel(5, 2), BorderLayout.CENTER);
		pn.add(menuSouthPicture, BorderLayout.SOUTH);
		return pn;
	}

	@Override
	public JPanel createMainPanel(int row, int column) {
		JPanel gameSelectMainPanel = new CreateJPanel().createPanel();
		JPanel gsb = new CreateJPanel().createPanel();
		gsb.setLayout(new GridLayout(row, column));
		gsb.add(btBoard1);
		gsb.add(btBoard2);
		gsb.add(btBoard3);
		gsb.add(btBoard4);
		gsb.add(btBoard5);
		gsb.add(btBoard6);
		gsb.add(btBoard7);
		gsb.add(btBoard8);
		gsb.add(btBoard9);
		gsb.add(btBoard10);
		gameSelectMainPanel.add(gsb);
		gameSelectMainPanel.add(new CreateReturnPanel().createPanel());
		return gameSelectMainPanel;
	}
}
