
import processing.core.*;
import processing.event.KeyEvent; 

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {
    SnakeWorld w;
    
    public void settings() {
        this.size(600, 600);
    }
    
    public void setup() {
        w = new SnakeWorld(new Snake(new Posn(width/2, height/2)),
                            new Apple(Math.random() * (width + 1), Math.random() * (width + 1)));
    }
    
    public void draw() {
    	w = w.update();
        w.draw(this);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }
    

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "SnakeApp" }, new SnakeApp());
        //PApplet.runSketch(new String[] { "Apple" }, new SnakeApp());
    }
}