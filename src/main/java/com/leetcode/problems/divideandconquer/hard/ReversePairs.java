package com.leetcode.problems.divideandconquer.hard;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/reverse-pairs/description/
 */
public class ReversePairs {

	class Solution {
		public int reversePairs(int[] nums) {
			TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				if (!map.containsKey(num)) {
					map.put(num, new TreeSet<>());
				}
				map.get(num).add(i);
			}
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				int limit = num % 2 == 1 ? num / 2 : num / 2 - 1;
				SortedMap<Integer, TreeSet<Integer>> tmp = map.headMap(limit, true);
				for (Integer key : tmp.keySet()) {
					count += tmp.get(key).tailSet(i, false).size();
				}
			}
			return count;
		}
	}

}
