package com.algorithm.playground.leetcode.problems.lc100.lc130.lc131;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
@SuppressWarnings("Duplicates")
public class PalindromePartitioning {

	class Solution {

		public List<List<String>> partition(String s) {
			if (s.length() == 1) {
				return singleton(singleton(s));
			}
			List<List<String>> result = new ArrayList<>();
			for (int i = 1; i <= s.length(); i++) {
				if (isPalindrome(s, 0, i - 1)) {
					String left = s.substring(0, i);
					if (i == s.length()) {
						result.add(singleton(left));
					}
					for (List<String> list : partition(s.substring(i))) {
						list.add(0, left);
						result.add(0, list);
					}
				}
			}
			return result;
		}

		private <T> List<T> singleton(T value) {
			List<T> list = new ArrayList<>();
			list.add(value);
			return list;
		}

		private boolean isPalindrome(String s, int l, int r) {
			while (l < r) {
				if (s.charAt(l++) != s.charAt(r--)) {
					return false;
				}
			}
			return true;
		}
	}

}
