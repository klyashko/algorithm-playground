package com.algorithm.playground.leetcode.problems.lc300.lc320.lc328;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {

	class Solution {
		public ListNode oddEvenList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode evenHead = head, even = head;
			ListNode oddHead = head.next, odd = head.next;
			head = head.next.next;
			int idx = 2;

			while (head != null) {
				if (idx++ % 2 == 0) {
					even.next = head;
					even = even.next;
				} else {
					odd.next = head;
					odd = odd.next;
				}
				head = head.next;
			}

			even.next = null;
			odd.next = null;

			even.next = oddHead;

			return evenHead;
		}
	}

}
