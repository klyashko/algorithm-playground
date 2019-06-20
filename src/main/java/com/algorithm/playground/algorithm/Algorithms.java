package com.algorithm.playground.algorithm;

public class Algorithms {

	public static String minRepetitionSubstring(String s) {
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = -1;
		for (int i = 0, j = -1; i < len; ) {
			while (j > -1 && s.charAt(i) != s.charAt(j)) {
				j = dp[j];
			}
			dp[++i] = ++j;
		}
		int length = len % (len - dp[len]) == 0 ? len / (len - dp[len]) : 1;
		return s.substring(0, len / length);
	}

	public static int maxSumSubArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int curr = 0;
		for (int i : arr) {
			curr = Math.max(i, curr + i);
			max = Math.max(max, curr);
		}
		return max;
	}

	public static int kmpPatternSearch(String str, String pattern) {
		int[] lps = computeLPS(pattern);
		int i = 0, j = 0, count = 0;
		while (i < str.length()) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				if (j == pattern.length()) {
					count++;
					j = lps[j - 1];
				}
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return count;
	}

	/**
	 * Computes "longest prefix suffix" array
	 *
	 * @param pattern
	 *
	 * @return
	 */
	private static int[] computeLPS(String pattern) {
		int[] lps = new int[pattern.length()];
		int len = 0, i = 1;

		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				lps[i++] = ++len;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i++] = len;
				}
			}
		}
		return lps;
	}

}
