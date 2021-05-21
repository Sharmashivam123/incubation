package com.incubation.dsimpl;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {
		Deque deque = new DequeImpl();
		deque.push("firstInserted");
		deque.offer("secondInserted");
		deque.offer("thirdInserted");
		
		System.out.println(deque.pop());
		System.out.println(deque.poll());
		
		MyHashMap<Integer, String> map = new MyHashMap<>();
		map.put(1, "shivam");
		map.put(2, "pooja");
		map.put(3, "aiyer");
		System.out.println(map.get(2));
	}

}
