package com.incubation.dp;

public class LargestSubArraysWithTwoDistinctValues {

	private static int lengthOfLargestSubArray(int[] arr) {
		int max = 0;
		int len = 0 ;
		
		if(arr.length == 0 )return 0;
		if(arr.length==1)return 0;
		if(arr.length==2 && arr[0] == arr[1])return 0;
		
		int v1 = arr[0];
		int v2 = arr[1];
		len = 2;
		for(int i = 2; i < arr.length; i++) {
			if(v1 == arr[i] || v2 == arr[i] || v1 == v2) {
				len++;
			}
			else {
				v2 = v1;
				v1 = arr[i];
				len  = 2;
			}
			
			if(len>max) {
				max = len;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4, 5, 1, 2, 1, 2};
		System.out.println(lengthOfLargestSubArray(arr));
	}
	
}
