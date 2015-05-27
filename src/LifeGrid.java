import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class LifeGrid {
	int[][] grid;
	int currentGeneration;

	/**
	 * Initializing the grid.
	 * @param height This is the height of the grid.
	 * @param width This the the width of the grid.
	 * @param fileName This is the file from which the properties of the grid are loaded.
	 */
	public LifeGrid(int height, int width, String fileName) {
		grid = new int[height][width];

		for (int i = 0; i < getGridHeight(); i++) {
			for (int j = 0; j < getGridWidth(); j++) {
				grid[i][j] = 0;
			}
		}
		currentGeneration = 0;
		String file = fileName;
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/kiran/Documents/Visual Studio 2013/Projects/ConwaysGameOfLife/" + file));
			String line;
			int position = 0;
			while ((line = reader.readLine()) != null
					&& position < getGridHeight()) {
				for (int i = 0; i < line.length() && i < getGridWidth(); i++) {
					if (line.charAt(i) == '1') {
						grid[position][i] = 1;
					}
				}
				position++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This is the constructor used to randomize the grid.
	 * @param height This is the height of the grid.
	 * @param width This is the width of the grid.
	 */
	public LifeGrid(int height, int width) {
		grid = new int[height][width];
		Random random = new Random();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = random.nextInt(2);
			}
		}
	}
}
