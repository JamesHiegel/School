package io.github.jameshiegel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RecursiveDescentParser {

	public static void main(String[] args) {
		try {
			// declare and initialize class variables
			final JFileChooser fc = new JFileChooser();
			File filename;
			String program = "";
			String line = "";
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// prompts user to navigate to file to be opened
			fc.setDialogTitle("Select file to open");
			fc.showOpenDialog(null);
			filename = fc.getSelectedFile();

			// read file and make into large string
			try (BufferedReader buffReader = new BufferedReader(new FileReader(filename))) {
				while ((line = buffReader.readLine()) != null) {
					program = program + line;
				}
				//removes all white spaces
				program = program.replaceAll("\\s", "");
				//System.out.println(program);
				//sends string and frame to parser
				Parser.GUI.parse(program, frame);
				//displays frame when parser is complete
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException io) {
			JOptionPane.showMessageDialog(null, "File Error!");
		}
	}
}