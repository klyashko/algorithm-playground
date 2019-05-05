package com.algorithm.playground.leetcode.problems.lc0.lc0.lc5;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

	class Solution {

		private final char DUMMY = '$';

		public String longestPalindrome(String s) {
			if (s.length() < 2) {
				return s;
			}
			char[] chars = new char[(s.length() << 1) + 1];
			int[] dp = new int[chars.length];
			for (int i = 0; i < chars.length; i++) {
				if ((i & 1) == 1) {
					chars[i] = s.charAt(i >> 1);
				} else {
					chars[i] = DUMMY;
				}
			}
			for (int i = 0; i < chars.length; i++) {
				dp[i] = getSizePalindromic(chars, getLeft(i, dp[i]), getRight(i, dp[i]));
				int left = getLeft(i, dp[i]);
				int right = getRight(i, dp[i]);
				int mid = i;
				for (int j = i + 1; j <= right; i = j, j++) {
					int idx = mid - (j - mid);
					int tmp = getLeft(idx, dp[idx]);
					if (tmp >= left) {
						dp[j] = dp[idx];
						if (getRight(j, dp[j]) == right) {
							break;
						}
					} else {
						int diff = left - tmp;
						dp[j] = dp[idx] - (diff << 1);
					}
				}
			}

			int max = 0;
			int idx = 0;
			for (int i = 1; i < dp.length - 1; i++) {
				int curr = dp[i] >> 1;
				if (curr > max) {
					max = curr;
					idx = i;
				}
			}

			StringBuilder builder = new StringBuilder();
			for (int i = getLeft(idx, dp[idx]); i <= getRight(idx, dp[idx]); i++) {
				if (chars[i] != DUMMY) {
					builder.append(chars[i]);
				}
			}

			return builder.toString();
		}

		private int getLeft(int mid, int len) {
			return mid - (len >> 1);
		}

		private int getRight(int mid, int len) {
			return mid + (len >> 1);
		}

		private int getSizePalindromic(char[] chars, int l, int r) {
			int size = r - l - 1;
			while (l >= 0 && r < chars.length && chars[l--] == chars[r++]) {
				size += 2;
			}
			return size;
		}

	}

}
