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
	public abstract PApplet draw(PApplet a);
	
	
	/* the fruit responds to being hit by the snake */
	public abstract IFruit move(Snake s);
	
	
	//deterimines if the snake has hit the fruit 
		public boolean hitBySnake(Posn sLoc) 
		{	
		    return sLoc.distanceTo(this.getLoc()) < SIZE;
		}
	
	/* returns the apple's position */
	public Posn getLoc() {
		return loc;
	}

	
	
	//auto-generated methods
	
	@Override
	public String toString() {
		return "AFruit [loc=" + loc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AFruit other = (AFruit) obj;
		return Objects.equals(loc, other.loc);
	}
	

}
