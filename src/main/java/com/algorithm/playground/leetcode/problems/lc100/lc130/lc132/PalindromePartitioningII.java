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
