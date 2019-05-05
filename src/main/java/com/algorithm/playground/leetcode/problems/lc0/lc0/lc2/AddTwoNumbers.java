package com.algorithm.playground.leetcode.problems.lc0.lc0.lc2;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode node = new ListNode(0);
			ListNode ans = node;
			int rest = 0;
			while (l1 != null && l2 != null) {
				int val = l1.val + l2.val + rest;
				rest = val / 10;
				val = val % 10;
				node.next = new ListNode(val);
				node = node.next;
				l1 = l1.next;
				l2 = l2.next;
			}

			ListNode l = l1 == null ? l2 : l1;

			while (l != null) {
				int val = l.val + rest;
				rest = val / 10;
				val = val % 10;
				node.next = new ListNode(val);
				node = node.next;
				l = l.next;
			}

			if (rest != 0) {
				node.next = new ListNode(rest);
			}

			return ans.next;
		}
	}

}
