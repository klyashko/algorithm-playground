package com.algorithm.playground.leetcode.problems.lc900.lc920.lc921;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinimumAddToMakeParenthesesValid {

	class Solution {
		public int minAddToMakeValid(String S) {
			int ans = 0, count = 0;
			for (char ch : S.toCharArray()) {
				if (ch == '(') {
					count++;
				} else if (count > 0) {
					count--;
				} else {
					ans++;
				}
			}
			return ans + count;
		}
	}

}
