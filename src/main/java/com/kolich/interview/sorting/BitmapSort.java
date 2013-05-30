package com.kolich.interview.sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class BitmapSort {

	public static void main(String[] args) throws Exception {
		
		// Any of the number read from the file must be less than 10,000,000
		int bitmap[] = new int[10000000];
		
		// Generate a set of random integers with no duplicates.
		int input[] = new int[1000000];
		for(int j = 0; j < bitmap.length-1; j++) {
			input[j] = j;
		}
		
		// Set all elements in the array to zero.
		Arrays.fill(bitmap, 0);
		
		// Read in file from disk and for each integer N
		// set the index N in the resulting array to 1.
		InputStream fis = null;
		BufferedReader r = null;
		try {
			fis = new FileInputStream(new File("sort.me"));
			r = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
			String line;
			while((line = r.readLine()) != null) {
				final int number = Integer.parseInt(line); // Might be a new line here at he end, fyi
				bitmap[number] = 1;
			}
		} finally {
			try {
				fis.close();
			} catch (Exception f) {}
			try {
				r.close();
			} catch (Exception g) {}
		}
		
		// Print out result.
		for(int i = 0; i < bitmap.length-1; i++) {
			if(bitmap[i] == 1) {
				// Found a valid number, print it out!
				System.out.println(bitmap[i]);
			}
		}
		
	}

}
