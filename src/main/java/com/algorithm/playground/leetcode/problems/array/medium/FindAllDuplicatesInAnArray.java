package com.algorithm.playground.leetcode.problems.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class FindAllDuplicatesInAnArray {

	public class Solution {
		public List<Integer> findDuplicates(int[] nums) {
			int[] counts = new int[nums.length + 1];

			List<Integer> result = new ArrayList<>();
			for (int i : nums) {
				counts[i]++;
				if (counts[i] == 2) {
					result.add(i);
				}
			}

			return result;
		}
	}

}
