package com.leetcode.problems.greedy.medium;

/**
 * https://leetcode.com/problems/is-subsequence/description/
 */
public class IsSubsequence {

	class Solution {
		public boolean isSubsequence(String s, String t) {
			int idx = -1;
			for (char ch : s.toCharArray()) {
				idx = t.indexOf(ch, idx) + 1;
				if (idx == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
