package hu.ak_akademia.snake.gameboard;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface JPanelController {

	JLabel snakeMainPicture = new JLabel(new ImageIcon("resources/pictures/background/snakeMainPicture.png"));
	JLabel menuSouthPicture = new JLabel(new ImageIcon("resources/pictures/background/menuSouthPicture.png"));
	
	JPanel createPanel(JButton[] jbuttons);
	
	JPanel createMainPanel(int row, int column, JButton[] jbuttons);
	
}
