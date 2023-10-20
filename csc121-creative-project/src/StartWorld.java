import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	/*
	 * Draws this StartWorld screen
	 */
	@Override
	public PApplet draw(PApplet w) {
		w.background(173, 216, 230);
		w.textSize(25);
		w.fill(0);
		w.text("Press spacebar to start", 180, 180);
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
			Posn mid = new Posn(SnakeApp.WINDOW_SIZE/2, SnakeApp.WINDOW_SIZE/2);
			PosnList segs = new PosnList().append(mid)
			                    .append(mid.translate(SnakeWorld.LEFT))
			                    .append(mid.translate(SnakeWorld.LEFT).translate(SnakeWorld.LEFT));
			return new SnakeWorld(new Snake(segs), apple, berry);
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
