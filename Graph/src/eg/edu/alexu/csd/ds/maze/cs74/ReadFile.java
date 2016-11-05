package eg.edu.alexu.csd.ds.maze.cs74;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

	public int dimentionx, dimentiony;
	private String path;

	public ReadFile(String file_path) {
		path = file_path;
	}

	public String[][] OpenFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		String dimention = textReader.readLine();
		String[] dem = dimention.split(" ");
		
		int row = Integer.parseInt(dem[0]);
		int col = Integer.parseInt(dem[1]);

		dimentionx = row;
		dimentiony = col;

		String[] data = new String[row];

		String[][] game = new String[row][col];

		for (int i = 0; i < row; i++) {
			data[i] = textReader.readLine();
		}

		for (int i = 0; i < row; i++) {

			String term = data[i];
			String[] s = term.split(" ");
			for (int j = 0; j < col; j++) {
				game[i][j] = s[j];
			}
		}
		textReader.close();
		return game;
	}

}
