import java.util.Objects;

import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple {

	
	/** the position of the apple */
	double x;
	double y;
	
	
	public Apple(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/* draws the apple */
	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.x, (int) this.y, 30);
		return a;
	}
	
	/* if the snake eats the apple, then the apple updates to a random location */
//	public AppleWorld update(SnakeWorld s) {
//		
//		if (this.inRange(s.x, s.y, 30))
//		{
//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
//		} 
//		
//		else if (this.inRange(s.x + 30, s.y, 30)) {
//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
//		}
//		
//		else if (this.inRange(s.x, s.y + 30, 30)) {
//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
//		}
//		
//		else if (this.inRange(s.x + 30, s.y + 30, 30)) {
//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
//		}
//		
//		else {
//			return this;
//		}
//		
//	}
	
	
	/* if the snake eats the apple, then the apple updates to a random location */
	public Apple update(Snake s) {
		
		if (this.inRange(s.loc.getX(), s.loc.getY(), 30)) {
			return new Apple(Math.random() * 601, Math.random() * 601);
		}
		else {
			return this;
		}
		
//		if (this.inRange(s.x, s.y, 30))
//		{
//			return new AppleWorld(100, 100);
//		} 
//		
//		else if (this.inRange(s.x + 30, s.y, 30)) {
//			return new AppleWorld(100, 100);
//		}
//		
//		else if (this.inRange(s.x, s.y + 30, 30)) {
//			return new AppleWorld(100,100);
//		}
//		
//		else if (this.inRange(s.x + 30, s.y + 30, 30)) {
//			return new AppleWorld(100, 100);
//		}
//		
//		else {
//			return this;
//		}
		
	}
	
	
	
	
	
	//if top left corner of snake is within the apple
	public boolean inRange(double x, double y, int size) 
	{	
		if (x + size >= this.x && this.x + size >= x
				&& 
				y >= this.y && y <= this.y + 30) // checks snake coming from left side and if it hits the left, top corner of apple 
		{
			return true; 
		} else if (y <= this.y + size && this.y <= y
					&& 
					x >= this.x && x <= this.x + size) // checks snake coming from bottom and if it hits the left, bottom corner of apple 
			{
				return true;
			} else if (x <= this.x + size && x >= this.x
						&& 
						y >= this.y && y <= this.y + size)// checks snake coming from right side and if it hits the right, top corner of apple 
				{
					return true; 
				} else if (y + size >= this.y && y + size <= this.y + size
							&& 
							x >= this.x && x + size <= this.x + size)// checks snake coming from top and if it hits the left, top corner of apple 
					{
						return true; 
					} else 
						{
							return false; 
						}
	}
				
//		if (x + size >= this.x &&                   //checks if snake point is within the side boundaries
//				x + size <= this.x + size
//				&&
//			y >= this.y &&  y <= this.y + size)    //checks if the snake point is within the top/bottom boundaries
//		{
//			return true;
//		}
//		
//		else if (x - size >= this.x &&                   //checks if snake point is within the side boundaries
//					x - size <= this.x + size
//					&&
//				y >= this.y &&  y <= this.y + size) 
//		{
//			
//			return true;
//		}
//		
//		
//		else if (x >= this.x &&                   //checks if snake point is within the side boundaries
//					x <= this.x + size
//					&&
//				y + size >= this.y &&  y + size <= this.y + size)          //checks if the snake point is within the top/bottom boundaries
//		{
//			return true;
//		}

		
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
                && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }
	
	
	
	
	
	
}
