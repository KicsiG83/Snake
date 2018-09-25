package hu.ak_akademia.snake.model;

public class SnakePiece {
	private int coorX;
	private int coorY;
	private final BoardItem piece;
	private SnakePiece pointer;

	public SnakePiece(BoardItem piece, SnakePiece pointer) {
		this.piece = piece;
		this.pointer = pointer;
	}

	public SnakePiece(int coorX, int coorY, BoardItem piece, SnakePiece pointer) {
		this(piece, pointer);
		this.coorX = coorX;
		this.coorY = coorY;
	}

	public BoardItem getPiece() {
		return piece;
	}

	public SnakePiece getPointer() {
		return pointer;
	}

	public void setPointer(SnakePiece pointer) {
		this.pointer = pointer;
	}

	public int getCoorX() {
		return coorX;
	}

	public int getCoorY() {
		return coorY;
	}

	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}

	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}

}
