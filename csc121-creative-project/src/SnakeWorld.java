import processing.core.PApplet; 
import processing.event.KeyEvent; 

public class SnakeWorld 
{
	/** the position and direction of the snake */ 
	double x; 
	double y; 
	String direction; 
	 
	
	 public SnakeWorld(double x, double y, String direction) {
	        this.x = x;
	        this.y = y; 
	        this.direction = direction; 
	        
	        
	    }

	 
	 /**
	 * Renders a picture of the drop on the window
	 */
	public PApplet draw(PApplet s) 
	{
		s.background(27, 108, 32);
	    s.fill(64, 227, 73);
	    s.square((int) this.x, (int) this.y, 30);
	    return s;
	}
	
	public SnakeWorld update() {
        if (this.y > 60 || this.y < 540 || this.x < 540 || this.x > 60) {
        	if (this.direction.equals("up"))
        	{
        		return new SnakeWorld(this.x, this.y - .5, this.direction);
        	}
        	if (this.direction.equals("down"))
        	{
        		return new SnakeWorld(this.x, this.y + .5, this.direction);
        	}
        	if (this.direction.equals("right"))
        	{
        		return new SnakeWorld(this.x + .5, this.y, this.direction);
        	}
        	
        	else //assuming direction is "left"
        	{
        		return new SnakeWorld(this.x - .5, this.y, this.direction);
        	}
        } else {
            return this;
        }
    }
	
	public SnakeWorld keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.UP) {
            return new SnakeWorld(this.x, this.y, "up");
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new SnakeWorld(this.x, this.y, "down");
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new SnakeWorld(this.x, this.y, "right");
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new SnakeWorld(this.x, this.y, "left");
        } else {
            return this;
        }
    }
	
	public String toString() {
        return "[" + x + ", " + y + "]";
    }
	    
	    
	
	

}
