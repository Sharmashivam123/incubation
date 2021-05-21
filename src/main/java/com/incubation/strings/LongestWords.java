package com.incubation.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem Statement-
 Given a string of letters and a dictionary, the function longestWord should
 find the longest word or words in the dictionary that can be made from the letters
 Input: letters = "oet", dictionary = {"to","toe","toes"}
 Output: {"toe"}
 Only lowercase letters will occur in the dictionary and the letters
 The length of letters will be between 1 and 10 characters
                 The solution should work well for a dictionary of over 100,000 words

Signature- Set<String> longestWord(String letters, Dictionary dictionary) {
                    }

Test Cases- 
Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
   Input- toe
  Output- toe

Input – oetdg
Output- "doe", "toe", "dog", "god"

 * @author Hp
 *
 */
public class LongestWords {

	static Set<String> longestWord(String letters, String[] dictionary) {
		Map<Integer, Set<String>> map = new HashMap<>();
		int arr[] = new int[26];
		for(char c:letters.toCharArray()) {
			arr[c-'a']++;
		}
		for(String s : dictionary) {
			int[] copy = Arrays.copyOf(arr, arr.length);
			for(int i = 0 ; i<s.length(); i++) {
				char c = s.charAt(i);
				copy[c-'a']--;
				if(copy[c-'a']<0)break;
				if( i == s.length()-1 ) {
					if(!map.containsKey(s.length()))
					{
						map.put(s.length(), new HashSet<>()) ;
					}
					map.get(s.length()).add(s);
				}
			}
		}
		int max = 0 ;
		for(int x: map.keySet())max = Math.max(x, max);
		return map.get(max);
    }
	
	public static void main(String args[]) {
		String[] dict= new String[]{"to", "tooe", "toes", "dooe", "doog", "god", "dogs", "book", "banana"};
		String letter = "oetdg";
		System.out.print(longestWord(letter, dict));
	}
	
}
