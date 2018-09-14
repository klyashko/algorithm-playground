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

	class TwoPointersSolution {
		public int trap(int[] height) {
			if (height.length == 0) {
				return 0;
			}
			int l = 0, r = height.length - 1;
			int leftMax = height[l];
			int rightMax = height[r];
			int ans = 0;

			while (l < r) {
				if (height[l] < height[r]) {
					l++;
					ans += Math.max(0, Math.min(leftMax, rightMax) - height[l]);
					leftMax = Math.max(leftMax, height[l]);
				} else {
					r--;
					ans += Math.max(0, Math.min(leftMax, rightMax) - height[r]);
					rightMax = Math.max(rightMax, height[r]);
				}
			}
			return ans;
		}
	}

}
