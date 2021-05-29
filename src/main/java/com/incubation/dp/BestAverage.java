package com.incubation.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Statement: Given a list of student test scores, find the best average
 * grade. Each student may have more than one test score in the list.
 * 
 * Complete the bestAverageGrade function in the editor below. It has one
 * parameter, scores, which is an array of student test scores. Each element in
 * the array is a two-element array of the form [student name, test score] e.g.
 * [ "Bobby", "87" ]. Test scores may be positive or negative integers.
 * 
 * If you end up with an average grade that is not an integer, you should use a
 * floor function to return the largest integer less than or equal to the
 * average. Return 0 for an empty input.
 * 
 * Example:
 * 
 * Input: [ [ "Bobby", "87" ], [ "Charles", "100" ], [ "Eric", "64" ], [
 * "Charles", "22" ] ].
 * 
 * Expected output: 87 Explanation: The average scores are 87, 61, and 64 for
 * Bobby, Charles, and Eric, respectively. 87 is the highest.
 * 
 * Signatue:
 * 
 * public static Integer bestAverageGrade(String[][] scores) { }
 * 
 * Test Cases:
 * 
 * Input : {{"Sarah", "91"}, {"Goldie", "92"}, {"Elaine", "93"}, {"Elaine",
 * "95"}, {"Goldie", "94"}, {"Sarah", "93"}} Output: 94
 * 
 * @author Hp
 *
 */
public class BestAverage {

	public static Integer bestAverageGrade(String[][] scores) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (String[] s : scores) {
			if (!map.containsKey(s[0])) {
				map.put(s[0], new ArrayList<>());
			}
			map.get(s[0]).add(Integer.parseInt(s[1]));
		}

		double ans = 0;

		for (List<Integer> list : map.values()) {
			double temp = list.stream().mapToDouble(a -> a).average().orElse(0.0);
			ans = Math.max(temp, ans);
		}
		return (int) ans;
	}

	public static void main(String args[]) {
//		System.out.println(bestAverageGrade(new String[][]{{"Sarah", "91"},
//    {"Goldie", "92"},
//    {"Elaine", "93"},
//    {"Elaine", "95"},
//    {"Goldie", "94"},
//    {"Sarah", "93"}}));
	}

}
