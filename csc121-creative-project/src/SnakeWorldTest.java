import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {

    Snake sl1 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 0);
    Snake sl2 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 57);
    Snake sl3 = new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 0);

    Apple a = new Apple(new Posn(300, 300));
    Apple a2 = new Apple(new Posn(50, 50));

    LoS los1 = new LoS(sl1, null);
    LoS los1v2 = new LoS(sl1, new LoS(sl2, null)); 
    LoS los1v3 = new LoS(sl2, new LoS(sl1, null));
    LoS los2 = new LoS(sl1, new LoS(sl2, new LoS(sl3, null)));

    ILoP mt = new MTLoP();
    ILoP lst = new ConsLoP(new Posn(100, 120), new ConsLoP(new Posn(120, 120), mt));
    ILoP lstApp = new ConsLoP(new Posn(100, 120), new ConsLoP(new Posn(120, 120), 
            new ConsLoP(new Posn(140, 120), mt)));


    @Test
    void testSnake() {
        assertTrue(a.hitBySnake(new Posn(300, 300)));
        
        assertEquals(new Snake(new PosnList().append(new Posn(300, 270)), SnakeWorld.UP, 25),
                sl1.move(a));
        assertEquals(new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 56),
                sl2.move(a));

        assertEquals(new Snake(new PosnList().append(new Posn(300, 300)).append(new Posn(300, 270)), SnakeWorld.DOWN, 25),
                new Snake(new PosnList().append(new Posn(300, 270)), SnakeWorld.DOWN, 0).move(a));

        

        assertFalse(sl1.hitWall());
        assertTrue(sl3.hitWall());
        assertFalse(new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 57).hitWall());
        assertTrue(new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 0).hitWall());
    }


    @Test
    void testHitBySnake() {
        assertFalse(a.hitBySnake(new Posn(0,0)));
        assertTrue(a2.hitBySnake(new Posn(60,60)));
        assertTrue(a2.hitBySnake(new Posn(51, 51)));
        assertFalse(a2.hitBySnake(new Posn(51, 81)));
        assertFalse(a2.hitBySnake(new Posn(79, 79)));
        assertTrue(a2.hitBySnake(new Posn(60, 40)));
        assertFalse(a2.hitBySnake(new Posn(60, 90)));
    }

    @Test 
    void testAddBoxInList() {
        assertEquals(los1, new LoS(sl1, null));
        assertEquals(los1v2, new LoS(sl1, new LoS(sl2, null)));

        los1 = los1.addBoxInList(los1, sl2);
        assertEquals(los1, new LoS(sl1, new LoS(sl2, null))); 

        assertFalse(los1.equals(new LoS(sl2, new LoS(sl1, null))));		
        assertFalse(los1.equals(new LoS(sl1, null)));  

        los2 = los2.addBoxInList(los2, sl1);
        assertEquals(los2, new LoS(sl1, new LoS(sl2, new LoS(sl3, new LoS(sl1, null)))));



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
    void testGetFirst() {
        assertEquals( new Posn(100, 120)  , new PosnList(lst).getHead() );
    }





}
