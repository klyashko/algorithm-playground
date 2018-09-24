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
				curr = node(val % 10, curr);
			}

			LinkedList<ListNode> stack = stack1.isEmpty() ? stack2 : stack1;

			while (!stack.isEmpty()) {
				ListNode n = stack.pop();
				int val = n.val + rest;
				rest = val / 10;
				curr = node(val % 10, curr);
			}

			if (rest != 0) {
				curr = node(rest, curr);
			}

			return curr;
		}

		private ListNode node(int val, ListNode next) {
			ListNode node = new ListNode(val);
			node.next = next;
			return node;
		}

		private void pushAll(LinkedList<ListNode> stack, ListNode node) {
			while (node != null) {
				stack.push(node);
				node = node.next;
			}
		}
	}

}
