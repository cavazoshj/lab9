package lab9;

import java.util.ArrayList;
import java.util.Random;

public class MyArray<T> {
    
    static Random rand = new Random();

    ArrayList<T> store = new ArrayList<>();

    public MyArray(T[] arrayCopy) {

	for (int i = 0; i < arrayCopy.length; i++)
	    store.add(arrayCopy[i]);
    }

    public int distance(MyArray other) {

	int distance = (this.store.size() - other.store.size());

	for (int i = 0; i < this.store.size(); i++) {
		if(!this.store.get(i).equals(other.store.get(i)))
		    distance++;
	}

	return distance;
    }

    public T sample() {
	
	int random = rand.nextInt(store.size());

	return store.get(random);

    }
}
