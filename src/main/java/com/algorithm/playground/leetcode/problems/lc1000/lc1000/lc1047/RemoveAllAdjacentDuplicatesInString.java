package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1047;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * <p>
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAllAdjacentDuplicatesInString {

	class Solution {
		public String removeDuplicates(String S) {
			char[] stack = new char[S.length() + 1];
			int idx = 0;
			for (char ch : S.toCharArray()) {
				if (ch == stack[idx]) {
					idx--;
				} else {
					stack[++idx] = ch;
				}
			}
			return new String(stack, 1, idx);
		}
	}

}
