package io.github.jameshiegel;

import java.util.ArrayList;

//File: World.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: A World object contains a number of Sea Ports, where 
 * Ships are docked at Docks and Persons complete Jobs.  
 * Data files are parsed in this class.
 */

public class World extends Thing {
	// instance variables
	protected ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	protected PortTime time = new PortTime();

	// constructors
	public World() {
		super();
	} // end constructor

	// methods
	public ArrayList<SeaPort> getPorts() {
		return ports;
	} // end method getPorts

	public PortTime getTime() {
		return time;
	} // end method getTime

	@Override
	public String toString() {
		return super.toString();
	} // end method toString

} // end class World
