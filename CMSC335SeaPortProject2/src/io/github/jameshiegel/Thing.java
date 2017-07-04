package io.github.jameshiegel;

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
