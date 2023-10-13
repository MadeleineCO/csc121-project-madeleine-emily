
import processing.core.*;
import processing.event.KeyEvent; 

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {
	
	private IWorld w;

	
	/* sets the size of the game board */
	public void settings() {
		this.size(600, 600);
	}

	/* sets up the SnakeWorld */
	public void setup() {
		w = new StartWorld(); 
	}

	/* draws the SnakeWorld */
	public void draw() {
		w = w.update();
		w.draw(this);
		w = w.gameOver();  
	}

	/* updates the SnakeWorld when an arrow key is pressed */
	public void keyPressed(KeyEvent kev) {
		w = w.keyPressed(kev);
	}


	/* runs the SnakeWorld */
	public static void main(String[] args) {
		PApplet.runSketch(new String[] { "SnakeApp" }, new SnakeApp());
	}
} 

