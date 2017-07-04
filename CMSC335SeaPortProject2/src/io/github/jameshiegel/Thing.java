package io.github.jameshiegel;

//File: Thing.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: The superclass for all objects used in the SeaPortProgram.

public class Thing implements Comparable<Thing> {
	// instance variables
	protected int index = 0;
	protected String name = "";
	protected int parent = 0;

	// constructors
	public Thing() {
	} // end constructor

	// methods
	public int getIndex() {
		return index;
	} // end method getIndex

	public String getName() {
		return name;
	} // end method getName

	public int getParent() {
		return parent;
	} // end method getParent

	@Override
	public String toString() {
		return name + " " + index;
	} // end method toString

	@Override
	public int compareTo(Thing o) {
		// TODO Auto-generated method stub
		return 0;
	} // end method compareTo

} // end class Thing
