package com.incubation.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
Hermione is preparing a cheat-sheet for her final exam in Potions class.
To create a potion, one must combine ingredients in a specific order, any of which may be repeated.
As an example, consider the following potion which uses 4 distinct ingredients
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D
Hermione realizes she can save tremendous space on her cheat-sheet by introducing a
special instruction, ‘*', which means “repeat from the beginning”.
Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D
Your job is to write a function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode the potion on Hermione’s Cheat Sheet.

Signature:
private Integer minimalSteps(String ingredients) {
}

Test Case:
Input: ABCDABCE
Output:8

Input: ABCABCE
Output: 5

 * @author Hp
 *
 */
public class MagicPotion {

	private static Integer minimalSteps(String ingredients) {
		Map<Character, Integer> map = new HashMap<>();
		int n = ingredients.length();
		int dp[] = new int[n+1];
		
		for(int i = 0 ; i < ingredients.length(); i++) {
			char c = ingredients.charAt(i);
			dp[i+1] = dp[i]+1;
			if(map.containsKey(c)) {
				int end = map.get(c);
				String startSub = ingredients.substring(0, end+1);
				if(startSub.equals(ingredients.substring(end+1, i+1))) {
					dp[i+1] = 1+dp[i-end];
				}
			}
			map.put(c, i);
		}
		return dp[n];
	}
	
	public static void main(String args[]) {
		System.out.println(minimalSteps("ABABCABABCD"));
	}
}
