package com.incubation.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement –
Finds the first character that does not repeat anywhere in the input string
If all characters are repeated, return 0
Given “apple”, the answer is “a”
Given “racecars”, the answer is “e"

Signature :
                char findFirst(String input){
                }

Test Cases- 
                  Input: apple
                  Output: a
              
                  Input – xxyyzz
                  Output - 0

 * @author Hp
 *
 */
public class FirstNonRepeatingCharacter {

	static char findFirst(String input){
		Set<Character> set = new HashSet<>();
		for( int i = 0 ; i < input.length()-1; i++ ) {
			char c = input.charAt(i);
			if(!set.contains(c)) {
				int index = input.indexOf(c, i+1);
				if(index == -1) {
					return c;
				}
			}
			set.add(c);
		}
		return '0';
    }
	
	public static void main(String args[]) {
		String str = "racecars";
		System.out.println(findFirst(str));
	}
	
}
