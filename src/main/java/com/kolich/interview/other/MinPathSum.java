package com.kolich.interview.other;

public class MinPathSum {
	public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
	// Calculate the sums in the 0th row and column since there is only one path
        for (int x = 1; x <n; x++) {
            grid[0][x] += grid[0][x - 1];
        }
        
        for (int y = 1; y <m ; y++) {
            grid[y][0] += grid[y - 1][0];
        }
        
	// Calculate the minimum sum in the rest of the array
        for (int x = 1; x < n; x++) {
            for (int y = 1; y < m; y++) {
		// Take the minimum of either the left or top adjacent element
                grid[y][x] += Math.min(grid[y][x - 1], grid[y - 1][x]);
            }
        }
        //return grid[n-1][m-1];
        System.out.print(grid[m-1][n-1]);
        return 0;
        
    }
	
	public static void main(String args[]) {
		int [][] grid = {
				{1,3,1},
				{3,2,1}
				//{4,2,1}
		}; 
		minPathSum(grid);
	}
	}