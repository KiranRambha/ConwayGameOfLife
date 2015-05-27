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
	
	/**
	 * This method prints the grid to the console.
	 */
	public void show() {
		System.out
				.println("*********************************************************************************************************");
		for (int gridHeight = 0; gridHeight < getGridHeight(); gridHeight++) {
			for (int gridWidth = 0; gridWidth < getGridWidth(); gridWidth++) {
				if (grid[gridHeight][gridWidth] == 1) {
					System.out.print("1");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("The current generation is: " + getCurrentGeneration());
		System.out.println("*********************************************************************************************************");
	}
	
	/**
	 * This method calculates and returns the height of the grid.
	 * @return Returns the height of the grid.
	 */
	public int getGridHeight() {
		return grid.length;
	}

	/**
	 * This method calculates the width of the grid and returns it.
	 * @return Returns the width of the grid.
	 */
	public int getGridWidth() {
		return grid[0].length;
	}

	/**
	 * This method returns the current generation value of the the grid.
	 * @return returns the current generation number.
	 */
	public int getCurrentGeneration() {
		return currentGeneration;
	}

	/**
	 * The method returns the content of the cell.
	 * @param height The y coordinate of the grid.
	 * @param width The x coordinate of the grid.
	 * @return Returns the content of the cell at that position.
	 */
	public int getCellContent(int height, int width) {
		return grid[height][width];
	}
	
	/**
	 * This method counts the number of neighbors around the cell and returns the number. 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return Returns the number of neighbors around the cell.
	 */
	public int getNumberOfNeighbours(int x, int y) {
		int count = 0, height = x, width = y;
		int tempheight = height - 1, tempwidth = width - 1;
		for (int i = tempheight; i <= tempheight + 2; i++) {
			for (int j = tempwidth; j <= tempwidth + 2; j++) {
				if (i >= 0 && i < getGridHeight() && j >= 0 && j < getGridWidth()) {
					if (grid[i][j] == 1) {
						count++;
					}
				}
			}
		}
		if (grid[height][width] == 1) {
			count--;
		}
		return count;
	}
	
	/**
	 * This method applies the rules of the game to the grid.
	 */
	public void run() {
		int[][] newGrid = new int[getGridHeight()][];
		for (int i = 0; i < getGridHeight(); i++) {
			newGrid[i] = new int[getGridWidth()];
		}

		for (int height = 0; height < getGridHeight(); height++) {
			for (int width = 0; width < getGridWidth(); width++) {
				if (grid[height][width] == 1 && getNumberOfNeighbours(height, width) < 2) {
					newGrid[height][width] = 0;
				} else if (grid[height][width] == 1 && (getNumberOfNeighbours(height, width) == 2 || getNumberOfNeighbours(height, width) == 3)) {
					newGrid[height][width] = 1;
				} else if (grid[height][width] == 1 && getNumberOfNeighbours(height, width) > 3) {
					newGrid[height][width] = 0;
				} else if (grid[height][width] == 0 && getNumberOfNeighbours(height, width) == 3) {
					newGrid[height][width] = 1;
				} else {
					newGrid[height][width] = 0;
				}
			}
		}
		System.arraycopy(newGrid, 0, grid, 0, newGrid.length);
		currentGeneration++;
	}

	/**
	 * This method returns the grid.
	 * @return This method returns the grid.
	 */
	public int[][] getGrid() {
		return grid;
	}
}
