package com.kolich.interview.other;

/*
 * A program based on DP to get the minimum number of coins required to make an ammount
 * ex [1,2,3] and 4 ans =2;
 * 
 * */

import java.util.*;

public class CoinChange {
	public static int minCoins(int[] coins, int total) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<Integer>();
		int ans = minCoins(coins, total, map, list);
		System.out.println("Coins used:" + list);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}



	public static int minCoins(int[] coins, int total,
			Map<Integer, Integer> map, List<Integer> list) {
		if (total <= 0){
			return total;
		}
			
		if (map.containsKey(total))
			return map.get(total);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= total) {

				int val = minCoins(coins, total - coins[i], map, new ArrayList<Integer>(list));
				if (val < min) {
					min = val;
					list.add(coins[i]);
				}

			}
		}
		if(min==Integer.MAX_VALUE)
		{
			list.clear();
		}
		else
			min+=1;
		map.put(total, min);
		
		return min;
	}

	public static void main(String args[]) {
       int[] coins = new int[]{1, 5, 10, 25};
       int target = 46;
       System.out.println(minCoins(coins, target));
	}
}
