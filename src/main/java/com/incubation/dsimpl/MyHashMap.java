package com.incubation.dsimpl;

public class MyHashMap<K, V> {

	private Entry<K, V>[] buckets;

	private static final int INITIAL_CAPACITY = 1 << 4;

	private int size = 0;

	public MyHashMap() {
		this(INITIAL_CAPACITY);
	}

	public MyHashMap(int initialCapacity) {
		buckets = new Entry[initialCapacity];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("map->");
		for(Entry<K, V> entry : this.buckets) {
			while(entry!=null) {
				sb.append("{"+entry.key+":"+entry.value+"}");
				entry = entry.next;
			}
		}
		return sb.toString();
	}

	public void put(K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value, null);
		int bucketIndex = key.hashCode() & (INITIAL_CAPACITY - 1);

		Entry<K, V> head = buckets[bucketIndex];
		if (head == null) {
			head = entry;
			size++;
		} else {
			while (head.next != null) {
				if (head.key.equals(key)) {
					head.value = value;
					return;
				}
				head = head.next;
			}
			if (head.key.equals(key)) {
				head.value = value;
				return;
			} else {
				head.next = entry;
				size++;
			}
		}
	}
	
	public V get(K key) {
		int bucketIndex = key.hashCode()&(INITIAL_CAPACITY-1);
		Entry<K, V> head = buckets[bucketIndex];
		
		if(head != null){
			while(head!=null) {
				if(head.key.equals(key)) {
					return head.value;
				}
				head = head.next;
			}
		}
		return null;
	}
	
	public void remove(K key) {
		int bucketIndex = key.hashCode()&(INITIAL_CAPACITY-1);
		Entry<K, V> head = buckets[bucketIndex];
		
		if(head != null){
			while(head.next!=null) {
				if(head.next.key.equals(key)) {
					head.next = head.next.next;
					return ;
				}
				head = head.next;
			}
			if(head.key.equals(key)) {
				head = null;
			}
		}
		 
	}
}

class Entry<K, V> {
	K key;
	V value;
	Entry<K, V> next;

	Entry(K key, V value, Entry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}