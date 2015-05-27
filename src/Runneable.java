import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


/**
 * This class runs continuously and paints the GUI utilizing the Timer class.
 * @author kiran
 *
 */
public class Runneable implements ActionListener {
	LifeGrid lifegrid;
	DrawCell drawcell;
	Timer timer = new Timer(0, this);
	public void start(LifeGrid lifegrid, DrawCell drawcell) {
		this.lifegrid = lifegrid;
		this.drawcell = drawcell;
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lifegrid.run();
		drawcell.repaint();
	}
	
	public void stop() {
		timer.stop();
	}
}
