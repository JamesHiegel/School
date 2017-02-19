package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 3

/**
 * This class creates Node objects with fractions as their value.
 */
public class FractionNode extends Node {
	/**
	 * This constructor creates an integer node.
	 * 
	 * @param value
	 *            sets the integer value of the node
	 */
	FractionNode(String value) {
		super(value);
	}
	
	public double getDoubleValue() {
		double output = 0.0;
		String numerator = value.substring(0, value.indexOf("/"));
		//System.out.println(numerator);
		String denominator = value.substring(value.indexOf("/") + 1, value.length());
		//System.out.println(denominator);
		output = Double.parseDouble(numerator) / Double.parseDouble(denominator);
		//System.out.println(output);
		return output;
	}

}