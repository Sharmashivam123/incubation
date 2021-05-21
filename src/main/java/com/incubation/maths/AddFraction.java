package com.incubation.maths;

import java.util.Arrays;

/*** Problem Statement- 
Given two fractions passed in as int arrays,
 returns the fraction which is result of adding the two input fractions
 Fraction is represented as a two-element array - [ numerator, denominator ]
                 The returned fraction has to be in its simplest form.
Signature:
                  int[] addFractions ( int[] fraction1, int[] fraction2 ){
                   }
Test Cases: 
                 INPUT:           
                  fraction1 - [2, 3];
                                  fraction2 - [1, 2];
                  OUTPUT: Hint-  {2/3 +1/2}
                   result = [7,6]
****/

public class AddFraction {
	
	int[] addFractions ( int[] fraction1, int[] fraction2 ){
		int result[] = new int[2];
		
		int num = ( fraction1[0] * fraction2[1] ) + ( fraction2[0] * fraction1[1] ) ;
		int den = fraction1[1] * fraction2[1];
		
		if(den == 0)return result;
		
		int hcf = num>den ? gcd (num, den) : gcd (den, num);
		
		num /= hcf;
		den /= hcf;
		
		result[0] = num;
		result[1] = den;
		return result;
    }
	
	private int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void main(String args[]) {
		System.out.println(Arrays.toString(new AddFraction().addFractions(new int[]{5,5}, new int[]{10, 5})));
	}

}
