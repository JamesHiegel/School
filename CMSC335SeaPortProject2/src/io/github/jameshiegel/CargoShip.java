package io.github.jameshiegel;

import java.util.Comparator;
import java.util.Scanner;

//File: CargoShip.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates a cargo ship.

public class CargoShip extends Ship {
	// instance variables
	protected double cargoValue = 0.0;
	protected double cargoVolume = 0.0;
	protected double cargoWeight = 0.0;

	// constructors
	public CargoShip() {
		super();
	} // end default constructor

	public CargoShip(Scanner sc) {
		super(sc);
		if (sc.hasNextDouble())
			cargoWeight = sc.nextDouble();
		if (sc.hasNextDouble())
			cargoVolume = sc.nextDouble();
		if (sc.hasNextDouble())
			cargoValue = sc.nextDouble();
	} // end Scanner constructor

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
		return "Cargo Ship: " + super.toString();
	} // end method toString

	public static Comparator<CargoShip> CargoShipValueComparator = new Comparator<CargoShip>() {
		@Override
		public int compare(CargoShip arg0, CargoShip arg1) {
			return Double.compare(arg0.cargoValue, arg1.cargoValue);
		} // end compare
	}; // end method CargoShipValueComparator
	
	public static Comparator<CargoShip> CargoShipVolumeComparator = new Comparator<CargoShip>() {
		@Override
		public int compare(CargoShip arg0, CargoShip arg1) {
			return Double.compare(arg0.cargoVolume, arg1.cargoVolume);
		} // end compare
	}; // end method CargoShipVolumeComparator
	
	public static Comparator<CargoShip> CargoShipWeightComparator = new Comparator<CargoShip>() {
		@Override
		public int compare(CargoShip arg0, CargoShip arg1) {
			return Double.compare(arg0.cargoWeight, arg1.cargoWeight);
		} // end compare
	}; // end method CargoShipWeightComparator
} // end class CargoShip
