package com.incubation.maths;

import java.util.ArrayList;

/**
 * Problem Statement:
Return an array containing prime numbers whose product is x
Examples:
primeFactorization( 6 ) == [2,3]
primeFactorization( 5 ) == [5]
                primeFactorization( 12 ) == [2,2,3]
Signature:
             public static ArrayList<Integer> primeFactorization(int x) {
              }
Test Cases- Input: 6
                     Output:[2,3]

 * @author Hp
 *
 */
public class PrimeFactorisation {

	public static ArrayList<Integer> primeFactorization(int x) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(x<2)return list;
		for(int i = 2; i*i<=x; i++) {
			while(x%i == 0) {
				list.add(i);
				x/=i;
			}
		}
		return list;
    }
	
}
