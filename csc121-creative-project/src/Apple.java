import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple extends AFruit implements IFruit {

	public Apple(Posn loc) {
		super(loc);
	}

	/*
	 * Draws the apple in the game as a red square
	 */
	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.getLoc().getX(), (int) this.getLoc().getY(), SIZE);
		return a;
	}
	
	
	/* if the snake eats the apple, then the apple updates to a random location */
	public IFruit move(Snake s) {
		if (this.hitBySnake(s.getLoc())) {
			SnakeWorld.SCORE++;
			return new Apple(
					new Posn( (float)  (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60, 
							(float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60));
		}
		
		
		
		return this;

	}

	
	//auto-generated method
	
	@Override
	public String toString() {
		return "Apple []";
	}
	
	
	
	
}
