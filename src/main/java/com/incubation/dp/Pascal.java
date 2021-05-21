package com.incubation.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**;
 * Problem Statement:
Pascals Triangle exhibits the following behaviour:

 The first and last numbers of each row in the triangle are 1
 Each number in the triangle is the sum of the two numbers above it.

 Example:
         1
        1 1
       1 2 1
      1 3 3 1
     1 4 6 4 1
    1 5 10 10 5 1
  1 6 15 20 15 6 1

 Please Complete the ‘pascal’ function below so that given a
 col and a row it will return the value in that position.

 Example, pascal(1,2) should return 2

Signature:
public static int pascal(int col, int row){
}

Test Cases:

Input : 0,0 
Output:1


Input : 1,2 
Output:2


Input : 4,8 
Output:70

 * @author Hp
 *
 */
public class Pascal {
	
	public static int pascal(int col, int row){
		List<List<Integer>> result  = new ArrayList<>();
		result.add(new ArrayList<>(Arrays.asList(1)));
		if(row == 0)return 1;
		result.add(new ArrayList<>(Arrays.asList(1, 1)));
		
		for(int i = 2; i<=row; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			List<Integer> lastList = result.get(i-1);
			for(int j = 1; j < lastList.size(); j++) {
				list.add(lastList.get(j-1)+lastList.get(j));
			}
			list.add(1);
			result.add(list);
		}
		return result.get(row).get(col);		
	}

	public static void main(String args[]) {
		System.out.print(pascal(4, 8));
	}
	
}
