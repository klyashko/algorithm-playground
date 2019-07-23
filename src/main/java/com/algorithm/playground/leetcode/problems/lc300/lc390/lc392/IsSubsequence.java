package com.algorithm.playground.leetcode.problems.lc300.lc390.lc392;

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
