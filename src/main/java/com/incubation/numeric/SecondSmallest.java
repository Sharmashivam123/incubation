package com.incubation.numeric;

/**
 * Second Smallest Problem Statement- Returns second smallest element in array
 * x. If x has fewer than 2 elements returns 0.
 * 
 * Signature: int secondSmallest(int[] x)
 * 
 * Test Cases: Input:[ -1, 0, 1, -2, 2] Output: -1
 * 
 * Input:[ 0, 1] Output: 1
 * 
 * 
 * @author Hp
 *
 */
public class SecondSmallest {

	static int secondSmallest(int[] arr) {
		int first = Integer.MAX_VALUE;
		int second = first;

		for (int n : arr) {
			if (first != n) {
				if (first > n) {
					second = first;
					first = n;
				} else if (second > n){
					second = n;
				}
			}
		}
		
		return second == Integer.MAX_VALUE?0:second;
	}

	public static void main(String args[]) {
		System.out.println(secondSmallest(new int[] {-3, -3, 1}));
	}
	
}
