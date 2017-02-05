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

	/**
	 * This method returns the value in the below format:
	 * value leftvalue rightvalue
	 * EX: + 2 1
	 */
	public String preOrderWalk() {
		String leftValue = left.preOrderWalk();
		String rightValue = right.preOrderWalk();
		return "" + this.value + " " + leftValue + " " + rightValue;
	}

	/**
	 * This method returns the value in the below format:
	 * (leftvalue value rightvalue)
	 * EX: (2 + 1)
	 */
	public String inOrderWalk() {
		String leftValue = left.inOrderWalk();
		String rightValue = right.inOrderWalk();
		return "(" + leftValue + " " + this.value + " " + rightValue + ")";
	}

	/**
	 * This method returns the value in the below format:
	 * leftvalue rightvalue value
	 * EX: 2 1 +
	 */
	public String postOrderWalk() {
		String leftValue = left.postOrderWalk();
		String rightValue = right.postOrderWalk();
		return leftValue + " " + rightValue + " " + this.value;
	}
}
