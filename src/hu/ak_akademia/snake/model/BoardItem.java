package hu.ak_akademia.snake.model;

public enum BoardItem {
	NO_ITEM(' ',FieldState.FREE),
	SNAKE_HEAD('O', FieldState.INUSE),
	SNAKE_BODY('o', FieldState.INUSE),
	HORIZONTAL_WALL('─',FieldState.INUSE),
	VERTICAL_WALL('│',FieldState.INUSE),
	CORNER('+',FieldState.INUSE),
	FOOD('*',FieldState.COLLECTABLE),
	
	FIELD_WALL('▓',FieldState.INUSE),
	TOP_LEFT_CORNER('┌',FieldState.INUSE),
	TOP_RIGHT_CORNER('┐',FieldState.INUSE),
	BOTTOM_LEFT_CORNER('└',FieldState.INUSE),
	BOTTOM_RIGHT_CORNER('┘',FieldState.INUSE);

	
	private final char sign;
	private final FieldState state;
	private BoardItem(char c, FieldState state) {
		this.sign = c;
		this.state = state;
	}
	public char getSign() {
		return sign;
	}
	public FieldState getState() {
		return state;
	}
}
