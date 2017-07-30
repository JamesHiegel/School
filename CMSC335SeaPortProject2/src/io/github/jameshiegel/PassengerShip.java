package io.github.jameshiegel;

import java.util.Comparator;
import java.util.Scanner;

//File: PassengerShip.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates a passenger ship.

public class PassengerShip extends Ship {
	// instance variables
	protected int numberOfOccupiedRooms = 0;
	protected int numberOfPassengers = 0;
	protected int numberOfRooms = 0;

	// constructors
	public PassengerShip() {
		super();
	} // end default constructor

	public PassengerShip(Scanner sc) {
		super(sc);
		if (sc.hasNextInt())
			numberOfPassengers = sc.nextInt();
		if (sc.hasNextInt())
			numberOfRooms = sc.nextInt();
		if (sc.hasNextInt())
			numberOfOccupiedRooms = sc.nextInt();
	} // end Scanner constructor

	// methods
	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	} // end method getNumberOfOccupiedRooms

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	} // end method getNumberOfPassengers

	public int getNumberOfRooms() {
		return numberOfRooms;
	} // end method getNumberOfRooms

	@Override
	public String toString() {
		String st = "Passenger ship: " + super.toString();
		if (jobs.size() == 0)
			return st;
		for (Job mj : jobs)
			st += "\n       - " + mj;
		return st;
	} // end method toString

	public static Comparator<PassengerShip> PassShipNumOccupiedRoomsComparator = new Comparator<PassengerShip>() {
		@Override
		public int compare(PassengerShip arg0, PassengerShip arg1) {
			return arg0.numberOfOccupiedRooms - arg1.numberOfOccupiedRooms;
		} // end compare
	}; // end method PassShipNumOccupiedRoomsComparator
	
	public static Comparator<PassengerShip> PassShipNumPassComparator = new Comparator<PassengerShip>() {
		@Override
		public int compare(PassengerShip arg0, PassengerShip arg1) {
			return arg0.numberOfPassengers - arg1.numberOfPassengers;
		} // end compare
	}; // end method PassShipNumPassComparator
	
	public static Comparator<PassengerShip> PassShipNumRoomsComparator = new Comparator<PassengerShip>() {
		@Override
		public int compare(PassengerShip arg0, PassengerShip arg1) {
			return arg0.numberOfRooms - arg1.numberOfRooms;
		} // end compare
	}; // end method PassShipNumRoomsComparator
	
} // end class PassengerShip
