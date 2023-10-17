import java.util.Objects;

import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple extends Fruit {


	/** the position of the apple */
	private Posn loc;


	public Apple(Posn loc) {
		super(loc);
	}

	/* draws the apple as a red square */
//	public PApplet draw(PApplet a) {
//		a.fill(255, 0, 0);
//		a.square((int) this.loc.getX(), (int) this.loc.getY(), size);
//		return a;
//	}


	/* if the snake eats the apple, then the apple updates to a random location */
	public IFruit move(Snake s) {
		if (this.hitBySnake(s.getLoc())) {
			return new Apple(
					new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
							(float) (Math.random() * ((540 - 40) + 1)) + 60));
		}
		
		return this;

	}


	//deterimines if the snake has hit the apple 
	public boolean hitBySnake(Posn sLoc) 
	{	
	    return sLoc.distanceTo(this.loc) < SIZE;
	}


	/* returns the apple's position */
//	public Posn getLoc() {
//		return loc;
//	}

	
	
	
	@Override
	public String toString() {
		return "Apple [loc=" + loc + ", size=" + SIZE + "]";
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
		Apple other = (Apple) obj;
		return Objects.equals(loc, other.loc) && SIZE == other.SIZE;
	}






}
