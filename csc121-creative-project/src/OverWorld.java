import processing.core.PApplet; 
import java.util.ArrayList;
import java.util.Arrays;
import processing.core.PImage;
import processing.event.KeyEvent;

/*
 * Represents the game over world 
 */
public class OverWorld implements IWorld {
	PImage img; 

	/*
	 * Draws the game over screen
	 */
	@Override
	public PApplet draw(PApplet w) {
		w.background(8, 170, 255);
		w.textSize(25); 
		w.fill(0);
		img = w.loadImage("Game Over.png");
		w.image(img, 0, -45); 
		return w;
	}

	/*
	 * Returns this OverWorld
	 */
	@Override
	public IWorld update() {
		return this; 
	}

	/*
	 * Resets the game when the spacebar is pressed
	 */
	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ')
		{
			//(Math.random() * ((max - min) + 1)) + min;
			IFruit apple = new Apple(
					new Posn( (float)  (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60, 
							(float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60));
			IFruit berry = new PoisonBerry(
					new Posn( (float)  (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60, 
							(float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60));
			
			ArrayList<IFruit> berryList = new ArrayList<IFruit>();
			berryList.add(berry);
			
			Posn mid = new Posn(SnakeApp.WINDOW_SIZE/2, SnakeApp.WINDOW_SIZE/2);
			PosnList segs = new PosnList().append(mid)
			                    .append(mid.translate(SnakeWorld.LEFT))
			                    .append(mid.translate(SnakeWorld.LEFT).translate(SnakeWorld.LEFT));
			
			return new SnakeWorld(new Snake(segs), apple, berryList);
		} else {
			return this;
		}
		
	}
	
	/*
	 * Retruns this OverWorld
	 */
	@Override 
	public IWorld gameOver()
	{
		return this; 
	}

}
