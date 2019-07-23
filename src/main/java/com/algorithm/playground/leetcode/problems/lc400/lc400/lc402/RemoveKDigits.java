package com.algorithm.playground.leetcode.problems.lc400.lc400.lc402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/remove-k-digits/
 * <p>
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 */
public class RemoveKDigits {

	class Solution {

		public String removeKdigits(String num, int k) {
			if (num.length() == k) {
				return "0";
			}
			Deque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < num.length(); i++) {
				char ch = num.charAt(i);
				while (!deque.isEmpty() && deque.peek() - ch > 0 && k > 0) {
					deque.poll();
					k--;
				}
				deque.push(ch);
			}
			for (; k > 0; k--) {
				deque.pop();
			}
			while (!deque.isEmpty() && deque.peekLast() == '0') {
				deque.removeLast();
			}
			if (deque.isEmpty()) {
				return "0";
			}
			StringBuilder builder = new StringBuilder();
			while (!deque.isEmpty()) {
				builder.append(deque.poll());
			}
			return builder.reverse().toString();
		}
	}

}
