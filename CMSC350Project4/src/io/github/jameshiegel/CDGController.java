package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CDGController {
	private CDGView theView;
	private CDGModel theModel;

	public CDGController(CDGView theView, CDGModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		// tells theView what method to call when a button is clicked
		this.theView.addDirectedGraphListener(new directedGraphListener());
		this.theView.addTopologicalOrderListener(new topologicalOrderListener());
	}

	class directedGraphListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// get the input from the view
			String input = theView.getFileName();
			try {
				theModel.makeDirectedGraph(input);
				// System.out.println("Hash Table:\n" +
				// theModel.getHashMapContents());
				theView.displayErrorMessage("Graph Built Sucessfully");
			} catch (IOException ioe) {
				theView.displayErrorMessage("File Did Not Open");
			} catch (InvalidClassException ice) {
				theView.displayErrorMessage("Invalid Class in File");
			}
		}
	}

	class topologicalOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// get the input from the view
			String input = theView.getClassToRecompile();
			// theView.setRecompilationOrder(input);
		}
	}
}