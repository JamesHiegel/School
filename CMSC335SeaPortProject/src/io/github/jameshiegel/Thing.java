package io.github.jameshiegel;

public class Thing implements Comparable<Thing> {
	// instance variables
	private int index = 0;
	private String name = "";
	private int parent = 0;

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

}
