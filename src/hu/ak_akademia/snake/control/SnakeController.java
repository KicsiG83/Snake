package hu.ak_akademia.snake.control;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Direction;
import hu.ak_akademia.snake.model.FieldState;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.model.SnakePiece;

public class SnakeController implements ActionListener {
	private Snake snake;
	private Board board;
	private Direction dir = Direction.RIGHT;
	private Player player;
	TextArea screen;

	public SnakeController(Snake snake, Board board, TextArea screen) {
		this.snake = snake;
		this.board = board;
		this.screen = screen;
		int startRow = board.getFields().length / 2;
		int startColoum = snake.getLength() + 2;
	
		SnakePiece lastPiece = snake.getHead();
		while (lastPiece.getPointer() != null) {
			lastPiece.setCoorX(startRow);
			lastPiece.setCoorY(startColoum);
			placeSnakePieceToBoard(startRow, startColoum, lastPiece);
			startColoum--;
			lastPiece = lastPiece.getPointer();
		}
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public Direction getDir() {
		return dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		screen.setText(board.toString());
	}

	private void placeSnakePieceToBoard(int row, int coloum, SnakePiece piece) {
		board.getFields()[row][coloum] = piece.getPiece();
	}

	private void move() {
		int[] nextFieldCoors = getNextFieldCoors();
		switch (checkNextField()) {
		case FREE:
			new SnakeMover(snake,board).autoMove(nextFieldCoors);
			break;
		case COLLECTABLE:
			feed();
			break;
		case INUSE:
			gameOver();
			break;
		}
	}

	private int[] getNextFieldCoors() {
		int[] nextFieldCoordinates = new int[2];
		switch (dir) {
		case RIGHT:
			nextFieldCoordinates[0] = snake.getHead().getCoorX();
			nextFieldCoordinates[1] = snake.getHead().getCoorY() + 1;
			break;
		case LEFT:
			nextFieldCoordinates[0] = snake.getHead().getCoorX();
			nextFieldCoordinates[1] = snake.getHead().getCoorY() - 1;
			break;
		case UP:
			nextFieldCoordinates[0] = snake.getHead().getCoorX() - 1;
			nextFieldCoordinates[1] = snake.getHead().getCoorY();
			break;
		case DOWN:
			nextFieldCoordinates[0] = snake.getHead().getCoorX() + 1;
			nextFieldCoordinates[1] = snake.getHead().getCoorY();
			break;
		}

		return nextFieldCoordinates;
	}

	private void feed() {
		player.setPoint(player.getPoint()+1);
		snake.eat();
		
	}

	private void gameOver() {
		
	}

	private FieldState checkNextField() {
		int[] nextFieldCoordinates = getNextFieldCoors();
		return board.getFields()[nextFieldCoordinates[0]][nextFieldCoordinates[1]].getState();
	}
}
