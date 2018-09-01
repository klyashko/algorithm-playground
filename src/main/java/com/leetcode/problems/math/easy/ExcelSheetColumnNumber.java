package com.leetcode.problems.math.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

	class Solution {
		public int titleToNumber(String s) {
			int len = s.length();
			if (len == 0) {
				return 0;
			}
			if (len == 1) {
				return s.charAt(0) - 'A' + 1;
			}

			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				int val = s.charAt(i) - 'A' + 1;
				sum += (val * (int) Math.pow(26, len - i - 1));
			}

			return sum;
		}
	}

}
