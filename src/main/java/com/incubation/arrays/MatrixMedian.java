package com.incubation.arrays;

public class MatrixMedian {
	public int findMedian(int[][] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			min = Math.min(arr[i][0], min);
			max = Math.max(arr[i][col - 1], max);
		}

		int total = row * col;

		while (min <= max) {
			int mid = min + (max - min) / 2;
			int smallerElements = countSmallerElements(arr, mid);

			if (smallerElements <= total / 2) {
				min = mid + 1;
			} else {
				max = mid-1;
			}
		}

		return max;
	}

	private int countSmallerElements(int arr[][], int target) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += countSmaller(arr[i], target);
		}
		return total;
	}

	private int countSmaller(int arr[], int target){
     int low = 0 ;
     int high = arr.length-1;
     
     while(low<=high){
         int mid = low+(high-low)/2;
         if(arr[mid]<target){
             low = mid+1;
         }
         else {
             high = mid-1;
         }
     }
     return low;
 }

}
