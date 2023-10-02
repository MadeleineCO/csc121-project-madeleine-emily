import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeWorldTest {

    Snake sl1 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 0);
    Snake sl2 = new Snake(new PosnList().append(new Posn(300, 300)), SnakeWorld.UP, 57);
    Snake sl3 = new Snake(new PosnList().append(new Posn(570, 300)), SnakeWorld.RIGHT, 0);

    Apple a = new Apple(new Posn(300, 300));
    Apple a2 = new Apple(new Posn(50, 50));

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
