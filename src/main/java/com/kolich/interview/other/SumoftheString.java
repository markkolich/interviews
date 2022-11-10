package com.kolich.interview.other;
import java.util.*;

/*
 * Assume a=1 b=2 c=3... z=26.
 * This program sorts strings given on the count
 * for ex az=27>ab=3.
 * If two or more strings have the same count, it sorts them using the lexicographic value of the string
 * */
class Word implements Comparable<Word> {// Class to implement a custom
										// comparison
	String w;
	int c;

	Word(String w, int c) {
		this.w = w;
		this.c = c;
	}

	/*
	 * This method sorts in descending order of counts of the word. Eg:
	 * "az","ab" if ascending sort is required change the < sign to >
	 */
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		if (this.c < o.c)
			return 1;
		else
			return -1;

	}

	public String toString() {
		return this.w + " " + this.c;
	}

}

public class SumoftheString {
	static int sum(String t) {
		int sum = 0;
		for (int i = 0; i < t.length(); i++) {
			sum = sum + t.charAt(i) - 'a' + 1;// Get the sum assuming all are
												// lowercase input. This must be
												// confirmed with the interview
												// first
		}
		return sum;
	}

	static String[] count(String[] ip) {
		if (ip.length == 0)
			return ip;// Blank input
		else {
			String[] op = new String[ip.length];// output should be of the same
												// length as input
			List<Word> arr = new ArrayList<Word>();
			for (int i = 0; i < ip.length; i++) {
				String t = ip[i];
				int c = sum(t);
				arr.add(new Word(t, c));
			}

			Collections.sort(arr); // This will use the comparator we defined.

			// System.out.println(arr);
			/*
			 * If strings are not to be sorted lexicographically We can put the
			 * value of arr in op and return
			 */
			// This part is for lexicographically sorting the equal count
			// strings
			int x = 0;
			for (int i = 1; i < arr.size(); i++) {
				if (arr.get(i).c != arr.get(i - 1).c) {
					if (i != arr.size() - 1)
						op[x] = arr.get(i - 1).w;// Makes sure you don't get
													// arrayindex out of bound
					else
						op[x] = arr.get(i).w;// Takes care of the last element
					x++;
				} else {
					List<String> tmp = new ArrayList<String>();

					while (i < arr.size() && arr.get(i - 1).c == arr.get(i).c) {
						tmp.add(arr.get(i - 1).w);
						i++;

					}
					// If this is the end of the loop
					// get the last element which
					// will be n-1
					tmp.add(arr.get(i - 1).w);
					i = i - 1;// We incremented i one extra time in the while
								// loop
					Collections.sort(tmp);// This sort is done using default
											// string lexicographic sorting
					// If the result is supposed to lex greater first then
					// reverse this tmp using Collections.reverse(tmp);

					for (String z : tmp) {
						op[x] = z;
						x++;
					}
				}
			}
			return op;
		}
	}

	public static void main(String args[]) {
		String[] ip = { "acb", "cab", "abc", "az", "lizzie", "bonnie" };
		System.out.println(Arrays.toString(count(ip)));
	}
}
