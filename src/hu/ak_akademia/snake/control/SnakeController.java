package hu.ak_akademia.snake.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import hu.ak_akademia.snake.gameboard.Buttons;
import hu.ak_akademia.snake.gameboard.CreateJPanel;
import hu.ak_akademia.snake.gameboard.GameOverPanel;
import hu.ak_akademia.snake.gameboard.MainBoard;
import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.Direction;
import hu.ak_akademia.snake.model.FieldState;
import hu.ak_akademia.snake.model.Player;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.model.SnakePiece;

public class SnakeController extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected Snake snake;
	protected Board board;
	protected Direction dir = Direction.RIGHT;
	protected Player player;
	protected FoodFactory food;
	protected Timer timer;
	protected boolean end;
	private JButton btReturn = new Buttons().createButton("resources/pictures/buttons/return.png");
	private JButton btExit = new Buttons().createButton("resources/pictures/buttons/exit.png");
	private JPanel pn = new JPanel();
	JTextPane screen;
	TextField scoring;

	public SnakeController(Snake snakeParam, Board boardParam, JTextPane screenParam, TextField scoringParam,
			Player player) {
		snake = snakeParam;
		board = boardParam;
		screen = screenParam;
		scoring = scoringParam;
		timer = new Timer(100, this);
		food = new FoodFactory(boardParam);
		this.player = player;

		/**TODO
		 * HIBA!!!
		 * Jelenleg a snake-et nem lehet irányítani, mert a JFrame nem kapja meg az irányítást.
		 * Az itteni actionPerformed-et át kell szervezni a MainBoard-ra!
		 */
		
		screen.setLayout(new BorderLayout());
		screen.setFont(new Font("monospaced", Font.PLAIN, 10));
		screen.setBorder(new EmptyBorder(10, 10, 10, 10));
		screen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		int startRow = boardParam.getFields().length / 2;
		int startColoum = snake.getLength() + 2;
		SnakePiece lastPiece = snake.getHead();
		pn.add(screenParam);
		JPanel buttonPn = new CreateJPanel().createPanel();
		btReturn.addActionListener(this);
		btExit.addActionListener(this);
		buttonPn.add(btReturn);
		buttonPn.add(btExit);
		screen.add(buttonPn, BorderLayout.SOUTH);
		add(pn);
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
		snakeMovever();
		if (!end) {
			screen.setText(board.toString());
			scoring.setText(player.toString());
		} 
	}

	private void placeSnakePieceToBoard(int row, int coloum, SnakePiece piece) {
		board.getFields()[row][coloum] = piece.getPiece();
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
		player.setPoint(player.getPoint() + 1);
		snake.eat();
		food.placeFood();
	}

	private void gameOver() {
		end = true;
		timer.stop();
		screen.setText(""); // MAGIC
		screen.add(new GameOverPanel(player).createPanel(MainBoard.getGameOverButtons()));
		setVisible(true);
	}

	private FieldState checkNextField() {
		int[] nextFieldCoordinates = getNextFieldCoors();
		return board.getFields()[nextFieldCoordinates[0]][nextFieldCoordinates[1]].getState();
	}
}
