package com.incubation.maths;

/**
 * Problem Statement-
      	Returns true if x is a power-of-10. Otherwise returns false.
Signature:
           boolean isPowerOf10(int x){
            }
Test Cases:
           INPUT:
           Input1: 3
           Output1: false

 * @author Hp
 *
 */

public class IsPower10 {
	boolean isPowerOf10(int x){
		return (Math.log(x)/Math.log(10))%1 == 0;
    }
	
	boolean isPowerOf10_1(int x) {
		if(x < 1)return false;
		
		while(x%10==0) {
			x = x/10;
		}
		return x==1;
	}
}
