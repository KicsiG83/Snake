package hu.ak_akademia.snake.model;

import java.io.FileReader;
import java.io.IOException;

public class ReadBoardFromFile {
	private static String test = "";
	private static String pathToFile;
	
	public ReadBoardFromFile(String pathToFile) {
		ReadBoardFromFile.pathToFile = pathToFile;
	}

	private static String ReadEntireFileIntoAStringCharByChar(String pathToFile) throws IOException {

		FileReader fileReader = new FileReader(pathToFile);
		String fileContents = "";
		int i;
		while ((i = fileReader.read()) != -1) {
			fileContents = fileContents + (char) i;
		}
		fileReader.close();
		return fileContents;
	}

	public static char[][] getBoard() {
		String str = "";
		try {
			str = ReadEntireFileIntoAStringCharByChar(pathToFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test = str;
		String[] splitedtest = test.split("\r\n");
		int n = splitedtest.length;
		int m = splitedtest[0].length();
		char[][] result = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = splitedtest[i].charAt(j);
			}
		}
		return result;
	}
}
