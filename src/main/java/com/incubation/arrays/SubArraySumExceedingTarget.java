package com.incubation.arrays;

/**
 * Problem Statement: Your task is ultimately to implement a function that takes
 * in an array and a integer. You want to return the *LENGTH* of the shortest
 * subarray whose sum is at least the integer, and -1 if no such sum exists.
 * 
 * Signature:
 * 
 * public static int subArrayExceedsSum(int arr[], int target) { }
 * 
 * Test Cases: Input:[1,2,3,4,] , k=6 Output :2
 * 
 * Input:[1,2,3,4,] , k=-1 Output :12
 * 
 * @author Hp
 *
 */
public class SubArraySumExceedingTarget {

	//worst case O(n^2)
	public static int subArrayExceedsSum(int nums[], int target) {
		int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; i++){
            int sum = 0 ;
            for(int j = i; j<n; j++){
                sum += nums[j];
                if(sum>=target){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
	}
	
	//worst case O(n log(n))
	public static int subArrayExceedsSum2(int nums[], int target) {
		int n = nums.length;
        int min = Integer.MAX_VALUE;
        
        int j = 0 ;
        int sum = 0;
        for(int i = 0 ; i < n; i++) {
        	sum += nums[i];
        	while(sum>=target && j <= i) {
        		min = Math.min(min,  i-j+1);
        		j++;
        	}
        }
        
        return min==Integer.MAX_VALUE?0:min;
	}
	
}
