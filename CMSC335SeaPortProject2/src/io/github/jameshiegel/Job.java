package io.github.jameshiegel;

import java.util.ArrayList;

//File: Job.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: Simulates a job that needs to be completed for a Ship. Each 
 * job requires a specific skill and takes a specified amount of time 
 * to complete.
 */

public class Job extends Thing {
	// instance variables
	protected double duration = 0.0;
	protected ArrayList<String> requirements = new ArrayList<String>();
	
	// constructor
	public Job() {
		super();
	} // end default constructor
	
	// methods
	public double getDuration() {
		return duration;
	} // end method getDuration
	
	public ArrayList<String> getRequirements() {
		return requirements;
	} // end method getRequirements

	@Override
	public String toString() {
		return name;
	} // end method toString
	
}// end class Job
