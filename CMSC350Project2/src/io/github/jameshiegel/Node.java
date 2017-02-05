package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 2

/**
 * This abstract class provides a basis for the OperandNode and OperatorNode
 * classes. Node objects contain a value, a left Node and a right Node.
 */
public abstract class Node {
	char value;
	Node left;
	Node right;

	/**
	 * This method creates a node with a value and two child nodes.
	 * 
	 * @param value
	 *            sets the value of the node
	 */
	Node(char value) {
		this.value = value;
	}

	public String toString() {
		return Character.toString(value);
	}
}
