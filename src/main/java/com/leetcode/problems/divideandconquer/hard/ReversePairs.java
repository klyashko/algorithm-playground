package com.leetcode.problems.divideandconquer.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/reverse-pairs/description/
 */
@SuppressWarnings("ConstantConditions")
public class ReversePairs {

	class Solution {
		public int reversePairs(int[] nums) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = nums.length - 1; i >= 0; i--) {
				int num = nums[i];
				if (!map.containsKey(num)) {
					map.put(num, new ArrayList<>());
				}
				map.get(num).add(0, i);
				if (stack.isEmpty()) {
					stack.push(num);
				} else {
					stack.push(Math.min(num, stack.peek()));
				}
			}
			int count = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				stack.pop();
				Integer min = stack.peek();
				int num = nums[i];
				int limit = num % 2 == 1 ? num / 2 : num / 2 - 1;
				for (int j = min; j <= limit; j++) {
					List<Integer> list = map.getOrDefault(j, Collections.emptyList());
					int idx = Collections.binarySearch(list, i + 1);
					if (idx < 0) {
						idx = -idx - 1;
					}
					count += list.size() - idx;
				}
			}
			return count;
		}

		private void insert(Node node, int key) {
			if (node.val > key) {
				if (node.left == null) {
					node.left = new Node(key);
					return;
				}
				insert(node.left, key);
			} else if (node.val < key) {
				if (node.right == null) {
					node.right = new Node(key);
					return;
				}
				insert(node.right, key);
			} else {
				node.count++;
			}
		}

		private int searchGe(Node node, int key) {
			if (node == null) {
				return 0;
			}
			int count = node.val > key ? node.count : 0;
			return count + searchGe(node.left, key) + searchGe(node.right, key);
		}

		private class Node {
			int val, count;
			Node left, right;

			public Node(int val) {
				this.val = val;
				this.count = 1;
			}
		}
	}

}
