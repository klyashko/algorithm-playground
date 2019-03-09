package com.algorithm.playground.leetcode.problems.string.medium;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

	class Solution {
		public int calculate(String s) {
			LinkedList<Integer> ints = new LinkedList<>();
			LinkedList<Character> ops = new LinkedList<>();
			Character curr = null;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (Character.isDigit(ch)) {
					Integer n = ch - '0';
					while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
						i += 1;
						n = n * 10 + (s.charAt(i) - '0');
					}
					if (curr != null) {
						Integer prev = ints.removeLast();
						ints.addLast(calc(prev, n, curr));
						curr = null;
					} else {
						ints.addLast(n);
					}
				} else if (ch != ' ') {
					if (ch == '-' || ch == '+') {
						ops.addLast(ch);
					} else {
						curr = ch;
					}
				}
			}

			while (!ops.isEmpty()) {
				Integer i1 = ints.removeFirst();
				Integer i2 = ints.removeFirst();
				Character op = ops.removeFirst();
				ints.addFirst(calc(i1, i2, op));
			}

			return ints.pop();
		}

		private Integer calc(Integer i1, Integer i2, Character op) {
			switch (op) {
				case '+':
					return i1 + i2;
				case '-':
					return i1 - i2;
				case '*':
					return i1 * i2;
				case '/':
					return i1 / i2;
			}
			return null;
		}
	}

}
