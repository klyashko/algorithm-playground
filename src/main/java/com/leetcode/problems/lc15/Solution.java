package com.leetcode.problems.lc15;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> values = new ArrayList<>();
		Set<Integer> seen = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int rest = 0 - nums[i];
			if (seen.add(rest)) {
				for (Pair two : twoSum(nums, i + 1, 0 - nums[i])) {
					values.add(list(nums[i], two.left, two.right));
				}
			}
		}
		return values;
	}

	private Set<Pair> twoSum(int[] nums, int from, int sum) {
		int l = from, r = nums.length - 1;
		Set<Pair> result = new HashSet<>();
		while (l < r) {
			int curr = nums[l] + nums[r];
			if (curr < sum) {
				l++;
			} else if (curr > sum) {
				r--;
			} else {
				result.add(new Pair(nums[l], nums[r]));
				l++;
			}
		}
		return result;
	}

	private List<Integer> list(Integer i1, Integer i2, Integer i3) {
		return new ArrayList<>(Arrays.asList(i1, i2, i3));
	}

	private static class Pair {
		int left, right;

		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair pair = (Pair) o;
			return left == pair.left &&
					right == pair.right;
		}

		@Override
		public int hashCode() {
			return Objects.hash(left, right);
		}
	}

}
