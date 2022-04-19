/* Name: Hunter Cavazos
 * Date: 4/18/2022
 * Class: INFOC-211
 * Description: This program simulates a game designed to make the user
 * come up with words within 1 Hamiltonian Distance of the given word.
 * Generic array objects are instantiated within the driver class and
 * passed to this class for comparison. */
package lab9;

import java.util.ArrayList;								// Import ArrayList library
import java.util.Random;								// Import Random library

public class MyArray<T> {
    /* Contains the MyArray attributes for a static random variable as well
     * as the store ArrayList object. Includes a constructor and methods
     * to calculate Hamiltonian distance and random index generation from
     * the given list of words. This class accepts type T generic parameters.*/
    
    static Random rand = new Random();							// Instantiate static Random attribute

    ArrayList<T> store = new ArrayList<>();						// Instantiate store ArrayList

    public MyArray(T[] arrayCopy) {
	// Constructor for MyArray objects, accepting type T arrays

	for (int i = 0; i < arrayCopy.length; i++)					// Traverse parameter array
	    store.add(arrayCopy[i]);							// Append to store arraylist
    }

    public int distance(MyArray other) {
	// Accepts object of MyArray type and calculates Hamiltonian distance

	int distance = Math.abs((this.store.size() - other.store.size()));		// Initialize distance with difference between
											// both arrays
	for (int i = 0; i < Math.min(this.store.size(), other.store.size()); i++) {	// Traverse the smaller array
		if(!this.store.get(i).equals(other.store.get(i)))			// If elements are different
		    distance++;								// Increment distance
	}

	return distance;								// Return distance
    }

    public T sample() {
	// Generates a random element from the store array
	
	int random = rand.nextInt(store.size());					// Initialize random value between 0 and array size

	return store.get(random);							// Return random index
    }
}
