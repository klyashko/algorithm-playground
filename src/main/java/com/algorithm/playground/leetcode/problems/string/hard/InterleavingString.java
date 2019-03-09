package com.algorithm.playground.leetcode.problems.string.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/interleaving-string/description/
 */
public class InterleavingString {

	class Solution {

		private Map<String, Boolean> cache = new HashMap<>();

		public boolean isInterleave(String s1, String s2, String s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}

			String key = s1 + "_" + s2 + "_" + s3;
			return cache.computeIfAbsent(key, ignored -> {
				if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
					return true;
				} else {
					boolean ans = false;
					if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
						ans = isInterleave(s1.substring(1), s2, s3.substring(1));
					}
					if (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
						ans |= isInterleave(s1, s2.substring(1), s3.substring(1));
					}
					return ans;
				}
			});
		}
	}

}
