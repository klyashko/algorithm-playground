package com.algorithm.playground.leetcode.problems.stack.hard;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */
public class RemoveDuplicateLetters {

	class Solution {
		public String removeDuplicateLetters(String s) {
			int[] counts = new int[26];
			boolean[] present = new boolean[26];
			char[] chars = s.toCharArray();

			for (char ch : chars) {
				counts[ch - 'a']++;
			}
			LinkedList<Character> stack = new LinkedList<>();

			for (char ch : chars) {
				int idx = ch - 'a';
				counts[idx]--;
				if (present[idx]) {
					continue;
				}

				//noinspection ConstantConditions
				while (!stack.isEmpty() && stack.peek() > ch && counts[stack.peek() - 'a'] > 0) {
					present[stack.pop() - 'a'] = false;
				}
				stack.push(ch);
				present[idx] = true;
			}

			StringBuilder builder = new StringBuilder();
			while (!stack.isEmpty()) {
				builder.insert(0, stack.pop());
			}

			return builder.toString();
		}
	}

}
