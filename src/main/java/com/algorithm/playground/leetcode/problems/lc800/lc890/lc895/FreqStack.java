package com.algorithm.playground.leetcode.problems.lc800.lc890.lc895;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 * <p>
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
public class FreqStack {

	private Map<Integer, Integer> counts = new HashMap<>();
	private List<LinkedList<Integer>> values = new ArrayList<>();
	private int max = 0;

	public FreqStack() { }

	public void push(int x) {
		Integer count = counts.merge(x, 1, Integer::sum);
		if (values.size() == count - 1) {
			values.add(new LinkedList<>());
		}
		values.get(count - 1).push(x);
		max = Math.max(max, count);
	}

	public int pop() {
		LinkedList<Integer> stack = values.get(max - 1);
		Integer val = stack.pop();
		if (stack.isEmpty()) {
			max--;
		}
		counts.merge(val, -1, (oldVal, newVal) -> oldVal == 1 ? null : oldVal + newVal);
		return val;
	}

}
