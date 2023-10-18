import java.util.Objects;

import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple extends AFruit implements IFruit {

	public Apple(Posn loc) {
		super(loc);
	}

	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.getLoc().getX(), (int) this.getLoc().getY(), SIZE);
		return a;
	}
	
	
	/* if the snake eats the apple, then the apple updates to a random location */
	public IFruit move(Snake s) {
		if (this.hitBySnake(s.getLoc())) {
			return new Apple(
					new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
							(float) (Math.random() * ((540 - 40) + 1)) + 60));
		}
		
		return this;

	}

	@Override
	public String toString() {
		return "Apple []";
	}
	
	
}
