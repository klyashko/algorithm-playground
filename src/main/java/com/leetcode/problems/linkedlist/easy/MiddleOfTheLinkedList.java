package com.leetcode.problems.linkedlist.easy;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfTheLinkedList {

	class Solution {
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
