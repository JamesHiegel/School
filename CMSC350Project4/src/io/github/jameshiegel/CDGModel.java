package io.github.jameshiegel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class Vertex<T> {
	private String name;
	private LinkedList<String> edges;
	private boolean visited;

	public Vertex(String n) {
		this.name = n;
		visited = false;
	}

	public String getName() {
		return name;
	}

	public boolean getVisited() {
		return visited;
	}

	public LinkedList<String> getEdges() {
		return edges;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setEdges(LinkedList<String> edges) {
		this.edges = edges;
	}
}

public class CDGModel {
	private HashMap<Integer, String> classNames = new HashMap<Integer, String>();
	private String line = null;
	private String words[];
	private ArrayList<Vertex<String>> graph = new ArrayList<Vertex<String>>(10);
	private boolean duplicate = false;
	private int index = -1;
	private LinkedList<String> adjList = new LinkedList<String>();

	public void makeDirectedGraph(String filename) throws IOException, InvalidClassException {
		// checks if the filename is valid
		Path path = Paths.get(filename);
		if (!Files.exists(path))
			throw new IOException();

		// use a try with resources to release resources when no longer needed
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			boolean firstWord = true;
			// reads the next line until there are no more lines
			while ((line = bufferedReader.readLine()) != null) {
				// breaks the line into an array of words
				words = line.split("\\s");
				for (int c = 0; c < words.length; c++) {
					// checks for valid class name
					if (!words[c].substring(0,5).equals("Class")) throw new InvalidClassException();
					
					// if the value does not exist in the HashMap add it
					if (!classNames.containsValue(words[c])) {
						classNames.put(classNames.size(), words[c]);
					}
					// checks for duplicates in the array
					for (int i = 0; i < graph.size(); i++) {
						if (graph.get(i).getName().equals(words[c])) {
							duplicate = true;
						}
					}
					// is the array is empty or there is not a duplicate add a
					// vertex
					if (graph.isEmpty() || duplicate == false) {
						graph.add(new Vertex(words[c]));
						index++;
					}
					duplicate = false;
					if (firstWord == false) {
						adjList.add(words[c]);
						graph.get(index).setEdges(adjList);
					}
					
					firstWord = false;
				}
				firstWord = true;
			}
		}
		for (int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i).getName() + " " + graph.get(i).getEdges());
		}
	}

	public String getHashMapContents() {
		String result = "";
		// obtains an Set of the HashMap, then obtains an iterator from the Set
		Iterator itr = classNames.entrySet().iterator();
		// iterators over the collection
		while (itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			// outputs the key and value
			result = result + (pair.getKey() + "=>" + pair.getValue() + "\n");
		}
		return result;
	}
}