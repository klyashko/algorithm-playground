package com.algorithm.playground.leetcode.problems.lc600.lc640.lc641;

/**
 * https://leetcode.com/problems/design-circular-deque/description/
 */
public class DesignCircularDeque {

	public static MyCircularDeque myCircularDeque(int k) {
		return new DesignCircularDeque().createMyCircularDeque(k);
	}

	private MyCircularDeque createMyCircularDeque(int k) {
		return new MyCircularDeque(k);
	}

	class MyCircularDeque {

		private Node head;
		private Node tail;
		private int size;
		private int capacity;

		/**
		 * Initialize your data structure here. Set the size of the deque to be k.
		 */
		public MyCircularDeque(int k) {
			this.capacity = k;
			head = new Node(-1);
			tail = new Node(-1);
			head.next = tail;
			tail.prev = head;
		}

		/**
		 * Adds an item at the front of Deque. Return true if the operation is successful.
		 */
		public boolean insertFront(int value) {
			if (isFull()) {
				return false;
			}
			Node n = new Node(value, head, head.next);
			head.next.prev = n;
			head.next = n;
			size++;
			return true;
		}

		/**
		 * Adds an item at the rear of Deque. Return true if the operation is successful.
		 */
		public boolean insertLast(int value) {
			if (isFull()) {
				return false;
			}
			Node n = new Node(value, tail.prev, tail);
			tail.prev.next = n;
			tail.prev = n;
			size++;
			return true;
		}

		/**
		 * Deletes an item from the front of Deque. Return true if the operation is successful.
		 */
		public boolean deleteFront() {
			if (isEmpty()) {
				return false;
			}
			head.next.next.prev = head;
			head.next = head.next.next;
			size--;
			return true;
		}

		/**
		 * Deletes an item from the rear of Deque. Return true if the operation is successful.
		 */
		public boolean deleteLast() {
			if (isEmpty()) {
				return false;
			}
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			size--;
			return true;
		}

		/**
		 * Get the front item from the deque.
		 */
		public int getFront() {
			return head.next.val;
		}

		/**
		 * Get the last item from the deque.
		 */
		public int getRear() {
			return tail.prev.val;
		}

		/**
		 * Checks whether the circular deque is empty or not.
		 */
		public boolean isEmpty() {
			return size == 0;
		}

		/**
		 * Checks whether the circular deque is full or not.
		 */
		public boolean isFull() {
			return size == capacity;
		}

		private class Node {
			int val;
			Node prev, next;

			public Node(int val) {
				this.val = val;
			}

			public Node(int val, Node prev, Node next) {
				this(val);
				this.prev = prev;
				this.next = next;
			}

			@Override
			public String toString() {
				return "Node{" +
						"val=" + val +
						", next=" + next +
						'}';
			}
		}
	}

}
