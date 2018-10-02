package com.leetcode.problems.binarysearchtree.medium;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicateIII {

	class Solution {
		public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
			TreeMap<Long, TreeSet<Integer>> map = new TreeMap<>();
			for (int i = 0; i < nums.length; i++) {
				long n = nums[i];
				if (!map.containsKey(n)) {
					map.put(n, new TreeSet<>());
				}
				map.get(n).add(i);
			}
			for (int i = 0; i < nums.length; i++) {
				long n = nums[i];
				long max = n + t;
				int upper = i + k;
				int lower = i - k;
				for (TreeSet<Integer> set : map.subMap(n, max + 1).values()) {
					Integer tmp = set.higher(i);
					if (tmp != null && tmp <= upper) {
						return true;
					}
					tmp = set.lower(i);
					if (tmp != null && tmp >= lower) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
