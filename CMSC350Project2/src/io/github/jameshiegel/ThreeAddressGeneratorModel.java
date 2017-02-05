package io.github.jameshiegel;

import java.util.Stack;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This class is where all the work occurs.
 */
public class ThreeAddressGeneratorModel {
	private Node root = null;
	private Stack<Character> stack2 = new Stack<Character>();
	private int registerCount = 0;
	private String fileName = "ThreeAddressInstructions.txt";

	public String constructTree(String postFixExp) {
		// remove all spaces from the String
		postFixExp = postFixExp.replaceAll("\\s", "");

		// convert String to character array
		char[] postfix = postFixExp.toCharArray();
		//System.out.println("Postfix expression is: " + postFixExp);

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
				//System.out.println("Pushed: " + postfix[i]);
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
				writeToFile(operator.postOrderWalk());
				//System.out.print("Popped: " + operator.right.inOrderWalk());
				//System.out.print(" Popped: " + operator.left.inOrderWalk());
				//System.out.println(" Pushed: " + operator.inOrderWalk());
				break;
			default:
				String x = Character.toString(postfix[i]);
				throw new RuntimeException(x);
			}

		}
		root = stack.pop();// sets the root as the top of the tree
		return root.inOrderWalk();
	}

	public void writeToFile(String input) {
		// System.out.println(System.getProperty("user.dir"));//displays current
		// working directory

		char[] inputArr;
		input = input.replaceAll("\\s", "");// remove spaces
		inputArr = input.toCharArray();
		String output = "";

		for (int i = 0; i < inputArr.length; i++) {
			switch (inputArr[i]) {
			// if the next char is an operand then push it onto the stack
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
				stack2.push(inputArr[i]);
				break;
			// if the next char is an operator then add the instruction verb and
			// call for the rest
			case '+':
				output += "\nAdd" + instructions();
				break;
			case '-':
				output += "\nSub" + instructions();
				break;
			case '/':
				output += "\nDiv" + instructions();
				break;
			case '*':
				output += "\nMul" + instructions();
				break;
			}
		}

		try {
			// opens the file
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// writes the data to the file
			bufferedWriter.write(output);

			// closes the file
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}

	private String instructions() {
		// System.out.println("size: " + stack2.size());
		String output = "";
		// uses a new register if needed
		if (stack2.size() < 2) {
			output += " R" + registerCount + " R" + (registerCount - 1) + " " + stack2.pop();
		} else {
			output += " R" + registerCount + " " + stack2.pop() + " " + stack2.pop();
		}
		registerCount++;
		return output;
	}
}