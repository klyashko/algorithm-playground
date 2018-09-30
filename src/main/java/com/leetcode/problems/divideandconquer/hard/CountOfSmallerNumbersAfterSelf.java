package com.leetcode.problems.divideandconquer.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 */
public class CountOfSmallerNumbersAfterSelf {

	class Solution {
		public List<Integer> countSmaller(int[] nums) {
			List<Integer> result = new ArrayList<>();
			Node root = null;
			for (int i = nums.length - 1; i >= 0; i--) {
				result.add(0, count(root, nums[i] - 1));
				root = insert(root, nums[i]);
			}
			return result;
		}

		private int count(Node node, int val) {
			if (node == null) {
				return 0;
			} else if (node.val == val) {
				return node.count;
			} else if (node.val > val) {
				return count(node.left, val);
			} else {
				return node.count + count(node.right, val);
			}
		}

		private Node insert(Node node, int val) {
			if (node == null) {
				return new Node(val);
			} else if (node.val == val) {
				node.count++;
			} else if (node.val > val) {
				node.left = insert(node.left, val);
				node.count++;
			} else {
				node.right = insert(node.right, val);
			}
			return node;
		}

		private class Node {
			int val, count;
			Node left, right;

			public Node(int val) {
				this.val = val;
				this.count = 1;
			}

			@Override
			public String toString() {
				return "Node{" +
						"val=" + val +
						", count=" + count +
						'}';
			}
		}
	}

}
