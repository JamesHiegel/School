package io.github.jameshiegel;

public class ClassDependencyGraph {

	public static void main(String[] args) {
		//instantiates the View and Model
		CDGView theView = new CDGView();
		CDGModel theModel= new CDGModel();
		//instantiates the Controller and passes the references to the View and Model
		CDGController theController= new CDGController(theView, theModel);
		//shows the GUI
		theView.setVisible(true);
	}

}
