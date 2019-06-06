/*
* File: TestCourse.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the Course class
*/

public class TestCourse {	
    public static void main(String[] args)  { 

	// Construct a default Course
        Course course001 = new Course();

	// Call the get values
	System.out.println("course 001 name is: " + 
                course001.getCourseName());
        System.out.println("course 001 num students is: " + 
               course001.getNumStudents());
	System.out.println("number courses is: " + 
                Course.getNumCourses());

	// Construct a Specific course
        Course course002 = new Course(28,"CMSC 101");

	// Call the get values
	System.out.println("course 002 name is: " + 
                course002.getCourseName());
        System.out.println("course 002 num students is: " + 
               course002.getNumStudents());
	System.out.println("number courses is: " + 
                Course.getNumCourses());

	// Construct a Specific course
       // Using partial constructor
        Course course003 = new Course(45);

	// Call the get values
	System.out.println("course 003 name is: " + 
                course003.getCourseName());
        System.out.println("course 003 num students is: " + 
               course003.getNumStudents());
	System.out.println("number courses is: " + 
                Course.getNumCourses());

	// Construct a Specific course
       // Using partial constructor
        Course course004 = new Course("CMIS242");

	// Call the get values
	System.out.println("course 004 name is: " + 
                course004.getCourseName());
        System.out.println("course 004 num students is: " + 
               course004.getNumStudents());
	System.out.println("number courses is: " + 
                Course.getNumCourses());

    }

}