package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JProgressBar;

//File: Job.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: Simulates a job that needs to be completed for a Ship. Each 
 * job requires a specific skill and takes a specified amount of time 
 * to complete.
 */

public class Job extends Thing implements Runnable {
	// instance variables
	protected double duration = 0.0;
	protected ArrayList<String> requirements = new ArrayList<String>();
	private JProgressBar bar;
	private Thread thread = new Thread();

	// constructor
	public Job() {
		super();
	} // end default constructor

	public Job(Scanner sc) {
		super(sc);
		if (sc.hasNextDouble())
			duration = sc.nextDouble();
		while (sc.hasNext())
			requirements.add(sc.next());
	} // end Scanner constructor

	// methods
	public double getDuration() {
		return duration;
	} // end method getDuration

	public ArrayList<String> getRequirements() {
		return requirements;
	} // end method getRequirements
	
	public void setThread(Thread thread) {
		this.thread = thread;
	} // end method setThread
	
	public void setBar(JProgressBar bar) {
		this.bar = bar;
	} // end method setBar

	@Override
	public String toString() {
		return null;
		// return name;
		// return requirements.toString();
	} // end method toString

	@Override
	public void run() {
		int sleepTime = 30;
		try {
			if (thread.isAlive())
				thread.join(); // Will wait on passes thread
			bar.setString(null); // Removes static text to allow % displayed
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(sleepTime);
				bar.setValue(i);
			}
		} catch (InterruptedException e) {
			bar.setString("Interrupted");
			return;
		}
		bar.setString("Finished");
	} // end method run

}// end class Job
