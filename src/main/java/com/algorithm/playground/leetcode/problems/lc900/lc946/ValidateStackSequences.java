package com.algorithm.playground.leetcode.problems.lc900.lc946;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * <p>
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result of
 * a sequence of push and pop operations on an initially empty stack.
 * <p>
 * Note:
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class ValidateStackSequences {

	class Solution {
		public boolean validateStackSequences(int[] pushed, int[] popped) {
			int[] stack = new int[pushed.length + 1];
			int popIdx = 0, idx = 0;
			for (int pushIdx = 0; pushIdx < pushed.length; popIdx++, idx--) {
				while (idx == 0 || (pushIdx < pushed.length && stack[idx] != popped[popIdx])) {
					stack[++idx] = pushed[pushIdx++];
				}
				if (pushIdx == pushed.length && stack[idx] != popped[popIdx]) {
					return false;
				}
			}
			while (popIdx < popped.length) {
				if (stack[idx--] != popped[popIdx++]) {
					return false;
				}
			}
			return true;
		}
	}

}
