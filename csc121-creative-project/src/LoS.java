/*
 * A list of snake boxes
 */

import java.util.Objects;

import processing.core.PApplet;

class LoS {
	
	Snake first; //represents the first snake box
	LoS rest; //represents the rest of the snake boxes
	
	
	
	public LoS(Snake first, LoS rest) {
		this.first = first;
		this.rest = rest;
	}

	/* draws the snake as a green square */
//    PApplet draw(PApplet c) {
//        c.fill(64, 227, 73);
//        c.square(this.loc.getX(), this.loc.getY(), 30);
//        return c;
//    }
	
	/* if apple is hit by snake, add another snake box */
	public LoS addBox(Apple a) {
		if (a.hitBySnake(first.getLoc())) {
			if (this.first.getDir().equals(SnakeWorld.UP)) {
				return addBoxInList(this.first.changeLocation(0,  30));
			} else if (this.first.getDir().equals(SnakeWorld.DOWN)){
				return addBoxInList(this.first.changeLocation(0,  -30));
			} else if (this.first.getDir().equals(SnakeWorld.RIGHT)){
				return addBoxInList(this.first.changeLocation(-30, 0));
			} else {    //checks LEFT
				return addBoxInList(this.first.changeLocation(30, 0));
			} 
			
		} else {
			return this; 
		}
	}
	
	/* adds a snake box onto the back of the list */
	public LoS addBoxInList(Snake slimy) {
		if (rest == null) {
			return new LoS(first, new LoS(slimy, null));
		} else {
			return new LoS(first, rest.addBoxInList(slimy));
		}
	}

	
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
		LoS other = (LoS) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}
	
	
	
	
	
	
}
