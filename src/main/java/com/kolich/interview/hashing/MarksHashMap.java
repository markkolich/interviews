package com.kolich.interview.hashing;

@SuppressWarnings({"rawtypes","unchecked"}) // ZOMG
public final class MarksHashMap<K,V> {

	static class Entry<K,V> {
		private final K key_;
		private final V value_;
		private Entry<K,V> next_;
		public Entry(K key, V value) {
			key_ = key;
			value_ = value;
			next_ = null;
		}
		public final K getKey() {
			return key_;
		}
		public final V getValue() {
			return value_;
		}
	}
	
	private static final int HASHMAP_SIZE = 128;	
	
	private final Entry[] bucket_;
	
	public MarksHashMap() {
		bucket_ = new Entry[HASHMAP_SIZE];
	}
	
	public void put(K key, V value) {
		final int index = bucketIndexForKey(key);
		if(bucket_[index] == null) {
			bucket_[index] = new Entry<K,V>(key, value);
		} else {
			Entry<K,V> entry = bucket_[index];
			while(entry.next_ != null) {
				entry =  entry.next_;
			}
			entry.next_ = new Entry<K,V>(key, value);
		}
	}
	
	public V get(K key) {
		Entry<K,V> entry = bucket_[bucketIndexForKey(key)];
		while(entry != null && !key.equals(entry.key_)) {
			entry = entry.next_;
		}
		return entry != null ? entry.value_ : null;
	}
	
	private final int bucketIndexForKey(K key) {
		final int hash = key.hashCode();
		return (hash & 0x7FFFFFFF) % bucket_.length; // Bitmask, bye bye negatives
	}

	public static void main(String[] args) {
				
		final MarksHashMap<String,Integer> map = new MarksHashMap<String,Integer>();
		
		map.put("foobar", 1);
		map.put("foobar", 2);
				
		map.put("baz", 3);
		
		map.get("foobar");

	}

}