package com.algorithm.playground.leetcode.problems.lc200.lc230.lc232;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class ImplementQueueUsingStacks {

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */
	class MyQueue {

		private LinkedList<Integer> current = new LinkedList<>();
		private LinkedList<Integer> next = new LinkedList<>();

		/**
		 * Initialize your data structure here.
		 */
		public MyQueue() { }

		/**
		 * Push element x to the back of queue.
		 */
		public void push(int x) {
			next.push(x);
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			if (current.isEmpty()) {
				fillCurrent();
			}
			return current.pop();
		}

		/**
		 * Get the front element.
		 */
		public int peek() {
			if (current.isEmpty()) {
				fillCurrent();
			}
			//noinspection ConstantConditions
			return current.peek();
		}

		/**
		 * Returns whether the queue is empty.
		 */
		public boolean empty() {
			return current.isEmpty() && next.isEmpty();
		}

		private void fillCurrent() {
			while (!next.isEmpty()) {
				current.push(next.poll());
			}
		}
	}

}
