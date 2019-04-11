package com.algorithm.playground.leetcode.problems.lc800.lc850.lc856;

/**
 * https://leetcode.com/problems/score-of-parentheses/description/
 */
public class ScoreOfParentheses {

	class Solution {
		public int scoreOfParentheses(String S) {
			int stack = 0;
			int result = 0;

			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == '(') {
					stack++;
				} else {
					stack--;
					if (S.charAt(i - 1) == '(') {
						result += 1 << stack;
					}
				}
			}

			return result;
		}
	}

}
