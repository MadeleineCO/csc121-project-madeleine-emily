import java.util.Objects;

import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple {


	/** the position of the apple */
	Posn loc;
	int size;


	public Apple(Posn loc) {
		this.loc = loc;
		this.size = 30;
	}

	/* draws the apple */
	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.loc.getX(), (int) this.loc.getY(), size);
		return a;
	}


	/* if the snake eats the apple, then the apple updates to a random location */
	public Apple move(Snake s) {
		if (this.hitBySnake(s.getLoc()) || 
				this.hitBySnake(s.getLoc().translate(new Posn(0, 30))) ||
				this.hitBySnake(s.getLoc().translate(new Posn(0, 30))) ||
				this.hitBySnake(s.getLoc().translate(new Posn(30, 30)))) 
		{
			return new Apple(
					new Posn((float) Math.random() * 541,
							(float) Math.random() * 541));
		}
		else {
			return this;
		}

	}


	//deterimines if the snake has hit the apple 
	public boolean hitBySnake(Posn sLoc) 
	{	
		return sLoc.inRange(this.loc, this.size, this.size);

	}


	/* returns the apple's position */
	public Posn getLoc() {
		return loc;
	}

	@Override
	public String toString() {
		return "Apple [loc=" + loc + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loc, size);
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
		return Objects.equals(loc, other.loc) && size == other.size;
	}






}
