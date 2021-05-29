package com.incubation.dp;

import java.util.TreeMap;

public class LongestContinuousSubarrayII {

	public static int longestSubarray(int[] nums, int limit) {
		TreeMap<Integer, Integer> map = new TreeMap<>();

		int ans = 0;

		int j = 0;

		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (k, v) -> v == null ? 1 : 1 + v);

			int min = map.firstKey();
            int max = map.lastKey();
            
			while (max - min > limit) {
				int key = nums[j];
				int value = map.get(nums[j]);

				if (value == 1) {
					map.remove(key);
				} else {
					map.put(key, value - 1);
				}

				j++;

				if (map.size() > 0) {
					min = map.firstKey();
		            max = map.lastKey();
				} else {
					break;
				}
			}
			ans = Math.max(ans, i - j + 1);
		}
		return ans;
	}

	public static void main(String args[]) {
		int arr[] = new int[] {8,2,4,7};
		System.out.println(longestSubarray(arr, 4));
	}
}
