import java.util.Objects;

import processing.core.PApplet; 
import processing.event.KeyEvent; 

public class SnakeWorld 
{
    Snake slimy;
    Apple a;

    static Posn UP = new Posn(0, -30);
    static Posn DOWN = new Posn(0, 30);
    static Posn LEFT = new Posn(-30, 0);
    static Posn RIGHT = new Posn(30, 0);
    
    static int DELAY_AMOUNT = 25;

    public SnakeWorld(Snake slimy, Apple a) {
        this.slimy = slimy;
        this.a = a;
    }

    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet w) 
    {
        w.background(27, 108, 32);
        this.slimy.draw(w);
        this.a.draw(w);
        return w;
    }
    
    /* updates the SnakeWorld by moving the snake and the apple */
    public SnakeWorld update() {
    	return new SnakeWorld(this.slimy.move(), this.a.move(slimy));
    }

    /* determines which arrow key has been pressed and creates a new SnakeWorld to reflect a KeyEvent */
    public SnakeWorld keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.UP) {
            return new SnakeWorld(this.slimy.changeDirection(this.UP), this.a);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new SnakeWorld(this.slimy.changeDirection(this.DOWN), this.a);
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new SnakeWorld(this.slimy.changeDirection(this.RIGHT), this.a);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new SnakeWorld(this.slimy.changeDirection(this.LEFT), this.a);
        } else {
            return this;
        }
    }

    
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
