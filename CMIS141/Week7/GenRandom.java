/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genrandom;

/*
 * File: TimeDiffArgs.java
 * Author: Dr. Robertson
 * Date: January 1, 2015
 * Purpose: This program generates
 * a number of random integers
 * based on user input from the command line
 * arguments
 */
public class GenRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Default values
        int numInteger = 100;
        
        // Check to make sure we have command line argument
        if (args.length == 1) {
            numInteger = Integer.parseInt(args[0]);            
            System.out.println("Generating: "
                    + args[0] + " Random Integers");
        } else {
            System.out.println("Application requires 1 command arguments");
            System.out.println("e.g. java GenRandom 1000");
            System.exit(0);
        }
        for (int i=0 ; i<numInteger; i++){
            int randInt = (int) (Math.random() * 10);
            System.out.println("Random Int is " + randInt);
        }
    }

}
