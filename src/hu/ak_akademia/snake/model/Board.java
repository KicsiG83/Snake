package hu.ak_akademia.snake.model;

public class Board {
	private BoardItem[][] fields;

	public BoardItem[][] getFields() {
		return fields;
	}

	public Board(char[][] map) {
		int row = map.length;
		int coloum = map[0].length;
		fields = new BoardItem[row][coloum];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < coloum; j++) {
				fields[i][j] = BoardItem.getFromCode(map[i][j]);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				result.append(fields[i][j].getSign());
			}
			result.append("\n");
		}
		return result.toString();
	}
}
