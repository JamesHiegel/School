package io.github.jameshiegel;

public class Person extends Thing {
	// instance variables
	private String skill = "";

	// constructors
	public Person(int index, String name, int parent, String skill) {
		super(index, name, parent);
		this.skill = skill;
	}

	// methods
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
