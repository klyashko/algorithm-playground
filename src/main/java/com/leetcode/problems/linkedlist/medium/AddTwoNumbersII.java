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

			while (!stack1.isEmpty() || !stack2.isEmpty()) {
				int val = rest;
				if (!stack1.isEmpty()) {
					val += stack1.pop().val;
				}
				if (!stack2.isEmpty()) {
					val += stack2.pop().val;
				}
				rest = val / 10;
				curr = node(val % 10, curr);
			}

			return rest == 0 ? curr : node(rest, curr);
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
