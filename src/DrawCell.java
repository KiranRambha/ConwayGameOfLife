import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * This class is the JPanel which holds all the buttons and paint objects.
 * @author kiran
 *
 */
public class DrawCell extends JPanel{
	private static final long serialVersionUID = 1L;
	Main main = new Main();
	int[][] grid;
	Random random = new Random();
	int color = 0;

	public DrawCell(int[][] grid) {
		this.grid = grid;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		color = random.nextInt(10);
		switch (color) {
		case 0:
			g.setColor(Color.BLUE);
			break;
			
		case 1:
			g.setColor(Color.RED);
			break;
			
		case 2:
			g.setColor(Color.ORANGE);
			break;
			
		case 3:
			g.setColor(Color.GREEN);
			break;
			
		case 4:
			g.setColor(Color.CYAN);
			break;
		
		case 5:
			g.setColor(Color.MAGENTA);
			break;
			
		case 6:
			g.setColor(Color.PINK);
			break;
		
		case 7:
			g.setColor(Color.WHITE);
			break;
			
		case 8:
			g.setColor(Color.YELLOW);
			break;
			
		case 9:
			g.setColor(Color.DARK_GRAY);
			break;
			
		default:
			g.setColor(Color.BLACK);
			break;
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					g.fillRect(j * 16, i * 16, 15, 15);
				}
			}
		}
		main.updateCurrentGeneration();
	}
}
