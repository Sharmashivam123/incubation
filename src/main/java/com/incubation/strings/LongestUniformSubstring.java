package com.incubation.strings;

import java.util.Arrays;

/**
 * 
 * Problem Statement- 
This method should return an integer array with two elements that correctly identifies the location of the longest
uniform substring within the input string. The first element of the array should be the starting index of the longest
substring and the second element should be the length.

input: “abbbccda" the longest uniform substring is “bbb” 
(which starts at index 1 and is 3 characters long.

Signature :
        int[] longestUniformSubstring(String input) {
         }

Test Cases – 
Input : aabbbbbCdAA
Output – [2,5]

 * @author Hp
 *
 */
public class LongestUniformSubstring {

	static int[] longestUniformSubstring(String input) {
		int []arr = new int[2];
		int n = input.length();
		if(n==0)return arr;
		
		int i = 0 , j = 0 ;
		
		int start = 0 ;
		int end = 0;
		
		char[] ch = input.toCharArray();
		
		while(j<n) {
			while(j<n && ch[i]==ch[j]) {
				j++;
			}
			if(end-start<j-i) {
				end = j;
				start = i;
			}
			i=j;
		}
		arr[0] = start;
		arr[1] = end - start ;
		return arr;
    }
	
	public static void main(String args[]) {
		System.out.println(Arrays.toString(longestUniformSubstring("abbbccdaaaaaa")));
	}
	
}
