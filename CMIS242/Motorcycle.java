
/*
* File: Motorcycle.java
* Author: James Hiegel
* Class: CMIS 242
* Date: 1/17/2016
* Purpose: This class defines the Motorcycle object, and returns a string with all variables.
*/
public class Motorcycle {
	// Instance variables
	private int mYear, mEngineSize, mGears, mWheels;
	private String mMake, mModel, mString;
	
	// Constructor
	public Motorcycle (int yr, String mk, String mdl, int engSz, int grs) {
		mYear = yr;
		mMake = mk;
		mModel = mdl;
		mEngineSize = engSz;
		mGears = grs;
		mWheels = ThreeMotorcycles.numWheels;
	}
	public String toString(){
		return mString = mYear + " " + mMake + " " + mModel + " (" + mEngineSize + "cc, " + mGears + " speed, "
				+ mWheels + " wheels)";
	}
}
