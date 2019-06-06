/*
* File: Titanic.java
* Author: James Hiegel
* Date: 13 December 2015
* Purpose: This program...
 */
package testtitanic;
// Class imports

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Titanic {
    // Class variables

    // Object variables
    private String[][] manifest;
    private File source;
    private BufferedReader fileIn;
    private String line;
    private int passengerCount;
    private int numPassengers;
    private Scanner lineScan;
    private int numPassPerish;
    private float perPassPerish;
    private int numPassSurv;
    private float perPassSurv;
    private int[] passSurvByClass = {0, 0, 0};
    private float[] perSurvByClass = {0, 0, 0};
    private int[] passSurvByGender = {0, 0};
    private float[] perSurvByGender = {0, 0};
    private String firstLetter;
    private int letterCount;

    // Constructor
    public Titanic(File source) throws IOException {
        //The constructor builds an array from the source
        this.source = source;
        fileIn = new BufferedReader(new FileReader(source));

        while ((line = fileIn.readLine()) != null) {
            if (line.trim().equals("")) {
                break;
            }
            passengerCount++;
        }

        fileIn.close();
        manifest = new String[passengerCount][6];
        numPassengers = passengerCount;
        passengerCount = 0;

        fileIn = new BufferedReader(new FileReader(source));
        while ((line = fileIn.readLine()) != null) { // line was declared as String
            if (line.trim().equals("")) {
                break;
            }
            lineScan = new Scanner(line);
            lineScan.useDelimiter("\t");
            for (int i = 0; i < 6; i++) {
                try {
                    manifest[passengerCount][i] = lineScan.next();
                } catch (NoSuchElementException nse) {
                    break;
                }

            }
            lineScan.close();
            passengerCount++;
        }
    }
    // Getters

    public void displayMenu() {
        System.out.println("\n"
                + "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :\n"
                + "1. How many passengers were on the Titanic?\n"
                + "2. What percentage of passengers perished on the Titanic?\n"
                + "3. What percentage of passengers survived the sinking of the Titanic?\n"
                + "4. What percentage of passengers survived for each of the three classes?\n"
                + "5. What percentage of passengers survived as a function of gender?\n"
                + "6. What specific passengers paid more than $200 for their tickets?\n"
                + "7. What specific passengers who were less than 10 years old perished on the titanic?\n"
                + "8. What specific passengers who were less than 10 years old survived the sinking of the titanic?\n"
                + "9. For each letter in the alphabet, how many passengers last names started with that letter?\n"
                + "Q. Quit the program");
    }

    public void getNumPass() {
        System.out.println("\nThere were " + this.numPassengers
                + " passengers on the Titanic.");
    }

    public void getPassPerish() {
        this.numPassPerish = 0;
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("0")) { // checks if passenger perished
                this.numPassPerish++;  // increments if true
            }
        }
        // converts to float and calculates percentage
        this.perPassPerish = (float) this.numPassPerish / this.numPassengers * 100;
        System.out.println("\n" + Math.round(this.perPassPerish) + "% of passengers perished.");
    }

    public void getPassSurv() {  // same as above, but checks for a 1 instead
        this.numPassSurv = 0;
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("1")) {
                this.numPassSurv++;
            }
        }
        this.perPassSurv = (float) this.numPassSurv / this.numPassengers * 100;
        System.out.println("\n" + Math.round(this.perPassSurv) + "% of passengers survived.");
    }

    public void getPassSurvByClass() {
        this.passSurvByClass[0] = 0;
        this.passSurvByClass[1] = 0;
        this.passSurvByClass[2] = 0;
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("1")) {
                switch (this.manifest[y][0]) {
                    case "1":
                        this.passSurvByClass[0]++;
                        break;
                    case "2":
                        this.passSurvByClass[1]++;
                        break;
                    default:
                        this.passSurvByClass[2]++;
                        break;
                }
            }
        }
        this.perSurvByClass[0] = (float) this.passSurvByClass[0] / this.numPassengers * 100;
        this.perSurvByClass[1] = (float) this.passSurvByClass[1] / this.numPassengers * 100;
        this.perSurvByClass[2] = (float) this.passSurvByClass[2] / this.numPassengers * 100;
        System.out.println("\nSurvival by class: 1st -- "
                + Math.round(this.perSurvByClass[0]) + "%, 2nd -- " + Math.round(this.perSurvByClass[1])
                + "%, 3rd -- " + Math.round(this.perSurvByClass[2]) + "%");
    }

    public void getPassSurvByGender() {
        this.passSurvByGender[0] = 0;
        this.passSurvByGender[1] = 0;
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("1")) {
                switch (this.manifest[y][3]) {
                    case "male":
                        this.passSurvByGender[0]++;
                        break;
                    default:
                        this.passSurvByGender[1]++;
                        break;
                }
            }
        }
        this.perSurvByGender[0] = (float) this.passSurvByGender[0] / this.numPassengers * 100;
        this.perSurvByGender[1] = (float) this.passSurvByGender[1] / this.numPassengers * 100;
        System.out.println("\nSurvival by gender: male -- "
                + Math.round(this.perSurvByGender[0]) + "%, female -- " + Math.round(this.perSurvByGender[1])
                + "%");
    }

    public void getPassPaidMoreThan200() {
        System.out.println("\nPaid more than $200 -- list");
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("1")) {
                if (java.lang.Float.parseFloat(this.manifest[y][5]) >= 200) {
                    System.out.println(this.manifest[y][2] + ", paid: $" + this.manifest[y][5]);
                }
            }
        }
    }

    public void getPerishLessThan10YrsOld() {
        System.out.println("\nUnder 10 years old who perished");
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("0")) {
                try {
                    if (java.lang.Float.parseFloat(this.manifest[y][4]) <= 10) {
                        System.out.println(this.manifest[y][2] + ", " + this.manifest[y][4] + " years old");
                    }
                } catch (NumberFormatException z) {
                }
            }
        }
    }

    public void getSurvLessThan10YrsOld() {
        System.out.println("\nUnder 10 years old who survived");
        for (int y = 0; y < this.numPassengers; y++) {
            if (this.manifest[y][1].equals("1")) {
                try {
                    if (java.lang.Float.parseFloat(this.manifest[y][4]) <= 10) {
                        System.out.println(this.manifest[y][2] + ", " + this.manifest[y][4] + " years old");
                    }
                } catch (NumberFormatException z) {
                }
            }
        }
    }

    public void getNumPassByLetter() {
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            letterCount = 0;
            //System.out.println(alphabet); // for debugging
            for (int y = 0; y < this.numPassengers; y++) {
                firstLetter = Character.toString(this.manifest[y][2].charAt(0));
                if (Character.toString(alphabet).equalsIgnoreCase(firstLetter)) {
                    //System.out.println(this.manifest[y][2]);  // for debugging
                    letterCount++;
                }
            }
            System.out.println(alphabet + ": " +letterCount);
        }
    }

}  // closes class
