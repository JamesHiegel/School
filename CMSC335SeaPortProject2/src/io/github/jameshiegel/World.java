package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

class World extends Thing {
	// instance variables
	protected ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	protected PortTime time = new PortTime();

	// methods
	public void process(String st) {
		// System.out.println("Processing >" + st + "<");
		SeaPortProgramView.appendLog("Processing >" + st + "<");
		Scanner sc = new Scanner(st);
		if (!sc.hasNext()) {
			sc.close();
			return;
		}
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
		md.docks.add(ms);
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
		md.persons.add(ms);
	} // end method assignDock

	public String search(String term, String type) {
		String results = "";
		int i = 0;
		double d = 0.0;
		PassengerShip ps = null;
		CargoShip cs = null;
		Person p = null;
		// results = term + " " + type;
		switch (type) {
		case "Name":
			for (SeaPort sp : ports) {
				if (sp.name.equals(term))
					results += sp.toString();
				for (Dock dk : sp.docks) {
					if (dk.name.equals(term))
						results += dk.toString();
					if (dk.ship.name.equals(term))
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh.name.equals(term))
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
				for (Person pr : sp.persons) {
					if (pr.name.equals(term))
						results += pr.toString();
				} // end Person for
			} // end SeaPort for
			break;
		case "Index":
			i = Integer.parseInt(term);
			for (SeaPort sp : ports) {
				if (sp.index == i)
					results += sp.toString();
				for (Dock dk : sp.docks) {
					if (dk.index == i)
						results += dk.toString();
					if (dk.ship.index == i)
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh.index == i)
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
				for (Person pr : sp.persons) {
					if (pr.index == i)
						results += pr.toString();
				} // end Person for
			} // end SeaPort for
			break;
		case "Draft":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if ((Double.compare(dk.ship.draft, d)) == 0)
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if ((Double.compare(sh.draft, d)) == 0)
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
			} // end SeaPort for
			break;
		case "Length":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if ((Double.compare(dk.ship.length, d)) == 0)
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if ((Double.compare(sh.length, d)) == 0)
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
			} // end SeaPort for
			break;
		case "Weight":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if ((Double.compare(dk.ship.weight, d)) == 0)
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if ((Double.compare(sh.weight, d)) == 0)
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
			} // end SeaPort for
			break;
		case "Width":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if ((Double.compare(dk.ship.width, d)) == 0)
						results += dk.toString();
				} // end Dock for
				for (Ship sh : sp.que) {
					if ((Double.compare(sh.width, d)) == 0)
						results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:\n"
								+ sh.toString();
				} // end Ship for
			} // end SeaPort for
			break;
		case "Number of Passengers":
			i = Integer.parseInt(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof PassengerShip) {
						ps = (PassengerShip) dk.ship;
						if (ps.numberOfPassengers == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						ps = (PassengerShip) sh;
						if (ps.numberOfPassengers == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Number of Occupied Rooms":
		case "Number of Rooms":
		case "Cargo Value":
		case "Cargo Volume":
		case "Cargo Weight":
		case "Skill":
		} // end switch
		return results;
	} // end method search

	public ArrayList<SeaPort> getPorts() {
		return ports;
	} // end method getPorts

	public PortTime getTime() {
		return time;
	} // end method getTime

	@Override
	public String toString() {
		String st = ">>>>> The World:";
		for (SeaPort sp : ports)
			st += sp;
		return st;
	} // end method toString

} // end class World