package io.github.jameshiegel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

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
	private JPanel jobPane = new JPanel();
	private HashMap<Integer, Thing> hmThings = new HashMap<Integer, Thing>();

	private JProgressBar jobBar = null;

	private enum Status {
		RUNNING, WAITING, COMPLETE, MISSING_SKILLS
	}

	private Status status = Status.WAITING;

	// constructor
	public Job(HashMap<Integer, Thing> hmThings, JPanel jsp, Scanner sc) {
		super(sc);
		if (sc.hasNextDouble())
			duration = sc.nextDouble();
		while (sc.hasNext())
			requirements.add(sc.next());
		jobStatusPane = jsp;
		jobStatusPane.add(jobPane);
		jobBar = new JProgressBar();
		jobBar.setFont(new java.awt.Font("Monospaced", 0, 12));
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		jobBar.setStringPainted(true);
		this.hmThings = hmThings;
		if (hmThings.get(parent) instanceof Dock) {
			jobPane.add(new JLabel(hmThings.get(parent).getName()));
		} else {
			jobPane.add(new JLabel(hmThings.get(parent).toString()));
		}
		jobPane.add(jobBar);
		jobPane.add(new JLabel(requirements.toString()));

		new Thread(this).start();
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

	public void showStatus(Status st) {
		status = st;
		switch (status) {
		case RUNNING:
			jobBar.setBackground(Color.YELLOW);
			jobBar.setString("Running");
		case WAITING:
			jobBar.setBackground(Color.ORANGE);
			jobBar.setString("Waiting");
		case COMPLETE:
			jobBar.setBackground(Color.GREEN);
			jobBar.setString("Complete");
		case MISSING_SKILLS:
			jobBar.setBackground(Color.RED);
			jobBar.setString("Missing Skills");
		} // end switch
	} // end method showStatus

	@Override
	public void run() {
		try {
			System.out.printf("Job %s Started\n", name);

			long time = System.currentTimeMillis();
			long startTime = time;
			long stopTime = (long) (time + 1000 * duration);

			if (hmThings.get(parent) instanceof Ship) { // is parent a ship?
				System.out.println("parent is a ship");
				Ship ship = (Ship) hmThings.get(parent);
				if (hmThings.get(ship.parent) instanceof Dock) { // docked?
					System.out.println("ship is docked");
					Dock dock = (Dock) hmThings.get(ship.parent);
					SeaPort port = (SeaPort) hmThings.get(dock.parent);
					// System.out.println(checkSkills(port));
					// if the port does not have the skills
					if (!checkSkills(port)) {
						status = Status.MISSING_SKILLS;
						showStatus(status);
					} // end if block
				} else if (hmThings.get(ship.parent) instanceof SeaPort) { // que?
					SeaPort port = (SeaPort) hmThings.get(ship.parent);
					System.out.println("ship is queued");
				} // end if-else-if block
			} else if (hmThings.get(parent) instanceof Dock) { // or a dock?
				System.out.println("parent is a dock");
				Dock dock = (Dock) hmThings.get(parent);
				SeaPort port = (SeaPort) hmThings.get(dock.parent);
			} // end if-else-if block
		} catch (InterruptedException e) {
		} // end try-catch block
	} // end method run

	public boolean checkSkills(SeaPort port) {
		return (port.skills.contains(requirements));
	}

}// end class Job
