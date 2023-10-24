import java.util.Objects;
import processing.core.PApplet;

public class Snake {
    private PosnList segs;   /* the list of segments
                         the head is always the first segment */
    private Posn dir;   /* represents the direction of movement */
    private int moveDelay; /* number of ticks the snake should wait before actually moving again */
    private int score;
    
    
    public Snake(PosnList segs, Posn dir, int moveDelay) {
        this.segs = segs;
        this.dir = dir;
        this.moveDelay = moveDelay;
    }

    public Snake(PosnList segs) {
        this(segs, SnakeWorld.RIGHT, SnakeWorld.DELAY_AMOUNT);
    }
    
    

    /* draws the snake as a green square */
    PApplet draw(PApplet c) {
    	c.noFill();
    	c.stroke(62, 157, 74);
    	c.strokeWeight(AFruit.SIZE * 2); 
    	c.strokeWeight(AFruit.SIZE); 
    	c.rect(0, 0, SnakeApp.WINDOW_SIZE, SnakeApp.WINDOW_SIZE);
    	c.noStroke(); 
    	c.strokeWeight(1); 
        c.fill(64, 152, 227);
        segs.drawSquares(c, AFruit.SIZE);
        return c;
    }
    
    /** move this snake's head segment in the its current direction */
    Snake move(IFruit a) {
        if (this.moveDelay <= 0 && ! this.hitWall()) {
            return new Snake(this.segs.move(this.dir, a.hitBySnake(this.getLoc().translate(this.dir))), this.dir, SnakeWorld.DELAY_AMOUNT);
        } else {
            return new Snake(this.segs, this.dir, this.moveDelay - 1);
        }
    }
    
    
    /** check if this snake is about to run into a wall */
    boolean hitWall() {
        if (this.moveDelay > 0) {
            return false;
        } else {
            Posn newLoc = this.getLoc().translate(this.dir);
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
        return new Snake(this.segs, newDir, this.moveDelay);
    }
    

    /* returns the snake's head position */
    public Posn getLoc() {
    	return this.segs.getHead();
    }
    
    /* returns the snake's direction */
    public Posn getDir() {
    	return dir;
    }
    
    
    /*returns the snake's segments */
    public PosnList getSegs() {
    	return segs;
    }
    
    
    // auto-generated methods
    

    @Override
    public int hashCode() {
        return Objects.hash(dir, moveDelay, segs);
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
        return Objects.equals(dir, other.dir) && moveDelay == other.moveDelay && Objects.equals(segs, other.segs);
    }

    @Override
    public String toString() {
        return "Snake [segs=" + segs + ", dir=" + dir + ", moveDelay=" + moveDelay + "]";
    }
    

}
