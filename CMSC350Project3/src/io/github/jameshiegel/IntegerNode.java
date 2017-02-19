package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 3

/**
 * This class creates Node objects with integers as their value.
 */
public class IntegerNode extends Node {
	/**
	 * This constructor creates an integer node.
	 * 
	 * @param value
	 *            sets the integer value of the node
	 */
	IntegerNode(String value) {
		super(value);
	}
	IntegerNode(Integer value) {
		super(value.toString());
	}

	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
}