package com.incubation.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement –
Given two words returns the shortest distance
 between their two midpoints in number of characters,  
 words can appear multiple times in any order and should be case insensitive.

Signature :
  public static double shortestDistance(String document, String word1, String word2) {
   }

Test Cases:

String Document – “In publishing and graphic design, lorem ipsum is a
 filler text commonly used to demonstrate the graphic elements”.

shortestDistance( document, "is", "a" ) == 2.5

 * @author 
 *
 */

public class DistanceBetweenTwoString {

	public static double shortestDistance(String document, String word1, String word2) {
		document = document.toLowerCase();
		String arr[] = document.split(" ");
		List<Integer> list = new ArrayList<>();
		int n = document.length();
		
		for(int i = 0 ; i<arr.length; i++) {
			String s = arr[i];
			
			if(word1.equals(s)) {
				list.add(i);
			}
		}
		double lendiff = Integer.MAX_VALUE;
		for(int i : list) {
			double diff = 0;
			for(int j = i+1; j<arr.length; j++) {
				diff += 1;
				if(word2.equals(arr[j])) {
					lendiff = Math.min(lendiff, diff);
					break;
				}
				diff += arr[j].length();
			}
		}
		return (double)(lendiff + (double)(word1.length()/2.0) + (double)(word2.length()/2.0));
   }
	
	public static void main(String args[]) {
		String d = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements.";
		System.out.print(shortestDistance(d, "lorem", "is"));
	}
}
