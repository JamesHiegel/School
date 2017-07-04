package io.github.jameshiegel;

//File: PortTime.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: A time keeping object used to determine the 
 * next Ship to dock, and calculate Job progress.
*/

public class PortTime {
	// instance variables
	protected int time = 0;

	// constructors
	public PortTime() {
		super();
	}

	// methods
	public int getTime() {
		return time;
	} // end method getTime
	
	public void setTime(int time) {
		this.time = time;
	} // end method setTime

	@Override
	public String toString() {
		return Integer.toString(time);
	} // end method toString
	
} // end class PortTime
