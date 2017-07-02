package io.github.jameshiegel;

public class Dock extends Thing {
	// instance variables
	private Ship ship;

	// constructors
	public Dock(int index, String name, int parent, Ship ship) {
		super(index, name, parent);
		this.ship = ship;
	}

	// methods
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "Dock [ship=" + ship + "]";
	}
	
}
