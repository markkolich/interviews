package com.kolich.interview.other;

//Given a sorted array Find the number of occurences of a given number using binary search. Returns -1 if number not found
public class Occur {

	public static int count(int a[], int x) {
		int i, j, n;
		n = a.length - 1;
		i = first(a, 0, n, x);
		if (i == -1)
			return i;
		j = last(a, i, n, x);
		System.out.println(i + " " + j);
		return j - i + 1;
	}

	static int first(int a[], int left, int right, int x) {
		if (left <= right) {
			int mid = left+((right-left) / 2);
			if (mid == 0 || x > a[mid - 1] && x == a[mid])
				return mid;
			else {
				if (x > a[mid])
					return first(a, mid + 1, right, x);
				else
					return first(a, left, mid - 1, x);
			}
		}

		return -1;

	}

	static int last(int a[], int left, int right, int x) {
		if (left <= right) {
			int mid = left+((right-left) / 2);
			if (mid == a.length - 1 || x < a[mid + 1] && x == a[mid])
				return mid;
			else {
				if (x < a[mid])
					return last(a, left, mid - 1, x);
				else
					return last(a, mid + 1, right, x);
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int a[] = { 1, 1, 1, 1, 2, 2 };
		int n = count(a, 1);
		System.out.println(n);

	}
}
