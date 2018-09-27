package com.leetcode.problems.sort.medium;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

	class Solution {
		public void sortColors(int[] nums) {
			int red = 0, white = 0, blue = 0;
			for (int num : nums) {
				if (num == 0) {
					red++;
				} else if (num == 1) {
					white++;
				} else {
					blue++;
				}
			}

			int idx = 0;
			for (; idx < red; idx++) {
				nums[idx] = 0;
			}
			for (int i = 0; i < white; i++, idx++) {
				nums[idx] = 1;
			}
			for (int i = 0; i < blue; i++, idx++) {
				nums[idx] = 2;
			}
		}
	}

}
