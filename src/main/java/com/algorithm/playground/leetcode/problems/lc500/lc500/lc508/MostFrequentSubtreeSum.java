package com.algorithm.playground.leetcode.problems.lc500.lc500.lc508;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class MostFrequentSubtreeSum {

	class Solution {
		public int[] findFrequentTreeSum(TreeNode root) {
			Map<Integer, Integer> frequency = new HashMap<>();
			sum(root, frequency);
			List<Integer> list = new ArrayList<>();
			int max = Integer.MIN_VALUE;

			for (Integer i : frequency.keySet()) {
				int f = frequency.get(i);
				if (f > max) {
					max = f;
					list.clear();
					list.add(i);
				} else if (f == max) {
					list.add(i);
				}
			}

			int[] ans = new int[list.size()];

			for (int i = 0; i < list.size(); i++) {
				ans[i] = list.get(i);
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
