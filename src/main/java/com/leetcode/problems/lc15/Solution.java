package com.leetcode.problems.lc15;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> values = new ArrayList<>();
		Set<Integer> fuck = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int rest = 0 - nums[i];
			if (fuck.add(rest)) {
				for (List<Integer> two : twoSum(nums, i + 1, 0 - nums[i])) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(two.get(0));
					list.add(two.get(1));
					values.add(list);
				}
			}
		}
		return values;
	}

	private Set<List<Integer>> twoSum(int[] nums, int from, int sum) {
		int l = from, r = nums.length - 1;
		Set<List<Integer>> result = new HashSet<>();
		while (l < r) {
			int curr = nums[l] + nums[r];
			if (curr < sum) {
				l++;
			} else if (curr > sum) {
				r--;
			} else {
				result.add(Arrays.asList(nums[l], nums[r]));
				l++;
			}
		}
		return result;
	}

}
