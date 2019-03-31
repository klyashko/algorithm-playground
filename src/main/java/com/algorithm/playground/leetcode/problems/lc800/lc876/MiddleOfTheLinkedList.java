package com.algorithm.playground.leetcode.problems.lc800.lc876;

import com.algorithm.playground.leetcode.problems.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfTheLinkedList {

	class Solution {
		public ListNode middleNode(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}
	}

	class SizeCountingSolution {
		public ListNode middleNode(ListNode head) {
			int size = 0;
			ListNode curr = head;
			while (curr != null) {
				size++;
				curr = curr.next;
			}
			int middle = size / 2;
			for (int i = 0; i < middle; i++) {
				head = head.next;
			}
			return head;
		}
	}

}
