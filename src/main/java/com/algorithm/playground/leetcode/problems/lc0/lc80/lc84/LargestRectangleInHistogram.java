package com.algorithm.playground.leetcode.problems.lc0.lc80.lc84;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */
public class LargestRectangleInHistogram {

	class Solution {
		public int largestRectangleArea(int[] heights) {
			if (heights.length == 0) {
				return 0;
			}
			int n = heights.length;
			int[] left = new int[n];
			int[] right = new int[n];

			for (int i = 1; i < n; i++) {
				int l = i - 1;
				while (l >= 0 && heights[i] <= heights[l]) {
					l = left[l] - 1;
				}
				left[i] = l + 1;
			}

			right[n - 1] = n - 1;
			for (int i = n - 2; i >= 0; i--) {
				int r = i + 1;
				while (r < n && heights[i] <= heights[r]) {
					r = right[r] + 1;
				}
				right[i] = r - 1;
			}

			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, (right[i] - left[i] + 1) * heights[i]);
			}

			return max;
		}
	}

	class SimpleSolution {
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
