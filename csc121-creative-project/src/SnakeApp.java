
import processing.core.*;
import processing.event.KeyEvent; 

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {
    SnakeWorld w;
    AppleWorld a;
    
    public void settings() {
        this.size(600, 600);
    }
    
    public void setup() {
        w = new SnakeWorld(width/2, height/2, "right");
        a = new AppleWorld(Math.random() * 601, Math.random() * 601);
    }
    
    public void draw() {
    	w = w.update();
        a = a.update(w);
        
        w.draw(this);
        a.draw(this);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }
    

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "SnakeApp" }, new SnakeApp());
        //PApplet.runSketch(new String[] { "Apple" }, new SnakeApp());
    }
}