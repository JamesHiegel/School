package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

class World extends Thing {
	// instance variables
	protected ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	protected PortTime time = new PortTime();
	JTextField searchTerm;
	JComboBox<String> searchType;
	JTree treeView;
	JTextArea textView;
	JTable jobStatus;
	JTextArea log;

	// constructors
	public World() {
		super();
	} // end default constructor

	// methods
	public void process(String st) {
		System.out.println("Processing >" + st + "<");
		Scanner sc = new Scanner(st);
		if (!sc.hasNext())
			return;
		switch (sc.next()) {
		case "port":
			addPort(sc);
			break;
		case "dock":
			addDock(sc);
			break;
		case "pship":
			addPassengerShip(sc);
			break;
		case "cship":
			addCargoShip(sc);
			break;
		case "person":
			addPerson(sc);
			break;
		} // end switch
	} // end method process

	private void addPerson(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addCargoShip(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addPassengerShip(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addDock(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addPort(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	SeaPort getSeaPortByIndex(int x) {
		for (SeaPort msp : ports)
			if (msp.index == x)
				return msp;
		return null;
	} // end method getSeaPortByIndex

	Dock getDockByIndex(int x) {
		for (SeaPort msp : ports)
			for (Dock dk : msp.docks)
				if (dk.index == x)
					return dk;
		return null;
	} // end method getDockByIndex

	Ship getShipByIndex(int x) {
		for (SeaPort msp : ports)
			for (Ship ms : msp.ships)
				if (ms.index == x)
					return ms;
		return null;
	} // end method getShipByIndex

	Person getPersonByIndex(int x) {
		for (SeaPort msp : ports)
			for (Person ps : msp.persons)
				if (ps.index == x)
					return ps;
		return null;
	} // end method getPersonByIndex

	void assignShip(Ship ms) {
		Dock md = getDockByIndex(ms.parent);
		if (md == null) {
			getSeaPortByIndex(ms.parent).ships.add(ms);
			getSeaPortByIndex(ms.parent).que.add(ms);
			return;
		}
		md.ship = ms;
		getSeaPortByIndex(md.parent).ships.add(ms);
	} // end method assignShip

	public ArrayList<SeaPort> getPorts() {
		return ports;
	} // end method getPorts

	public PortTime getTime() {
		return time;
	} // end method getTime

	@Override
	public String toString() {
		return ">>>>> the World:";
	} // end method toString

} // end class World