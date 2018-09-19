package com.leetcode.problems.stack.hard;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class LargestRectangleInHistogram {

	class Solution {
		public int largestRectangleArea(int[] heights) {
			int max = 0;

			for (int i = 0; i < heights.length; i++) {
				int min = heights[i];
				int len = 1;
				max = Math.max(max, min * len);
				for (int j = i - 1; j >= 0; j--) {
					min = Math.min(heights[j], min);
					len++;
					max = Math.max(max, min * len);
				}
			}

			return max;
		}
	}

}
