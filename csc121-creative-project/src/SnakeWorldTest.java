import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {

	SnakeWorld s = new SnakeWorld(300, 300, "up");
	
	SnakeWorld s2 = new SnakeWorld(300, 330, "up");
	
	SnakeWorld s3 = new SnakeWorld(330, 300, "up");
	
	SnakeWorld s4 = new SnakeWorld(300, 270, "up");
	
	SnakeWorld s5 = new SnakeWorld(270, 330, "up");
	
	AppleWorld a = new AppleWorld(300, 300);
	
	@Test
	void testAppleWorldUpdate() {
		//assertEquals(new AppleWorld(100, 100), a.update(s)); //works - snake on top of apple
		
		//assertEquals(new AppleWorld(100, 100), a.update(s2)); //works - checks bottom line
		
		//assertEquals(new AppleWorld(100, 100), a.update(s3));  //works - checks right line
		
		//assertEquals(new AppleWorld(100, 100), a.update(s4)); //works   - checks top line
		
		//assertEquals(new AppleWorld(100, 100), a.update(s5));   //works - checks left line
	}

}
