package com.algorithm.playground.leetcode.problems.lc600.lc630.lc639;

/**
 * https://leetcode.com/problems/decode-ways-ii/
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 * <p>
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 * <p>
 * Also, since the answer may be very large, you should return the output mod 10^9 + 7.
 */
public class DecodeWaysII {

	class Solution {

		private int mod = 1_000_000_007;

		public int numDecodings(String s) {
			long prev1 = 1, prev2 = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				long curr = 0;
				char first = s.charAt(i);
				if (first != '0') {
					if (first == '*') {
						curr = 9 * prev1;
					} else {
						curr = prev1;
					}

					if (i < s.length() - 1) {
						char second = s.charAt(i + 1);
						curr += count(first, second) * prev2;
					}
					curr %= mod;
				}
				if (curr == 0 && prev1 == 0) {
					return 0;
				}
				prev2 = prev1;
				prev1 = curr;
			}
			return (int) prev1;
		}

		private int count(char ch1, char ch2) {
			if (ch1 == '*' && ch2 == '*') {
				return 15;
			} else if (ch1 == '*') {
				return ch2 <= '6' ? 2 : 1;
			} else if (ch2 == '*') {
				if (ch1 == '1') {
					return 9;
				} else if (ch1 == '2') {
					return 6;
				} else {
					return 0;
				}
			} else {
				int val = ((ch1 - '0') * 10) + (ch2 - '0');
				return val <= 26 ? 1 : 0;
			}
		}

	}

}
