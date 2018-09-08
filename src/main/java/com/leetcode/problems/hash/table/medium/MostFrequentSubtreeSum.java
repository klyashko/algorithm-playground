package com.leetcode.problems.hash.table.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
@SuppressWarnings("Duplicates")
public class MostFrequentSubtreeSum {

	class Solution {
		public int[] findFrequentTreeSum(TreeNode root) {
			Map<Integer, Integer> frequency = new HashMap<>();
			sum(root, frequency);
			Map<Integer, List<Integer>> map = new HashMap<>();
			int max = Integer.MIN_VALUE;

			for (Integer i : frequency.keySet()) {
				int f = frequency.get(i);
				if (!map.containsKey(f)) {
					map.put(f, new ArrayList<>());
				}
				map.get(f).add(i);
				max = Math.max(max, f);
			}

			List<Integer> maxList = map.getOrDefault(max, Collections.emptyList());
			int[] ans = new int[maxList.size()];

			for (int i = 0; i < maxList.size(); i++) {
				ans[i] = maxList.get(i);
			}

			return ans;
		}

		private int sum(TreeNode n, Map<Integer, Integer> frequency) {
			if (n == null) {
				return 0;
			}
			int sum = n.val + sum(n.left, frequency) + sum(n.right, frequency);
			frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
			return sum;
		}
	}

}
