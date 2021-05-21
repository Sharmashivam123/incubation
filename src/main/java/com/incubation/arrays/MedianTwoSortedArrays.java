package com.incubation.arrays;

/**
 * Problem Statement: Find the median of the two sorted arrays
 * 
 * Signature: public static double findMedianSortedArrays(int[] A, int[] B) { }
 * 
 * Test Cases: Input: Arr1= [1,3]; Arr2 = [2,4]; Output: 2.5
 * 
 * Input: Arr1 = [1,3] Arr2= [2] Output:2.0
 * 
 * @author Hp
 *
 */
public class MedianTwoSortedArrays {

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int n1 = A.length;
		int n2 = B.length;

		if (n1 > n2)
			return findMedianSortedArrays(B, A);

		int total = n1 + n2;

		int low = 0;
		int high = n1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			int x1 = mid - 1 == -1 ? Integer.MIN_VALUE : A[mid - 1];
			int y1 = mid == n1 ? Integer.MAX_VALUE : A[mid];

			int mid2 = (total / 2) - mid;

			int x2 = mid2 - 1 == -1 ? Integer.MIN_VALUE : B[mid2 - 1];
			int y2 = mid2 == n2 ? Integer.MAX_VALUE : B[mid2];

			if (x1 <= y2 && x2 <= y1) {
				if (total % 2 == 1) {
					return Math.min(y1, y2);
				} else {
					return (double) ((Math.min(y1, y2) + Math.max(x1, x2)) / 2);
				}
			} else if (x2 > y1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		if (n1 == 0 && n2 == 0)
			return 0;
		int mid = (total - 1) / 2;
		if (total % 2 == 1) {
			return B[mid];
		} else
			return (double) ((B[mid] + B[mid - 1]) / 2);
	}

}
