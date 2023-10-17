/*
 * Interface for fruit objects in the game
 */

import processing.core.PApplet;

interface IFruit {
	
	public PApplet draw(PApplet a);
	
	public IFruit move(Snake s);
	
	public boolean hitBySnake(Posn sLoc);
	
	
}
