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

	class Solution_ {
		public int largestRectangleArea(int[] heights) {
			int n = heights.length;
			int[] left = new int[n];
			int[] right = new int[n];

			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= i && heights[i] <= heights[i - j]; j++) {
					left[i]++;
				}
				for (int j = 1; j < n - i && heights[i] <= heights[i + j]; j++) {
					right[i]++;
				}
			}

			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, (left[i] + right[i] + 1) * heights[i]);
			}

//			System.out.println(Arrays.toString(left));
//			System.out.println(Arrays.toString(right));

			return max;
		}
	}

}
