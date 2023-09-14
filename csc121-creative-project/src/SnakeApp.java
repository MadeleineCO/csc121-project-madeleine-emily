
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
        w = new SnakeWorld(width/2, height/2, "right");
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
    }
}