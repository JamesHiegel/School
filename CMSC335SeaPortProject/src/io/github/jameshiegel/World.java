package io.github.jameshiegel;

import java.util.ArrayList;

public class World extends Thing {
	// instance variables
	private ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	private PortTime time = new PortTime();

	// constructors
	public World(int index, String name, int parent, ArrayList<SeaPort> ports, PortTime time) {
		super(index, name, parent);
		this.ports = ports;
		this.time = time;
	}

	// methods
	public ArrayList<SeaPort> getPorts() {
		return ports;
	}

	public void setPorts(ArrayList<SeaPort> ports) {
		this.ports = ports;
	}

	public PortTime getTime() {
		return time;
	}

	public void setTime(PortTime time) {
		this.time = time;
	}

}
