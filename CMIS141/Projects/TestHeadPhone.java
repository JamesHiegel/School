/*
* File: Headphone.java
* Author: James Hiegel
* Date: 27 November 2015
* Purpose: This program simulates a headphone set.  The user inputs the brand 
* and model to creae the object.  Then the user can change the volume and plug
* or unplug the headphone set.
*/
package testheadphone;

public class TestHeadPhone {

    public static void main(String[] args) {
        // default
        HeadPhone defaultHeadset = new HeadPhone();
        System.out.println("Expected Output: black");
        System.out.println("Output: " + defaultHeadset.getHeadPhoneColor());
        System.out.println("Expected Output: unknown");
        System.out.println("Output: " + defaultHeadset.getManufacturer());
        System.out.println("Expected Output: 2");
        System.out.println("Output: " + defaultHeadset.getVolume());
        System.out.println("Expected Output: false");
        System.out.println("Output: " + defaultHeadset.getPluggedIn());
        defaultHeadset.setHeadPhoneColor("orange");
        defaultHeadset.setManufacturer("Walmart");
        defaultHeadset.setPluggedIn(true);
        defaultHeadset.changeVolume(1);
        System.out.println("Expected Output: A(n) orange Walmart headphone set "
                + "at volume 1 is plugged in.");
        System.out.println("Output: " + defaultHeadset.toString());
        System.out.println("");
        
        // red, Beats, volume 3, plugged in
        HeadPhone redBeats = new HeadPhone("red", "Beats", 3, true);
        System.out.println("Expected Output: red");
        System.out.println("Output: " + redBeats.getHeadPhoneColor());
        System.out.println("Expected Output: Beats");
        System.out.println("Output: " + redBeats.getManufacturer());
        System.out.println("Expected Output: 3");
        System.out.println("Output: " + redBeats.getVolume());
        System.out.println("Expected Output: true");
        System.out.println("Output: " + redBeats.getPluggedIn());
        redBeats.setHeadPhoneColor("blue");
        redBeats.setManufacturer("Skullcandy");
        redBeats.setPluggedIn(false);
        redBeats.changeVolume(2);
        System.out.println("Expected Output: A(n) blue Skullcandy headphone set "
                + "at volume 2 is not plugged in.");
        System.out.println("Output: " + redBeats.toString());
        System.out.println("");
        
        // white, Bose, volume 2, unplugged
        HeadPhone whiteBose = new HeadPhone("white", "Bose", 2, false);
        System.out.println("Expected Output: white");
        System.out.println("Output: " + whiteBose.getHeadPhoneColor());
        System.out.println("Expected Output: Bose");
        System.out.println("Output: " + whiteBose.getManufacturer());
        System.out.println("Expected Output: 2");
        System.out.println("Output: " + whiteBose.getVolume());
        System.out.println("Expected Output: false");
        System.out.println("Output: " + whiteBose.getPluggedIn());
        whiteBose.setHeadPhoneColor("green");
        whiteBose.setManufacturer("Sennheiser");
        whiteBose.setPluggedIn(true);
        whiteBose.changeVolume(1);
        System.out.println("Expected Output: A(n) green Sennheiser headphone set "
                + "at volume 1 is plugged in.");
        System.out.println("Output: " + whiteBose.toString());
    }  // close main method
    
}  // close TestHeadPhone class
