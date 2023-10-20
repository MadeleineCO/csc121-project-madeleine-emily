/*
 * Interface for the worlds of the game
 */

import processing.core.PApplet;
import processing.event.KeyEvent;

public interface IWorld {
	
	/*
	 * Draws the IWrld
	 */
	public PApplet draw(PApplet w); 
	 
	/*
	 * Updates the elements of the IWorld
	 */
	public IWorld update(); 
	
	/*
	 * Respons to KeyEvents in the IWorld
	 */
	public IWorld keyPressed(KeyEvent kev); 
	 
	/*
	 * Determines what happens to the IWorld when the game is over
	 */
	public IWorld gameOver(); 
	 
}
