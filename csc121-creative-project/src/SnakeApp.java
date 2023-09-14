
/**
 * Represents an interactive application where a snake eats an apple 
 * to grow longer. The user must use the arrow keys to control the snake.
 */
interface IWorld {
	
}
class Posn {
	 double x;
	 double y;
	 Posn(double x, double y) {
	    this.x = x;
	    this.y = y;
	  }

	   /* TEMPLATE
	  public ??? posnMethod(...) {
	    ... this.x      -- double
	    ... this.y      -- double
	    
	    ... this.inRange(Posn, double, double)  -- boolean
	  }    
	   */

}

class Snake implements IWorld 
{
	Posn p; 
	int length; 
	String direction; 
	
	Snake(Posn p, int length, String direction)
	{
		this.p = p; 
		this.length = length; 
		this.direction = direction; 
	}
	 /* TEMPLATE
	  public ??? snakeMethod(...) {
	    ... this.p     -- Posn
	    ... this.length      -- int
	    ... this.direction   -- String 
	  }    
	   */
}

class Apple implements IWorld 
{
	Posn p; 
	boolean ate; 
	
	Apple(Posn p, boolean ate) 
	{
		this.p = p;
		this.ate = ate;
	}
	/* TEMPLATE
	  public ??? appleMethod(...) {
	    ... this.p     -- Posn
	    ... this.ate     -- boolean 
	  }    
	   */
}



/** contains all of the wall borders */ 
class Border 
{
	int topwallY; 
	int rightwallX; 
	int botWallY; 
	int leftWallX;
	
	Border(int topwallY, int rightwallX, int botWallY, int leftWallX) {
		this.topwallY = topwallY;
		this.rightwallX = rightwallX;
		this.botWallY = botWallY;
		this.leftWallX = leftWallX;
	}
	
	/* TEMPLATE
	  public ??? appleMethod(...) {
	    ... this.topWallY    -- int
	    ... this.rightWallX   -- int
	    ... this.botWallY    -- int
	    ... this.leftWallX   -- int
	  }    
	   */	
}



