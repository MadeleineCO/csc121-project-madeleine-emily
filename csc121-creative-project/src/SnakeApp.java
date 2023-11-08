import java.io.*;
import processing.core.*;
import processing.event.KeyEvent; 
import java.util.*;
import java.io.File;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {

	private IWorld w;
	public static final int WINDOW_SIZE = 600;
	//public static int SCORE;
	//public static int HIGH_SCORE; 




	/* sets the size of the game board */
	public void settings() {
		this.size(WINDOW_SIZE, WINDOW_SIZE);
	}

	/* sets up the SnakeWorld */
	public void setup() {
		w = new StartWorld(); 
	}

	/* draws the SnakeWorld */
	public void draw() {
		w = w.update();
		w.draw(this);
		w = w.gameOver();  
	}

	/* updates the SnakeWorld when an arrow key is pressed */
	public void keyPressed(KeyEvent kev) {
		w = w.keyPressed(kev);
	}


 /*
	public static boolean processFile() throws FileNotFoundException 
	{
		File hFile = new File("HighScoreFile");

		Scanner sc = new Scanner(hFile); 
		PrintWriter pw = new PrintWriter(hFile);
		
		if (sc.hasNext()) {
			HIGH_SCORE = sc.nextInt();
		}
		
		while (sc.hasNext()) {
			int i = sc.nextInt();
			
			if (i > HIGH_SCORE) {
				HIGH_SCORE = i;
			}
			
		}
		
		
		pw.println(HIGH_SCORE);
		System.out.println(HIGH_SCORE);
		
		pw.close();
		sc.close();
		
		return true; 
	}    */


	/* runs the SnakeWorld */
	public static void main(String[] args) {

//		try {
//			processFile();
//		} catch(FileNotFoundException e) {
//			System.out.println("High score file not found.");
//		}
		
		
		
		PApplet.runSketch(new String[] { "SnakeApp" }, new SnakeApp());
		
	}


}
