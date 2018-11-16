package hu.ak_akademia.snake.control;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import hu.ak_akademia.snake.gameboard.MainBoard;
import hu.ak_akademia.snake.gameboard.MainPanel;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Direction;
import hu.ak_akademia.snake.model.FieldState;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;

public class DemoController extends SnakeController implements ActionListener {

	private static final long serialVersionUID = 1L;
	public DemoController(Snake snake, Board board, JTextPane screen, JLabel scoring, Player player) {
		super(snake, board, screen, scoring, player);
	}

	@Override
	public void setDir(Direction dir) {
		this.dir = dir;
	}

	@Override
	public Direction getDir() {
		return dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		snakeMovever();
		screen.setText(board.toString());
		scoring.setText(player.toString());
	}

	public void snakeMovever() {
		int[] nextFieldCoors = getNextFieldCoors();
		switch (checkNextField()) {
		case COLLECTABLE:
			feed();
		case FREE:
			new SnakeMover(snake, board).autoMove(nextFieldCoors);
			break;
		case INUSE:
			gameOver();
			break;
		}
	}

	private int[] getNextFieldCoors() {
		int[] foodCoors = food.getCoorsOfLastFood();
		int[] right = { snake.getHead().getCoorX(), snake.getHead().getCoorY() + 1 };
		int[] left = { snake.getHead().getCoorX(), snake.getHead().getCoorY() - 1 };
		int[] up = { snake.getHead().getCoorX() - 1, snake.getHead().getCoorY() };
		int[] down = { snake.getHead().getCoorX() + 1, snake.getHead().getCoorY() };
		int[][] optionalSteps = { right, left, up, down };
		List<Integer> distances = new ArrayList<>();

		for (int i = 0; i < optionalSteps.length; i++) {
			if (!board.getFields()[optionalSteps[i][0]][optionalSteps[i][1]].getState().equals(FieldState.INUSE)) {
				Integer dist = (foodCoors[0] - optionalSteps[i][0]) * (foodCoors[0] - optionalSteps[i][0])
						+ (foodCoors[1] - optionalSteps[i][1]) * (foodCoors[1] - optionalSteps[i][1]);
				distances.add(dist);
			} else {
				distances.add(Integer.MAX_VALUE);
			}
		}

		int minIndex = 0;
		for (int i = 0; i < distances.size(); i++) {
			if (distances.get(i) < distances.get(minIndex)) {
				minIndex = i;
			}
		}
		switch (minIndex) {
		case 0:
			setDir(Direction.RIGHT);
			break;
		case 1:
			setDir(Direction.LEFT);
			break;
		case 2:
			setDir(Direction.UP);
			break;
		case 3:
			setDir(Direction.DOWN);
			break;
		}
		return optionalSteps[minIndex];
	}

	private void feed() {
		player.setPoint(player.getPoint() + 1);
		snake.eat();
		food.placeFood();
	}

	/**
	 * TODO 
	 * A leállást követően vagy még előtte vizsgálni kell a vissza gombot! 
	 * Cél a főmenü!
	 */
	public void gameOver() {
		end = true;
		timer.stop();
		setVisible(false);
		removeAll();
		screen.add(new MainPanel().createPanel(MainBoard.mainButtons));
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SPACE);
	        robot.keyRelease(KeyEvent.VK_SPACE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		revalidate();
		repaint();
		
	}

	private FieldState checkNextField() {
		int[] nextFieldCoordinates = getNextFieldCoors();
		return board.getFields()[nextFieldCoordinates[0]][nextFieldCoordinates[1]].getState();
	}
}
