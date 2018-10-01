package com.leetcode.problems.unionfind.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {

	class Solution {
		public int longestConsecutive(int[] nums) {
			DSU dsu = new DSU();
			for (int i : nums) {
				if (dsu.isPresent(i - 1)) {
					dsu.union(i - 1, i);
				}
				if (dsu.isPresent(i + 1)) {
					dsu.union(i, i + 1);
				}
				dsu.find(i);
			}
			return dsu.max();
		}

		private class DSU {
			Map<Integer, Integer> parents = new HashMap<>();
			Map<Integer, Integer> sizes = new HashMap<>();

			private boolean isPresent(int key) {
				return parents.containsKey(key);
			}

			private int max() {
				int max = 0;
				for (Integer i : sizes.values()) {
					max = Math.max(max, i);
				}
				return max;
			}

			private void union(int key1, int key2) {
				int p1 = find(key1);
				int p2 = find(key2);
				if (p1 != p2) {
					parents.put(p2, p1);
					sizes.put(p1, sizes.get(p1) + sizes.get(p2));
				}
			}

			private int find(int key) {
				if (!parents.containsKey(key)) {
					parents.put(key, key);
					sizes.put(key, 1);
					return key;
				} else if (parents.get(key) == key) {
					return key;
				}
				int p = find(parents.get(key));
				parents.put(key, p);
				return p;
			}

		}
	}

	class NaiveSolution {
		public int longestConsecutive(int[] nums) {
			if (nums.length == 0) {
				return 0;
			}
			Arrays.sort(nums);
			int max = 1;
			int count = 1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != nums[i - 1]) {
					if (nums[i] - 1 == nums[i - 1]) {
						count++;
					} else {
						count = 1;
					}
					max = Math.max(max, count);
				}
			}
			return max;
		}
	}

}
