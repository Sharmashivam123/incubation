 package com.incubation.strings;

/**
 * Problem Statement- 
The sentence “The quick brown fox jumps over the lazy dog" contains
 every single letter in the alphabet. Such sentences are called pangrams.
 write a function findMissingLetters, which takes a String “sentence,
 and returns all the letters it is missing (which prevent it from
 being a pangram). You should ignore the case of the letters in sentence,
 and your return should be all lower case letters, in alphabetical order.
  you should also ignore all non US-ASCII characters.

Signature:

String findMissingLetters(String sentence) {
}

Test Cases:
Input: The slow purple oryx meanders past the quiescent canine
Output: bfgjkvz


 * @author Hp
 *
 */
public class Pangram {

	static String findMissingLetters(String sentence) {
		char ch[] = sentence.toCharArray();
		int arr[] = new int[26];
		
		for(char c:ch) {
			if(c>64 && c<91) {
				arr[c - 'A']++;
			}else if(c>96 && c<123) {
				arr[c-'a']++;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i= 0 ; i < 26; i++) {
			if(arr[i]==0) {
				char c = (char)(i+'a');
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(findMissingLetters("The slow purple oryx meanders past the quiescent canine"));
	}
	
	
}
