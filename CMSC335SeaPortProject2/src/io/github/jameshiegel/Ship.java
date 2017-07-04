package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

//File: Ship.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: A superclass for Passenger and Cargo ships.

public class Ship extends Thing {
	// instance variables
	protected PortTime arrivalTime = new PortTime();
	protected PortTime dockTime = new PortTime();
	protected double draft = 0.0;
	protected double length = 0.0;
	protected double weight = 0.0;
	protected double width = 0.0;
	protected ArrayList<Job> jobs = new ArrayList<Job>();

	// constructors
	public Ship() {
		super();
	} // end default constructor

	public Ship(Scanner sc) {
		super(sc);
		if (sc.hasNextDouble())
			weight = sc.nextDouble();
		if (sc.hasNextDouble())
			length = sc.nextDouble();
		if (sc.hasNextDouble())
			width = sc.nextDouble();
		if (sc.hasNextDouble())
			draft = sc.nextDouble();
	} // end Scanner constructor

	// methods
	public PortTime getArrivalTime() {
		return arrivalTime;
	} // end method getArrivalTime

	public PortTime getDockTime() {
		return dockTime;
	}// end method getDockTime

	public double getDraft() {
		return draft;
	}// end method getDraft

	public double getLength() {
		return length;
	}// end method getLength

	public double getWeight() {
		return weight;
	}// end method getWeight

	public double getWidth() {
		return width;
	}// end method getWidth

	public ArrayList<Job> getJobs() {
		return jobs;
	}// end method getJobs

	@Override
	public String toString() {
		return super.toString();
	} // end method toString

	// @Override
	// public String toString() {
	// String st = super.toString();
	// st += String.format("%10.2f D %10.2f L %10.2f W %10.2f <-> ", draft,
	// length, weight, width);
	// return st;
	// } // end method toString

} // end class Ship
