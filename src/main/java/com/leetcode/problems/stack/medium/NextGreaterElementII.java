package com.leetcode.problems.stack.medium;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElementII {

	class Solution {
		public int[] nextGreaterElements(int[] nums) {
			int[] ans = new int[nums.length];
			if (nums.length == 0) {
				return ans;
			}
			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = nums.length * 2; i >= 0; i--) {
				int idx = i % nums.length;
				//noinspection ConstantConditions
				while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
					stack.pop();
				}
				ans[idx] = stack.isEmpty() ? -1 : stack.peek();
				stack.push(nums[idx]);
			}
			return ans;
		}
	}

}
