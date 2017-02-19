package io.github.jameshiegel;

public class BSTModel<E extends Comparable<E>> {
	private Node root;

	class Node {
		E data;
		Node left;
		Node right;

		public Node(E data) {
			this.data = data;
		}
	}

	/**
	 * This method returns true or false if the Node is empty.
	 * 
	 * @return a boolean value
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * This method inserts a new value into the tree.
	 * 
	 * @param the
	 *            value to be inputed
	 */
	public void insert(E value) {
		if (isEmpty())
			root = new Node(value);
		else
			insert(root, value);
	}

	/**
	 * This method inserts a new value to the left or right of a node in the tree.
	 * 
	 * @param the
	 *            node to be
	 * @param the
	 *            value to be inputed
	 */
	private void insert(Node node, E value) {

		if (value.compareTo(node.data) < 0) {
			if (node.left == null)
				node.left = new Node(value);
			else
				insert(node.left, value);
		} else {
			if (node.right == null)
				node.right = new Node(value);
			else
				insert(node.right, value);
		}
	}
}