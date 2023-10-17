import java.util.Objects;

import processing.core.PApplet;

public class PosnList {
    
    private ILoP lop;
    
    public PosnList() {
        lop = new MTLoP();
    }
    
    // package access only
    PosnList(ILoP lop) {
        this.lop = lop;
    }

    /**
    boolean ranIntoSelf()
    {
    	lop.rest.hitAny(this.first); 
    }
    */

    /**
     * draws squares of the given size at each of the 
     * posns in this list.
     */
    public PApplet drawSquares(PApplet c, int size) {
        return this.lop.drawSquares(c, size);
    }

    
    
    /** moves the head of this list in the given 
     *  direction. if grow is true, the tail stays
     *  where it was. if grow is false, drop the
     *  tail segment so the whole list looks like
     *  "moves"
     */
    public PosnList move(Posn dir, boolean grow) {
        this.lop = new ConsLoP(this.getHead().translate(dir), this.lop);
        
        if (!grow) {
            this.lop = this.lop.dropLast();
        } 
        
        return this;
    }
    
    /*
     * Moves the snake
     */
    public PosnList move(Posn dir) {
        return this.move(dir, false);
    }

	
	
	/** checks if the head of this snake has hit itself */
	public boolean hitPosnInList() {
		return lop.hitPosnInList(lop);
	}
		
    
    /**
     * returns the first posn in this list
     */
    public Posn getHead() {
        return this.lop.getFirst();
    }

    /**
     * adds the given posn to the end of this list
     * and produces the resulting list
     */
    public PosnList append(Posn posn) {
        this.lop = this.lop.append(posn);
        return this;
    }
    
    
    
    
    // auto-generated methods

    @Override
    public int hashCode() {
        return Objects.hash(lop);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PosnList other = (PosnList) obj;
        return Objects.equals(lop, other.lop);
    }

    @Override
    public String toString() {
        return "PosnList [lop=" + lop + "]";
    }

    
    
    
}
