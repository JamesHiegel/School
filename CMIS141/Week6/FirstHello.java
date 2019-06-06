/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthello;

import java.util.Scanner;

/**
 *
 * @author jim
 */
public class FirstHello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter your name: ");
        Scanner scannerIn = new Scanner(System.in);
        String yourName = scannerIn.next();
        System.out.println("Hello, " + yourName + " from Netbeans!");

    }

}
