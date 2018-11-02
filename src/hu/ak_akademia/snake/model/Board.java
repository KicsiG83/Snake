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
				if (map[i][j] == ' ') {
					fields[i][j] = (BoardItem.NO_ITEM);
				} else if (map[i][j] == '│') {
					fields[i][j] = (BoardItem.VERTICAL_WALL);
				} else if (map[i][j] == '─') {
					fields[i][j] = (BoardItem.HORIZONTAL_WALL);
				} else if (map[i][j] == '+') {
					fields[i][j] = (BoardItem.CORNER);
				} else if (map[i][j] == '┌') {
					fields[i][j] = (BoardItem.TOP_LEFT_CORNER);
				} else if (map[i][j] == '┐') {
					fields[i][j] = (BoardItem.TOP_RIGHT_CORNER);
				} else if (map[i][j] == '└') {
					fields[i][j] = (BoardItem.BOTTOM_LEFT_CORNER);
				} else if (map[i][j] == '┘') {
					fields[i][j] = (BoardItem.BOTTOM_RIGHT_CORNER);
				} else if (map[i][j] == '▓') {
					fields[i][j] = (BoardItem.FIELD_WALL);
				}
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
