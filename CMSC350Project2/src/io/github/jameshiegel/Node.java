package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 2

/**
 * This abstract class provides a basis for the OperandNode and OperatorNode
 * classes. Node objects contain a value, a left Node and a right Node.
 */
public abstract class Node {
	protected char value;
	protected Node left;
	protected Node right;

	/**
	 * This method creates a node with a value and two child nodes.
	 * 
	 * @param value
	 *            sets the value of the node
	 */
	Node(char value) {
		this.value = value;
	}

	/**
	 * This method returns the value of the node.
	 */
	public String preOrderWalk() {
		return String.valueOf(value);
	}

	/**
	 * This method returns the value of the node.
	 */
	public String inOrderWalk() {
		return String.valueOf(value);
	}

	/**
	 * This method returns the value of the node.
	 */
	public String postOrderWalk() {
		return String.valueOf(value);
	}
}