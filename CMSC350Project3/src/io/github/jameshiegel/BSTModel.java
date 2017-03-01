package io.github.jameshiegel;

public class BSTModel<E extends Comparable<E>> {
	private Node root;
	private String output = "";

	public void parseIntegerString(String input) {
		root = null;
		output = "";
		String[] split = input.split("\\s+");
		// int[] numbers = new int[input.length()];
		// int i = 0;
		for (String string : split) {
			insert(string);
			// numbers[i++] = Integer.parseInt(string);
			// System.out.println(string);
		}
		// for (int c = 0 ; c < numbers.length; c++) {
		// System.out.println(numbers[c]);
		// }

	}

	public void parseFractionString(String input) {

	}

	/**
	 * This method returns true or false if the Node is empty.
	 * 
	 */
	class Node {
		String data;
		Node left;
		Node right;

		public Node(String data) {
			this(data, null, null);
		}
		
		public Node(String data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
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
	 * @param string
	 *            item to be inputed
	 */
	public void insert(String string) {
		if (isEmpty())
			root = new Node(string);
		else
			insert(root, string);
	}

	/**
	 * This method inserts a new value to the left or right of a node in the
	 * tree.
	 * 
	 * @param node
	 *            current Node
	 * @param value
	 *            data to be inputed
	 */
	private void insert(Node node, String value) {

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
	
	public String ascendOrder() {
		return ascendOrder(root);
	}
	
	public String ascendOrder(Node node) {
		if (node != null) {
			ascendOrder(node.left);
			output += node.data + " ";
			System.out.println(node.data);
			ascendOrder(node.right);
		}
		return output;
	}
	
	public String descendOrder() {
		return descendOrder(root);
	}
	
	public String descendOrder(Node node) {
		if (node != null) {
			descendOrder(node.right);
			output += node.data + " ";
			//System.out.println(node.data);
			descendOrder(node.left);
		}
		return output;
	}

}