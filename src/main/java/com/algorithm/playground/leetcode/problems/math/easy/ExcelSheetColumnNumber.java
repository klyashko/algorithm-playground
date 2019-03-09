package com.algorithm.playground.leetcode.problems.math.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

	class Solution {
		public int titleToNumber(String s) {
			int sum = 0, prev = 1;
			for (int i = s.length() - 1; i >= 0; i--) {
				int val = s.charAt(i) - 'A' + 1;
				sum += val * prev;
				prev *= 26;
			}

			return sum;
		}
	}

}
