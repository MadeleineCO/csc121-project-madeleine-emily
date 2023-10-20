import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {

    Snake sl1 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 0);
    Snake sl2 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 57);
    Snake sl3 = new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 0);

    IFruit a = new Apple(new Posn(300, 300));
    IFruit a2 = new Apple(new Posn(50, 50));

    ILoP mt = new MTLoP();
    ILoP lst = new ConsLoP(new Posn(100, 120), new ConsLoP(new Posn(120, 120), mt));
    ILoP lstApp = new ConsLoP(new Posn(100, 120), new ConsLoP(new Posn(120, 120), 
            new ConsLoP(new Posn(140, 120), mt)));


    @Test
    void testSnake() {
    	assertEquals(new Posn(300,300), a.getLoc());
    	
        assertTrue(a.hitBySnake(new Posn(300, 300)));
        
        assertEquals(new Snake(new PosnList().append(new Posn(300, 270)), SnakeWorld.UP, SnakeWorld.DELAY_AMOUNT),
                sl1.move(a));
        assertEquals(new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 56),
                sl2.move(a));

        assertEquals(new Snake(new PosnList().append(new Posn(300, 300)).append(new Posn(300, 270)), SnakeWorld.DOWN, SnakeWorld.DELAY_AMOUNT),
                new Snake(new PosnList().append(new Posn(300, 270)), SnakeWorld.DOWN, 0).move(a));

        

        assertFalse(sl1.hitWall());
        assertTrue(sl3.hitWall());
        assertFalse(new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 57).hitWall());
        assertTrue(new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 0).hitWall());
    }


    @Test
    void testAppendILoP() {
        assertEquals(new ConsLoP(new Posn(140, 160), mt), mt.append(new Posn(140, 160)));
        assertEquals(lstApp, lst.append(new Posn(140, 120)));


        PosnList pl = new PosnList();
        pl.append(new Posn(100, 120)).append(new Posn(120, 120));

        assertEquals(new PosnList(lst),   pl);
    }

    @Test
    void testDropLast() {
        assertEquals(mt, new ConsLoP(new Posn(120, 120), mt).dropLast());
        assertEquals(lst, lstApp.dropLast());
    }

    @Test
    void testCountSegs() {
    	assertEquals(3, lstApp.countSegs());
    }
    
    @Test
    void testHitPosn() {
    	assertTrue(lst.hitPosn(new Posn(100, 120)));
    	assertFalse(lst.hitPosn(new Posn(300, 300)));
    }
    
    @Test
    void testHitPosnInList() {
        ILoP lop = new ConsLoP(new Posn(100, 100), new ConsLoP(new Posn(200, 200), mt));
        ILoP lop2 = new ConsLoP(new Posn(100, 100), new ConsLoP(new Posn(100, 100), mt));
        ILoP lop3 = new ConsLoP(new Posn(100, 100), new ConsLoP(new Posn(110, 110), mt));
        ILoP lop4 = new ConsLoP(new Posn(100, 100), new ConsLoP(new Posn(200, 200), new ConsLoP(new Posn(110, 110), mt)));
    
		assertFalse(lop.hitPosnInList(lop));
		assertTrue(lop2.hitPosnInList(lop2));
		assertTrue(lop3.hitPosnInList(lop3));
		assertTrue(lop4.hitPosnInList(lop4));
	
    }




}
