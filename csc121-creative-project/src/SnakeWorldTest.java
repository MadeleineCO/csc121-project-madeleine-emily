import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {
	
    Snake sl1 = new Snake(new Posn(300, 300), SnakeWorld.UP, 0);
    Snake sl2 = new Snake(new Posn(300, 300), SnakeWorld.UP, 57);
    Snake sl3 = new Snake(new Posn(570, 300), SnakeWorld.RIGHT, 0);
    Snake sl4 = new Snake(new Posn(301, 301), SnakeWorld.UP, 0);
    
	Apple a = new Apple(new Posn(300, 300));
	Apple a2 = new Apple(new Posn(50, 50));
	
	LoS los1 = new LoS(sl1, null);
	LoS los1v2 = new LoS(sl1, new LoS(sl2, null)); 
	LoS los1v3 = new LoS(sl2, new LoS(sl1, null));
	LoS los2 = new LoS(sl1, new LoS(sl2, new LoS(sl3, null)));
	LoS los3 = new LoS(sl4, null);
	
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
		assertTrue(a.hitBySnake(sl4.getLoc()));
	}
	
	@Test 
	void testAddBoxInList() {
		assertEquals(los1, new LoS(sl1, null));
		assertEquals(los1v2, new LoS(sl1, new LoS(sl2, null)));
		
		los1 = los1.addBoxInList(sl2);
		assertEquals(los1, new LoS(sl1, new LoS(sl2, null))); 
		
		assertFalse(los1.equals(new LoS(sl2, new LoS(sl1, null))));		
		assertFalse(los1.equals(new LoS(sl1, null)));  
		
		los2 = los2.addBoxInList(sl1);
		assertEquals(los2, new LoS(sl1, new LoS(sl2, new LoS(sl3, new LoS(sl1, null)))));

	}
	
	@Test
	void testAddBox() {
		assertEquals(los3, new LoS(sl4, null));
		los3 = los3.addBox(a);
		assertEquals(los3, new LoS(sl4, new LoS(new Snake(new Posn(301, 331), SnakeWorld.UP, 0), null)));
		
	}
	
	@Test 
	void testChangeLocation() {
		assertTrue(new Snake(new Posn (330, 300), SnakeWorld.UP, 0).equals(sl1.changeLocation(30, 0)));
	}

}
