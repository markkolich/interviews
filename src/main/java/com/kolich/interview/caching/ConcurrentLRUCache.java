package com.kolich.interview.caching;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLRUCache<K, V> {

	private final int maxSize_;

	private final Map<K, V> map_;
	private final Queue<K> queue_;

	public ConcurrentLRUCache(final int maxSize) {
	    maxSize_ = maxSize;
	    map_ = new ConcurrentHashMap<K, V>(maxSize);
	    // This queue orders elements FIFO (first-in-first-out). The head
	    // of the queue is that element that has been on the queue the longest
	    // time. The tail of the queue is that element that has been on the
	    // queue the shortest time. 
	    queue_ = new ConcurrentLinkedQueue<K>();
	}

	/**
	 * @param key - may not be null!
	 * @param value - may not be null!
	 */
	public void put(final K key, final V value) {
	    if (map_.containsKey(key)) {
	        queue_.remove(key); // remove the key from the FIFO queue
	    }

	    while (queue_.size() >= maxSize_) {
	        K oldestKey = queue_.poll();
	        if (null != oldestKey) {
	            map_.remove(oldestKey);
	        }
	    }
	    queue_.add(key);
	    map_.put(key, value);
	}

	/**
	 * @param key - may not be null!
	 * @return the value associated to the given key or null
	 */
	public V get(final K key) {
	    return map_.get(key);
	}

}
