package com.kolich.interview.other;
import java.util.*;

public class SumOfSquares {
	public static ArrayList<ArrayList<Integer>> returnPairs(int x) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pairs = new ArrayList<Integer>();
		HashSet<Integer> st = new HashSet<Integer>();
		for (int i = 0; i <= (int) Math.sqrt(x); i++) {
			double k = Math.sqrt(x - (i * i));
			int z = -1;
			if (k % (int) k == 0 || k == 0.0) {// Checks if it is a perfect square
				z = (int) k;
			}
			if (z != -1 && st.contains(z)) {
				pairs.add(i);
				pairs.add(z);
				ans.add(pairs);
			} else
				st.add(i);
			if (pairs.size() != 0)
				pairs = new ArrayList<Integer>();

		}
		return ans;

	}

	public static void main(String args[]) {
		int x = 10000;
		ArrayList<ArrayList<Integer>> ans = returnPairs(x);
		System.out.println(ans);

	}
}
