/*
* File: Motorcycle.java
* Author: James Hiegel
* Date: 11/15/2015
* Purpose: This program contains the Motorcycle class,
* constructors, setters, getters and other methods.
*/

public class Motorcycle {    
    private int mGears;
	private String mMake;
	private String mModel;
	private int mYear;
   
    // Constructor
    public Motorcycle (String mak, String mod, int yr, int gr) { 
	mMake = mak;
	mModel = mod;
	mYear = yr;
	mGears = gr;
    }

   // Default constructor
    public Motorcycle () {		
	mMake = "Harley-Davidson";
	mModel = "Softtail";
	mYear = 2015;
	mGears = 6;     
    }
    
    // Setter methods 
    // setMake
    public void setMake(String mak) {
	mMake = mak;
    }
    // setModel
    public void setModel(String mod) {
	mModel = mod;
	}
	// setYear
    public void setYear(int yr) {
	mYear = yr;
	}
	// setGears
    public void setGears(int gr) {
	mGears = gr;
    }
	
   // Getter methods
   // getMake
    public String getMake() {
	return mMake;
    }    
   // getModel
    public String getModel() {
	return mModel;
    }  
	// getYear
    public int getYear() {
	return mYear;
    }  
	// getGears
    public int getGears() {
	return mGears;
    }  
}