package com.incubation.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem Statement:
Given a list of words, group them by anagrams
Input: List of "cat", "dog", "god"
                Output: A Set of Sets of anagrams: {{‘cat'}, {‘dog', ‘god'}}

Signature : Set<Set<String>> group(List<String> words){
                     }

Test Cases – 
              Input : ["cat", "dog", "god"]
                              Output: [[“cat”],[“dog”,”god”]]

 * @author Hp
 *
 */
public class GroupAnagrams {

	static Set<Set<String>> group(List<String> words){
		
		 Set<Set<String>> result = new HashSet<>();
		
		Map<String, Set<String>> map = new HashMap<>();
		
		for(String s : words) {
			char ch[] = s.toCharArray();
			Arrays.sort(ch);
			String sorted = String.valueOf(ch);
			if(!map.containsKey(sorted)) {
				map.put(sorted, new HashSet<>());
			}
			map.get(sorted).add(s);
		}
		return new HashSet<>(map.values());
    }
	
	public static void main(String args[]) {
		System.out.println(group(Arrays.asList("cat", "dog", "god")));
	}
}
