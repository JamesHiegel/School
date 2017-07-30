package io.github.jameshiegel;

//File: HelloWorld.java
//Date: 06 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335, Summer 2017
//Purpose: Demonstrates a the usage of the Runnable interface

public class HelloWorld implements Runnable {

	public static void main(String[] args) {

		// creates a Runnable object
		HelloWorld hw = new HelloWorld();
		// creates a Thread object by passing the Runnable object to the constructor
		Thread t = new Thread(hw);
		// Starts the new thread
		t.start();

		// an alternate shorthand version of the above
		(new Thread(new HelloWorld())).start();
	} // end method main

	@Override
	//This method holds the code that will be executed by a Thread object.
	public void run() {
		System.out.println("Hello World!");
	} // end method run
}
