package io.github.jameshiegel;

public class Node<E> {
	//Instance variables
	private E data;
	private Node<E> left;
	private Node<E> right;

	//Constructors
	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}