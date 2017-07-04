package io.github.jameshiegel;

public class CargoShip {
	// instance variables
	protected double cargoValue = 0.0;
	protected double cargoVolume = 0.0;
	protected double cargoWeight = 0.0;

	// constructors
	public CargoShip() {
		super();
	} // end constructor

	// methods
	public double getCargoValue() {
		return cargoValue;
	} // end method getCargoValue

	public double getCargoVolume() {
		return cargoVolume;
	} // end method getCargoVolume

	public double getCargoWeight() {
		return cargoWeight;
	} // end method getCargoWeight

	@Override
	public String toString() {
		String st = "Passenger Ship: " + super.toString();
		return st;
	} // end method toString


}
