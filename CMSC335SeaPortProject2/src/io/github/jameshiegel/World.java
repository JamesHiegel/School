package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

class World extends Thing {
	// instance variables
	private ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	private PortTime time = new PortTime();
	
	@SuppressWarnings("unused")
	private JPanel jobStatusPane = new JPanel();
	
	// HashMap to hold all objects in the World
	private HashMap<Integer, Thing> hmThings = new HashMap<Integer, Thing>();
	
	// used for the JTree
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
	@SuppressWarnings("unused")
	private JTree tree; 
	
	// constructor
	public World(JPanel jobStatusPane) {
		this.jobStatusPane = jobStatusPane;
	}

	// methods
	/**
	 * This method utilizes Scanner to parse a provided String into the
	 * appropriate Thing subclass.
	 * 
	 * @param st
	 *            the String to be parsed.
	 */
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
		case "job":
			addJob(sc);
			break;
		} // end switch
	} // end method process

	/**
	 * Creates a Job object and adds it to it's parent and the hmThings HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a Person.
	 */
	private void addJob(Scanner sc) {
		Job jb = new Job(sc);
		hmThings.put(jb.getIndex(), jb);
		assignJob(jb);
		// add to tree
		DefaultMutableTreeNode node = null;
		if (getShipByIndex(jb.getParent()) != null) {
			node = getParentNode(getShipByIndex(jb.getParent()).getName());
		} else if (getDockByIndex(jb.getParent()) != null) {
			node = getParentNode(getDockByIndex(jb.getParent()).getName());
		}
		node.add(new DefaultMutableTreeNode(jb.getName()));
	} // end method addPerson

	/**
	 * Creates a Person object and adds it to it's parent and the hmThings
	 * HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a Person.
	 */
	private void addPerson(Scanner sc) {
		Person pr = new Person(sc);
		hmThings.put(pr.getIndex(), pr);
		assignPerson(pr);
		// add to tree
		DefaultMutableTreeNode node = null;
		Thing th = getSeaPortByIndex(pr.getParent());
		if (th != null) {
			node = getParentNode(getSeaPortByIndex(pr.getParent()).getName());
		} else {
			node = getParentNode(getDockByIndex(pr.getParent()).getName());
		}
		node.add(new DefaultMutableTreeNode(pr.getName()));
	} // end method addPerson

	/**
	 * Creates a CargoShip object and adds it to it's parent and the hmThings
	 * HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a CargoShip.
	 */
	private void addCargoShip(Scanner sc) {
		CargoShip cs = new CargoShip(sc);
		hmThings.put(cs.getIndex(), cs);
		assignShip(cs);
		// add to tree
		DefaultMutableTreeNode node = null;
		Thing th = getSeaPortByIndex(cs.getParent());
		if (th != null) {
			node = getParentNode(getSeaPortByIndex(cs.getParent()).getName());
		} else {
			node = getParentNode(getDockByIndex(cs.getParent()).getName());
		}
		node.add(new DefaultMutableTreeNode(cs.getName()));
	} // end method addPerson

	/**
	 * Creates a PassengerShip object and adds it to it's parent and the
	 * hmThings HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a PassengerShip.
	 */
	private void addPassengerShip(Scanner sc) {
		PassengerShip ps = new PassengerShip(sc); // create PassengerShip
		hmThings.put(ps.getIndex(), ps); // add to hmThings HashMap
		assignShip(ps); // add to parent
		// add to tree
		DefaultMutableTreeNode node = null;
		Thing th = getSeaPortByIndex(ps.getParent());
		if (th != null) {
			node = getParentNode(getSeaPortByIndex(ps.getParent()).getName());
		} else {
			node = getParentNode(getDockByIndex(ps.getParent()).getName());
		}
		node.add(new DefaultMutableTreeNode(ps.getName()));
		// System.out.println("Added " + ps.getName() + " to " + node);
	} // end method addPerson

	/**
	 * Creates a Dock object and adds it to it's parent and the hmThings
	 * HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a Dock.
	 */
	private void addDock(Scanner sc) {
		Dock dk = new Dock(sc); // create dock
		hmThings.put(dk.getIndex(), dk); // add to hmThings HashMap
		assignDock(dk); // add to parent SeaPort
		// add dock to tree
		DefaultMutableTreeNode node = getParentNode(getSeaPortByIndex(dk.getParent()).getName());
		node.add(new DefaultMutableTreeNode(dk.getName()));
		// System.out.println("Added " + dk.getName() + " to " + node);
	} // end method addPerson

	/**
	 * Creates a SeaPort object and adds it to the ports ArrayList and hmThings
	 * HashMap.
	 * 
	 * @param sc
	 *            the String to be parsed into a SeaPort.
	 */
	private void addPort(Scanner sc) {
		SeaPort sp = new SeaPort(sc); // create port
		hmThings.put(sp.getIndex(), sp); // add to hmThings HashMap
		ports.add(sp); // add to ports ArrayList
		// add port to tree
		root.add(new DefaultMutableTreeNode(sp.getName()));
		// System.out.println("Added " + sp.getName() + " to " + root);
	} // end method addPerson

	/**
	 * Returns a SeaPort object at index x of the hmThings HashMap. Returns a
	 * null value if the requested index is not found.
	 * 
	 * @param x
	 *            the index to find.
	 * @return the SeaPort with the specified index value
	 */
	SeaPort getSeaPortByIndex(int x) {
		// for (SeaPort msp : ports)
		// if (msp.index == x)
		// return msp;
		Thing th = hmThings.get(x); // get Thing at index x
		if (th instanceof SeaPort) // check if it is a SeaPort
			return (SeaPort) th; // if true, cast to SeaPort and return
		return null; // if false, return null
	} // end method getSeaPortByIndex

	/**
	 * Returns a Dock object at index x of the hmThings HashMap. Returns a null
	 * value if the requested index is not found.
	 * 
	 * @param x
	 *            the index to find.
	 * @return the Dock with the specified index value
	 */
	Dock getDockByIndex(int x) {
		// for (SeaPort msp : ports)
		// for (Dock dk : msp.docks)
		// if (dk.index == x)
		// return dk;
		Thing th = hmThings.get(x); // get Thing at index x
		if (th instanceof Dock) // check if it is a Dock
			return (Dock) th; // if true, cast to Dock and return
		return null;
	} // end method getDockByIndex

	/**
	 * Returns a Ship object at index x of the hmThings HashMap. Returns a null
	 * value if the requested index is not found.
	 * 
	 * @param x
	 *            the index to find.
	 * @return the Ship with the specified index value
	 */
	Ship getShipByIndex(int x) {
		// for (SeaPort msp : ports)
		// for (Ship ms : msp.ships)
		// if (ms.index == x)
		// return ms;
		Thing th = hmThings.get(x); // get Thing at index x
		if (th instanceof Ship) // check if it is a Ship
			return (Ship) th; // if true, cast to Ship and return
		return null;
	} // end method getShipByIndex

	/**
	 * Returns a Person object at index x of the hmThings HashMap. Returns a
	 * null value if the requested index is not found.
	 * 
	 * @param x
	 *            the index to find.
	 * @return the Person with the specified index value
	 */
	Person getPersonByIndex(int x) {
		// for (SeaPort msp : ports)
		// for (Person ps : msp.persons)
		// if (ps.index == x)
		// return ps;
		Thing th = hmThings.get(x); // get Thing at index x
		if (th instanceof Person) // check if it is a Person
			return (Person) th; // if true, cast to Person and return
		return null;
	} // end method getPersonByIndex

	/**
	 * Assigns a provided Job object to its parent Ship.
	 * 
	 * @param jb
	 *            the Job to be assigned.
	 */
	void assignJob(Job jb) {
		Ship md = getShipByIndex(jb.parent);
		if (md == null)
			return;
		md.jobs.add(jb);
	} // end method assignDock

	/**
	 * Assigns a provided Dock object to its parent SeaPort.
	 * 
	 * @param ms
	 *            the Dock to be assigned.
	 */
	void assignDock(Dock ms) {
		SeaPort md = getSeaPortByIndex(ms.parent);
		if (md == null)
			return;
		md.docks.add(ms);
	} // end method assignDock

	/**
	 * Assigns a provided Ship object to its parent SeaPort ships roster and
	 * either a que roster or a dock.
	 * 
	 * @param ms
	 *            the Ship to be assigned.
	 */
	void assignShip(Ship ms) {
		Dock md = getDockByIndex(ms.parent); // gets parent index
		if (md == null) { // adds ship to SeaPort que if not assigned a Dock
			getSeaPortByIndex(ms.parent).que.add(ms);
			getSeaPortByIndex(ms.parent).ships.add(ms);
		} else { // otherwise adds it to the assigned Dock
			md.ship = ms;
			getSeaPortByIndex(md.parent).ships.add(ms);
		}
	} // end method assignShip

	/**
	 * Assigns a provided Person object to its parent SeaPort persons roster.
	 * 
	 * @param ms
	 *            the Person to be assigned.
	 */
	void assignPerson(Person ms) {
		SeaPort md = getSeaPortByIndex(ms.parent); // gets parent index
		if (md == null) // if no parent discard
			return;
		md.persons.add(ms); // add Person to parent SeaPort's persons roster
		md.addSkills(ms.skill); // add the Person's skills to the SeaPort's skill roster
	} // end method assignDock

	/**
	 * Returns a String displaying where the searched term for was found.
	 * 
	 * @param term
	 *            the String to be searched for.
	 * @param type
	 *            the type of data to be searched.
	 * @return a String listing where the searched for term was found
	 */
	public String search(String term, String type) {
		String results = "";
		int i = 0;
		double d = 0.0;
		PassengerShip ps = null;
		CargoShip cs = null;
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
			Thing th = hmThings.get(i); // gets Thing from HashMap
			if (th instanceof SeaPort) {
				// casts to SeaPort and then calls toString method
				SeaPort sp = (SeaPort) th;
				results += sp.toString();
			} else if (th instanceof Dock) {
				// casts to Dock and then appends toString method to custom
				// string
				Dock dk = (Dock) th;
				SeaPort sp = getSeaPortByIndex(dk.parent);
				results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n" + dk.toString();
			} else if (th instanceof Ship) {
				// casts to Ship and then appends toString method to custom
				// string
				Ship sh = (Ship) th;
				if (getDockByIndex(sh.parent) == null) { // if parent not a dock
					SeaPort sp = getSeaPortByIndex(sh.parent);
					results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all ships in que:"
							+ "\n   > " + sh.toString();
				} else { // if parent is a dock
					Dock dk = getDockByIndex(sh.parent);
					SeaPort sp = getSeaPortByIndex(dk.parent);
					results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n" + dk.toString();
				} // end else
			} else if (th instanceof Person) {
				// casts to Person and then appends toString method to custom
				// string
				Person pr = (Person) th;
				SeaPort sp = getSeaPortByIndex(pr.parent);
				results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n --- List of all persons:" + "\n   > "
						+ pr.toString();
			} else {
				results = "Index not found.";
			} // end else if series

			// for (SeaPort sp : ports) {
			// if (sp.index == i)
			// results += sp.toString();
			// for (Dock dk : sp.docks) {
			// if (dk.index == i)
			// results += dk.toString();
			// if (dk.ship.index == i)
			// results += dk.toString();
			// } // end Dock for
			// for (Ship sh : sp.que) {
			// if (sh.index == i)
			// results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n\n
			// ---
			// List of all ships in que:\n"
			// + sh.toString();
			// } // end Ship for
			// for (Person pr : sp.persons) {
			// if (pr.index == i)
			// results += pr.toString();
			// } // end Person for
			// } // end SeaPort for
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
			i = Integer.parseInt(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof PassengerShip) {
						ps = (PassengerShip) dk.ship;
						if (ps.numberOfOccupiedRooms == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						ps = (PassengerShip) sh;
						if (ps.numberOfOccupiedRooms == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Number of Rooms":
			i = Integer.parseInt(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof PassengerShip) {
						ps = (PassengerShip) dk.ship;
						if (ps.numberOfRooms == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						ps = (PassengerShip) sh;
						if (ps.numberOfRooms == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Cargo Value":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof CargoShip) {
						cs = (CargoShip) dk.ship;
						if (cs.cargoValue == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						cs = (CargoShip) sh;
						if (cs.cargoValue == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Cargo Volume":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof CargoShip) {
						cs = (CargoShip) dk.ship;
						if (cs.cargoVolume == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						cs = (CargoShip) sh;
						if (cs.cargoVolume == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Cargo Weight":
			d = Double.parseDouble(term);
			for (SeaPort sp : ports) {
				for (Dock dk : sp.docks) {
					if (dk.ship instanceof CargoShip) {
						cs = (CargoShip) dk.ship;
						if (cs.cargoWeight == i)
							results += dk.toString();
					} // end instanceof if
				} // end Dock for
				for (Ship sh : sp.que) {
					if (sh instanceof PassengerShip) {
						cs = (CargoShip) sh;
						if (cs.cargoWeight == i)
							results += "\n\nSeaPort: " + sp.name + " " + sp.index
									+ "\n\n --- List of all ships in que:\n" + sh.toString();
					} // end instanceof if
				} // end Ship for
			} // end SeaPort for
			break;
		case "Skill":
			for (SeaPort sp : ports) {
				String st = null;
				for (Person pr : sp.persons) {
					if (pr.skill.contains(term))
						st += pr.toString();
				} // end for
				if (st != null) {
					results += "\n\nSeaPort: " + sp.name + " " + sp.index + "\n >" + st;
				}
			} // end for
			break;
		} // end switch
		return results;
	} // end method search

	// public ArrayList<SeaPort> getPorts() {
	// return ports;
	// } // end method getPorts

	/**
	 * Returns the current PortTime.
	 * 
	 * @return a PortTime object
	 */
	public PortTime getTime() {
		return time;
	} // end method getTime

	/**
	 * Returns a String listing the World and ports, with their contents.
	 * 
	 * @return a String object
	 */
	@Override
	public String toString() {
		String st = ">>>>> The World:";
		for (SeaPort sp : ports)
			st += sp;
		return st;
	} // end method toString

	/**
	 * Returns a String listing objects in sorted order.
	 * 
	 * @param sortType
	 *            the type of objects to be sorted
	 * @return a String object
	 */
	public String sort(String sortType) {
		String st = "";
		Thing th = null;
		ArrayList<Integer> indexes = new ArrayList<Integer>(hmThings.keySet());
		Map<String, Thing> tMap = new TreeMap<String, Thing>();
		Map<Double, Thing> dMap = new TreeMap<Double, Thing>();
		Map<Integer, Thing> iMap = new TreeMap<Integer, Thing>();
		switch (sortType) {
		// creates a TreeMap and fills it with the name of each Thing and a
		// reference to each Thing
		case "Name":
			tMap.clear();
			for (int i : indexes) {
				tMap.put(hmThings.get(i).name, hmThings.get(i));
			} // end for loop
				// creates output string
			for (Map.Entry<String, Thing> entry : tMap.entrySet()) {
				if (entry.getValue() instanceof SeaPort) {
					SeaPort sp = (SeaPort) entry.getValue();
					st += "\nSeaPort: " + sp.name + " " + sp.index;
				} else if (entry.getValue() instanceof Dock) {
					Dock sp = (Dock) entry.getValue();
					st += "\nDock: " + sp.name + " " + sp.index;
				} else if (entry.getValue() instanceof PassengerShip) {
					PassengerShip sp = (PassengerShip) entry.getValue();
					st += "\nPassengerShip: " + sp.name + " " + sp.index;
				} else if (entry.getValue() instanceof CargoShip) {
					CargoShip sp = (CargoShip) entry.getValue();
					st += "\nCargoShip: " + sp.name + " " + sp.index;
				} else if (entry.getValue() instanceof Person) {
					Person sp = (Person) entry.getValue();
					st += "\nPerson: " + sp.name + " " + sp.index;
				} // end else if series
			} // end for loop
			return st;
		case "Index":
			// sorts the collection by its key, i.e. index
			Collections.sort(indexes);
			// creates output string
			for (int i : indexes) {
				th = hmThings.get(i);
				if (th instanceof SeaPort) {
					SeaPort sp = (SeaPort) th;
					st += "\nSeaPort: " + sp.name + " " + sp.index;
				} else if (th instanceof Dock) {
					Dock sp = (Dock) th;
					st += "\nDock: " + sp.name + " " + sp.index;
				} else if (th instanceof PassengerShip) {
					PassengerShip sp = (PassengerShip) th;
					st += "\nPassengerShip: " + sp.name + " " + sp.index;
				} else if (th instanceof CargoShip) {
					CargoShip sp = (CargoShip) th;
					st += "\nCargoShip: " + sp.name + " " + sp.index;
				} else if (th instanceof Person) {
					Person sp = (Person) th;
					st += "\nPerson: " + sp.name + " " + sp.index;
				} // end else if series
			} // end for loop
			return st;
		case "Draft":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					dMap.put(sh.draft, sh);
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				if (sp instanceof PassengerShip) {
					st += "\nPassengerShip: ";
				} else if (sp instanceof CargoShip) {
					st += "\nCargoShip: ";
				}
				st += sp.name + " " + sp.index + "\n >Draft: " + entry.getKey();
			} // end for loop
			return st;
		case "Length":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					dMap.put(sh.length, sh);
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				if (sp instanceof PassengerShip) {
					st += "\nPassengerShip: ";
				} else if (sp instanceof CargoShip) {
					st += "\nCargoShip: ";
				}
				st += sp.name + " " + sp.index + "\n >Length: " + entry.getKey();
			} // end for loop
			return st;
		case "Weight":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					dMap.put(sh.weight, sh);
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				if (sp instanceof PassengerShip) {
					st += "\nPassengerShip: ";
				} else if (sp instanceof CargoShip) {
					st += "\nCargoShip: ";
				}
				st += sp.name + " " + sp.index + "\n >Weight: " + entry.getKey();
			} // end for loop
			return st;
		case "Width":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					dMap.put(sh.width, sh);
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				if (sp instanceof PassengerShip) {
					st += "\nPassengerShip: ";
				} else if (sp instanceof CargoShip) {
					st += "\nCargoShip: ";
				}
				st += sp.name + " " + sp.index + "\n >Width: " + entry.getKey();
			} // end for loop
			return st;
		case "Number of Passengers":
			iMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof PassengerShip) {
						PassengerShip ps = (PassengerShip) sh;
						iMap.put(ps.numberOfPassengers, ps);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Integer, Thing> entry : iMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nPassengerShip: " + sp.name + " " + sp.index + "\n >Number of Passengers: " + entry.getKey();
			} // end for loop
			return st;
		case "Number of Occupied Rooms":
			iMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof PassengerShip) {
						PassengerShip ps = (PassengerShip) sh;
						iMap.put(ps.numberOfOccupiedRooms, ps);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Integer, Thing> entry : iMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nPassengerShip: " + sp.name + " " + sp.index + "\n >Number of Occupied Rooms: "
						+ entry.getKey();
			} // end for loop
			return st;
		case "Number of Rooms":
			iMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof PassengerShip) {
						PassengerShip ps = (PassengerShip) sh;
						iMap.put(ps.numberOfRooms, ps);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Integer, Thing> entry : iMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nPassengerShip: " + sp.name + " " + sp.index + "\n >Number of Rooms: " + entry.getKey();
			} // end for loop
			return st;
		case "Cargo Value":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof CargoShip) {
						CargoShip cs = (CargoShip) sh;
						dMap.put(cs.cargoValue, cs);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nCargoShip: " + sp.name + " " + sp.index + "\n >Cargo Value: " + entry.getKey();
			} // end for loop
			return st;
		case "Cargo Volume":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof CargoShip) {
						CargoShip cs = (CargoShip) sh;
						dMap.put(cs.cargoVolume, cs);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nCargoShip: " + sp.name + " " + sp.index + "\n >Cargo Volume: " + entry.getKey();
			} // end for loop
			return st;
		case "Cargo Weight":
			dMap.clear();
			for (SeaPort sp : ports) {
				for (Ship sh : sp.ships) {
					if (sh instanceof CargoShip) {
						CargoShip cs = (CargoShip) sh;
						dMap.put(cs.cargoWeight, cs);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<Double, Thing> entry : dMap.entrySet()) {
				Ship sp = (Ship) entry.getValue();
				st += "\nCargoShip: " + sp.name + " " + sp.index + "\n >Cargo Weight: " + entry.getKey();
			} // end for loop
			return st;
		case "Skill":
			tMap.clear();
			for (SeaPort sp : ports) {
				for (Person sh : sp.persons) {
					if (sh instanceof Person) {
						Person pr = (Person) sh;
						tMap.put(pr.skill, pr);
					}
				} // end for Ship loop
			} // end for SeaPort loop
				// creates output string
			for (Map.Entry<String, Thing> entry : tMap.entrySet()) {
				Person sp = (Person) entry.getValue();
				st += "\nPerson: " + sp.name + " " + sp.index + "\n >Skills: " + entry.getKey();
			} // end for loop
			return st;
		} // end switch
		return st;
	} // end method sort

	//TODO: create custom tree renderer
	// SeaPort = anchor, Dock = dock, PassengerShip = cruise ship, CargoShip = container ship, Person = person, Job = checklist
	
	/**
	 * Returns a JTree object for display in the GUI.
	 * 
	 * @return a JTree object
	 */
	public JTree getTree() {
		return tree = new JTree(root);
	} // end method getTree

	/**
	 * Returns a DefaultMutableTreeNode object whose name matches the provided
	 * String. NOTE: this code was based upon code examples from www.java2s.com
	 * 
	 * @param st
	 *            the String to be searched for
	 * 
	 * @return a DefaultMutableTreeNode object
	 */
	public DefaultMutableTreeNode getParentNode(String st) {
		DefaultMutableTreeNode node = null;
		// creates an enumeration that traverses the subtree
		Enumeration<?> e = root.breadthFirstEnumeration();
		// iterates through the array until if finds the requested string
		while (e.hasMoreElements()) {
			node = (DefaultMutableTreeNode) e.nextElement();
			// compares the node's name to the search string
			if (st.equals(node.getUserObject().toString())) {
				return node;
			} // end if
		} // end while
		return null;
	} // end method getParentNode

} // end class World