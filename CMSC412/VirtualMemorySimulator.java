package github.io.jameshiegel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VirtualMemorySimulator {
	final static int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, EIGHT = 8;
	static int menuOption = EIGHT;
	static List<Integer> referenceString = new ArrayList<Integer>();
	static int memorySize = 0;

	public static void main(String[] args) {
		try {
			memorySize = Integer.parseInt(args[ZERO]);
			if (args.length != ONE || memorySize < ONE || memorySize > SEVEN) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(
					"Error: Command line argument must be an integer in the range of 1 to 7.");
		}

		Scanner input = new Scanner(System.in);

		do {
			menuOption = EIGHT;
			displayMenu();
			if (input.hasNextInt()) {
				menuOption = input.nextInt();
			} else {
				System.out.println("Error: Type an integer and press enter.");
				input.next();
			}
			switch (menuOption) {
			case ZERO: {
				break;
			}
			case ONE: {
				ReadReferenceString();
				break;
			}
			case TWO: {
				GenerateReferenceString();
				break;
			}
			case THREE: {
				DisplayReferenceString();
				break;
			}
			case FOUR: {
				SimulateFIFO fifo = new SimulateFIFO(referenceString, memorySize);
				fifo.StartSimulation();
				break;
			}
			case FIVE: {
				break;
			}
			case SIX: {
				break;
			}
			case SEVEN: {
				break;
			}
			default: {
			}
			}
			System.out.println();
		} while (menuOption != 0);

		input.close();
	}

	public static void displayMenu() {
		System.out.print("0 - Exit\n" + "1 - Read reference string\n" + "2 - Generate reference string\n"
				+ "3 - Display current reference string\n" + "4 - Simulate FIFO\n" + "5 - Simulate OPT\n"
				+ "6 - Simulate LRU\n" + "7 - Simulate LFU\n" + "Type a menu option and press enter: ");
	}

	public static void DisplayReferenceString() {
		if (referenceString.isEmpty()) {
			System.out.print("Error: Reference string is empty.");
		}
		Iterator<Integer> it = referenceString.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void ReadReferenceString() {
		referenceString.clear();
		System.out.print("Type integer reference string and press enter: ");
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine().replaceAll(" ", "");
		String[] stringArray = inputString.split("");
		try {
			for (String element : stringArray) {
				referenceString.add(Integer.parseInt(element));
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: Reference string can only be integers.");
		}
	}

	public static void GenerateReferenceString() {
		referenceString.clear();
		System.out.print("Type length of reference string and press enter: ");
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		try {
			int stringLength = scan.nextInt();
			if (stringLength < 1) {
				throw new InputMismatchException();
			}
			for (int counter = 0; counter < stringLength; counter++) {
				referenceString.add(rand.nextInt(10));
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Reference string length can only be an integer.");
		}
	}

	public static void pressAnyKeyToContinue() {
		System.out.print("Press Enter key to continue...\n");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}

class SimulateFIFO {
	List<Integer> referenceString = new ArrayList<Integer>();
	int memorySize = 0;
	int pageFaults = 0;
	LinkedList<Integer> memoryQueue = new LinkedList<Integer>();

	SimulateFIFO(List<Integer> referenceString, int memorySize) {
		this.referenceString = referenceString;
		this.memorySize = memorySize;
	}

	public void StartSimulation() {
		for (int frame : referenceString) {
			if (memoryQueue.contains(frame)) {
				System.out.printf("Frame %d found in memory.\n", frame);
			} else {
				System.out.printf("Page fault. ");
				pageFaults++;
				if (memoryQueue.isEmpty()) {
				} else if (memoryQueue.size() >= memorySize) {
					memoryQueue.remove();
				}
				memoryQueue.add(frame);
				System.out.printf("Frame %d added to memory.\n", frame);
			}
			VirtualMemorySimulator.pressAnyKeyToContinue();
		}
		System.out.printf("Total page faults: %d\n", pageFaults);
	}
}