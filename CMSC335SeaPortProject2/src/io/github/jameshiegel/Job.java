package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

//File: Job.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: Simulates a job that needs to be completed for a Ship. Each 
 * job requires a specific skill and takes a specified amount of time 
 * to complete.
 */

//job    name index parent duration [skill]+ (one or more, matches skill in person, may repeat)
//job    <string> <int> <int> <double> [<string>]+

public class Job extends Thing implements Runnable {
	// instance variables
	private double duration = 0.0;
	private ArrayList<String> requirements = new ArrayList<String>();
	
	private JPanel jobStatusPane;
	private JProgressBar jobBar = new JProgressBar();
	private enum Status {RUNNING, WAITING, COMPLETE, MISSING_SKILLS}
	private Status status = Status.WAITING;
	
	// constructor
	public Job(JPanel jobStatusPane, Scanner sc) {
		super(sc);
		if (sc.hasNextDouble())
			duration = sc.nextDouble();
		while (sc.hasNext())
			requirements.add(sc.next());
		this.jobStatusPane = jobStatusPane;
	} // end constructor

	// methods
	public double getDuration() {
		return duration;
	} // end method getDuration

	public ArrayList<String> getRequirements() {
		return requirements;
	} // end method getRequirements

	@Override
	public String toString() {
		return requirements.toString();
	} // end method toString

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}// end class Job
