package io.github.jameshiegel;

/*File Name: Thing.Java
 *Date: 27 June 2017
 *Author: James Hiegel
 */
/**
 * The Thing class 
 */

public class Thing implements Comparable<Thing> {
	// instance variables
	protected String name = "";
	protected int index = 0;
	protected int parent = 0;

	// constructors
	public Thing(int index, String name, int parent) {
		this.index = index;
		this.name = name;
		this.parent = parent;
	}

	public Thing() {
	}

	// methods
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public int compareTo(Thing arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Thing [index=" + index + ", name=" + name + ", parent=" + parent + "]";
	}

}
