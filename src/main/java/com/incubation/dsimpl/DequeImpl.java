package com.incubation.dsimpl;
/**
 * Problem Statement:
Implement a double-ended queue (abbreviated to deque) that stores strings.
A deque is a data structure that has characteristics of both a queue and a stack. 
Elements  can be added or removed from either the front or back.

Signature:
             Create Class Deque

 * @author Hp
 *
 */

public class DequeImpl extends Deque{

	Node front;
	Node rear;
	
	@Override
	public String peek() {
		if(rear == null)return null;
		return rear.data;
	}

	@Override
	public boolean isEmpty(String s) {
		return (front == rear && rear == null);
	}

	@Override
	public String pop() {
		String data = null;
		if(rear == null) {
			data = null;
		}else if(front == rear) {
			data = rear.data;
			front = null;
			rear = null;;
		}else {
			data = rear.data;
			rear = rear.prev;
			rear.next = null;
		}
		return data;
	}

	@Override
	public void push(String s) {
		Node node = new Node(s);
		if(rear == null ) {
			front = node;
			rear = node;
		}
		else {
			node.prev = rear;
			rear.next = node;
			rear = node;
		}
	}

	@Override
	public String poll() {
		String data ;
		if(front == null) {
			data = null;
		}
		else if(front == rear) {
			data = front.data;
			rear = null;
			front = null;
		}
		else {
			data = front.data;
			front = front.next;
			front.prev = null;
		}
		return data;
	}

	@Override
	public void offer(String s) {
		this.push(s);
	}
	
	
	
}
