package io.github.jameshiegel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public enum Parser {
	GUI {
		void parse(String s, Container container) throws ParseException {
			// checks if file is good
			if (s.startsWith("Window") && s.endsWith("End.")) {
				// removes start and end of GUI
				s = s.substring(6, s.length() - 4);
				// System.out.println(s);

				// checks for valid title format
				if (!s.startsWith("\"") || (s.indexOf('"') > s.indexOf(';'))) {
					throw new ParseException("Invalid GUI string");
				}

				// sets title of frame
				int titleStart = s.indexOf('"') + 1;
				int titleEnd = s.indexOf('"', s.indexOf('"') + 1);
				((JFrame) container).setTitle(s.substring(titleStart, titleEnd));

				listofContainers.add(container);
				container = listofContainers.get(containerIndex);

				// removes title
				s = s.substring(titleEnd + 1, s.length());
				// System.out.println(s);

				// checks for valid size format
				if (!s.startsWith("(") || (s.indexOf(')') > s.indexOf(';'))) {
					throw new ParseException("Invalid GUI string");
				}
				// sets frame size
				int frameX = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(",")));
				int frameY = Integer.parseInt(s.substring(s.indexOf(",") + 1, s.indexOf(")")));
				container.setSize(frameX, frameY);

				// removes size data
				s = s.substring(s.indexOf(")") + 1, s.length());
				// System.out.println(s);

				LAYOUT.parse(s, container);
			} else {
				throw new ParseException("Invalid start/end");
			}
		}
	},

	LAYOUT {
		void parse(String s, Container container) throws ParseException {
			System.out.println(s);
			if (s.startsWith("LayoutFlow")) {
				// sets layout to Flow
				container.setLayout(new FlowLayout());
				// trims string
				s = s.substring(s.indexOf(":") + 1, s.length());
			} else if (s.startsWith("LayoutGrid")) {
				// sets layout to Grid
				String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
				String var[] = temp.split(",");
				for (String vars : var) {
					System.out.println(vars);
				}
				container.setLayout(new GridLayout(Integer.parseInt(var[0]), Integer.parseInt(var[1]),
						Integer.parseInt(var[2]), Integer.parseInt(var[3])));
				// trims string
				s = s.substring(s.indexOf(":") + 1, s.length());
			} else {
				throw new ParseException("Invalid Layout");
			}
			WIDGETS.parse(s, container);
		}
	},

	WIDGETS {
		void parse(String s, Container container) throws ParseException {
			String[] parts = s.split(";");
			// System.out.println(parts.length);
			for (String part : parts) {
				WIDGET.parse(part, container);
			}
		}
	},

	WIDGET {
		void parse(String s, Container container) throws ParseException {
			System.out.println(s);

			if (s.startsWith("Button")) {
				// create button
				String label = s.substring(s.indexOf('"') + 1, s.length() - 1);
				listofButtons.add(new JButton(label));
				container.add(listofButtons.get(jbuttonIndex));
				jbuttonIndex++;
			} else if (s.startsWith("Group")) {
				// create button group

			} else if (s.startsWith("Label")) {
				// create label
				String label = s.substring(5, s.length());
				if (label.equals("\"\"")) {
					label = "";
				}
				listofLabels.add(new JLabel(label));
				container.add(listofLabels.get(jlabelIndex));
				jlabelIndex++;
			} else if (s.startsWith("Panel")) {
				// create a panel and adds it to the current container
				listofPanels.add(new JPanel());
				container.add(listofPanels.get(jpanelIndex));
				//adds the new panel to the list of containers
				listofContainers.add(listofPanels.get(jpanelIndex));
				// increments the counters
				containerIndex++;
				currentContainer++;
				// sets the current container to the one just created
				container = listofContainers.get(currentContainer);
				// set panel layout for current container
				LAYOUT.parse(s.substring(5, s.length()), container);
				jpanelIndex++;
			} else if (s.startsWith("Textfield")) {
				// create text field
				int columns = Integer.parseInt(s.substring(9, s.length()));
				listofTextFields.add(new JTextField(columns));
				container.add(listofTextFields.get(jtextfieldIndex));
				jtextfieldIndex++;
			} else if (s.startsWith("End")) {
				// this stops the addition of widgets to a panel
				// sets the current container to the previous container
				currentContainer--;
				container = listofContainers.get(currentContainer);
			} else {
				throw new ParseException("Invalid Layout");
			}
		}
	};

	abstract void parse(String s, Container container) throws ParseException;

	static List<JTextField> listofTextFields = new ArrayList<JTextField>();
	private static int jtextfieldIndex;

	static List<JPanel> listofPanels = new ArrayList<JPanel>();
	private static int jpanelIndex;

	static List<JLabel> listofLabels = new ArrayList<JLabel>();
	private static int jlabelIndex;

	static List<JButton> listofButtons = new ArrayList<JButton>();
	private static int jbuttonIndex;

	static List<ButtonGroup> listofBtnGrps = new ArrayList<ButtonGroup>();
	private static int buttongroupIndex;

	static List<Container> listofContainers = new ArrayList<Container>();
	private static int containerIndex;
	private static int currentContainer;
}