/* Name: Hunter Cavazos
 * Date: 4/18/2022
 * Class: INFOC-211
 * Description: This program simulates a game designed to make the user
 * come up with words within 1 Hamiltonian Distance of the given word.
 * Generic array objects are instantiated within the driver class and
 * passed to this class for comparison. */
package lab9;

import java.util.ArrayList;								// Import ArrayList library
import java.util.Scanner;								// Import Scanner library

public class MyArrayTest {
    /* Acts as the driver for the program. Contains string array of predetermined
     * words for the program to choose from, instantiates a random String object
     * from sample() method, converts selected word to MyArray char array, 
     * */

    public static void main(String[] args) {
	// Driver method for program
	
	System.out.println("Welcome to the Hamiltonian Distance Game!");		// Intro prompt
	System.out.println("You will be given a word and must list as many"
		+ " possible words that are 1 Hamiltonian distance from"
		+ " the given word. Good luck!");

	Scanner input = new Scanner(System.in);						// Instantiate Scanner object

	int counter = 0;								// Initialize counter
	int dist = 1;									// Initialize dist

	String[] words = new String[] {"banana", "pineapple", "pitbull", 		// Initialize words array with word list
		"mousepad", "speakers", "chair", "baseball", "purple",
		"television", "commercial"};

	MyArray wordsArray = new MyArray(words);					// Instantiate MyArray object from words array

	String firstWord = (String) wordsArray.sample();				// Instantiate String object from random index from sample()

	Character[] firstArray = firstWord.chars().mapToObj(ch -> (char) ch)		// Instantiate Char array from firstWord
		.toArray(Character[]::new);

	MyArray first = new MyArray(firstArray);					// Instantiate first word object from firstArray Char array

	String secondWord;								// Instantiate secondWord String

	System.out.println("\nYour word is: \t" + firstWord);				// Output word selection

	while (dist == 1) {								// While dist != 1
	    System.out.print("Enter a word: ");						// Prompt user for word input
	    secondWord = input.next();							// Initialize secondWord from input

	    Character[] secondArray = (secondWord).chars().mapToObj(ch -> (char) ch)	// Instantiate Char array from secondWord
		    .toArray(Character[]::new);

	    MyArray second = new MyArray(secondArray);					// Instantiate second word object from secondWord Char array

	    dist = first.distance(second);						// Assign distance with return value from distance()

	    if (dist == 1)								// If dist = 1
		counter++;								// Increment score counter
	}

	System.out.println("Results: " + counter + " words.");				// Output results
    }
}
