package com.leetcode.problems.linkedlist.easy;

import com.leetcode.problems.linkedlist.ListNode;

import java.util.LinkedList;

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
			if (head == null) {
				return null;
			}
			LinkedList<ListNode> stack = new LinkedList<>();
			while (head != null) {
				stack.push(head);
				head = head.next;
			}
			ListNode newHead = new ListNode(stack.pop().val);
			ListNode curr = newHead;
			while (!stack.isEmpty()) {
				ListNode node = new ListNode(stack.pop().val);
				curr.next = node;
				curr = node;
			}
			return newHead;
		}
	}

}
