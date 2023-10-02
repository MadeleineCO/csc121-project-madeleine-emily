import java.util.Objects;

import processing.core.PApplet;


/**
 * represents a functional-style list of posns
 */
public interface ILoP {

    /** produces a new list of posns with the given one added to the end */
    ILoP append(Posn posn);

    /** produces the first posn in this list */
    Posn getFirst();

    /**
     * draws squares of the given size at each of the 
     * posns in this list.
     */
    PApplet drawSquares(PApplet c, int size);

    /**
     * removes the last posn in this list
     */
    ILoP dropLast();

    /**
     * is this list empty?
     */
    boolean isEmpty();
}


class MTLoP implements ILoP {
    
    
    
    /** produces a new list of posns with the given one added to the end */
    public ILoP append(Posn posn) {
        return new ConsLoP(posn, this);
    }
    
    /** produces the first posn in this list */
    public Posn getFirst() {
        throw new IllegalStateException("the list is empty");
    }
    
    /**
     * draws squares of the given size at each of the 
     * posns in this list.
     */
    public PApplet drawSquares(PApplet c, int size) {
        return c;
    }
    
    /**
     * removes the last posn in this list
     */
    public ILoP dropLast() {
        throw new IllegalStateException("the list is empty");
    }
    
    /**
     * is this list empty?
     */
    public boolean isEmpty() {
        return true;
    }


    // auto-generated methods
    
    @Override
    public boolean equals(Object other) {
        return other instanceof MTLoP;
    }

    @Override
    public int hashCode() {
        return MTLoP.class.hashCode();
    }

    @Override
    public String toString() {
        return "MTLoP []";
    }
}


class ConsLoP implements ILoP {
    private Posn first;
    private ILoP rest;
    
    public ConsLoP(Posn first, ILoP rest) {
        this.first = first;
        this.rest = rest;
    }
    
    /** produces a new list of posns with the given one added to the end */
    public ILoP append(Posn posn) {
        return new ConsLoP(this.first, this.rest.append(posn));
    }
    
    /** produces the first posn in this list */
    public Posn getFirst() {
        return this.first;
    }
    
    /**
     * is this list empty?
     */
    public boolean isEmpty() {
        return false;
    }
    
    /**
     * draws squares of the given size at each of the 
     * posns in this list.
     */
    public PApplet drawSquares(PApplet c, int size) {
        c.square(this.first.getX(), this.first.getY(), 30);
        return this.rest.drawSquares(c, size);
    }

    /**
     * removes the last posn in this list
     */
    public ILoP dropLast() {
        if (this.rest.isEmpty()) {
            return this.rest;
        } else {
            return new ConsLoP(this.first, this.rest.dropLast());
        }
    }
    

    // auto-generated

    @Override
    public int hashCode() {
        return Objects.hash(first, rest);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConsLoP other = (ConsLoP) obj;
        return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
    }

    @Override
    public String toString() {
        return "ConsLoP [first=" + first + ", rest=" + rest + "]";
    }
    
    
    
}


