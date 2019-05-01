package com.algorithm.playground.leetcode.problems.lc100.lc130.lc132;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartitioningII {

	class Solution {

		public int minCut(String s) {
			int[][] dp = new int[s.length()][s.length()];
			for (int i = 1; i < s.length(); i++) {
				for (int j = 0; j < s.length() - i; j++) {
					if (isPalindrome(s, j, j + i)) {
						dp[j][j + i] = 0;
					} else {
						int min = i;
						for (int k = j; k < i; k++) {
							min = Math.min(min, 1 + dp[j][k] + dp[k + 1][j + i]);
						}
						dp[j][j + i] = min;
					}
				}
			}
			return dp[0][s.length() - 1];
		}

		private boolean isPalindrome(String s, int left, int right) {
			int len = right - left + 1;
			int r = (len >> 1) + left;
			int l = r - (1 - (len & 1));
			while (l >= left && r <= right) {
				if (s.charAt(l--) != s.charAt(r++)) {
					return false;
				}
			}
			return true;
		}
	}

	class SolutionCached {

		private Map<String, Integer> cache = new HashMap<>();

		public int minCut(String s) {
			Integer val = cache.get(s);
			if (val != null) {
				return val;
			} else if (s.isEmpty() || s.length() == 1) {
				return 0;
			}

			int min = s.length() - 1;
			int max = 0;
			for (int i = 0; i < s.length(); i++) {
				int tmp = count(s, i, i);
				if (tmp != 1 && tmp >= max) {
					min = Math.min(min, count(s, i, i, tmp - 1));
					max = tmp;
				}
				tmp = count(s, i, i + 1);
				if (tmp != 0 && tmp >= max) {
					min = Math.min(min, count(s, i, i + 1, tmp - 1));
					max = tmp;
				}
			}

			cache.put(s, min);

			return min;
		}

		private int count(String s, int li, int ri, int len) {
			if (li - len == 0 && ri + len + 1 == s.length()) {
				return 0;
			} else if (li - len == 0 || ri + len + 1 == s.length()) {
				return 1 + minCut(s.substring(0, li - len)) + minCut(s.substring(ri + len + 1));
			} else {
				return 2 + minCut(s.substring(0, li - len)) + minCut(s.substring(ri + len + 1));
			}
		}

		private int count(String s, int li, int ri) {
			int count = 0;
			while (li >= 0 && ri < s.length()) {
				if (s.charAt(li--) != s.charAt(ri++)) {
					break;
				}
				count++;
			}
			return count;
		}

	}

}
