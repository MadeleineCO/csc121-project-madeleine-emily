/*
 * Represents a fruit in the game
 */

import java.util.Objects;

import processing.core.PApplet;

abstract class Fruit implements IFruit {

	/** the position of the apple */
	private Posn loc;
	public final static int SIZE = 30;
	
	public Fruit(Posn loc) {
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

	@Override
	public int hashCode() {
		return Objects.hash(loc, SIZE);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Objects.equals(loc, other.loc) && SIZE == other.SIZE;
	}

	@Override
	public String toString() {
		return "Fruit [loc=" + loc + ", size=" + SIZE + "]";
	}
	
	
		
		
	
}
