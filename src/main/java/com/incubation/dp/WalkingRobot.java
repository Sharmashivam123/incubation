package com.incubation.dp;

/**
 * Problem Statement: Implement the ‘walk" method. This method takes in a
 * string, path, where each character in the string corresponds to a potential
 * movement of the robot. The robot can move up, down, left, and right
 * represented by the characters ‘U', 'D', "L', and 'R' respectively. All other
 * characters may be ignored. Assume the robot's initial position is at (0,0).
 * The output of this method is the robot's final x and y coordinates relative
 * to the initial position Signature:
 *  public static Integer[] walk(String path){ }
 * 
 * Test Cases:
 * 
 * Input: “”(Blank) Output: [0,0]
 * 
 * 
 * Input: “L” Output: [-1,0]
 * 
 * Input: “UUU” Output: [0,3]
 * 
 * Input: “ULDR” Output: [0,0]
 * 
 * 
 * @author Hp
 *
 */
public class WalkingRobot {
	 public static Integer[] walk(String path){
		 Integer x = 0 ;
		 Integer y = 0;
		 
		 for(char c : path.toCharArray()) {
			 if(c == 'L')x--;
			 else if(c == 'R')x++;
			 else if(c == 'U')y++;
			 else y--;
		 }
		 return new Integer[]{x, y};
	 }
}
