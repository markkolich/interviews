package com.kolich.interview.other;
//Program to print a pascal triangle iteratively or recursively

public class Pascal {
	public static void main(String args[]) {
		int x = 3;
		int triangle[][] = new int[x][x];
		String s = "   ";
		for (int i = 0; i < x; i++) {
			triangle[i][0] = 1;
		}
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < x; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < (x - i - 1); j++) {
				System.out.print(s);
			}
			for (int j = 0; j <= i; j++) {

				System.out.print(triangle[i][j] + s + s);

			}

			System.out.println();

		}

	/*	 Normal printing
		 for(int i=0;i<x;i++)
		 {
		 for(int j=0;j<=i;j++)
		 System.out.print(triangle[i][j]);
		 System.out.println();
		 }*/
		System.out.println("This will print it recursively");

		for (int k = 0; k < 5; k++) {
			for (int j = 0; j < k; j++)
				System.out.print(recPascal(k, j) + " ");
			System.out.println();
		}

	}

	static int recPascal(int row, int col) {
		int val1, val2;
		if (row == 0 || col == 0 || row == col + 1)
			return 1;
		else {
			val1 = recPascal(row - 1, col - 1);
			val2 = recPascal(row - 1, col);
			return val1 + val2;
		}
	}
}