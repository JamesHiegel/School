package io.github.jameshiegel;

public class PortTime {
	// instance variables
	protected int time = 0;

	// constructors
	public PortTime() {
		super();
	}

	// methods
	public int getTime() {
		return time;
	} // end method getTime
	
	public void setTime(int time) {
		this.time = time;
	} // end method setTime

	@Override
	public String toString() {
		return Integer.toString(time);
	} // end method toString
}
