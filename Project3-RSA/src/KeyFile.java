/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * Block class
 * This is the class that will allow the RSA computation to deal with smaller numbers
 */

//TODO: NOTE: Assuming that a KeyFile is composed of a 2 HUI's, one per line, in a text file. This means it can be read using the same methods as ResourceFile.

import java.io.IOException;

public class KeyFile extends ResourceFile {

	public KeyFile(String path) throws IOException {
		super(path);
		if (primes.size() > 2) {
			throw new IOException("Incorrect file specified!");
		}
	}
	
	public HUI getPrime1() {
		return primes.get(0);
	}
	public HUI getPrime2() {
		return primes.get(1);
	}
	
}
