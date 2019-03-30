package com.algorithm.playground.leetcode.problems.lc200.lc220;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicateIII {

	class Solution {
		public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
			if (k == 0) {
				return t == 0 && nums.length > 1;
			}
			TreeMap<Long, Integer> map = new TreeMap<>();
			for (int i = 0; i < nums.length; i++) {
				long n = nums[i];
				long min = n - t, max = n + t;
				Map.Entry<Long, Integer> entry = map.higherEntry(min - 1);
				if (entry != null && entry.getKey() <= max) {
					return true;
				}
				if (i >= k) {
					int idx = i - k;
					long toDelete = nums[idx];
					if (map.get(toDelete) == idx) {
						map.remove(toDelete);
					}
				}
				map.put(n, i);
			}
			return false;
		}
	}

	class SecondSolution {
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
