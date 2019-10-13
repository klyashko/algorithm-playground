package com.algorithm.playground.leetcode.problems.lc1000.lc1221;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class SplitAStringInBalancedStrings {

	class Solution {
		public int balancedStringSplit(String s) {
			int curr = 0, ans = 0;
			for (int i = 0; i < s.length(); i++) {
				curr += s.charAt(i) == 'L' ? 1 : -1;
				ans += curr == 0 ? 1 : 0;
			}
			return ans;
		}
	}

}
