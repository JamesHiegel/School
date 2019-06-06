/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymorestrings;

/*
 * File: MoreString.java
 * Author: Dr. Robertson
 * Date: January 1, 2015
 * Purpose: This program constructs String,
 * StringBuffer and StringBuilder objects
 * and uses several methods
 * and array and loops are used
 * for efficiency of code
 */
public class MyMoreStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create an Array of Strings for use
        String[] firstName = {"Joe", "John", "Lisa", "Sally", "Fred"};
        String[] lastName = {"Jones", "Adams", "Taylor", "Layton", "Mears"};
        String[] city = {"Cairo", "Annapolis", "Dayton", "Houston", "Los Angeles"};

        // Similar Creations for StringBuffer
        StringBuffer[] firstName1 = new StringBuffer[5];
        StringBuffer[] lastName1 = new StringBuffer[5];
        StringBuffer[] city1 = new StringBuffer[5];

        // Loop to create StringBuffers 
        for (int i = 0; i < firstName.length; i++) {
            firstName1[i] = new StringBuffer(firstName[i]);
            lastName1[i] = new StringBuffer(lastName[i]);
            city1[i] = new StringBuffer(city[i]);
        }

        // Similar Creation for StringBuilder
        StringBuilder[] firstName2 = new StringBuilder[5];
        StringBuilder[] lastName2 = new StringBuilder[5];
        StringBuilder[] city2 = new StringBuilder[5];

        // Loop to create StringBuilders 
        for (int i = 0; i < firstName.length; i++) {
            firstName2[i] = new StringBuilder(firstName[i]);
            lastName2[i] = new StringBuilder(lastName[i]);
            city2[i] = new StringBuilder(city[i]);
        }

        // Create an Array of fullNames
        // For each type
        String[] fullName = new String[firstName.length];
        StringBuffer[] fullName1 = new StringBuffer[firstName.length];
        StringBuilder[] fullName2 = new StringBuilder[firstName.length];

        // Loop through and assign 
        // and use methods
        for (int i = 0; i < firstName.length; i++) {
            fullName[i] = firstName[i].concat(" ").concat(lastName[i]);
            System.out.println("Fullname " + i + ":" + fullName[i]);
            // Is string empty?
            System.out.println("Is Empty " + i + ":" + fullName[i].isEmpty());
            // 3rd character in City 
            System.out.println("City 3rd char " + i + ":" + city[i].charAt(2));
            // Fullname length
            System.out.println("Fullname length " + i + ":" + fullName[i].length());
            // City ends with n
            System.out.println("City ends with n " + i + ":" + city[i].endsWith("n"));
            // Fullname substring
            System.out.println("Fullname substring " + i + ":" + fullName[i].substring(3, 7));

        }
        // Loop for StringBuffers
        System.out.println("********************************");
        System.out.println("****** String Buffer ***********");
        for (int i = 0; i < firstName.length; i++) {
            // Append
            fullName1[i] = firstName1[i].append(" ").append(lastName1[i]);
            System.out.println("Fullname " + i + ":" + fullName1[i]);
             // 3rd character in City 
            System.out.println("City 3rd char " + i + ":" + city1[i].charAt(2));
            // Fullname length
            System.out.println("Fullname length " + i + ":" + fullName1[i].length());
             // Fullname capacity
            System.out.println("Fullname capacity " + i + ":" + fullName1[i].capacity());
              // Set first char to K
            city1[i].setCharAt(0, 'K');
            System.out.println("City first is " + i + ":" + city1[i]);
             // Insert a string at position 5
            fullName1[i].insert(5, " Middle ");
             System.out.println("After Middle insert " + i + ":" + fullName1[i]);
        }
        
        // Loop for StringBuilders
        System.out.println("********************************");
        System.out.println("****** String Builder ***********");
        for (int i = 0; i < firstName.length; i++) {
            // Append
            fullName2[i] = firstName2[i].append(" ").append(lastName2[i]);
            System.out.println("Fullname " + i + ":" + fullName2[i]);
             // 3rd character in City 
            System.out.println("City 3rd char " + i + ":" + city2[i].charAt(2));
            // Fullname length
            System.out.println("Fullname length " + i + ":" + fullName2[i].length());
             // Fullname capacity
            System.out.println("Fullname capacity " + i + ":" + fullName2[i].capacity());
              // Set first char to K
            city2[i].setCharAt(0, 'K');
            System.out.println("City first is " + i + ":" + city2[i]);
             // Insert a string at position 5
            fullName2[i].insert(5, " Middle ");
             System.out.println("After Middle insert " + i + ":" + fullName2[i]);
        }

    }

}
