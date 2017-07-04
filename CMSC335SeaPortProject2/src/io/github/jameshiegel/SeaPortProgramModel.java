package io.github.jameshiegel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//File: SeaPortProgramView.java
//Date: 04 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: 

public class SeaPortProgramModel {
	// instance variables
	private FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
	private World world = new World();

	// methods
	public void loadFile() throws FileNotFoundException {
		JFileChooser fc = new JFileChooser(".");
		Scanner sc = null;
		String st = "";
		File file = null;
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		try {
			sc = new Scanner(new BufferedReader(new FileReader(file)));
			while (sc.hasNextLine()) {
				st = sc.nextLine();
				st.trim();
				// ignores comment lines and blank lines
				if (!st.startsWith("//") && !st.equals("")) {
					world.process(st);
				}
			} // end while
		} finally {
			sc.close();
		} // end try-catch-finally

	} // end method loadFile

} // end class SeaPortProgramModel
