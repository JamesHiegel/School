package io.github.jameshiegel;

import java.util.ArrayList;

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

