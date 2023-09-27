
import processing.core.*;
import processing.event.KeyEvent; 

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {
	SnakeWorld w;

	public void settings() {
		this.size(600, 600);
	}

	public void setup() {
		//(Math.random() * ((max - min) + 1)) + min;
		Apple apple = new Apple(
				new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
						(float) (Math.random() * ((540 - 60) + 1)) + 60));
		w = new SnakeWorld(new Snake(new Posn(width/2, height/2)), apple);
	}

	public void draw() {
		w = w.update();
		w.draw(this);
	}

	public void keyPressed(KeyEvent kev) {
		w = w.keyPressed(kev);
	}


	public static void main(String[] args) {
		PApplet.runSketch(new String[] { "SnakeApp" }, new SnakeApp());
	}
} 