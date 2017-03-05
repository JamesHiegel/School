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

public class CDGModel {
	private HashMap<Integer, String> classNames = new HashMap<Integer, String>();
	private String line = null;
	private String words[];
	
	
	public void makeDirectedGraph(String filename) throws IOException {
		// checks if the filename is valid
		Path path = Paths.get(filename);
		if (!Files.exists(path))
			throw new IOException();

		// use a try with resources to release resources when no longer needed
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			// reads the next line until there are no more lines
			boolean firstWord = true;
			while ((line = bufferedReader.readLine()) != null) {
				// breaks the line into an array of words
				words = line.split("\\s");
				for (int c = 0; c < words.length; c++) {
					// if the value does not exist in the HashMap add it
					if (!classNames.containsValue(words[c])) {
						classNames.put(classNames.size(), words[c]);
					}
					if (firstWord == true) {
						// add a new LinkedList to the ArrayList
					} else {
						// add the index to the current LinkedList
					}
				}
				firstWord = false;
			} // next word
			firstWord = true;
		} // next line
	}

	public String getHashMapContents() {
		String result = "";
		// obtains an Set of the HashMap, then obtains an iterator from the Set
		Iterator itr = classNames.entrySet().iterator();
		// iterators over the collection
		while (itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			// outputs the key and value
			result = result + (pair.getKey() + "=>" + pair.getValue() + " ");
		}
		return result;
	}
}