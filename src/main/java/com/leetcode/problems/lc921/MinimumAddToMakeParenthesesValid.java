package com.leetcode.problems.lc921;

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
