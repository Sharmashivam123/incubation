package com.incubation.dsimpl;

public abstract class Deque {

	
	Deque(){
		
	}


	//methods for common operations
	public abstract String peek();
	public abstract boolean isEmpty(String s) ;
	
	
	//methods for stack operations
	public abstract String pop();
	public abstract void push(String s) ;
	
	//methods for queue operations
	public abstract String poll();
	public abstract void offer(String s) ;
	
}

class Node {
	String data;
	Node next, prev;
	Node (String data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
