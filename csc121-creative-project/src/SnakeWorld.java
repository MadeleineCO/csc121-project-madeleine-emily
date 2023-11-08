import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*; 

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
    
    public static boolean isGameOver = false; 
    
    public static int SCORE; 
    public static int HIGH_SCORE; 

    public SnakeWorld(Snake slimy, IFruit a) {
        this.slimy = slimy;
        this.a = a;
        this.b = new Apple(
				new Posn( (float)  (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60, 
						(float) (Math.random() * ((SnakeApp.WINDOW_SIZE - 120) + 1)) + 60));
        try {
        	if (isGameOver) {
        		updateHighScore(); 
        	} else {
        		HIGH_SCORE = readHighScore(); 
        	}
		} catch(FileNotFoundException e) {
			System.out.println("High score file not found.");
		}
    }
    
    public SnakeWorld(Snake slimy, IFruit a, IFruit b) {
        this.slimy = slimy;
        this.a = a;
        this.b = b;
    }

    /**
     * Renders the game
     */
    public PApplet draw(PApplet w) 
    {
        w.background(108, 206, 120);
        this.slimy.draw(w);
        this.a.draw(w);
        this.b.draw(w);
        w.textSize(25); 
        w.fill(0); 
        w.text("Score: " + SCORE, 190, 40);
        w.text("High Score: " + HIGH_SCORE, 290, 40);
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
        if (kev.getKeyCode() == PApplet.UP && this.slimy.getDir() != DOWN) {
            return new SnakeWorld(this.slimy.changeDirection(UP), this.a, this.b);
        } 
        else if (kev.getKeyCode() == PApplet.DOWN && this.slimy.getDir() != UP) {
            return new SnakeWorld(this.slimy.changeDirection(DOWN), this.a, this.b);
        } 
        else if (kev.getKeyCode() == PApplet.RIGHT && this.slimy.getDir() != LEFT) {
            return new SnakeWorld(this.slimy.changeDirection(RIGHT), this.a, this.b);
        } else if (kev.getKeyCode() == PApplet.LEFT && this.slimy.getDir() != RIGHT) {
            return new SnakeWorld(this.slimy.changeDirection(LEFT), this.a, this.b);
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
    		if (SCORE > HIGH_SCORE) {
    			HIGH_SCORE = SCORE;
    		}
    		SCORE = 0;
    		
    		isGameOver = true; 
    		
    		return new OverWorld();  
    		
    		
    		
    	} else { 
    		return this;  
    	} 
    }
    
    /* reads the high score file */ 
    public int readHighScore() throws FileNotFoundException {
    	File hFile = new File("HighScoreFile");

		Scanner sc = new Scanner(hFile); 
		
    	int h = 0; 
    	while (sc.hasNext()) {
    		if (sc.nextInt() > h) {
    			h = sc.nextInt(); 
    		}
    	}
    	
    	sc.close(); 
    	return h; 
    }
    
    /* writes and updates the high score file */
    public void updateHighScore() throws FileNotFoundException{
    	PrintWriter pw = new PrintWriter(new File("HighScoreFile"));
    	pw.println(HIGH_SCORE); 
    	
    	pw.close(); 
    }
    
    // auto-generated methods

	@Override
	public int hashCode() {
		return Objects.hash(a, b, slimy);
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
		return Objects.equals(a, other.a) && Objects.equals(b, other.b) && Objects.equals(slimy, other.slimy);
	}

	@Override
	public String toString() {
		return "SnakeWorld [slimy=" + slimy + ", a=" + a + ", b=" + b + "]";
	}



}
