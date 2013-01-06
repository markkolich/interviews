package com.kolich.interview.arrays;

public class Print2DArraySpiral {

	private static void PrintInSpiral(int[][] num, int length) {
        int size = length-1;
        for (int i = 0; i < size; i++) {
            for (int k = i; k <= size-i; k++){
                System.out.println(num[i][k]);
            }
            for (int j = i+1; j <= size-i; j++){
                System.out.println(num[j][size-i]);
            }
            for (int k = size-i-1; k >= i; k--){
                System.out.println(num[size-i][k]);
            }
            for (int j = size-1-i; j > i; j--){
                System.out.println(num[j][i]);
            }
        }
    }
	
	public static void main(String[] args) {
		
		int[][] someArray = {
            { 1,  2,  3,  4,  5,  6 },
            { 7,  8,  9,  10, 11, 12 },
            { 13, 14, 15, 16, 17, 18 },
            { 19, 20, 21, 22, 23, 24 },
            { 25, 26, 27, 28, 29, 30 },
            { 31, 32, 33, 34, 35, 36 }
		  };

		PrintInSpiral(someArray, someArray.length);
		
	}

}
