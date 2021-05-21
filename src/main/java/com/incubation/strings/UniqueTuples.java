package com.incubation.strings;

import java.util.HashSet;

/**
 * Problem Statement: Given a string and size of the tuples, extracts all unique
 * tuples(substrings) of the given size.
 * 
 * Signature:
 * 
 * HashSet<String> uniqueTuples( String input, int len ){ }
 * 
 * Test Cases: Input : abbccde, 2 Output : ["ab" "bb", "bc", "cc", "cd", "de"]
 * 
 * 
 * @author Hp
 *
 */
public class UniqueTuples {

	static HashSet<String> uniqueTuples( String input, int len ){ 
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0 ; i < input.length() - len + 1; i++) {
			set.add(input.substring(i, i+len));
		}
		return set;
	}
	
	public static void main(String ars[]) {
		System.out.println(uniqueTuples("abbccde", 2));
	}
}
