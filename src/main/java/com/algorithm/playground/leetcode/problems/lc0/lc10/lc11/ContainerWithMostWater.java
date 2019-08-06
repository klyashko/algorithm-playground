package com.algorithm.playground.leetcode.problems.lc0.lc10.lc11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

	class Solution {

		public int maxArea(int[] height) {
			int max = 0;
			int le = 0, ri = height.length - 1;
			while (le < ri) {
				int len = ri - le;
				max = Math.max(max, Math.min(height[le], height[ri]) * len);
				if (height[le] < height[ri]) {
					le++;
				} else {
					ri--;
				}
			}
			return max;
		}

	}

}
