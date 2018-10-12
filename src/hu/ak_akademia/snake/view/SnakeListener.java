package hu.ak_akademia.snake.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import hu.ak_akademia.snake.control.SnakeController;
import hu.ak_akademia.snake.model.Direction;

public class SnakeListener extends KeyAdapter implements KeyListener {
	private SnakeController sc;

	public SnakeListener(SnakeController sc) {
		this.sc = sc;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Direction lastDir = sc.getDir();
		if (e == null) {
			return;
		}
		switch (e.getExtendedKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(lastDir==Direction.UP || lastDir==Direction.DOWN) {
				sc.setDir(Direction.LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT:
			 if(lastDir==Direction.UP || lastDir==Direction.DOWN) {
				sc.setDir(Direction.RIGHT);
			}
			break;
		case KeyEvent.VK_UP:
			if(lastDir==Direction.LEFT || lastDir==Direction.RIGHT) {
				sc.setDir(Direction.UP);
			}
			break;
		case KeyEvent.VK_DOWN:
			if(lastDir==Direction.LEFT || lastDir==Direction.RIGHT) {
				sc.setDir(Direction.DOWN);
			}
			break;
		}
	}
}
