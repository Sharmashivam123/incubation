package com.incubation.dp;

/**
 * Problem Statement: There is a staircase with ‘n' number of steps. A child
 * walks by and wants to climb up the stairs, starting at the bottom step and
 * ascending to the top. Of course, the child wants to have fun, too, so instead
 * of taking 1 step at a time, it will vary between taking either 1, 2 or 3
 * steps at a time. Please complete the ‘countSteps' method below so that given
 * 'n' number of steps it will return the number of unique combinations the
 * child could traverse. An example would be countSteps(3) == 4:
 * 
 * Signature : public static Integer countSteps(Integer n) { }
 * 
 * Test Cases: Input : 3 Output: 4
 * 
 * Input : 1 Output: 1
 * 
 * Input : 2 Output: 2
 * 
 * Input : 10 Output: 274
 * 
 * Input : -5 Output: 0
 *
 *
 */
public class StairCases {

	public static Integer countSteps(Integer n) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		if(n <= 0)return  0;
		dp[1] = 1;
		if(n==1)return dp[1];
		dp[2] = 2;
		if(n == 2)return dp[2];
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		return dp[n];
	}

}
