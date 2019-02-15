package com.leetcode.problems.array.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {

	class Solution {
		public int thirdMax(int[] nums) {
			long[] tmp = new long[4];
			Arrays.fill(tmp, Long.MIN_VALUE);
			for (int i : nums) {
				insert(tmp, i);
			}
			return (int) (tmp[2] == Long.MIN_VALUE ? tmp[0] : tmp[2]);
		}

		private void insert(long[] tmp, int val) {
			for (long i : tmp) {
				if (val == i) {
					return;
				}
			}
			tmp[3] = val;
			for (int i = 2; i >= 0; i--) {
				if (tmp[i] < tmp[i + 1]) {
					long t = tmp[i];
					tmp[i] = tmp[i + 1];
					tmp[i + 1] = t;
				} else {
					break;
				}
			}
		}
	}

}
