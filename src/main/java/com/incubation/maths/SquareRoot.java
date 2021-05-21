package com.incubation.maths;

/**
 * Problem Statement-
                        Returns square root of the given double
Signature: 
                        double squareRoot( double x ){
                        }
Test Cases:
                       Input1: 4
                       Ouput1:2
                       Input2:2
                       Output2: 1.41421  

 * @author Hp
 *
 */

public class SquareRoot {

	double squareRoot( double x ){
		if(x<2)return 1.0;
		double sq = x/2;
		double t ;
		do {
			t= sq;
			sq = (t + (x)/t)/2.0;
		}while(t-sq!=0);
		return sq;
    }
	
	public static void main(String args[]) {
		System.out.println(new SquareRoot().squareRoot(8));
	}
	
}
