/*
* File: TestKitchenOven.java
* Author: James Hiegel
* Date: 28 November 2015
* Purpose: This program simulates a kitchen oven.  Users can turn the oven on
* and off, change the temperature, put something in the oven, take something
* out and wait for the contents to cook.
 */

// these are for making dialog boxes
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestKitchenOven {

    public static void main(String[] args) {
        boolean quitGame = false;
        
        // Test constructors
        KitchenOven ovens[] = new KitchenOven[3];  // array of two ovens
        ovens[0] = new KitchenOven();  // default
        ovens[1] = new KitchenOven(true, "hot", "ham", "cooked");
        ovens[2] = new KitchenOven(false, "cold", "empty", "uncooked");
        
        // Test getters
            for (int c = 0 ; c <= KitchenOven.getNumOvens() ; c++) {
            System.out.println("Oven #"+ (c + 1));
            System.out.println("State: "+ ovens[c].getOvenState());
            System.out.println("Temp: "+ ovens[c].getOvenTemp());
            System.out.println("Contents: "+ ovens[c].getOvenContents());
            System.out.println("Ready?: "+ ovens[c].getIsCooked());
            System.out.println("");
        }
        // Test setters
        ovens[0].toggleOvenState();
        ovens[0].toggleOvenTemp();
        ovens[0].setOvenContents("pumpkin pie");
        ovens[0].toggleFoodCooked();
        
        ovens[1].toggleOvenState();
        ovens[1].toggleOvenTemp();
        ovens[1].setOvenContents("empty");
        ovens[1].toggleFoodCooked();
        
        for (int c = 0 ; c <= KitchenOven.getNumOvens() ; c++) {
            System.out.println("Oven #"+ (c + 1));
            System.out.println("State: "+ ovens[c].getOvenState());
            System.out.println("Temp: "+ ovens[c].getOvenTemp());
            System.out.println("Contents: "+ ovens[c].getOvenContents());
            System.out.println("Ready?: "+ ovens[c].getIsCooked());
            System.out.println("");
        }
        // Dialogs!
        JFrame frame = null;  // creates & initializes a empty frame
        String welcomeMessage = "Welcome to the Kitchen Oven Simulator.\nCook "
                + "your favorite meals in a virtual oven.";
        JOptionPane.showMessageDialog(frame, welcomeMessage);
        
        Object[] menuOptions = {"Toggle oven on/off", "Toggle oven hot/cold",
            "Put food in the oven", "Take food out of the oven",
            "Wait for the food in the oven to cook", "Quit"};
        
        do {  // open do loop
        String pickedOption = (String)JOptionPane.showInputDialog(frame,
                ovens[2].getOvenStatus() + "\n\nWhat would you like to do?", 
                "Kitchen Oven Simulator", JOptionPane.PLAIN_MESSAGE, null,
                menuOptions, "Toggle oven on/off");
            switch (pickedOption) {
                case "Toggle oven on/off":
                    ovens[2].toggleOvenState();
                    break;
                case "Toggle oven hot/cold":
                    ovens[2].toggleOvenTemp();
                    break;
                case "Put food in the oven":
                    String food = (String)JOptionPane.showInputDialog(frame,
                            "What are you putting in the oven?",
                            "Kitchen Oven Simulator", JOptionPane.PLAIN_MESSAGE, null,
                            null,null);
                    ovens[2].setOvenContents(food);
                    break;
                case "Take food out of the oven":
                    ovens[2].setOvenContents("empty");
                    ovens[2].toggleFoodCooked();
                    break;
                case "Wait for the food in the oven to "
                    + "cook":
                    ovens[2].toggleFoodCooked();
                    break;
                default:
                    quitGame = true;
                    break;
            }
        } while (!quitGame);  // close do loop
        
    }  // close main method
        
}  // close TestKitchenOven class