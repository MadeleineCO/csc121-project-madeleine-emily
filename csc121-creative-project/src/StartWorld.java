import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {
	PImage img; 
	
	/*
	 * Draws this StartWorld screen
	 */
	@Override
	public PApplet draw(PApplet w) {
		w.background(8, 170, 255);
		w.textSize(25); 
		w.fill(0);
		img = w.loadImage("press SpaceBar To Start Newwww.png");
		w.image(img, 0, -45); 
		return w;
	}

	/*
	 * Returns this StartWorld
	 */
	@Override
	public IWorld update() {
		return this;
	}

	/*
	 * Determines if the spacebar has been pressed. If so, resets this StartWorld
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
					new Posn( (float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60, 
							(float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60));
			
			ArrayList<IFruit> berryList = new ArrayList<IFruit>();
			berryList.add(berry);
			
			Posn mid = new Posn(SnakeApp.WINDOW_SIZE/2, SnakeApp.WINDOW_SIZE/2);
			PosnList segs = new PosnList().append(mid)
			                    .append(mid.translate(SnakeWorld.LEFT))
			                    .append(mid.translate(SnakeWorld.LEFT).translate(SnakeWorld.LEFT));
			return new SnakeWorld(new Snake(segs), apple, berryList);
		} else 
		{
			return this;
		}
		
	}
	
	/*
	 * Returns this StartWorld
	 */
	@Override 
	public IWorld gameOver()
	{
		return this; 
	}

}
