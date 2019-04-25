package com.algorithm.playground.leetcode.problems.lc0.lc90.lc91;

/**
 * https://leetcode.com/problems/decode-ways/
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays {

	class Solution {

		public int numDecodings(String s) {
			int[] dp = new int[s.length() + 1];
			dp[0] = 1;
			dp[1] = isValid(s.charAt(0)) ? 1 : 0;

			for (int i = 2; i <= s.length(); i++) {
				if (isValid(s.charAt(i - 1))) {
					dp[i] += dp[i - 1];
				}
				if (isValid(s.charAt(i - 2), s.charAt(i - 1))) {
					dp[i] += dp[i - 2];
				}
			}

			return dp[s.length()];
		}

		private boolean isValid(char ch) {
			return ch != '0';
		}

		private boolean isValid(char ch1, char ch2) {
			if (!isValid(ch1)) {
				return false;
			}
			int val = ((ch1 - '0') * 10) + (ch2 - '0');
			return val <= 26;
		}
	}

}
