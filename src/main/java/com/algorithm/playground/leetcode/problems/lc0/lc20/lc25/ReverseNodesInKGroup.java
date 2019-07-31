package com.algorithm.playground.leetcode.problems.lc0.lc20.lc25;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseNodesInKGroup {

	class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode curr = new ListNode(0), h = curr;

			while (head != null) {
				ListNode tmp = head;
				for (int i = 0; i < k - 1; i++) {
					head = head.next;
					if (head == null) {
						curr.next = tmp;
						break;
					}
				}
				if (head != null) {
					ListNode next = head.next;
					head.next = null;
					head = next;
					curr.next = reverse(tmp);
					curr = tmp;
				}
			}

			return h.next;
		}

		private ListNode reverse(ListNode head) {
			ListNode prev = null, curr = head;
			while (curr != null) {
				ListNode tmp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = tmp;
			}
			return prev;
		}
	}

}
