package hu.ak_akademia.snake.gameboard;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons {

	public JButton createButton(String path) {
		JButton button = new JButton(new ImageIcon(path));
		button.setBorderPainted(false);
		button.setName(path);
		button.setBackground(Color.decode("#8cb404"));
		return button;
	}
}
