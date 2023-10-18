import java.util.Objects;

import processing.core.PApplet; 
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld
{
    private Snake slimy;
    private IFruit a;
    private IFruit b;

    public static final Posn UP = new Posn(0, -30);
    public static final Posn DOWN = new Posn(0, 30);
    public static final Posn LEFT = new Posn(-30, 0);
    public static final Posn RIGHT = new Posn(30, 0);
    
    public static final int DELAY_AMOUNT = 15;

    public SnakeWorld(Snake slimy, IFruit a) {
        this.slimy = slimy;
        this.a = a;
        this.b = new Apple(
				new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
						(float) (Math.random() * ((540 - 40) + 1)) + 60));
    }
    
    public SnakeWorld(Snake slimy, IFruit a, IFruit b) {
        this.slimy = slimy;
        this.a = a;
        this.b = b;
    }

    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet w) 
    {
        w.background(108, 206, 120);
        this.slimy.draw(w);
        this.a.draw(w);
        this.b.draw(w);
        return w;
    }
    
    /* updates the SnakeWorld by moving the snake and the apple */
    public IWorld update() {
        IFruit a2 = this.a.move(slimy);
        IFruit b2 = this.b.move(slimy);
    	return new SnakeWorld(this.slimy.move(this.a), a2, b2);
    }

    /* determines which arrow key has been pressed and creates a new SnakeWorld to reflect a KeyEvent */
    public IWorld keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.UP && this.slimy.getDir() != SnakeWorld.DOWN) {
            return new SnakeWorld(this.slimy.changeDirection(this.UP), this.a, this.b);
        } 
        else if (kev.getKeyCode() == PApplet.DOWN && this.slimy.getDir() != SnakeWorld.UP) {
            return new SnakeWorld(this.slimy.changeDirection(this.DOWN), this.a, this.b);
        } 
        else if (kev.getKeyCode() == PApplet.RIGHT && this.slimy.getDir() != SnakeWorld.LEFT) {
            return new SnakeWorld(this.slimy.changeDirection(this.RIGHT), this.a, this.b);
        } else if (kev.getKeyCode() == PApplet.LEFT && this.slimy.getDir() != SnakeWorld.RIGHT) {
            return new SnakeWorld(this.slimy.changeDirection(this.LEFT), this.a, this.b);
        } else if (kev.getKey() == 'q'){
        	return new StartWorld(); 
        }
        else {
            return this;
        }
    }
    
    /*
     * Determines if the snake his hit the wall or itself. If so, returns the game over world
     */
    public IWorld gameOver()
    {
    	if (this.slimy.hitWall() || slimy.getSegs().hitPosnInList() || b.hitBySnake(this.slimy.getLoc()))
    	{
    		return new OverWorld(); 
    		
    	} else {
    		return this; 
    	}
    }

    
    
    //re-generate to update
    @Override
    public String toString() {
        return "SnakeWorld [slimy=" + slimy + ", a=" + a + ", UP=" + UP + ", DOWN=" + DOWN + ", LEFT=" + LEFT
                + ", RIGHT=" + RIGHT + "]";
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(a, slimy);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SnakeWorld other = (SnakeWorld) obj;
        return Objects.equals(a, other.a) && Objects.equals(slimy, other.slimy);
    }





}
