package com.algorithm.playground.leetcode.problems.lc300.lc382;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/description/
 */
public class LinkedListRandomNode {

	public static Solution solution(ListNode head) {
		return new LinkedListRandomNode().create(head);
	}

	private Solution create(ListNode head) {
		return new Solution(head);
	}

	/**
	 * Your Solution_ object will be instantiated and called as such:
	 * Solution_ obj = new Solution_(head);
	 * int param_1 = obj.getRandom();
	 */
	class Solution {

		private ListNode head;
		private ListNode curr;
		private Random rnd = new Random();

		/**
		 * @param head The linked list's head.
		 *             Note that the head is guaranteed to be not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			this.head = head;
			this.curr = head;
		}

		/**
		 * Returns a random node's value.
		 */
		public int getRandom() {
			int next = rnd.nextInt(101);
			for (int i = 0; i < next; i++) {
				curr = curr.next == null ? head : curr.next;
			}
			return curr.val;
		}
	}

}
