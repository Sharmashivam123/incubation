package com.incubation.trees;

/**
 * Problem statement:
 * 
 * Given a forest ( one or more disconnected trees ), find the root of largest
 * tree and return its Id. If there are multiple such roots, return the smallest
 * Id of them.
 * 
 * Complete the largestTree function in the editor below. It has one parameter,
 * immediateParent, which is a map containing key-value pair indicating child ->
 * parent relationship. The key is child and value is the corresponding
 * immediate parent. Constraints Child cannot have more than one immediate
 * parent. Parent can have more than one immediate child. The given key-value
 * pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
 * 
 * Example:
 * 
 * Input: {{1->2}, {3 -> 4} }
 * 
 * Expected output: 2 Explanation: There are two trees one having root of Id 2
 * and another having root of Id 4. Both trees have size 2. The smaller number
 * of 2 and 4 is 2. Hence the answer is 2.
 * 
 * Signature : public static Integer largestTree(final Map<Integer, Integer>
 * immediateParent) { }
 * 
 * @author Hp
 *
 */
public class LargestTree {

	
	
}
