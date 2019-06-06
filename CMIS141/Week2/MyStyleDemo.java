/*
* File: MyStyleDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Operators
* and applies the Java style guides.
*/

public class MyStyleDemo {	

    public static void main(String[] args) { 
	// Welcome Statement
        System.out.println("Welcome to My Style Demo");
        
        // Place holders to store calculation
        double doubleResults = 0.0;
        int intResults = 0;

        // Addition (+)
        doubleResults = 4.1 + 8.1;
        System.out.println("4.1 + 8.1 = " + doubleResults);
        doubleResults = 4.1 + 10.5;
        System.out.println("4.1 + 10.5 = " + doubleResults);

        //  Subtraction (-)
        doubleResults = 4.1 - 8.1;
        System.out.println("4.1 - 8.1 = " + doubleResults);
        doubleResults = 4.1 - 10.5;
        System.out.println("4.1 - 10.5 = " + doubleResults);

	// Multiplication (*) 
        doubleResults = 4.1 * 8.1;
        System.out.println("4.1 * 8.1 = " + doubleResults);
        doubleResults = 4.1 * 10.5;
        System.out.println("4.1 * 10.5 = " + doubleResults);

	// Division (/)
        doubleResults = 4.1 / 8.1;
        System.out.println("4.1 / 8.1 = " + doubleResults);
        doubleResults = 4.1 / 10.5;
        System.out.println("4.1 / 10.5 = " + doubleResults);

	// Modulus (%)
        intResults = 20 % 3;
        System.out.println("20 % 3 = " + intResults);
        intResults = 20 % 5;
        System.out.println("20 % 5 = " + intResults);
         
 	// Precedence groupings 
       System.out.println("\n");   // New Line to separate Output
       System.out.println("*****Precedence Groupings*****");     
       doubleResults = 8.1 / 10.5 + 4.1 * 4.1 + 20;
       System.out.println("8.1 / 10.5 + 4.1 * 4.1 + 20 = " + doubleResults); 
       doubleResults = 8.1 / 10.5 + 4.1 * (4.1 + 20);
       System.out.println("8.1 / 10.5 + 4.1 * (4.1 + 20) = " + doubleResults);       
       doubleResults = 20 % 3 / 10.5 + 3 / (4.1 * 20 % 5);
       System.out.println("20 % 3 / 10.5 + 3 / (4.1 * 20 % 5) = " + doubleResults);  
       System.out.println("*****************************");  
       System.out.println("\n"); 

       // Unary Operators       
       // Variables for demonstrating Unary Operators
        System.out.println("*****Unary Operators*****");  
        int ageAdult = 20;
        int ageToddler = 3;
        int ageDog = 5;
        int ageCat = 10;

        // Post Increment (++)
        intResults = ageAdult++;      
        System.out.println("ageAdut++ = " + intResults);
       
       // Pre increment (++)
       intResults = ++ageToddler;
       System.out.println("++ageToddler = " + intResults);

       // Post decrement (--)
       intResults = ageDog--;
       System.out.println("ageDog-- = " + intResults);

       // Pre decrement (--)
       intResults = --ageCat;
       System.out.println("--ageCat = " + intResults);

       // Not Operator (!)
       // This should be true since 20 >= 3
       boolean ageTest = (20 >= 3);
       System.out.println("(20 >= 3) = " + ageTest);
       // This should be false since ! inverts the boolean value
       ageTest = !(20 >= 3);
       System.out.println("!(20 >= 3) = " + ageTest);
       System.out.println("*****************************");  
       System.out.println("\n"); 

	// Equality Operators
        // Equality (==)
       // 20 is not equal to 3 so flag should be false.
       System.out.println("*****Equality Operators*****");  
       ageTest = (20 == 3);
       System.out.println("(20 == 3) = " + ageTest);
        ageTest = (20 / 4 == 5);
       System.out.println("(20 / 4 == 5) = " + ageTest);

        // Not Equal (!=)
       // 20 is not equal to 3 so flag should be true.
       ageTest = (20 != 3);
       System.out.println("(20 != 3) = " + ageTest);
        ageTest = (20 / 4 != 5);
       System.out.println("(20 / 4 != 5) = " + ageTest);

        // Greater than (>)
        // 20 is greater than3 so flag should be true.
       ageTest = (20 > 3);
       System.out.println("(20 > 3) = " + ageTest);
        ageTest = (20 / 4 > 5);
       System.out.println("(20 / 4 > 5) = " + ageTest);
      
        // Greater than or equal to (>=)
        // 20 is not equal to 3 so flag should be false.
       ageTest = (20 >= 3);
       System.out.println("(20 >= 3) = " + ageTest);
       ageTest = (20 / 4 >= 5);
       System.out.println("(20 / 4 >= 5) = " + ageTest);
        
 	// Less than (<)
        // 20 is not less than 3 so flag should be false.
       ageTest = (20 < 3);
       System.out.println("(20 < 3) = " + ageTest);
        ageTest = (20 / 4 < 5);
       System.out.println("(20 / 4 < 5) = " + ageTest);

	// Less than or equal (<=)
        // 20 is not less than or equal so 3 so flag should be false.
       ageTest = (20 <= 3);
       System.out.println("(20 <= 3) = " + ageTest);
        ageTest = (20 / 4 <= 5);
       System.out.println("(20 / 4 <= 5) = " + ageTest);
        System.out.println("*****************************");  
       System.out.println("\n");

	// Conditional Operators
        // And (&&)
        System.out.println("*****Conditional Operators*****");
        ageTest = (20 == 20 ) && (15 >= 1) ;
        System.out.println ("(20 == 20 ) && (15 >= 1) = " + ageTest); 
        ageTest = (20 == 20 ) || (15 >= 1) ;
        System.out.println ("(20 == 20 ) || (15 >= 1) = " + ageTest); 

        // Conditional Operators can become complex
	// this can be tricky and precedence rules are critical
	// for this && is evaluated before ||. So all && are evaluated first.
        ageTest = (20 == 20 ) && (15 >= 1) || (true == false) && (1 == 4);
        System.out.println ("(20 == 20 ) && (15 >= 1) || (true == false) && (1 == 4) = " + ageTest); 
        System.out.println("*****************************");  
       System.out.println("\n");

	// Bitwise Operators
        System.out.println("*****Bitwise Operators*****");
        int binMask = 0b1111;
        int binValue1 =  0b0011; 
        int binValue2 = 0b1100;
        int hexMask = 0x0004;
        int hexValue1 =  0x0008;      
        int hexValue2 =  0x000A;     
	// Apply the & to each bit
        System.out.println (" 0b0011 & 0b1111 = " + (binValue1 & binMask) );
        System.out.println (" ob1100 & 0b1111 = " + (binValue2 & binMask) );
       // Apply the | to each bit
        System.out.println ("0b0011 | 0b1111 = " + (binValue1 | binMask) );
        System.out.println ("0b1100 | 0b1111 = " + (binValue2 | binMask) );
       // Apply the & to each bit
        System.out.println ("0x0008 & 0x0004 = " + (hexValue1 & hexMask) );
        System.out.println ("0x0008 & 0x0004 = " + (hexValue2 & hexMask) );
       // Apply the | to each bit
       System.out.println ("0x000A | 0x0004 = " + (hexValue1 | hexMask) );
       System.out.println ("0x000A | 0x0004 = " + (hexValue2 | hexMask) );
       System.out.println("*****************************");  
       System.out.println("\n");

     }
}