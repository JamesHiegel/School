package io.github.jameshiegel;

import java.util.Stack;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This class is where all the work occurs.
 */
public class ThreeAddressGeneratorModel {
	private Node root = null;
	private int operands = 0;

	public String constructTree(String postFixExp) {
		// remove all spaces from the String
		postFixExp = postFixExp.replaceAll("\\s", "");

		// convert String to character array
		char[] postfix = postFixExp.toCharArray();
		System.out.println("Postfix expression is: " + postFixExp);

		// create the tree
		Stack<Node> stack = new Stack<Node>();

		for (int i = 0; i < postfix.length; i++) {// iterate over array
			switch (postfix[i]) {
			// operands
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				// make a new operand node
				OperandNode operand = new OperandNode(postfix[i]);
				// put it on the stack
				stack.push(operand);
				System.out.println("Pushed: " + postfix[i]);
				operands++;
				break;
			// operators
			case '+':
			case '-':
			case '/':
			case '*':
				// make a new operator node
				OperatorNode operator = new OperatorNode(postfix[i]);
				// pop the operand nodes off the stack and add them to the
				// operator node
				operator.right = stack.pop();
				operator.left = stack.pop();
				// push the operator node onto the stack
				stack.push(operator);
				System.out.print("Popped: " + operator.right.toString());
				System.out.print(" Popped: " + operator.left.toString());
				System.out.println(" Pushed: " + operator.toString());
				break;
			default:
				String x = Character.toString(postfix[i]);
				throw new RuntimeException(x);
			}

		}
		root = stack.pop();// sets the root as the top of the tree
		return root.toString();
	}
	
	
}