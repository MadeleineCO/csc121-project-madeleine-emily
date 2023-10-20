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
    
    /** returns the rest of the list */
    ILoP getRest();

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
    
    //counts the number of posns in this list
    int countSegs();

    //determines if the first posn in this list hits another posn in the list */
	boolean hitPosnInList(ILoP lop);
	
	/*
	 * Determines if the first Posn in the list has hit the given Posn
	 */
	public boolean hitPosn(Posn p);
}


/*
 * Represents an empty list of posns
 */
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
     * draws squares of the given size at each of the posns in this list.
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

    /*
     * Returns zero because there are no Posns in an empty list
     */
    @Override
	public int countSegs() {
		return 0;
	}

    /*
     * Does not apply to an empty list
     */
	@Override
	public ILoP getRest() {
		return null;
	}

	/*
	 * Returns false for this empty list
	 */
	@Override
	public boolean hitPosnInList(ILoP lop) {
		return false;
	}

	/*
	 * Returns false for this empty list
	 */
	@Override
	public boolean hitPosn(Posn p) {
		return false;
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

/*
 * Represents a non-empty list of Posns
 */
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
    
    /** returns the rest of the list */
    public ILoP getRest() {
    	return this.rest;
    }
    
    /**
     * is this list empty?
     */
    public boolean isEmpty() {
        return false;
    }
    
    /**
     * draws squares of the given size at each of the posns in this list.
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
    
    /*
     * Counts the number of segments in this list
     */
    @Override
	public int countSegs() {
		return 1 + this.rest.countSegs();
	}

	/*
	 * Determines if the first of the list hits any of the other Posns in the list
	 */
	public boolean hitPosnInList(ILoP lop) {
		if (lop.isEmpty()) {
	        return false;
	    }

	    if (lop.getRest().hitPosn(first)) {
	        return true;
	    } else {
	        return this.hitPosnInList(lop.getRest());
	    }
	}
	
	/*
	 * Deterimines if the first Posn has hit the given Posn 
	 */
	public boolean hitPosn(Posn p) 
	{	
		return p.distanceTo(this.first) < AFruit.SIZE;
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


