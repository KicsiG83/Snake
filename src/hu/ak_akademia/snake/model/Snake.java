package hu.ak_akademia.snake.model;

public class Snake {
	private SnakePiece head = new SnakePiece(BoardItem.SNAKE_HEAD, null);
	private int length = 0;

	public Snake(int startLength) {
		int i = startLength;
		while (i > 0) {
			eat();
			i--;
		}
	}

	public SnakePiece getHead() {
		return head;
	}

	public int getLength() {
		return length;
	}

	public void eat() {
		length++;
		incrase(getLastPiece());
	}

	private void incrase(SnakePiece piece) {
		SnakePiece newPiece = new SnakePiece(BoardItem.SNAKE_BODY, null);
		piece.setPointer(newPiece);
	}

	private SnakePiece getLastPiece() {
		SnakePiece lastPiece = head;
		while (lastPiece.getPointer() != null) {
			lastPiece = lastPiece.getPointer();
		}
		return lastPiece;
	}

}
