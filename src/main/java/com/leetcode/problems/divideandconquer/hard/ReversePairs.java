package com.leetcode.problems.divideandconquer.hard;

/**
 * https://leetcode.com/problems/reverse-pairs/description/
 */
@SuppressWarnings("ConstantConditions")
public class ReversePairs {

	class Solution {
		public int reversePairs(int[] nums) {
			if (nums.length == 0) {
				return 0;
			}
			int count = 0;
			Node root = new Node(nums[0]);
			for (int i = 1; i < nums.length; i++) {
				int num = nums[i];
				long key = (long) num * 2L;
				if (key < Integer.MAX_VALUE) {
					count += searchGe(root, key + 1);
				}
				insert(root, num);
			}
			return count;
		}

		private Node insert(Node node, int key) {
			if (node == null) {
				return new Node(key);
			} else if (node.val > key) {
				node.left = insert(node.left, key);
			} else if (node.val < key) {
				node.right = insert(node.right, key);
				node.count++;
			} else {
				node.count++;
			}
			return node;
		}

		private int searchGe(Node node, long key) {
			if (node == null) {
				return 0;
			} else if (node.val == key) {
				return node.count;
			} else if (key < node.val) {
				return node.count + searchGe(node.left, key);
			} else {
				return searchGe(node.right, key);
			}
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
