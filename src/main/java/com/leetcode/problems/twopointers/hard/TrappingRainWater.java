package com.leetcode.problems.twopointers.hard;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {

	class Solution {
		public int trap(int[] height) {
			LinkedList<Integer> stack = new LinkedList<>();
			int count = 0;
			for (int i = 0; i < height.length; i++) {
				int val = height[i];
				int max = 0;
				while (!stack.isEmpty()) {
					//noinspection ConstantConditions
					int prev = stack.peek();
					if (height[prev] != 0) {
						count += (i - prev - 1) * (Math.min(height[prev], val) - max);
					}
					if (height[prev] > val) {
						break;
					}
					max = Math.max(max, height[prev]);
					stack.pop();
				}
				stack.push(i);
			}
			return count;
		}
	}

}
