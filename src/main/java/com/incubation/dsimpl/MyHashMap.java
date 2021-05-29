package com.incubation.dsimpl;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyHashMap<Key, Value> {
	private MapNode<Key, Value>[] bucket;
	private int INITIAL_CAPACITY;
	private int size;

	public MyHashMap() {
		this(15);
	}

	public MyHashMap(int INITIAL_CAPACITY) {
		this.INITIAL_CAPACITY = INITIAL_CAPACITY;
		bucket = new MapNode[INITIAL_CAPACITY];
	}

	public void put(Key k, Value v) {
		Entry<Key, Value> entry = new Entry<>(k, v);
		MapNode<Key, Value> node = new MapNode<>(k, entry, null);
		int index = getBucketIndex(k);
		if (this.bucket[index] == null) {
			this.bucket[index] = node;
			this.size++;
			return;
		} else {
			MapNode<Key, Value> head = this.bucket[index];
			if (head.key.equals(k)) {
				this.bucket[index] = node;
				node.next = head.next;
				this.size++;
				return;
			}
			while (head.next != null) {
				if (k.equals(head.next.key)) {
					MapNode<Key, Value> next = head.next.next;
					head.next = node;
					node.next = next;
					this.size++;
					return;
				}
			}

			head.next = node;
			this.size++;

		}
	}

	private int getBucketIndex(Key k) {
		return k.hashCode() % INITIAL_CAPACITY;
	}
	
	public int size() {
		return this.size;
	}
	
	public void remove(Key k) {
		int index = getBucketIndex(k);
		MapNode<Key, Value> head = this.bucket[index];
		if(head.key.equals(k)) {
			head = head.next;
			this.bucket[index] = head;
			this.size--;
			return;
		}
		MapNode<Key, Value> prev = head;
		head = head.next;
		
		while(head!=null) {
			if(head.key.equals(k)) {
				prev.next = head.next;
				this.size--;
				return;
			}
			prev = head;
			head = head.next;
		}
		System.out.println("Element Not Present");
	}
	
	public Value get(Key k) {
		int index = getBucketIndex(k);
		MapNode<Key, Value> head = this.bucket[index];
		
		while(head!=null) {
			if(k.equals(head.key)) {
				return head.entry.getValue();
			}
			head = head.next;
		}
		System.out.println("Element Not Present");
		return null;
	}

	Predicate<MapNode<Key, Value>> isNotNull = node->node!=null;
	
	Consumer<MapNode<Key, Value>> print = node-> {
		while(node!=null) {
			System.out.println(node.key+" "+node.entry.getValue());
			node = node.next;
		}
	};
	
	@Override
	public String toString() {
		Arrays.stream(this.bucket).filter(isNotNull).forEach(print);
		return "Printed";
	}

}

class MapNode<K, V> {
	K key;
	Entry<K, V> entry;
	MapNode<K, V> next;

	public MapNode(K key, Entry<K, V> entry, MapNode<K, V> next) {
		this.key = key;
		this.entry = entry;
		this.next = next;
	}
}

class Entry<K, V> {

	private K k;
	private V v;

	public Entry(K k, V v) {
		this.k = k;
		this.v = v;
	}

	public K getKey() {
		return k;
	}

	public V getValue() {
		return v;
	}

}
