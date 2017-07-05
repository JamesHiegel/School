package io.github.jameshiegel;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

// File: SeaPortProgram.java
// Date: 01 July 2017
// Author: James Hiegel
// Purpose: 

public class SeaPortProgram extends JFrame {
	private final String[] opt = { "Name", "Index", "Skill", "Length", "Width", "Draft" };
	private JComboBox<String> jcb = new JComboBox<String>(opt);
	private JTextField searchTerm = new JTextField(15);
	private JTree jtl = new JTree();
	private JTextArea jtam = new JTextArea(5, 20);
	private JTextArea jtar = new JTextArea(5, 20);
	private FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
	private World world;

	public SeaPortProgram() {
		setTitle("SeaPort Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		setLocationRelativeTo(null);// centers window on screen
		setVisible(true);

		// top panel
		JPanel tp = new JPanel();
		JButton loadBtn = new JButton("Load File");
		tp.add(loadBtn);
		tp.add(jcb);
		tp.add(searchTerm);
		JButton searchBtn = new JButton("Search");
		tp.add(searchBtn);
		add(tp, BorderLayout.PAGE_START);

		// left panel
		JPanel lp = new JPanel(new BorderLayout());
		lp.add(jtl);
		add(lp, BorderLayout.LINE_START);

		// middle panel
		JPanel mp = new JPanel(new BorderLayout());
		JScrollPane jspm = new JScrollPane(jtam);
		jtam.setEditable(false);
		mp.add(jspm);
		add(mp, BorderLayout.CENTER);

		// right panel
		JPanel rp = new JPanel(new BorderLayout());
		jtar.setEditable(false);
		jtar.setLineWrap(true);
		rp.add(jtar);
		add(rp, BorderLayout.LINE_END);

		validate();

		// action listeners
		loadBtn.addActionListener(e -> loadFile());
		searchBtn.addActionListener(e -> search());

	} // end SeaPortProgram constructor

	public void loadFile() {
		JFileChooser fc = new JFileChooser(".");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(SeaPortProgram.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			appendLog(String.format("Loading %s\n", file));
			world = new World(file);
			appendDisplay(world.toString());
		}
	} // end method loadFile

	public void search() {
		String opt = (String) jcb.getSelectedItem();
		String st = searchTerm.getText();
		st.trim();
		appendLog(String.format("Search button pressed, type: %s, target: %s\n", opt, st));
		jtam.setText("");
		try {
			switch (opt) {
			case "Name":
				for (SeaPort sp : world.ports) {
					searchHelper(sp.getName(), st);
					for (Dock dk : sp.docks) {
						searchHelper(dk.getName(), st);
					}
					for (Ship sh : sp.que) {
						searchHelper(sh.getName(), st);
					}
					for (Ship sh : sp.ships) {
						searchHelper(sh.getName(), st);
					}
					for (Person pr : sp.persons) {
						searchHelper(pr.getName(), st);
					}
				}
				break;
			case "Index":
				for (SeaPort sp : world.ports) {
					searchHelper(Integer.toString(sp.index), st);
					for (Dock dk : sp.docks) {
						searchHelper(Integer.toString(dk.index), st);
					}
					for (Ship sh : sp.que) {
						searchHelper(Integer.toString(sh.index), st);
					}
					for (Ship sh : sp.ships) {
						searchHelper(Integer.toString(sh.index), st);
					}
					for (Person pr : sp.persons) {
						searchHelper(Integer.toString(pr.index), st);
					}
				}
				break;
			case "Skill":
				for (SeaPort sp : world.ports) {
					for (Person pr : sp.persons) {
						searchHelper(pr.skill, st);
					}
				}
				break;
			case "Length":
				for (SeaPort sp : world.ports) {
					for (Ship sh : sp.que) {
						searchHelper(Double.toString(sh.length), st);
					}
					for (Ship sh : sp.ships) {
						searchHelper(Double.toString(sh.length), st);
					}
				}
				break;
			case "Width":
				for (SeaPort sp : world.ports) {
					for (Ship sh : sp.que) {
						searchHelper(Double.toString(sh.width), st);
					}
					for (Ship sh : sp.ships) {
						searchHelper(Double.toString(sh.width), st);
					}
				}
				break;
			case "Draft":
				for (SeaPort sp : world.ports) {
					for (Ship sh : sp.que) {
						searchHelper(Double.toString(sh.draft), st);
					}
					for (Ship sh : sp.ships) {
						searchHelper(Double.toString(sh.draft), st);
					}
				}
				break;
			} // end switch
		} catch (

		NumberFormatException e) {
			displayErrorMessage("Invalid index!");
		}
	} // end
		// method
		// search

	public void appendLog(String text) {
		jtar.append(text);
	} // end method appendLog

	public void appendDisplay(String text) {
		jtam.append(text);
	} // end method appendDisplay

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	} // end method displayErrorMessage

