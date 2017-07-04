package io.github.jameshiegel;

//File: Person.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates a person that can complete Jobs with their skill(s).

public class Person extends Thing {
	// instance variables
	protected String skill = "";
	
	// constructors
	public Person() {
		super();
	}
	
	// methods
	public String getSkill() {
		return skill;
	} // end method getSkill
	
	@Override
	public String toString() {
		String st = "Person: " + super.toString();
		st += skill;
		return st;
	} // end method toString

} // end class Person
