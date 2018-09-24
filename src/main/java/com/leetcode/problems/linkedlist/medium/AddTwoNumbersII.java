package com.leetcode.problems.linkedlist.medium;

import com.leetcode.problems.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */
public class AddTwoNumbersII {

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			LinkedList<ListNode> stack1 = new LinkedList<>();
			LinkedList<ListNode> stack2 = new LinkedList<>();

			pushAll(stack1, l1);
			pushAll(stack2, l2);

			ListNode curr = null;
			int rest = 0;

			while (!stack1.isEmpty() && !stack2.isEmpty()) {
				ListNode a = stack1.pop();
				ListNode b = stack2.pop();
				int val = a.val + b.val + rest;
				rest = val / 10;
				val %= 10;
				ListNode node = new ListNode(val);
				node.next = curr;
				curr = node;
			}

			LinkedList<ListNode> stack = stack1.isEmpty() ? stack2 : stack1;

			while (!stack.isEmpty()) {
				ListNode n = stack.pop();
				int val = n.val + rest;
				rest = val / 10;
				val %= 10;
				ListNode node = new ListNode(val);
				node.next = curr;
				curr = node;
			}

			if (rest != 0) {
				ListNode node = new ListNode(rest);
				node.next = curr;
				curr = node;
			}

			return curr;
		}

		private void pushAll(LinkedList<ListNode> stack, ListNode node) {
			while (node != null) {
				stack.push(node);
				node = node.next;
			}
		}
	}

}
