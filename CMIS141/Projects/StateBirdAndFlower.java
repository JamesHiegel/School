/*
* File: StateBirdAndFlower.java
* Author: James Hiegel
* Date: 06 December 2015
* Purpose: This program will display the State bird and flower for the user 
* entered State.  The user State name is not case sensitive and leading or 
* trailing white spaces will be ignored.
*/
package statebirdandflower;

import java.util.Scanner;

public class StateBirdAndFlower {

    public static void main(String[] args) {
        // Declare and initialize variables
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        boolean found = false;
        
        String[][] birdAndFlower = {{"Alabama", "Yellowhammer", "Camellia"},
            {"Alaska", "Willow Ptarmigan", "Forget-me-not"},
            {"Arizona", "Cactus Wren", "Saguaro Cactus Blossom"},
            {"Arkansas", "Mockingbird", "Apple Blossom"},
            {"California", "California Valley Quail", "Golden Poppy"},
            {"Colorado", "Lark Bunting", "Columbine"},
            {"Connecticut", "American Robin", "Mountain Laurel"},
            {"Delaware", "Blue Hen Chicken", "Peach Blossom"},
            {"Florida", "Mockingbird", "Orange Blossom"},
            {"Georgia", "Brown Thrasher", "Cherokee Rose"},
            {"Hawaii", "Nene (Hawaiian Goose)", "Hibiscus"},
            {"Idaho", "Mountain Bluebird", "Syringa"},
            {"Illinois", "Cardinal", "Native violet"},
            {"Indiana", "Cardinal", "Peony"},
            {"Iowa", "Eastern Goldfinch", "Wild Rose"},
            {"Kansas", "Western Meadowlark", "Native Sunflower"},
            {"Kentucky", "Kentucky Cardinal", "Goldenrod"},
            {"Louisiana", "Pelican", "Magnolia"},
            {"Maine", "Chickadee", "White Pine Cone and Tassel"},
            {"Maryland", "Baltimore Oriole", "Black-Eyed Susan"},
            {"Massachusetts", "Chickadee", "Mayflower"},
            {"Michigan", "Robin", "Apple Blossom"},
            {"Minnesota", "Common Loon", "Pink and White Lady's Slipper"},
            {"Mississippi", "Mockingbird", "Magnolia"},
            {"Missouri", "Bluebird", "Hawthorn"},
            {"Montana", "Western Meadowlark", "Bitterroot"},
            {"Nebraska", "Western Meadowlark", "Goldenrod"},
            {"Nevada", "Mountain Bluebird", "Sagebrush"},
            {"New Hampshire", "Purple Finch", "Purple Lilac"},
            {"New Jersey", "Eastern Goldfinch", "Purple Violet"},
            {"New Mexico", "Roadrunner", "Yucca Flower"},
            {"New York", "Bluebird", "Rose"},
            {"North Carolina", "Cardinal", "Dogwood"},
            {"North Dakota", "Western Meadowlark", "Wild Prairie Rose"},
            {"Ohio", "Cardinal", "Scarlet Carnation"},
            {"Oklahoma", "Scissor-Tailed Flycatcher", "Mistletoe"},
            {"Oregon", "Western Meadowlark", "Oregon Grape"},
            {"Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
            {"Rhode Island", "Rhode Island Red", "Violet"},
            {"South Carolina", "Carolina Wren", "Yellow Jessamine"},
            {"South Dakota", "Ring-Necked Pheasant", "American Pasqueflower"},
            {"Tennessee", "Mockingbird", "Iris"},
            {"Texas", "Mockingbird", "Bluebonnet"},
            {"Utah", "California Gull", "Sego Lily"},
            {"Vermont", "Hermit Thrush", "Red Clover"},
            {"Virginia", "Cardinal", "Dogwood"},
            {"Washington", "Willow Goldfinch", "Western Rhododendron"},
            {"West Virginia", "Cardinal", "Big Rhododendron"},
            {"Wisconsin", "Robin", "Wood Violet"},
            {"Wyoming", "Meadowlark", "Indian Paintbrush"}};
       
        // Welcome message
        System.out.println("Welcome to the State bird and flower index.");
        
        // Main loop
        do {
            // User prompt
            System.out.println("Enter a State or None to exit:");
            userInput = scan.nextLine().trim();
            for (int i = 0 ; i < 50 ; i++) {
                if (userInput.equalsIgnoreCase(birdAndFlower[i][0])) {
                    System.out.println("State bird: " + birdAndFlower[i][1]);
                    System.out.println("Stare flower: " + birdAndFlower[i][2]);
                    found = true;  // sets found flag to true
                    break;  // stops the search loop once found
                } else found = false;
            }
            if (found == false && (userInput.compareToIgnoreCase("None") != 0)) {
                System.out.println("Invalid option entered."); // error message
            }
        } while (userInput.compareToIgnoreCase("None") != 0);  // close main loop

    } // close main method
    
} // close class
