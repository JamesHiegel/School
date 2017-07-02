package io.github.jameshiegel;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
	private JTextField searchTerm = new JTextField(15);
	private JTree jtl = new JTree();
	private JTextArea jtam = new JTextArea(5, 20);
	private JTextArea jtar = new JTextArea(5, 20);
	private FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
	private World world;

	// TODO Read the data file, creating the specified internal data
	// structure
	// TODO Display the internal data structure in a nice format in the
	// GUI
	// TODO Display the results of a Search specified by the user
	// TODO Displays pop-up with error message

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
		JButton searchBtn = new JButton("Search");
		tp.add(searchBtn);
		tp.add(searchTerm);
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
		searchBtn.addActionListener(e -> search(searchTerm.getText()));

	} // end SeaPortProgram constructor

	public void loadFile() {
		jtar.append("Load File button pressed\n");
		JFileChooser fc = new JFileChooser(".");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(SeaPortProgram.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			appendLog(String.format("%s selected\n", file));
			world = new World(file);
		}
	} // end method loadFile

	public void search(String target) {
		appendLog(String.format("Search button pressed, target: %s\n", target));
	} // end method search

	public void appendLog(String text) {
		jtar.append(text);
	} // end method appendLog

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
		} // end World constructor

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

		@Override
		public String toString() {
			String st = "\n\nDock: " + super.toString();
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
			if (sc.hasNext())
				jobs.add(new Job(sc));
		} // end Scanner constructor

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
			st += "\n --- Jobs: ";
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
			st += "\n --- Jobs: ";
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
			st += "\n --- Skills: ";
			st += "\n - " + skill;
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