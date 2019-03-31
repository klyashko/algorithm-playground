package com.algorithm.playground.leetcode.problems.lc200.lc206;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

	class Solution {
		public ListNode reverseList(ListNode head) {
			return reverseList(head, null);
		}

		private ListNode reverseList(ListNode head, ListNode curr) {
			if (head == null) {
				return curr;
			}
			ListNode node = new ListNode(head.val);
			node.next = curr;
			return reverseList(head.next, node);
		}
	}

	class IterativeSolution {
		public ListNode reverseList(ListNode head) {
			ListNode curr = null;
			while (head != null) {
				ListNode node = new ListNode(head.val);
				node.next = curr;
				curr = node;
				head = head.next;
			}
			return curr;
		}
	}

}
