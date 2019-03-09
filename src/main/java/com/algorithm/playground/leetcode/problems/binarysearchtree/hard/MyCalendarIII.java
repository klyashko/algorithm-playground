package com.algorithm.playground.leetcode.problems.binarysearchtree.hard;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-iii/description/
 */
public class MyCalendarIII {

	/**
	 * Your MyCalendarThree object will be instantiated and called as such:
	 * MyCalendarThree obj = new MyCalendarThree();
	 * int param_1 = obj.book(start,end);
	 */
	class MyCalendarThree {

		private TreeMap<Integer, Integer> deltas;

		public MyCalendarThree() {
			deltas = new TreeMap<>();
		}

		public int book(int start, int end) {
			deltas.put(start, deltas.getOrDefault(start, 0) + 1);
			deltas.put(end, deltas.getOrDefault(end, 0) - 1);
			int max = 0, curr = 0;
			for (Integer delta : deltas.values()) {
				curr += delta;
				max = Math.max(max, curr);
			}
			return max;
		}

	}

}
