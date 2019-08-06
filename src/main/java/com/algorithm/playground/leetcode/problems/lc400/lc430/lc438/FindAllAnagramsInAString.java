package com.algorithm.playground.leetcode.problems.lc400.lc430.lc438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the
 * length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 */
public class FindAllAnagramsInAString {

	class Solution {

		public List<Integer> findAnagrams(String s, String p) {
			if (p.length() > s.length()) {
				return Collections.emptyList();
			}
			int[] pattern = new int[26];
			for (int i = 0; i < p.length(); i++) {
				pattern[p.charAt(i) - 'a']++;
			}
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < p.length() - 1; i++) {
				pattern[s.charAt(i) - 'a']--;
			}

			for (int i = p.length() - 1; i < s.length(); i++) {
				int le = i - p.length();
				if (le >= 0) {
					pattern[s.charAt(le) - 'a']++;
				}
				pattern[s.charAt(i) - 'a']--;
				if (allZeros(pattern)) {
					result.add(le + 1);
				}
			}
			return result;
		}

		private boolean allZeros(int[] nums) {
			for (int i : nums) {
				if (i != 0) {
					return false;
				}
			}
			return true;
		}

	}

}
