/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timediffargs;

import java.time.Duration;
import java.time.Instant;

/*
* File: TimeDiffArgs.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates
* sending in command line input
* parameters
*/
public class TimeDiffArgs {

    /**
     * @param args the command line arguments
     */
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Default values
        int outerLoop = 100;
        int innerLoop = 10;
        // Check to make sure we have command line argument
        if (args.length == 2){
            outerLoop = Integer.parseInt(args[0]);
            innerLoop = Integer.parseInt(args[1]);
            System.out.println("Setting loop values: " +
                    args[0] + "," + args[1]);
        }
        else {
            System.out.println("Application requires 2 command arguments");
            System.out.println("e.g. java TimeDiffArgs 1000 10");
            System.exit(0);
        }
             
        // Snap an instance      
        Instant before = Instant.now();
        // Now run a length loop
        for (int i=0; i<outerLoop;i++){
            for (int j=0; j<innerLoop;j++){
                System.out.println("i x j = " + i*j);
            }
        }
        Instant after = Instant.now();      
        System.out.println("Difference is " + 
               Duration.between(before, after).toNanos()/1_000_000_000.0 +
                " Seconds.");
       
        
    }
    
}
