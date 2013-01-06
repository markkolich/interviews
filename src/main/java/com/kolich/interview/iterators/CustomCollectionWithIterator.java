package com.kolich.interview.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomCollectionWithIterator<T> implements Iterable<T> {
	
	public List<T> list_;
	
	public CustomCollectionWithIterator() {
		list_ = new ArrayList<T>();
	}

	private class CustomCollectionIterator<I> implements Iterator<T> {
		
		private CustomCollectionWithIterator<T> collection_;
		
		// Index of where we are at in the underlying list.
		private int index_ = 0;
		
		// The actual "next" item
		private T next_ = null;
		
		private CustomCollectionIterator(CustomCollectionWithIterator<T> c) {
			collection_ = c;
			// Find the first instance of what we're looking for.
			calcNext();
		}

		@Override
		public boolean hasNext() {
			return next_ != null;
		}

		@Override
		public T next() {
			final T next = next_;
			// Find the next instance of what we're looking for.
			calcNext();
			return next;
		}

		@Override
		public void remove() { }
		
		private void calcNext() {
			boolean found = false;
			// While the item of type String was not found in the list, and
			// the current index we're looking at is less than the size of
			// the underlying collection, keep going.
			while(!found && index_ < collection_.list_.size()) {
				final T obj;
				if((obj = collection_.list_.get(index_)) instanceof String) {
					next_ = obj;
					found = true;
				}
				index_++;
			}
			// If we scanned the entire list and nothing was found, then "next"
			// is null meaning we're done.
			if(!found) {
				next_ = null;
			}
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CustomCollectionIterator<T>(this);
	}
	
	public static void main(String[] args) {
		final CustomCollectionWithIterator<Object> c = new CustomCollectionWithIterator<Object>();
		c.list_.add("Dog");
		c.list_.add(new Integer(23));
		c.list_.add("Cat");
		
		for(final Object o : c) {
			final String s = (String)o;
			System.out.println(s);
		}
	}
	
}
