package com.kolich.interview.math;

public class AllPairsThatMultiplyToNumber {

	public static void main(String[] args) {
		printFactors(21);
	}

	public static void printFactors(int n) {
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				System.out.println("" + (n / i) + "*" + i);
			}
		}
	}

}
