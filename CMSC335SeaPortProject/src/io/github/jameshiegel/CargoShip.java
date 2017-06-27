package io.github.jameshiegel;

import java.util.ArrayList;

public class CargoShip extends Ship {
	// instance variables
	private double cargoValue = 0.0;
	private double cargoVolume = 0.0;
	private double cargoWeight = 0.0;

	// constructors
	public CargoShip(int index, String name, int parent, PortTime arrivalTime, PortTime dockTime, double draft,
			double length, double weight, double width, ArrayList<Job> jobs, double cargoValue, double cargoVolume,
			double cargoWeight) {
		super(index, name, parent, arrivalTime, dockTime, draft, length, weight, width, jobs);
		this.cargoValue = cargoValue;
		this.cargoVolume = cargoVolume;
		this.cargoWeight = cargoWeight;
	}

	// methods
	public double getCargoValue() {
		return cargoValue;
	}

	public void setCargoValue(double cargoValue) {
		this.cargoValue = cargoValue;
	}

	public double getCargoVolume() {
		return cargoVolume;
	}

	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	public double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

}
