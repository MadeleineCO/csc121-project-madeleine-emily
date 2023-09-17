import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class AppleWorld {

	
	/** the position of the apple */
	double x;
	double y;
	
	
	public AppleWorld(double x, double y) {
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
	public AppleWorld update(SnakeWorld s) {
		
		if (this.inRange(s.x, s.y, 30)) {
			return new AppleWorld(Math.random() * 601, Math.random() * 601);
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
	public boolean inRange(double x, double y, int size) {	
		if (x + 30 >= this.x &&                   //checks if snake point is within the side boundaries
				x + 30 <= this.x + 30
				&&
			y >= this.y &&  y <= this.y + 30)    //checks if the snake point is within the top/bottom boundaries
		{
			return true;
		}
		
		else if (x - 30 >= this.x &&                   //checks if snake point is within the side boundaries
					x - 30 <= this.x + 30
					&&
				y >= this.y &&  y <= this.y + 30) 
		{
			
			return true;
		}
		
		
		else if (x >= this.x &&                   //checks if snake point is within the side boundaries
					x <= this.x + 30
					&&
				y + 30 >= this.y &&  y + 30 <= this.y + 30)          //checks if the snake point is within the top/bottom boundaries
		{
			return true;
		}
		
		
		
		
		else {
			return false;
		}
			
		
		
	}
		
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
	
	
	
	
}
