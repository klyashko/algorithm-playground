package com.algorithm.playground.leetcode.problems.lc0.lc10.lc19;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 */
public class RemoveNthNodeFromEndOfList {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {

		public ListNode removeNthFromEnd(ListNode head, int n) {
			return removeNthFromEnd(head, new int[]{n});
		}

		private ListNode removeNthFromEnd(ListNode head, int[] n) {
			if (head == null) {
				return null;
			}
			ListNode next = removeNthFromEnd(head.next, n);
			if (--n[0] == 0) {
				return next;
			}
			head.next = next;
			return head;
		}

	}

	class SolutionWithStack {

		public ListNode removeNthFromEnd(ListNode head, int n) {
			LinkedList<ListNode> stack = new LinkedList<>();
			while (head != null) {
				stack.push(head);
				head = head.next;
			}

			int count = 1;
			while (!stack.isEmpty()) {
				ListNode node = stack.pop();
				if (count++ != n) {
					node.next = head;
					head = node;
				}
			}

			return head;
		}

	}

}
