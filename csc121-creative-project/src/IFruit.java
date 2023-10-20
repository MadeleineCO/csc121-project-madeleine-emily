/*
 * Interface for fruit objects in the game
 */

import processing.core.PApplet;

interface IFruit {
	
	/*
	 * Draws the IFruit in the game
	 */
	public PApplet draw(PApplet a);
	
	/*
	 * Moves the IFruit in the game if applicable
	 */
	public IFruit move(Snake s);
	
	/*
	 * Determines if the IFruit has been hit by a Snake
	 */
	public boolean hitBySnake(Posn sLoc);
	
	/*
	 * Returns the location of the IFruit
	 */
	public Posn getLoc();
	
	
}