	public String searchHelper(String x, String y) {
		if (x.contains(y))
			appendDisplay(x.toString() + "\n");
		return null;
	}

	public class Thing implements Comparable<Thing> {
		// instance variables
		String name = "";
		int index = 0;
		int parent = 0;

		// constructors
		public Thing(Scanner sc) {
			if (sc.hasNext())
				name = sc.next();
			if (sc.hasNextInt())
				index = sc.nextInt();
			if (sc.hasNextInt())
				parent = sc.nextInt();
		} // end Scanner constructor

		public Thing() {
		} // end default constructor

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return name + " " + index;
		} // end method toString

		@Override
		public int compareTo(Thing arg0) {
			// TODO Auto-generated method stub
			return 0;
		} // end method compareTo

	} // end class Thing

	public class World extends Thing {
		// instance variables
		ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
		PortTime time = new PortTime();

		// constructors
		public World(File file) {
			appendLog("World created.\n");
			Scanner sc = null;
			String st = "";
			try {
				sc = new Scanner(new BufferedReader(new FileReader(file)));
				while (sc.hasNextLine()) {
					st = sc.nextLine();
					// ignores comment lines and blank lines
					if (!st.startsWith("//") && !st.equals("")) {
						process(st);
					}
				} // end while
			} catch (FileNotFoundException e) {
				displayErrorMessage("File Not Found.");
			} finally {
				sc.close();
			} // end try-catch-finally
		} // end World constructor

		void process(String st) {
			System.out.println("Processing >" + st + "<");
			Scanner sc = new Scanner(st);
			if (!sc.hasNext()) // checks for end of line
				return;
			switch (sc.next()) {
			case "port":
				addPort(sc);
				break;
			case "dock":
				addDock(sc);
				break;
			case "pship":
				addPassShip(sc);
				break;
			case "cship":
				addCargoShip(sc);
				break;
			case "person":
				addPerson(sc);
				break;
			} // end switch
		} // end method process

		void addPort(Scanner sc) {
			SeaPort sp = new SeaPort(sc);
			ports.add(sp);
			appendLog("Port " + sp.getName() + " added.\n");
		} // end method addPort

		void addDock(Scanner sc) {
			Dock dc = new Dock(sc);
			// System.out.println(dc.toString());
			SeaPort sp = getSeaPortByIndex(dc.parent);
			sp.docks.add(dc);
			appendLog("Dock " + dc.getName() + " added.\n");
		} // end method addDock

		void addPassShip(Scanner sc) {
			PassengerShip ps = new PassengerShip(sc);
			// System.out.println(ps.toString());
			assignShip(ps);
			appendLog("Ship " + ps.getName() + " added.\n");
		} // end method addPassShip

		void addCargoShip(Scanner sc) {
			CargoShip cs = new CargoShip(sc);
			// System.out.println(cs.toString());
			assignShip(cs);
			appendLog("Ship " + cs.getName() + " added.\n");
		} // end method addCargoShip

		void addPerson(Scanner sc) {
			Person pr = new Person(sc);
			SeaPort sp = getSeaPortByIndex(pr.parent);
			sp.persons.add(pr);// adds person to port's roster
			appendLog("Person " + pr.getName() + " added.\n");
		} // end method addPerson

		SeaPort getSeaPortByIndex(int x) {
			for (SeaPort msp : ports)
				if (msp.index == x)
					return msp;
			return null;
		} // end getPortByIndex

		Dock getDockByIndex(int x) {
			for (SeaPort msp : ports)
				for (Dock ms : msp.docks)
					if (ms.index == x)
						return ms;
			return null;
		} // end getDockByIndex

		Ship getShipByIndex(int x) {
			for (SeaPort msp : ports)
				for (Ship ms : msp.ships)
					if (ms.index == x)
						return ms;
			return null;
		} // end getShipByIndex

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

		@Override
		public String toString() {
			String st = ">>>>> The World:";
			for (SeaPort md : ports)
				st += "\n" + md;
			return st;
		} // end method toString
	} // end class World

	public class SeaPort extends Thing {
		// instance variables
		ArrayList<Dock> docks = new ArrayList<Dock>();
		// the list of ships waiting to dock
		ArrayList<Ship> que = new ArrayList<Ship>();
		// a list of all the ships at this port
		ArrayList<Ship> ships = new ArrayList<Ship>();
		// people with skills at this port
		ArrayList<Person> persons = new ArrayList<Person>();

		// constructors
		public SeaPort(Scanner sc) {
			super(sc);
		} // end Scanner constructor

		public void addDock(Dock dk) {
			this.docks.add(dk);
			appendLog("Dock " + docks.get(docks.size() - 1).name + " added.\n");
		}

		public String getName() {
			return super.getName();
		}

		@Override
		public String toString() {
			String st = "\n\nSeaPort: " + super.toString();
			for (Dock md : docks)
				st += "\n" + md;
			st += "\n\n --- List of all ships in que:";
			for (Ship ms : que)
				st += "\n > " + ms;
			st += "\n\n --- List of all ships:";
			for (Ship ms : ships)
				st += "\n > " + ms;
			st += "\n\n --- List of all persons:";
			for (Person mp : persons)
				st += "\n > " + mp;
			return st;
		} // end method toString
	} // end class SeaPort

	public class Dock extends Thing {
		// instance variables
		Ship ship;

		// constructors
		public Dock(Scanner sc) {
			super(sc);
		} // end Scanner constructor

		public String getName() {
			return super.getName();
		}

		@Override
		public String toString() {
			String st = "\nDock: " + super.toString();
			st += "\n Ship: " + ship.toString();
			return st;
		} // end method toString
	} // end class Dock

	public class Ship extends Thing {
		// instance variables
		PortTime arrivalTime, dockTime;
		double draft, length, weight, width;
		ArrayList<Job> jobs = new ArrayList<Job>();

		// constructors
		public Ship(Scanner sc) {
			super(sc);
			if (sc.hasNextInt())
				arrivalTime = new PortTime(sc.nextInt());
			if (sc.hasNextInt())
				dockTime = new PortTime(sc.nextInt());
			if (sc.hasNextDouble())
				draft = sc.nextDouble();
			if (sc.hasNextDouble())
				length = sc.nextDouble();
			if (sc.hasNextDouble())
				weight = sc.nextDouble();
			if (sc.hasNextDouble())
				width = sc.nextDouble();
			// if (sc.hasNext())
			// jobs.add(new Job(sc));
		} // end Scanner constructor

		public String getName() {
			return super.getName();
		}

		@Override
		public String toString() {
			return super.toString();
		} // end method toString
	} // end class Ship

	public class PassengerShip extends Ship {
		// instance variables
		int numberOfOccupiedRooms = 0;
		int numberOfPassengers = 0;
		int numberOfRooms = 0;

		// constructors
		public PassengerShip(Scanner sc) {
			super(sc);
			if (sc.hasNextInt())
				numberOfPassengers = sc.nextInt();
			if (sc.hasNextInt())
				numberOfRooms = sc.nextInt();
			if (sc.hasNextInt())
				numberOfOccupiedRooms = sc.nextInt();
		} // end Scanner constructor

		@Override
		public String toString() {
			String st = "Passenger ship: " + super.toString();
			if (jobs.size() == 0)
				return st;
			for (Job mj : jobs)
				st += "\n - " + mj;
			return st;
		} // end method toString
	} // end class PassengerShip

	public class CargoShip extends Ship {
		// instance variables
		double cargoValue = 0.0;
		double cargoVolume = 0.0;
		double cargoWeight = 0.0;

		// constructors
		public CargoShip(Scanner sc) {
			super(sc);
			if (sc.hasNextInt())
				cargoValue = sc.nextInt();
			if (sc.hasNextInt())
				cargoVolume = sc.nextInt();
			if (sc.hasNextInt())
				cargoWeight = sc.nextInt();
		} // end Scanner constructor

		@Override
		public String toString() {
			String st = "Cargo ship: " + super.toString();
			if (jobs.size() == 0)
				return st;
			for (Job mj : jobs)
				st += "\n - " + mj;
			return st;
		} // end method toString
	} // end class CargoShip

	public class Person extends Thing {
		// instance variables
		String skill = "";

		// constructors
		public Person(Scanner sc) {
			super(sc);
			if (sc.hasNext())
				skill = sc.next();
		} // end Scanner constructor

		@Override
		public String toString() {
			String st = "Person: " + super.toString();
			st += " " + skill;
			return st;
		} // end method toString
	} // end class Person

	public class Job extends Thing {
		// instance variables
		double duration = 0.0;
		// should be some of the skills of the persons
		ArrayList<String> requirements = new ArrayList<String>();

		// constructors
		public Job(Scanner sc) {
			super(sc);
			if (sc.hasNextDouble())
				duration = sc.nextDouble();
			if (sc.hasNext())
				requirements.add(sc.next());
		} // end Scanner constructor

		@Override
		public String toString() {
			return "Job [duration=" + duration + ", requirements=" + requirements + "]";
		} // end method toString
	} // end class Job

	public class PortTime {
		// instance variables
		int time = 0;

		// constructors
		public PortTime(int time) {
			this.time = time;
		} // end int constructor

		public PortTime() {
		} // end default constructor

		@Override
		public String toString() {
			return "PortTime [time=" + time + "]";
		} // end method toString
	} // end class PortTime

	public static void main(String[] args) {
		SeaPortProgram spp = new SeaPortProgram();
	} // end main method
} // end program SeaPortProgram