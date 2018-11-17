package hu.ak_akademia.snake.model;

public enum BoardItem {
	NO_ITEM(' ',FieldState.FREE),
	SNAKE_HEAD('O', FieldState.INUSE),
	SNAKE_BODY('¤', FieldState.INUSE),
	HORIZONTAL_WALL('-',FieldState.INUSE),
	VERTICAL_WALL('|',FieldState.INUSE),
	CORNER('+',FieldState.INUSE),
	FOOD('o',FieldState.COLLECTABLE),	
	FIELD_WALL('X',FieldState.INUSE);
	
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
	
	public static BoardItem getFromCode(char sign) {
        for (BoardItem status : values()) {
            if (status.getSign()==sign) {
                return status;
            }
        }
        throw new IllegalArgumentException("Érvénytelen pálya jel: " + sign);
    }
}
