/*
* File: Headphone.java
* Author: James Hiegel
* Date: 27 November 2015
* Purpose: This program defines the HeadPhone class.  Each object has four 
* variables: volume, pluggedIn, manufacturer and headPhoneColor.
*/
package testheadphone;

public class HeadPhone {
// Class variables
final static int LOW = 1;
final static int MEDIUM = 2;
final static int HIGH = 3;

// Object variables
private int volume = MEDIUM;
private boolean pluggedIn = false;
private String manufacturer = "Unknown";
private String headPhoneColor = "black";
private String headPhoneStatus = "";
private String plugged = "";

// Constructors
public HeadPhone() {
}
public HeadPhone(String headPhoneColor, String manufacturer, int volume,
        boolean pluggedIn) {
    this.headPhoneColor = headPhoneColor;
    this.manufacturer = manufacturer;
    this.volume = volume;
    this.pluggedIn = pluggedIn;
}

// Setters
public void setHeadPhoneColor(String color) {
    this.headPhoneColor = color;
}
public void setManufacturer(String brand) {
    this.manufacturer = brand;
}
public void setPluggedIn(boolean plug) {
    this.pluggedIn = plug;
}
public void changeVolume(int vol) {
    switch(vol) {
        case 1 : {
            this.volume = LOW;
            break;
        }
        case 3 : {
            this.volume = HIGH;
            break;
        }
        default : this.volume = MEDIUM;
    }
}

// Getters
public String getHeadPhoneColor() {  // returns headphone color
    return this.headPhoneColor;
}
public String getManufacturer() {  // returns manufacturer
    return this.manufacturer;
}
public boolean getPluggedIn() {  // returns true/false for plugged in
    return this.pluggedIn;
}
public int getVolume() {  // returns 1,2 or 3 for volume
    return this.volume;
}
// returns a string describing the object
// example: "A red Beats headphone set at volume 2 is plugged in."
@Override
public String toString() {
    if (this.pluggedIn == true) {
        plugged = "plugged in.";
    } else plugged = "not plugged in.";
    headPhoneStatus = "A(n) " + this.headPhoneColor + " " + this.manufacturer +
            " headphone set at volume " + this.volume + " is " + plugged;
    return headPhoneStatus;
}

}  // close HeadPhone.class