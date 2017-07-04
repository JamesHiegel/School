package io.github.jameshiegel;

import java.util.Scanner;

class Thing implements Comparable<Thing> {
	// instance variables
	protected int index = 0;
	protected String name = "";
	protected int parent = 0;

	// constructors
	public Thing() {
	} // end default constructor

	public Thing(Scanner sc) {
		if (sc.hasNext())
			name = sc.next();
		if (sc.hasNextInt())
			index = sc.nextInt();
		if (sc.hasNextInt())
			parent = sc.nextInt();
	} // end Scanner constructor

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
		String st = String.format("%20s %10d", name, index);
		return st;
	} // end method toString

	@Override
	public int compareTo(Thing o) {
		// TODO Auto-generated method stub
		return 0;
	} // end method compareTo

} // end class Thing