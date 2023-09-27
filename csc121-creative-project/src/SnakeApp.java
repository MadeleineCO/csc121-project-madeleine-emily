
import processing.core.*;
import processing.event.KeyEvent; 

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {
	SnakeWorld w;

	/* sets the size of the game board */
	public void settings() {
		this.size(600, 600);
	}

	/* sets up the SnakeWorld */
	public void setup() {
		//(Math.random() * ((max - min) + 1)) + min;
		Apple apple = new Apple(
				new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
						(float) (Math.random() * ((540 - 60) + 1)) + 60));
		w = new SnakeWorld(new Snake(new Posn(width/2, height/2)), apple);
	}

	/* draws the SnakeWorld */
	public void draw() {
		w = w.update();
		w.draw(this);
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