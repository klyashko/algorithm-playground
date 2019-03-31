package com.algorithm.playground.leetcode.problems.lc1000.lc1019;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

	class Solution {
		public int[] nextLargerNodes(ListNode head) {
			LinkedList<Integer> nodes = new LinkedList<>();
			for (; head != null; head = head.next) {
				nodes.push(head.val);
			}

			LinkedList<Integer> stack = new LinkedList<>();
			int[] ans = new int[nodes.size()];

			for (int i = nodes.size() - 1; !nodes.isEmpty(); i--) {
				//noinspection ConstantConditions
				while (!stack.isEmpty() && nodes.peek() >= stack.peek()) {
					stack.pop();
				}
				ans[i] = stack.isEmpty() ? 0 : stack.peek();
				stack.push(nodes.pop());
			}

			return ans;
		}
	}

}
