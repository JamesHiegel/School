/*
* File: TestLottery.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program contains simulates a 3, 4 or 5 pick lottery.
*/

import java.util.Scanner;


public class TestLottery {	
    public static void main(String[] args)  { 

	// Welcome Text
	System.out.println("Welcome to the lottery simulator.");
	System.out.println("This program contains simulates a 3, 4 or 5 pick lottery.");
	
	// Declare and initialize variables
	int gameType = 3;
	int numGames = 1;
	int playAgain = 2;
	int numSum = 0;
	int numPicked = 0;
	String pickResults = "";
	
	// Scanner class
	Scanner scannerIn = new Scanner(System.in);
	
	// Construct a lottery with range 0-9
	Lottery pickLotto = new Lottery(0,9);
	
	do{
	
	// Ask user what lotto to play
	do{
		System.out.println("Which lottery game do you want to play (Enter 3 for pick-3, 4 for pick-4 or 5 for pick-5)?");
		gameType = scannerIn.nextInt();
		if(gameType < 3 || gameType > 5){ //valid input check
			System.out.println("Please enter 3, 4 or 5.");
		}
	}while(gameType < 3 || gameType > 5);
	
	// Ask user how many games to play
	System.out.println("How many games would you like to play?");
	numGames = scannerIn.nextInt();
		if(numGames < 0){ //changes to 1 if less than 0
			numGames = 1;
		}

	// Print results
	System.out.println("Thank you! The numbers selected were:");
	for(int count = 1; count <= numGames; count++){
		for(int countTwo = 1; countTwo <= gameType; countTwo++){
			numPicked = pickLotto.getPicks();
			numSum = numSum + numPicked;
			pickResults = pickResults + numPicked + " ";
		}
		System.out.println(pickResults);
		pickResults = "";
	}
	
	System.out.println("The sum for all numbers picked was: " + numSum);

	
	System.out.println("Would you like to play again (Enter 1 for yes, 2 for no)?");
	playAgain = scannerIn.nextInt();
	
	}while(playAgain == 1);
	
	}
}