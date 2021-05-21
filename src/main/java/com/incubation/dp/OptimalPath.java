package com.incubation.dp;

/**
 * Problem Statement: You are an avid rock collector who lives in southern
 * California. Some rare and desirable rocks just became available in New York,
 * so you are planning a cross-country road trip. There are several other rare
 * rocks that you could pick up along the way.
 * 
 * You have been given a grid filled with numbers, representing the number of
 * rare rocks available in various cities across the country. Your objective is
 * to find the optimal path from So_Cal to New_York that would allow you to
 * accumulate the most rocks along the way.
 * 
 * Note: You can only travel either north (up) or east (right). 2) Consider
 * adding some additional tests in doTestsPass(). 3) Implement optimalPath()
 * correctly. 4) Here is an example: ^ {{0, 0, 0, 0, 5}, New_York (finish) N {0,
 * 1, 1, 1, 0}, < W E > So_Cal (start) {2, 0, 0, 0, 0}} S v The total for this
 * example would be 10 (2 + 0 + 1 + 1 + 1 + 0 + 5).
 * 
 * Signature: public static Integer optimalPath(Integer[][] grid) { }
 * 
 * Test Cases: Input : {{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}};
 * Output: 10
 * 
 * @author Hp
 *
 */
public class OptimalPath {

	public static Integer optimalPath(Integer[][] grid) {

		int row = grid.length;

		if (row == 0)
			return 0;

		int col = grid[0].length;

		int[][] arr = new int[row][col];

		arr[row - 1][0] = grid[row - 1][0];

		for (int i = row - 2; i >= 0; i--) {
			arr[i][0] = grid[i][0] + arr[i + 1][0];
		}

		for (int i = 1; i < col; i++) {
			arr[row - 1][i] = grid[row - 1][i] + arr[row - 1][i - 1];
		}

		for (int i = row - 2; i >= 0; i--) {
			for (int j = 1; j < col; j++) {
				arr[i][j] = grid[i][j] + Math.max(arr[i + 1][j], arr[i][j - 1]);
			}
		}
		return arr[0][col - 1];
	}

	public static void main(String args[]) {
		System.out.println(optimalPath(new Integer[][] { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } }));
	}

}
