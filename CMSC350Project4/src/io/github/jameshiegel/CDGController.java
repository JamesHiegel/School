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
				theView.setRecompilationOrder(theModel.getHashMapContents());
			} catch (IOException ioe) {
				theView.displayErrorMessage("Invalid File Name");
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
