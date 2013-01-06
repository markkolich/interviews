package com.kolich.interview.arrays;

public class CompletelySorted2DArray {
	
	/*
	 * You have a [n * n] array which is sorted both row wise and
	 * column wise. How do you find an element in this array in O(n)
	 * time ?
	 */

	/*
	 * 1. Start from left bottom most cell. 
	 * 2. If query is larger move right.
	 * 3. If query is smaller move up.
	 * 4. If you can’t move right or up and haven't
	 * found the query yet, it means that the query does
	 * not exist.
	 */
	
	private static int[][] array1__ = new int[][]{
		{1, 2, 3, 4, 5},
		{6, 7, 8, 9, 10},
		{11, 12, 13, 14, 15}
	};
	
	public static void main(String[] args) {

		System.out.println(find(array1__, 4));
		System.out.println(find(array1__, 15));
		System.out.println(find(array1__, 11));
		System.out.println(find(array1__, 8));
		
	}
	
	public static int find(final int[][] array, final int find) {
		
		int x = 0, y = array.length-1;
		
		int index = array[y][x];
		while(index != find) {
			if(find > index) {
				x++;
			} else {
				y--;
			}
			index = array[y][x];
		}
		
		return index;
		
	}

}
