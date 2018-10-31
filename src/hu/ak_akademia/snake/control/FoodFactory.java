package hu.ak_akademia.snake.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.BoardItem;
import hu.ak_akademia.snake.model.FieldState;

public class FoodFactory {
	private Board board;
	public FoodFactory(Board board) {
		this.board = board;
	}
	
	public void placeFood() {
		List<Integer[]> coordinatesOfFreeFileds = getListOfFreeFields();
		Random rnd = new Random();
		int limit = coordinatesOfFreeFileds.size();
		int rndIndex = rnd.nextInt(limit);
		
		Integer[] rndCoors = coordinatesOfFreeFileds.get(rndIndex);
		board.getFields()[rndCoors[0]][rndCoors[1]] = BoardItem.FOOD;
	}
	
	private List<Integer[]> getListOfFreeFields() {
		List<Integer[]> result = new ArrayList<>();
		int row = board.getFields().length;
		int coloum = board.getFields()[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < coloum; j++) {
				if(board.getFields()[i][j].getState().equals(FieldState.FREE)) {
					Integer[] addMe = {i,j};
					result.add(addMe);
				}
			}
		}
		return result;
	}
}
