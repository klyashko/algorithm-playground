package com.algorithm.playground.leetcode.problems.lc100.lc150.lc155;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {


	private LinkedList<int[]> stack = new LinkedList<>();

	/**
	 * initialize your data structure here.
	 */
	public MinStack() { }

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(new int[]{x, x});
		} else {
			stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		//noinspection ConstantConditions
		return stack.peek()[0];
	}

	public int getMin() {
		//noinspection ConstantConditions
		return stack.peek()[1];
	}

}
