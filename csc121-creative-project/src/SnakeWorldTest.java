import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {
	
    Snake sl1 = new Snake(new Posn(300, 300), SnakeWorld.UP, 0);
    Snake sl2 = new Snake(new Posn(300, 300), SnakeWorld.UP, 57);
    Snake sl3 = new Snake(new Posn(570, 300), SnakeWorld.RIGHT, 0);
    
	Apple a = new Apple(new Posn(300, 300));
	Apple a2 = new Apple(new Posn(50, 50));
	
	@Test
	void testSnake() {
	    assertEquals(new Snake(new Posn(300, 270), SnakeWorld.UP, 25),
	                 sl1.move());
        assertEquals(new Snake(new Posn(300, 300), SnakeWorld.UP, 56),
                    sl2.move());
        
        assertFalse(sl1.hitWall());
        assertTrue(sl3.hitWall());
        assertFalse(new Snake(new Posn(570, 300), SnakeWorld.RIGHT, 57).hitWall());
        assertTrue(new Snake(new Posn(570, 300), SnakeWorld.RIGHT, 0).hitWall());
	}
	
	
	@Test
	void testHitBySnake() {
		assertFalse(a.hitBySnake(new Posn(0,0)));
		assertTrue(a2.hitBySnake(new Posn(60,60)));
		assertTrue(a2.hitBySnake(new Posn(51, 51)));
		assertFalse(a2.hitBySnake(new Posn(51, 81)));
		assertTrue(a2.hitBySnake(new Posn(79, 79)));
		assertFalse(a2.hitBySnake(new Posn(60, 40)));
		assertFalse(a2.hitBySnake(new Posn(60, 90)));
	}

}
