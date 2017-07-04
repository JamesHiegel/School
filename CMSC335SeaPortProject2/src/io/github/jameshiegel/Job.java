package io.github.jameshiegel;

import java.util.ArrayList;

public class Job extends Thing {
	// instance variables
	protected double duration = 0.0;
	protected ArrayList<String> requirements = new ArrayList<String>();
	
	// constructor
	public Job() {
		super();
	}
	
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
}
