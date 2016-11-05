package eg.edu.alexu.csd.ds.maze.cs74;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {

	private String path;

	public WriteFile(String File_path) {
		path = File_path;
	}

	public void write(String[][] randomMaze, int dx, int dy) {
		File file = new File(path);
		Writer fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(dx + " " + dy);
			bufferedWriter.newLine();
			for (int i = 0; i < dx; i++) {
				for (int j = 0; j < dy; j++) {
					bufferedWriter.write(randomMaze[i][j] + " ");
				}
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error writing the file : ");
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null && fileWriter != null) {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
