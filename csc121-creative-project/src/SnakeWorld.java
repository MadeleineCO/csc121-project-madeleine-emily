import processing.core.PApplet; 

public class SnakeWorld 
{
	/** the position of the snake */ 
	double x; 
	double y; 
	
	 public SnakeWorld(double x, double y) {
	        this.x = x;
	        this.y = y; 
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
	
	public CircleWorld update() {
        if (this.y < 400) {
            return new CircleWorld(this.x, this.y + .5);
        } else {
            return this;
        }
    }
	    
	    
	
	

}
