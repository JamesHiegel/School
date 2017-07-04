package io.github.jameshiegel;

import java.util.ArrayList;

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
	} // end constructor

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

} // end class Ship
