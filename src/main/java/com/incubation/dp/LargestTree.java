package com.incubation.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestTree {

	
	public static void main(String args[]) {
		List<Node> list = new ArrayList<>();
		list.add(new Node(1, 2));
		list.add(new Node(2, 3));
		list.add(new Node(4, 5));
		list.add(new Node(6, 4));
		
		System.out.println(getLargestTreeNode(list));
	}

	private static int getLargestTreeNode(List<Node> list) {
		Map<Integer, Integer> map =  new HashMap<>();
		for(Node node : list) {
			map.put(node.child, node.parent);
		}
		
		for(int key : map.keySet()) {
			int parent = getParent(map, key);
			map.put(key,  parent);
		}
		
		Map<Integer, Integer> freq = new HashMap<>();
		
		int count = 0 ;
		int max = Integer.MIN_VALUE;
		
		for(int i:map.values()) {
			freq.compute(i , (k, v)->v == null ? 1 : 1+v);
			if(count<freq.get(i)) {
				count = freq.get(i);
				max = i;
			}else if (count == freq.get(i)) {
				max = Math.min(i, max);
			}
		}
		return max;
	}

	private static int getParent(Map<Integer, Integer> map, int key) {
		int parent = map.get(key);
		
		while(map.get(key)!=null) {
			parent = map.get(key);
			key = parent;
		}
		
		return parent;
	}
	
	
}
class Node {
	int parent;
	int child;
	Node (int parent, int child){
		this.parent = parent;
		this.child = child;
	}
}