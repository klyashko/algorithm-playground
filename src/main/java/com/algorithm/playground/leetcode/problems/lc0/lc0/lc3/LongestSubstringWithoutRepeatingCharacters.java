package com.algorithm.playground.leetcode.problems.lc0.lc0.lc3;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	class Solution {

		public int lengthOfLongestSubstring(String s) {
			BitSet set = new BitSet();
			int left = 0, max = 0;
			for (int right = 0; right < s.length(); right++) {
				int idx = s.charAt(right);
				if (set.get(idx)) {
					while (s.charAt(left++) != s.charAt(right)) {
						set.clear(s.charAt(left - 1));
					}
				}
				set.set(idx);
				int len = right - left + 1;
				max = Math.max(max, len);
			}
			return max;
		}

	}

}
