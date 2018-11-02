package hu.ak_akademia.snake.control;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Direction;
import hu.ak_akademia.snake.model.FieldState;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.model.SnakePiece;
import hu.ak_akademia.snake.model.Player;

public class SnakeController implements ActionListener {
	protected Snake snake;
	protected Board board;
	protected Direction dir = Direction.RIGHT;
	protected Player player;
	protected FoodFactory food;
	protected Timer timer;
	protected boolean end;
	TextArea screen;
	TextField scoring;

	public SnakeController(Snake snake, Board board, TextArea screen,TextField scoring) {
		this.snake = snake;
		this.board = board;
		this.screen = screen;
		this.scoring = scoring;
		timer = new Timer(100,this);
		food = new FoodFactory(board);
		player = new Player();
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
		food.placeFood();
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public Direction getDir() {
		return dir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int lastX = snake.getHead().getCoorX();
		int lastY = snake.getHead().getCoorY();
		move();
		if(!end) {
			screen.setText(board.toString());
			scoring.setText(player.toString());
		}
	}

	private void placeSnakePieceToBoard(int row, int coloum, SnakePiece piece) {
		board.getFields()[row][coloum] = piece.getPiece();
	}

	private void move() {
		int[] nextFieldCoors = getNextFieldCoors();
		switch (checkNextField()) {
		case COLLECTABLE:
			feed();
		case FREE:
			new SnakeMover(snake,board).autoMove(nextFieldCoors);
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
		food.placeFood();
		
	}

	private void gameOver() {
		end = true;
		timer.stop();
		screen.setText("Game Over!");
	}

	private FieldState checkNextField() {
		int[] nextFieldCoordinates = getNextFieldCoors();
		return board.getFields()[nextFieldCoordinates[0]][nextFieldCoordinates[1]].getState();
	}
}
