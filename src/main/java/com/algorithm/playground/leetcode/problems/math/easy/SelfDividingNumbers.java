package com.algorithm.playground.leetcode.problems.math.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/description/
 */
public class SelfDividingNumbers {

	class Solution {
		public List<Integer> selfDividingNumbers(int left, int right) {
			List<Integer> result = new LinkedList<>();
			for (; left <= right; left++) {
				if (isSelfDividing(left)) {
					result.add(left);
				}
			}
			return result;
		}

		private boolean isSelfDividing(int n) {
			int copy = n;
			while (n > 0) {
				int t = n % 10;
				if (t == 0 || copy % t != 0) {
					return false;
				}
				n /= 10;
			}
			return true;
		}

	}

}
