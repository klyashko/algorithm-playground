package com.leetcode.problems.linkedlist.easy;

import com.leetcode.problems.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {

	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode curr;
			if (l2 == null || (l1 != null && l1.val < l2.val)) {
				curr = l1;
				l1 = l1 != null ? l1.next : null;
			} else {
				curr = l2;
				l2 = l2.next;
			}
			ListNode head = curr;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					curr.next = l1;
					l1 = l1.next;
				} else {
					curr.next = l2;
					l2 = l2.next;
				}
				curr = curr.next;
			}
			if (l1 != null) {
				curr.next = l1;
			} else if (l2 != null) {
				curr.next = l2;
			}
			return head;
		}
	}

}
