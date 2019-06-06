/*
* File: KitchenOven.java
* Author: James Hiegel
* Date: 28 November 2015
* Purpose: This program defines the KitchenOven class.  Each object has the
* following variables: ovenState, ovenTemp, and ovenContents.  There are setter
* and getter methods for each variable. The ovenStatus method returns a string 
* combining all the variables.
 */
// Class imports

public class KitchenOven {
    // Class variables
    private static int numOvens = 0;
    // Object variables
    private boolean ovenState = false;
    private String ovenTemp = "cold";
    private String ovenContents = "empty";
    private String isCooked = "uncooked";
    private String isOn = "";
    private String ovenStatus = "";

    // Constructors
    public KitchenOven() {  // default, no argument constructor
    }
    // full constructor
    public KitchenOven(boolean state, String temp, String contents, 
            String cooked) {
        this.ovenState = state;
        this.ovenTemp = temp;
        this.ovenContents = contents;
        this.isCooked = cooked;
        numOvens++;
    }
    
    // Methods
    // Setters
    public void toggleOvenState() {  // toggles oven on/off
        if (this.ovenState == false) {
            this.ovenState = true;
        } else if (this.ovenState == true) {
            this.ovenState = false;
        }
    }
    public void toggleOvenTemp() {  // toggles oven hot/cold
        if ("hot".equals(this.ovenTemp)) {
            this.ovenTemp = "cold";
        } else this.ovenTemp = "hot";
    }
    public void setOvenContents(String contents) {  // changes oven contents
        this.ovenContents = contents;
    }
    public void toggleFoodCooked() {  // toggles food cooked/uncooked
        if (this.isCooked.equals("uncooked")) {
            this.isCooked = "cooked";
        } else this.isCooked = "uncooked";
    }
    
    // Getters
    public boolean getOvenState() {  // returns oven state (on/off)
        return this.ovenState;
    }
    public String getOvenTemp() {  // returns oven temp
        return this.ovenTemp;
    }
    public String getOvenContents() {  // returns oven contents
        return this.ovenContents;
    }
    public String getIsCooked() {  // returns food state
        return this.isCooked;
    }
    public String getOvenStatus() {
        isOn = (this.ovenState == true) ? "on" : "off";
        ovenStatus = "The oven is " + isOn + ", " + this.ovenTemp + 
                " and contains a " + this.isCooked + " " + this.ovenContents;
        return ovenStatus;
    }
    public static int getNumOvens() {
        return numOvens;
    }
}
