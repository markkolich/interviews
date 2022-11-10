package com.kolich.interview.other;
/*Given an array Of integers build a new array of integers such that every 2nd element of the array is greater than its left and right element. */

import java.util.Arrays;

public class Wave {
	//Function to swap 2 given elements
	public static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	//Swap the elements based on the elements. Make a note that the increment is by 2 numbers.
	public static void makeWave(int a[]) {
		for (int i = 1; i < a.length; i = i + 2) {
			if (a[i - 1] > a[i])
				swap(a, i - 1, i);
			if (i < a.length - 1 && a[i + 1] > a[i])
				swap(a, i + 1, i);
		}
	}

	public static void main(String args[]) {
		int a[] = { };
		System.out.println(Arrays.toString(a));
		makeWave(a);
		System.out.println(Arrays.toString(a));
	}
}
