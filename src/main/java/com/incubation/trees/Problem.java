package com.incubation.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem Statement:
//Implement the “put" and “contains” methods.
//                Fix the "“inOrderTraversal” method.
//                 
public class Problem {
	static class BST {
		private Node root;

		public BST() {
			this.root = new Node();
		}

		public void put(int value) {
			root = insertInTree(root, value);
		}
		
		private Node insertInTree(Node root, int val) {
			if(root == null || root.val == null) {
				root = new Node();
				root.val = val;
				return root;
			}
			else if(val<root.val) {
				root.left = insertInTree(root.left, val);
			}
			else if(val>root.val){
				root.right = insertInTree(root.right, val);
			}
			else return root;
			return root;
		}

		public boolean contains(int value) {
			return isNodePresent(root, value);
		}

		private boolean isNodePresent(Node root, int val) {
			if(root == null) {
				return false;
			}
			if(val<root.val) {
				return isNodePresent(root.left, val);
			}
			else if(val>root.val) {
				return isNodePresent(root.right, val);
			}
			else return true;
		}
		
		public List<Integer> inOrderTraversal() {
			final ArrayList<Integer> acc = new ArrayList<>();
			inOrderTraversal(root, acc);
			return acc;
		}

		private void inOrderTraversal(Node node, List<Integer> acc) {
			if (node == null) {
				return;
			}
			inOrderTraversal(node.left, acc);
			acc.add(node.val);
			inOrderTraversal(node.right, acc);
		}

		private static class Node {
			Integer val;
			Node left;
			Node right;
		}
	}

	public static void testBST() {
		final BST searchTree = new BST();
		searchTree.put(3);
		searchTree.put(1);
		searchTree.put(2);
		searchTree.put(5);
		assertFalse(searchTree.contains(0));
		assertTrue(searchTree.contains(1));
		assertTrue(searchTree.contains(5));
		assertFalse(searchTree.contains(6));
		assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
	}

	private static void assertFalse(boolean rez) {
		if (rez) {
			throw new RuntimeException("Test failed");
		} else {
			System.out.println("Test passed");
		}
	}

	private static void assertTrue(boolean rez) {
		if (!rez) {
			throw new RuntimeException("Test failed");
		} else {
			System.out.println("Test passed");
		}
	}

	private static void assertEquals(List<Integer> expected, List<Integer> result) {
		if (!expected.equals(result)) {
			System.out.println(String.format("Test failed \"%s\" not equeals to \"%s\"", expected, result));
		} else {
			System.out.println("Test passed");
		}
	}

	// TODO: write some more tests
	public static void main(String[] args) {
		testBST();
	}
}
