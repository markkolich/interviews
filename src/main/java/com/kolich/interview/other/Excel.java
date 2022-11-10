package com.kolich.interview.other;

/*
 * Given a column number in Excel get the Alphabetical notation
 * and vice versa 
 * eg 27->AA
 * AA->27
 * */
public class Excel {
	public static String numberToString(int n) {
		if (n <=0)
			return "0";
		n = n - 1;
		String ans = "";
		int mod;
		while (true) {
			mod = n % 26;
			n = n / 26;
			ans = (char) (mod + 'A') + ans;
			if (n > 0)
				n--;
			else if (n == 0)
				break;
		}

		return ans;
	}

	public static String stringToNumber(String s) {
		String ans = "";
		if (s.isEmpty() || s.equals("0")|| s.charAt(0)=='-')
			return "0";
		else {
			int x = 0;
			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i) - 'A' + 1;
				x = x * 26 + c;
			}
			ans = Integer.toString(x);
		}
		return ans;
	}

	public static void main(String args[]) {
		int x = 55;
		String ans = numberToString(x);
		System.out.println(ans);
		System.out.println(stringToNumber(ans));
	}

}
