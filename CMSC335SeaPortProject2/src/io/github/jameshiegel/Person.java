package io.github.jameshiegel;

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
		return st;
	} // end method toString
}
