package com.incubation.maths;

/**
 * Problem Statement-
  Given base and integer exponent, compute value of base raised to the power of exponent.

Signature:
public static double power(double base, int exp) {
}

Test Cases:
Input: 2.0
       4
Output: 16.0


 * @author Hp
 *
 */

public class CalculatePower {

	public static double power(double base, int exp) {
		if(base == 0)return 0;
        if(exp == 0)return 1;
        
         double sq = power(base*base, exp/2);
        
        if(exp%2!=0){
            if(exp<0)sq /= base;
            else
            sq *= base;
        }
        
        return sq;
	}
}
