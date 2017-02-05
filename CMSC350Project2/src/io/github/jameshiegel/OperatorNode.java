package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 2

/**
 * This class creates Node objects with integers as their value.
 */
public class OperatorNode extends Node {
	/**
	 * This constructor creates an operator node.
	 * 
	 * @param value
	 *            sets the char value of the node
	 */
	OperatorNode(char value) {
		super(value);
	}
	
	@Override
	public String toString() {
		return "(" + this.left + " " + value + " " + this.right + ")"; 
	}
}
