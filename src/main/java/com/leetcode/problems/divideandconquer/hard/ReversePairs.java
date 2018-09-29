package com.leetcode.problems.divideandconquer.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/reverse-pairs/description/
 */
public class ReversePairs {

	class Solution {
		public int reversePairs(int[] nums) {
			TreeMap<Integer, List<Integer>> map = new TreeMap<>();
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				if (!map.containsKey(num)) {
					map.put(num, new ArrayList<>());
				}
				map.get(num).add(i);
			}
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				int limit = num % 2 == 1 ? num / 2 : num / 2 - 1;
				SortedMap<Integer, List<Integer>> tmp = map.headMap(limit, true);
				for (Integer key : tmp.keySet()) {
					List<Integer> list = tmp.get(key);
					int idx = Collections.binarySearch(list, i + 1);
					if (idx < 0) {
						idx = -idx - 1;
					}
					count += list.size() - idx;
				}
			}
			return count;
		}
	}

}
