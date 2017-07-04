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
		Person pr = new Person(sc);
		assignPerson(pr);
	} // end method addPerson

	private void addCargoShip(Scanner sc) {
		CargoShip cs = new CargoShip(sc);
		assignShip(cs);
	} // end method addPerson

	private void addPassengerShip(Scanner sc) {
		PassengerShip ps = new PassengerShip(sc);
		assignShip(ps);
	} // end method addPerson

	private void addDock(Scanner sc) {
		Dock dk = new Dock(sc);
		assignDock(dk);
	} // end method addPerson

	private void addPort(Scanner sc) {
		SeaPort sp = new SeaPort(sc);
		ports.add(sp);
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

	void assignDock(Dock ms) {
		SeaPort md = getSeaPortByIndex(ms.parent);
		if (md == null)
			return;
		getSeaPortByIndex(md.parent).docks.add(ms);
	} // end method assignDock

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

	void assignPerson(Person ms) {
		SeaPort md = getSeaPortByIndex(ms.parent);
		if (md == null)
			return;
		getSeaPortByIndex(md.parent).persons.add(ms);
	} // end method assignDock

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