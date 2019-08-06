package com.algorithm.playground.leetcode.problems.lc500.lc581;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {

	class Solution {

		public int findUnsortedSubarray(int[] nums) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int le = Integer.MAX_VALUE, ri = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				Map.Entry<Integer, Integer> gr = map.higherEntry(nums[i]);
				if (gr != null) {
					le = Math.min(le, gr.getValue());
					ri = i;
				}
				map.putIfAbsent(nums[i], i);
			}
			return le == Integer.MAX_VALUE ? 0 : ri - le + 1;
		}

	}

}
