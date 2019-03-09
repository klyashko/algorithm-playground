package com.algorithm.playground.leetcode.problems.queue.medium;

/**
 * https://leetcode.com/problems/design-circular-queue/description/
 */
public class DesignCircularQueue {

	public static MyCircularQueue myCircularQueue(int k) {
		return new DesignCircularQueue().create(k);
	}

	private MyCircularQueue create(int k) {
		return new MyCircularQueue(k);
	}

	/**
	 * Your MyCircularQueue object will be instantiated and called as such:
	 * MyCircularQueue obj = new MyCircularQueue(k);
	 * boolean param_1 = obj.enQueue(value);
	 * boolean param_2 = obj.deQueue();
	 * int param_3 = obj.Front();
	 * int param_4 = obj.Rear();
	 * boolean param_5 = obj.isEmpty();
	 * boolean param_6 = obj.isFull();
	 */
	class MyCircularQueue {

		private int[] values;
		private int front, tail;

		/**
		 * Initialize your data structure here. Set the size of the queue to be k.
		 */
		public MyCircularQueue(int k) {
			values = new int[k + 1];
		}

		/**
		 * Insert an element into the circular queue. Return true if the operation is successful.
		 */
		public boolean enQueue(int value) {
			if (isFull()) {
				return false;
			}
			values[tail] = value;
			tail = ++tail % values.length;
			return true;
		}

		/**
		 * Delete an element from the circular queue. Return true if the operation is successful.
		 */
		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			front = ++front % values.length;
			return true;
		}

		/**
		 * Get the front item from the queue.
		 */
		public int Front() {
			return isEmpty() ? -1 : values[front];
		}

		/**
		 * Get the last item from the queue.
		 */
		public int Rear() {
			if (isEmpty()) {
				return -1;
			}
			int idx = tail == 0 ? values.length - 1 : tail - 1;
			return values[idx];
		}

		/**
		 * Checks whether the circular queue is empty or not.
		 */
		public boolean isEmpty() {
			return tail == front;
		}

		/**
		 * Checks whether the circular queue is full or not.
		 */
		public boolean isFull() {
			return (tail + 1) % values.length == front;
		}
	}

}
