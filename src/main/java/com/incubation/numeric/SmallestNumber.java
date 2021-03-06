package com.incubation.numeric;
/**
 * Problem Statement-
Returns the smallest number in array that has been rotated
For example - Array {3,4,5,6,1,2} returns 1
Input array was originally sorted in increasing orders
FindMinInArray must have O(log n) runtime
                Input array does not have any duplicates
Signature:
             public static int FindMin(int a[]){
             }

Test Cases:
        Input: [3, 4, 5, 6, 1, 2]
        Output: 1

        Input: [2, 1]
        Output:1

 * @author Hp
 *
 */
public class SmallestNumber {

	public static int findMin(int arr[]){
		int low = 0;
		int high = arr.length-1;
		
		while(low<high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid]<arr[high]){
                high = mid;
            }
			else {
				low = mid+1;
            }
		}
		return arr[high];
    }
	
	public static void main(String args[]) {
		System.out.println(findMin(new int[] {3,3,1,3}));
	}
}
