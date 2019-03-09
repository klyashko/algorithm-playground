package com.algorithm.playground.leetcode.problems.string.easy;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {

	class Solution {
		public boolean isLongPressedName(String name, String typed) {
			int idx = 0;
			for (char ch : name.toCharArray()) {
				idx = typed.indexOf(ch, idx) + 1;
				if (idx == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
