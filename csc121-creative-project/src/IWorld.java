import processing.core.PApplet;
import processing.event.KeyEvent;

public interface IWorld {
	 public PApplet draw(PApplet w); 
	 
	 public IWorld update(); 
	 
	 public IWorld keyPressed(KeyEvent kev); 
	 
	 public IWorld gameOver(); 
	 
}
