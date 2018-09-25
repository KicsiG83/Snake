package hu.ak_akademia.snake.control;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.BoardItem;
import hu.ak_akademia.snake.model.Snake;
import hu.ak_akademia.snake.model.SnakePiece;

public class SnakeMover {
	Snake snake;
	Board board;
	
	public SnakeMover(Snake snake, Board board) {
		this.snake = snake;
		this.board = board;
	}

	private void moveSnakePiece(SnakePiece piece, int newRow, int newCol) {
		int row = piece.getCoorX();
		int col = piece.getCoorY();
		board.getFields()[row][col] = BoardItem.NO_ITEM;
		piece.setCoorX(newRow);
		piece.setCoorY(newCol);
		board.getFields()[newRow][newCol] = piece.getPiece();
	}
	public void autoMove(int[] nextFieldCoors) {
		int newRow = nextFieldCoors[0];
		int newCol = nextFieldCoors[1];
		SnakePiece lastPiece = snake.getHead();
		while (lastPiece.getPointer() != null) {
			int oldRow = lastPiece.getCoorX();
			int oldCol = lastPiece.getCoorY();
			moveSnakePiece(lastPiece, newRow, newCol);
			lastPiece = lastPiece.getPointer();
			newRow = oldRow;
			newCol = oldCol;
		}
	}
	
}
