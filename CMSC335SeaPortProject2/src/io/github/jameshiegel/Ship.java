package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Comparator;
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
		String st = super.toString();
		st += jobs.toString();
		return st;
	} // end method toString

	public static Comparator<Ship> ShipWeightComparator = new Comparator<Ship>() {
		@Override
		public int compare(Ship arg0, Ship arg1) {
			return Double.compare(arg0.weight, arg1.weight);
		} // end compare
	}; // end method ShipWeightComparator

	public static Comparator<Ship> ShipLengthComparator = new Comparator<Ship>() {
		@Override
		public int compare(Ship arg0, Ship arg1) {
			return Double.compare(arg0.length, arg1.length);
		} // end compare
	}; // end method ShipLengthComparator
	
	public static Comparator<Ship> ShipWidthComparator = new Comparator<Ship>() {
		@Override
		public int compare(Ship arg0, Ship arg1) {
			return Double.compare(arg0.width, arg1.width);
		} // end compare
	}; // end method ShipWidthComparator
	
	public static Comparator<Ship> ShipDraftComparator = new Comparator<Ship>() {
		@Override
		public int compare(Ship arg0, Ship arg1) {
			return Double.compare(arg0.draft, arg1.draft);
		} // end compare
	}; // end method ShipDraftComparator
	
	// @Override
	// public String toString() {
	// String st = super.toString();
	// st += String.format("%10.2f D %10.2f L %10.2f W %10.2f <-> ", draft,
	// length, weight, width);
	// return st;
	// } // end method toString

} // end class Ship
