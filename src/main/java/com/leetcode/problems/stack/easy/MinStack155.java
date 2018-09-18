package com.leetcode.problems.stack.easy;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack155 {

	class MinStack {

		private int min = Integer.MAX_VALUE;
		private LinkedList<Integer> stack = new LinkedList<>();

		/**
		 * initialize your data structure here.
		 */
		public MinStack() { }

		public void push(int x) {
			min = Math.min(min, x);
			stack.push(x);
		}

		public void pop() {
			int el = stack.pop();
			if (el == min) {
				min = Integer.MAX_VALUE;
				LinkedList<Integer> tmp = new LinkedList<>();
				while (!stack.isEmpty()) {
					tmp.push(stack.pop());
				}
				while (!tmp.isEmpty()) {
					push(tmp.pop());
				}
			}
		}

		public int top() {
			//noinspection ConstantConditions
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

}
