import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
		static JLabel generation;
		static LifeGrid lifegrid;
		public void updateCurrentGeneration() {
			generation.setText("GENERATION: " + lifegrid.getCurrentGeneration());
		}
		
		public static void main(String[] args) throws InterruptedException {
			JFrame frame;
			Scanner scanner = new Scanner(System.in);
			Runneable runnable = new Runneable();
			
			System.out.println("Do you want to Randomise? (T/F)");
			String random = scanner.nextLine();
			if (random.compareTo("T") == 0 || random.compareTo("t") == 0) {
				lifegrid = new LifeGrid(800, 900);
			} else {
				lifegrid = new LifeGrid(800, 900, "Grid.txt");
			}
			
			scanner.close();
			
			/**
			 * The Frame that holds all the GUI components.
			 */
			frame = new JFrame("Conway's Game Of Life");
			frame.setVisible(true);
			frame.setSize(900, 830);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
