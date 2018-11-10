package hu.ak_akademia.snake.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.ak_akademia.snake.model.Board;
import hu.ak_akademia.snake.model.BoardItem;
import hu.ak_akademia.snake.model.FieldState;

public class FoodFactory {
	private Board board;
	private int[] coorsOfLastFood = new int[2];
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
		coorsOfLastFood[0]=rndCoors[0];
		coorsOfLastFood[1]=rndCoors[1];
	}
	
	private List<Integer[]> getListOfFreeFields() {
		List<Integer[]> result = new ArrayList<>();
		int row = board.getFields().length;
		int column = board.getFields()[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(board.getFields()[i][j].getState().equals(FieldState.FREE)) {
					Integer[] addMe = {i,j};
					result.add(addMe);
				}
			}
		}
		return result;
	}

	public int[] getCoorsOfLastFood() {
		return coorsOfLastFood;
	}
}
