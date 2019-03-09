package com.algorithm.playground.leetcode.problems.divideandconquer.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	class MergeSortSolution {
		public List<Integer> countSmaller(int[] nums) {
			if (nums.length == 0) {
				return Collections.emptyList();
			}
			int[] indexes = new int[nums.length];
			for (int i = 0; i < indexes.length; i++) {
				indexes[i] = i;
			}
			Integer[] array = new Integer[nums.length];
			mergeSort(nums, 0, nums.length - 1, array, indexes);
			return Arrays.asList(array);
		}

		private void mergeSort(int[] nums, int s, int e, Integer[] result, int[] indexes) {
			if (s >= e) {
				result[s] = 0;
				return;
			}
			int mid = s + (e - s) / 2;
			mergeSort(nums, s, mid, result, indexes);
			mergeSort(nums, mid + 1, e, result, indexes);

			int[] sorted = new int[e - s + 1];
			int j = mid + 1, p = mid + 1, r = 0;
			for (int i = s; i <= mid; i++) {
				while (j <= e && nums[indexes[j]] < nums[indexes[i]]) {
					j++;
				}
				result[indexes[i]] += j - (mid + 1);
				while (p <= e && nums[indexes[p]] <= nums[indexes[i]]) {
					sorted[r++] = indexes[p++];
				}
				sorted[r++] = indexes[i];
			}

			System.arraycopy(sorted, 0, indexes, s, r);
		}
	}

}
