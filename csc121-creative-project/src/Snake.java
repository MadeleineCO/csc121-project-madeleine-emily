import java.util.Objects;
import processing.core.PApplet;

public class Snake {
    Posn loc;   /* the head loc */
    Posn dir;   /* represents the direction of movement */
    int moveDelay; /* number of ticks the snake should wait before actually moving again */
    
    
    public Snake(Posn loc, Posn dir, int moveDelay) {
        this.loc = loc;
        this.dir = dir;
        this.moveDelay = moveDelay;
    }

    public Snake(Posn loc) {
        this(loc, SnakeWorld.RIGHT, SnakeWorld.DELAY_AMOUNT);
    }
    

    /* draws the snake as a green square */
    PApplet draw(PApplet c) {
        c.fill(64, 227, 73);
        c.square(this.loc.getX(), this.loc.getY(), 30);
        return c;
    }
    
    /** move this snake's head segment in the it's current direction */
    Snake move() {
        if (this.moveDelay <= 0 && ! this.hitWall()) {
            return new Snake(this.loc.translate(this.dir), this.dir, SnakeWorld.DELAY_AMOUNT);
        } else {
            return new Snake(this.loc, this.dir, this.moveDelay - 1);
        }
    }
    
    
    /** check if this snake is about to run into a wall */
    boolean hitWall() {
        if (this.moveDelay > 0) {
            return false;
        } else {
            Posn newLoc = this.loc.translate(this.dir);
            if (newLoc.getX() >= 570) {         //right wall
            	return true;
            } 
            else if (newLoc.getY() <= 0) {    //top wall
            	return true;
            } 
            else if (newLoc.getX() <= 0) {    //left wall
            	return true;
            } 
            else if (newLoc.getY() >= 570) {
            	return true;                    //bottom wall
            } 
            else { 
            	return false;
            	}
        }
    }
    
    
    /** changes the direction that the snake is moving to the given direction */
    Snake changeDirection(Posn newDir) {
        return new Snake(this.loc, newDir, this.moveDelay);
    }

    /* returns the snakes position */
    public Posn getLoc() {
    	return loc;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(dir, loc, moveDelay);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Snake other = (Snake) obj;
        return Objects.equals(dir, other.dir) && Objects.equals(loc, other.loc) && moveDelay == other.moveDelay;
    }

    @Override
    public String toString() {
        return "Snake [loc=" + loc + ", dir=" + dir + ", moveDelay=" + moveDelay + "]";
    }

}
