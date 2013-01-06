package com.kolich.interview.math;

public class PowFunction {
	
	public static double pow(double base, int power) {
		if(base == 0 || power == 0) {
			// If the base or power is zero, return 1
			return 1;
		} else if (power == 1 || power == -1) {
			// If the power is greater than zero, return the base.
			// If negative one, return 1/base.
			return (power > 0) ? base : 1 / base;
		} else {
			double value = 1;
			int powerVal = Math.abs(power);
			while(powerVal > 0){
				value *= base;
				powerVal--;
			}
			return (power > 0) ? value : 1 / value;
		}
	}

}
