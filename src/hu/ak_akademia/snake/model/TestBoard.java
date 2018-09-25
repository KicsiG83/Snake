package hu.ak_akademia.snake.model;

public class TestBoard {
	public static final String test =
		  "+----------------------------------------------------------------------+\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "|                                                                      |\n"
		+ "+----------------------------------------------------------------------+\n";
	
	public static char[][] getTestMap() {
		String[] splitedtest = test.split("\n");
		int n = splitedtest.length;
		int m = splitedtest[0].length();
		char[][] result = new char[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result[i][j] = splitedtest[i].charAt(j);
			}
		}
		return result;
	}
}
