import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
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
			
			/**
			 * The JPanel onto which the button and grid is added.
			 */
			DrawCell drawcell = new DrawCell(lifegrid.getGrid());
			drawcell.setLayout(null);
			drawcell.setBackground(Color.LIGHT_GRAY);
			frame.add(drawcell);
			
			/**
			 * Start Stop Button on the GUI
			 */
			Button startStopButton = new Button();
			startStopButton.setLabel("START");
			startStopButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
			startStopButton.setBackground(Color.GRAY);
			startStopButton.setBounds(200, 770, 700, 35);
			drawcell.add(startStopButton);
			
			/**
			 * Generation Label on the frame.
			 */
			generation = new JLabel("GENERATION: " + lifegrid.getCurrentGeneration());
			generation.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
			generation.setBackground(Color.WHITE);
			generation.setOpaque(true);
			drawcell.add(generation);
			generation.setBounds(0, 770, 200, 35);
	}
}
