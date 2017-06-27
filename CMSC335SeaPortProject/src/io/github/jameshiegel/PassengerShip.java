package io.github.jameshiegel;

import java.util.ArrayList;

public class PassengerShip extends Ship {
	// instance variables
	private int numberOfOccupiedRooms = 0;
	private int numberOfPassengers = 0;
	private int numberOfRooms = 0;

	// constructors
	public PassengerShip(int index, String name, int parent, PortTime arrivalTime, PortTime dockTime, double draft,
			double length, double weight, double width, ArrayList<Job> jobs, int numberOfOccupiedRooms,
			int numberOfPassengers, int numberOfRooms) {
		super(index, name, parent, arrivalTime, dockTime, draft, length, weight, width, jobs);
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfRooms = numberOfRooms;
	}

	// methods
	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	}

	public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

}
