/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

/*
 * File: DateTime.java
 * Author: Dr. Robertson
 * Date: January 1, 2015
 * Purpose: This program demonstrates
 * the use of the classes in the
 * java.time package
 */
public class DateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Use LocalDate Class
        // now() uses current local date
        LocalDate date = LocalDate.now();

        // get Year, Julian day of year
        // and Day of Month
        int year = date.getYear();
        int yearDay = date.getDayOfYear();
        int monthDay = date.getDayOfMonth();

        // Print results
        System.out.println("Year is " + year);
        System.out.println("Julian day is " + yearDay);
        System.out.println("Day of month is " + monthDay);

        // Use plus method        
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(4));

        // Use of method and loop
        // to determine leap years
        for (int i = 1990; i < 2025; i++) {
            boolean isLeap = Year.of(i).isLeap();
            if (isLeap) {
                System.out.println(i + " is a Leap year");
            }
        }
        // Experment with LocalTime
        LocalTime thisSec;
        // Initialize to now
        thisSec = LocalTime.now();
        // Display the hour and LocalTime
        System.out.println("time is " + thisSec.getHour() + 
                "," + thisSec);

        // Date and Time
        // This uses both Date and time
        LocalDateTime thisDate;
        // now() method is useful for all
        thisDate = LocalDateTime.now();
        // get methods are available
        System.out.println("Time Data: " + thisDate.getHour() + ":" + thisDate.getMinute()
                + ":" + thisDate.getSecond());
        // plus methods are available for checking dates in future
        System.out.printf("now: %s%n", LocalDateTime.now() + ","
                + LocalDateTime.now().plusMonths(24).plusDays(5));
    }

}
