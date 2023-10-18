import processing.core.PApplet;

class PoisonBerry extends AFruit implements IFruit {
	
	public PoisonBerry(Posn loc) {
		super(loc);
	}

	/*
	 * Draws this PoisonBerry as a green square
	 */
	public PApplet draw(PApplet a) {
		a.fill(0, 255, 0);
		a.square((int) this.getLoc().getX(), (int) this.getLoc().getY(), SIZE);
		return a;
	}
	
	/*
	 * Returns this PoisonBerry
	 */
	@Override
	public IFruit move(Snake s) {
		return this;
	}

	@Override
	public String toString() {
		return "PoisonBerry []";
	}

}
