package com.incubation.maths;

/**
 * 
 * 
 * Problem Statement-
 Given two arrays of integers, returns the dot product of the arrays.
	Signature:
  	long dotProduct( int[] array1, int array2[] ){
  	}  
Test Cases:           INPUT:
               array1 = [1, 2];
                               array2 = [2, 3]; 
                               OUTPUT: hint {1*2+2*3}
                               Result =[8]   

 *
 */

public class DotProduct {

	long dotProduct( int[] array1, int array2[] ){
		long result = 0L;
		
		int n = array1.length;
		
		for(int i = 0 ; i < n; i++) {
			result += array1[i] * array2[i];
		}
		
		return result;
  	}
	
}
