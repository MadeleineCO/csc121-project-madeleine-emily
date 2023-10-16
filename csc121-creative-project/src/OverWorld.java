import processing.core.PApplet;
import processing.event.KeyEvent;

public class OverWorld implements IWorld{


	/*
	 * Draws the game over screen
	 */
	@Override
	public PApplet draw(PApplet w) {
		w.background(173, 216, 230);
		w.fill(255, 0, 0);
		w.textSize(40);
		w.text("GAME OVER", 205, 100);
		w.textSize(25);
		w.text("Press spacebar to restart", 180, 180);
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
			Apple apple = new Apple(
					new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
							(float) (Math.random() * ((540 - 60) + 1)) + 60));
			Posn mid = new Posn(200/2, 200/2);
			PosnList segs = new PosnList().append(mid)
			                    .append(mid.translate(SnakeWorld.LEFT))
			                    .append(mid.translate(SnakeWorld.LEFT).translate(SnakeWorld.LEFT));
			return new SnakeWorld(new Snake(segs), apple);
		} else 
		{
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
