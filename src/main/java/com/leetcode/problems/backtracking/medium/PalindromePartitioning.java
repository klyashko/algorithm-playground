package com.leetcode.problems.backtracking.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

	class Solution {

		public List<List<String>> partition(String s) {
			if (s.isEmpty()) {
//				List<List<String>> list = new ArrayList<>();
//				List<String> l = new ArrayList<>();
				return Collections.emptyList();
			}
			List<List<String>> result = new ArrayList<>();

			for (int i = 1; i <= s.length(); i++) {
				String l = s.substring(0, i);
				String r = s.substring(i);
				if (isPalindrome(l)) {
					List<List<String>> list = partition(r);
					if (list.isEmpty()) {
						result.add(new ArrayList<>(Collections.singleton(l)));
					}
					for (List<String> ll : list) {
						ll.add(0, l);
						result.add(0, ll);
					}
				}
			}
			return result;
		}

		private boolean isPalindrome(String s) {
			int r = s.length() / 2;
			int l = s.length() % 2 == 0 ? r - 1 : r;
			while (l >= 0) {
				if (s.charAt(l--) != s.charAt(r++)) {
					return false;
				}
			}
			return true;
		}
	}

}
