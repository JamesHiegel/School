/*
* File: Titanic.java
* Author: James Hiegel
* Date: 13 December 2015
* Purpose: This program...
 */
package testtitanic;
// Imports

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestTitanic {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        // Declare variables
        Scanner scan = new Scanner(System.in);
        String userInput;
        int opt;

        Titanic ship = new Titanic(new File(args[0]));

        // Welcome Message
        System.out.println("********** Welcome to the Titanic Statistical "
                + "Application **************************");
        // Main program loop
        do {
            // Displays menu
            ship.displayMenu();
            System.out.print("\nEnter your Selection: ");
            userInput = scan.nextLine().trim();
            // Converts string to int
            try {
                opt = Integer.parseInt(userInput);
                switch (opt) {
                    case 1:
                        ship.getNumPass();
                        break;
                    case 2:
                        ship.getPassPerish();
                        break;
                    case 3:
                        ship.getPassSurv();
                        break;
                    case 4:
                        ship.getPassSurvByClass();
                        break;
                    case 5:
                        ship.getPassSurvByGender();
                        break;
                    case 6:
                        ship.getPassPaidMoreThan200();
                        break;
                    case 7:
                        ship.getPerishLessThan10YrsOld();
                        break;
                    case 8:
                        ship.getSurvLessThan10YrsOld();
                        break;
                    case 9:
                        ship.getNumPassByLetter();
                        break;
                }
                if (opt > 9 | opt < 1) { // Invalid entry notification
                    System.out.println("Please enter a valid option.");
                }
            } catch (NumberFormatException z) {  // Error catch
                if (userInput.equalsIgnoreCase("Q")) {
                } else { // Invalid entry notification
                    System.out.println("Please enter a valid option.");
                }
            }
        } while (userInput.compareToIgnoreCase("Q") != 0);  // close main loop
        System.out.println("\nThank you for trying the Titanic Program.\n"
                + "Elapsed time in seconds was: " + (System.nanoTime() - startTime / 1000000000.0));
        
    }

}
