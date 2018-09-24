package com.leetcode.problems.bitmanipulation.easy;

/**
 * https://leetcode.com/problems/number-complement/description/
 */
public class NumberComplement {

	class Solution {
		public int findComplement(int num) {
			StringBuilder s = new StringBuilder(Integer.toBinaryString(num));
			for (int i = 0; i < s.length(); i++) {
				s.setCharAt(i, s.charAt(i) == '0' ? '1' : '0');
			}

			return Integer.parseInt(s.toString(), 2);
		}
	}

	class FastSolution {
		public int findComplement(int num) {
			int mask = (Integer.highestOneBit(num) << 1) - 1;
			return mask ^ num;
		}
	}

}
