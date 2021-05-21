package com.incubation.strings;
/**
 * Problem Statement- 
For a string input the function returns output encoded as follows:

"a" -> "a1"
"aa" -> "a2"
"aabbb" -> "a2b3"
"aabbbaa" -> "a2b3a2"

Signature :
        String rle(String input) {
         }

Test Case:
                 Input : aaabbbaad
                 Output: a3b3a2d1 

 * @author Hp
 *
 */
public class RunLengthEncoding {

	static String rle(String input) {
		
		int n = input.length();
		
		int i = 0 ;
		int j = 0 ;
		StringBuilder sb = new StringBuilder();
		
		char ch[] = input.toCharArray();
		
		while(j<n) {
			while(j<n && ch[i]==ch[j]) {
				j++;
			}
			sb.append(ch[i]);
			sb.append((j-i));
			i = j;
		}
		
		return sb.toString();
    }
	
	public static void main(String args[]) {
		System.out.println(rle("aabbb"));
	}
	
}
