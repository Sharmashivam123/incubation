package com.incubation.strings;
/**
 * Problem Statement :
Takes String str and returns a new String
such that the characters are in reversed order.
Example: reverseStr(str) where str is “abcd " returns “dcba".

Signature: public static String reverseStr( String str ){
                    }

Test Cases:
 Input : abcd
Output: dcba


 * @author Hp
 *
 */
public class ReverseString {
	 public static String reverseStr( String str ){
		 char ch[] = str.toCharArray();
		 int i = 0 ;
		 int n = ch.length-1;
		 
		 while(i<n) {
			 swap(ch, i, n);
			 i++;
			 n--;
		 }
		 return String.valueOf(ch);
     }
	 static void swap(char []ch, int i, int j) {
		 char temp = ch[i];
		 ch[i] = ch[j];
		 ch[j] = temp;
	 }
}
