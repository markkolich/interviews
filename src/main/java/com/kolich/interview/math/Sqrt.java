package com.kolich.interview.math;

public class Sqrt {

	public static void main(String[] args) {
		
		System.out.println(sqrt(9.0d));
		
		System.out.println(sqrtNewton(9.0d));

	}
	
	public static double sqrt(double x){
		double result = -1.0d, i = 0.0d;
		if(x > 0.0d) {
			// While i*i < x, increment i to find the value
			for(i = 0.0d; (i*i)<x; i++) {}
			i = i-1;
			// Total approximation at this point.
			// How accurate do you want to be?
			result = x / i;
			result = (result+i) / 2;
		}
		return result;
	}
	
	public static double sqrtNewton(double x){
        double result = -1.0d;
        if(x > 0.0d) {
        	double epsilon = 1e-15d;    // relative error tolerance
            double t = x;              // estimate of the square root of c
        	// repeatedly apply Newton update step until
            // desired precision is achieved
            while (Math.abs(t - x/t) > epsilon*t) {
                t = (x/t + t) / 2.0;
            }
            result = t;
        }        
        return result;
	}

}
