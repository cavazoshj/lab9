package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayTest {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	int counter = 0;
	int dist = 1;

	String[] words = new String[] {"banana", "pineapple", "pitbull", 
		"mousepad", "speakers", "chair", "baseball", "purple",
		"television", "commercial"};

	MyArray wordsArray = new MyArray(words);

	String firstWord = (String) wordsArray.sample();

	Character[] firstArray = firstWord.chars().mapToObj(ch -> (char) ch)
		.toArray(Character[]::new);

	MyArray first = new MyArray(firstArray);

	String secondWord;

	System.out.println("Your word is: \t" + firstWord);

	while (dist == 1) {
	    System.out.print("Enter a word: ");
	    secondWord = input.next();

	    Character[] secondArray = (secondWord).chars().mapToObj(ch -> (char) ch)
		    .toArray(Character[]::new);

	    MyArray second = new MyArray(secondArray);

	    try {
		dist = first.distance(second);

		if (dist == 1)
		    counter++;
	    }

	    catch (IndexOutOfBoundsException e) {
		System.out.println("Words must be of equal length.");

		System.out.print("Enter a word: ");
		secondWord = input.next();
	    }
	}

	System.out.println("Results: " + counter);

    }

}
