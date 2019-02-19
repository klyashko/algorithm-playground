package com.leetcode.problems.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> values = new ArrayList<>();
		int prev = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				break;
			} else if (prev != nums[i]) {
				for (int[] two : twoSum(nums, i + 1, 0 - nums[i])) {
					values.add(list(nums[i], two[0], two[1]));
				}
				prev = nums[i];
			}
		}
		return values;
	}

	private List<int[]> twoSum(int[] nums, int from, int sum) {
		int l = from, r = nums.length - 1;
		List<int[]> result = new ArrayList<>();
		while (l < r) {
			int curr = nums[l] + nums[r];
			if (curr < sum) {
				l++;
			} else if (curr > sum) {
				r--;
			} else {
				result.add(new int[]{nums[l], nums[r]});
				int left = nums[l];
				int right = nums[r];
				while (l < nums.length && left == nums[l]) {
					l++;
				}
				while (r > l && right == nums[r]) {
					r--;
				}
			}
		}
		return result;
	}

	private List<Integer> list(Integer i1, Integer i2, Integer i3) {
		return Arrays.asList(i1, i2, i3);
	}

}
