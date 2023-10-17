/*
 * Represents a fruit in the game
 */

import java.util.Objects;

import processing.core.PApplet;

abstract class AFruit implements IFruit {

	/** the position of the apple */
	private Posn loc;
	public final static int SIZE = 30;
	
	public AFruit(Posn loc) {
		this.loc = loc;
	}
	
	/* draws the fruit as a square */
	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.loc.getX(), (int) this.loc.getY(), SIZE);
		return a;
	}
	
	
	/* if the snake eats the apple, then the apple updates to a random location */
	public abstract IFruit move(Snake s);
	
	
	//deterimines if the snake has hit the apple 
	public abstract boolean hitBySnake(Posn sLoc);
	
	/* returns the apple's position */
	public Posn getLoc() {
		return loc;
	}

	
		
		
	
}
