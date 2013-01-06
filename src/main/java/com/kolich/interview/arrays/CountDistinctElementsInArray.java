package com.kolich.interview.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountDistinctElementsInArray<T> {
	
	private Map<T, Integer> count_;
	
	public CountDistinctElementsInArray() {
		count_ = new HashMap<T, Integer>();
	}
	
	public void count(T[] t) {
		for(int i = 0; i < t.length; i++) {
			Integer count;
			if((count = count_.get(t[i])) != null) {
				count++;
			} else {
				// First time we've seen this element
				count = 1; // Autoboxing
			}
			count_.put(t[i], count);
		}
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer(); // Thread SAFE!!
		final Iterator<T> i = count_.keySet().iterator();
		while(i.hasNext()) {
			final T next = i.next();
			sb.append(next + " = " + count_.get(next) + "\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
		final CountDistinctElementsInArray<String> strings =
			new CountDistinctElementsInArray<String>();
		
		strings.count(new String[]{
			"dog", "cat", "bird", "cat", "dog", "fish", "elephant", "cat"
		});
		
		System.out.println(strings);
		
	}

}
