package io.github.jameshiegel;

import java.util.ArrayList;

public class Job extends Thing {
	// instance variables
	private double duration = 0.0;
	// should be some of the skills of the persons
	private ArrayList<String> requirements = new ArrayList<String>();

	// constructors
	public Job(int index, String name, int parent, double duration, ArrayList<String> requirements) {
		super(index, name, parent);
		this.duration = duration;
		this.requirements = requirements;
	}

	// methods
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public ArrayList<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<String> requirements) {
		this.requirements = requirements;
	}

}
