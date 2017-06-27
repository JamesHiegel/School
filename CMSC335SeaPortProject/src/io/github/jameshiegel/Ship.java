package io.github.jameshiegel;

import java.util.ArrayList;

public class Ship extends Thing {
	// instance variables
	private PortTime arrivalTime, dockTime;
	private double draft, length, weight, width;
	private ArrayList<Job> jobs = new ArrayList<Job>();

	// constructors
	public Ship(int index, String name, int parent, PortTime arrivalTime, PortTime dockTime, double draft,
			double length, double weight, double width, ArrayList<Job> jobs) {
		super(index, name, parent);
		this.arrivalTime = arrivalTime;
		this.dockTime = dockTime;
		this.draft = draft;
		this.length = length;
		this.weight = weight;
		this.width = width;
		this.jobs = jobs;
	}

	// methods
	public PortTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(PortTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public PortTime getDockTime() {
		return dockTime;
	}

	public void setDockTime(PortTime dockTime) {
		this.dockTime = dockTime;
	}

	public double getDraft() {
		return draft;
	}

	public void setDraft(double draft) {
		this.draft = draft;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
}
