/** This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <http://www.gnu.org/licenses/>.
 */
package io.github.jameshiegel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * James Hiegel CMSC 350 UMUC Spring 2017 Project 1
 */
public class InfixCalculator implements ActionListener {

   public static final int HEIGHT = 150;
   public static final int WIDTH = 400;
   protected JTextField expfield = new JTextField(225);
   protected JTextField resultfield = new JTextField(225);

   public static void main(String[] args) {
      //create and initialize variables
      InfixCalculator infixCalculator = new InfixCalculator();
      infixCalculator.createGUI();
   }

   private void createGUI() {
      //create the frame and set exit on close
      JFrame frame = new JFrame("Infix Expression Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WIDTH, HEIGHT);

      //create and add components
      JPanel pane = new JPanel(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      JLabel expLabel = new JLabel("Enter Infix Expression");
      c.insets = new Insets(5, 5, 5, 0);
      c.gridy = 0;
      c.gridx = 0;
      pane.add(expLabel, c);

      c.gridx = 1;
      c.gridwidth = 2;
      c.ipadx = 225;
      pane.add(expfield, c);

      JButton evalBtn = new JButton("Evaluate");
      c.gridy = 1;
      c.gridwidth = 1;
      c.ipadx = 0;
      pane.add(evalBtn, c);
      evalBtn.addActionListener(this);

      JLabel resultLabel = new JLabel("Result");
      c.gridy = 2;
      c.gridx = 0;
      pane.add(resultLabel, c);

      c.gridy = 2;
      c.gridx = 1;
      c.ipadx = 225;
      resultfield.setEditable(false);
      pane.add(resultfield, c);

      //add panel and display frame
      frame.add(pane);
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         InfixEvaluator eval = new InfixEvaluator(expfield.getText());
         resultfield.setText(Integer.toString(eval.evaluate()));
      } catch (ArithmeticException ae) {
         JOptionPane popup = new JOptionPane();
         JOptionPane.showMessageDialog(popup, "Divide by zero error!",
                 "Error",JOptionPane.ERROR_MESSAGE);
      }
   }
}
